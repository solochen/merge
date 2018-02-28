package com.diaoyan.android.ui.activity.videolist.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.diaoyan.android.R;
import com.diaoyan.android.ui.activity.videolist.model.ListDataGenerater;
import com.diaoyan.android.ui.activity.videolist.model.VideoModel;

/**
 * Created by chenshaolong on 2017/11/9.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ItemViewHolder> {

    View.OnClickListener listener;
    Context mContext;

    public RecyclerAdapter(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public RecyclerAdapter.ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_view, parent, false);
        mContext = view.getContext();
        return new RecyclerAdapter.ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.ItemViewHolder holder, int position) {
        VideoModel model = ListDataGenerater.datas.get(position);
        holder.name.setText("Just Video " + position);
//        Picasso.with(mContext).load(model.coverImage)
//                .placeholder(R.drawable.shape_place_holder)
//                .into(holder.cover);
        model.position = position;
        holder.playArea.setTag(model);
        holder.playArea.setOnClickListener(listener);
    }

    @Override
    public int getItemCount() {
        return ListDataGenerater.datas.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        public TextView name;
        public ImageView cover;
        public View playArea;

        public ItemViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.tv_video_name);
            cover = (ImageView) itemView.findViewById(R.id.img_cover);
            playArea = itemView.findViewById(R.id.layout_play_area);
        }
    }
}