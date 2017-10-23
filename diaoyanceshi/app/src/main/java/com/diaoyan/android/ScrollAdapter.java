package com.diaoyan.android;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenshaolong on 2017/10/23.
 */

public class ScrollAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<String> mList;

    public ScrollAdapter(){
        mList = new ArrayList<>();
        for(int i = 0; i < 100; i ++){
            mList.add("item:" + i);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        View view = View.inflate(parent.getContext(), R.layout.item_scroll, null);
        viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ViewHolder mHolder = (ViewHolder) holder;

    }


    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View convertView) {
            super(convertView);
        }
    }

}
