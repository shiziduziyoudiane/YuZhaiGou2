package com.yuzhaigou.peilei.yuzhaigou.fragment;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yuzhaigou.peilei.yuzhaigou.R;
import com.yuzhaigou.peilei.yuzhaigou.base.MyListAdapter;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

/**
 * Created by Administrator on 2016/3/24.
 */
public class FirstFragmentListAdapter extends MyListAdapter<String> {
    public FirstFragmentListAdapter(List<String>data, Context context) {
        super(data, context);
    }

    @Override
    public View getItemView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_firstfragment_lv, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.textView.setText(mData.get(position));
        return convertView;
    }

    private class ViewHolder {
        @ViewInject(R.id.tv_test)
        private TextView textView;
        public ViewHolder(View convertView) {
            x.view().inject(this, convertView);
        }
    }
}
