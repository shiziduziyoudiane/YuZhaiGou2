package com.yuzhaigou.peilei.yuzhaigou.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.yuzhaigou.peilei.yuzhaigou.R;

/**
 * Created by Administrator on 2016/3/25.
 */
public class CustomProgressBar extends View {
    /**
     * 第一圈的颜色
     */
    private int mFirstColor;
    /**
     * 第二圈的颜色
     */
    private int mSecondColor;
    /**
     * 圈的宽度
     */
    private int mCircleWidth;
    /**
     * 画笔
     */
    private Paint mPaint;
    /**
     * 当前时间
     */
    private long now;

    /**
     * 速度
     */
    private int mSpeed;
    /**
     * 文字大小
     */
    private int textSize;
    /**
     * 文字颜色
     */
    private int textColor;
    /**
     * 结束时间
     */
    private String endTime;

    /**
     * 是否应该开始下一个
     */
    private boolean isNext = false;

    public CustomProgressBar(Context context) {
        this(context, null);
    }

    public CustomProgressBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomProgressBar, defStyleAttr, 0);
        int n = a.getIndexCount();
        for (int i = 0; i < n; i++) {
            int attr = a.getIndex(i);
            switch (attr) {
                case R.styleable.CustomProgressBar_firstColor:
                    mFirstColor = a.getColor(attr, Color.GRAY);
                    break;
                case R.styleable.CustomProgressBar_secondColor:
                    mSecondColor = a.getColor(attr, Color.YELLOW);
                    break;
                case R.styleable.CustomProgressBar_circleWidth:
                    mCircleWidth = a.getDimensionPixelSize(attr, (int) TypedValue.applyDimension
                            (TypedValue.COMPLEX_UNIT_PX, 20, getResources().getDisplayMetrics()));
                    break;
                case R.styleable.CustomProgressBar_speed:
                    mSpeed = a.getInt(attr, 0);// 默认为小时
                    break;
                case R.styleable.CustomProgressBar_textsize:
                    textSize = a.getDimensionPixelSize(attr, 16);
                    break;
                case R.styleable.CustomProgressBar_textcolor:
                    textColor = a.getColor(attr, Color.YELLOW);
                    break;
                case R.styleable.CustomProgressBar_endTime:
                    endTime = a.getString(R.styleable.CustomProgressBar_endTime);
                    break;
            }
        }
        a.recycle();
        mPaint = new Paint();
        // 绘图线程
        new Thread() {
            public void run() {
                while (true) {
                    now = System.currentTimeMillis();
                    postInvalidate();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                }

            }
        }.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int centre = getWidth() / 2; // 获取圆心的x坐标
        int radius = centre - mCircleWidth / 2;// 半径
        mPaint.setStrokeWidth(mCircleWidth); // 设置圆环的宽度
        mPaint.setAntiAlias(true); // 消除锯齿
        mPaint.setStyle(Paint.Style.STROKE); // 设置空心
        RectF oval = new RectF(centre - radius, centre - radius, centre + radius, centre + radius); // 用于定义的圆弧的形状和大小的界限
        if (!isNext) {// 第一颜色的圈完整，第二颜色跑
            mPaint.setColor(mFirstColor); // 设置圆环的颜色
            canvas.drawCircle(centre, centre, radius, mPaint); // 画出圆环
            mPaint.setColor(mSecondColor); // 设置圆环的颜色
            canvas.drawArc(oval, -90, now, false, mPaint); // 根据进度画圆弧
        } else {
            mPaint.setColor(mSecondColor); // 设置圆环的颜色
            canvas.drawCircle(centre, centre, radius, mPaint); // 画出圆环
            mPaint.setColor(mFirstColor); // 设置圆环的颜色
            canvas.drawArc(oval, -90, now, false, mPaint); // 根据进度画圆弧
        }
        mPaint.setStrokeWidth(0);
        mPaint.setColor(textColor);
        mPaint.setTextSize(textSize);
        mPaint.setTypeface(Typeface.DEFAULT); //设置字体
        int mEndTime = 0;
        mEndTime = Integer.parseInt(endTime);
        int hour = (int) (((float) now/ (float) 360) * 24);  //中间的进度百分比，先转换成float在进行除法运算，不然都为0
        int minute = (int) (((float) now / (float) 360) * 60);
        int second = (int) (((float) now / (float) 360) * 60);
        switch (mSpeed) {
            case 0:
                float textWidth1 = mPaint.measureText(hour + "");   //测量字体宽度，我们需要根据字体的宽度设置在圆环中间
                canvas.drawText(hour + "", centre - textWidth1 / 2, centre + textSize / 2, mPaint); //圆环内数字
                break;
            case 1:
                float textWidth2 = mPaint.measureText(minute + "");   //测量字体宽度，我们需要根据字体的宽度设置在圆环中间
                canvas.drawText(hour + "", centre - textWidth2 / 2, centre + textSize / 2, mPaint); //圆环内数字
                break;
            case 2:
                float textWidth3 = mPaint.measureText(second + "");   //测量字体宽度，我们需要根据字体的宽度设置在圆环中间
                canvas.drawText(hour + "", centre - textWidth3 / 2, centre + textSize / 2, mPaint); //圆环内数字
                break;
        }

    }
}

