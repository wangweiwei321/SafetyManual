package com.htxf.safetymanual.general;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.htxf.safetymanual.R;

/**
 * Created by Administrator on 2016/5/22.
 */
public class GeneralRulesRecyclerViewAdapter extends RecyclerView.Adapter<GeneralRulesRecyclerViewAdapter.ViewHolder> {

    public String[] data = null;

    public GeneralRulesRecyclerViewAdapter(String[] data) {
        this.data = data;
    }

    //创建新View，被LayoutManager所调用
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        //inflate的布局是recyclerView中包含的内容而不是含有RecyclerView的布局
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.general_rules_content,viewGroup,false);
        ViewHolder vh = new ViewHolder(view);
        return vh;

    }
    //将数据与界面进行绑定的操作
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.mTextView.setText(data[position]);
    }
    //获取数据的数量
    @Override
    public int getItemCount() {
        return data.length;
    }
    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView;
        public ViewHolder(View view){
            super(view);
            mTextView = (TextView) view.findViewById(R.id.general_rules_content_text);
        }
    }

}
