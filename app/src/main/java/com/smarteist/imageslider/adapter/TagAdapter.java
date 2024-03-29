package com.smarteist.imageslider.adapter;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.smarteist.imageslider.R;
import com.smarteist.imageslider.model.tag;


import java.util.List;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by World Of UI/UX on 17/4/19.
 */
public class TagAdapter extends RecyclerView.Adapter<TagAdapter.MyViewHolder> {

    private Context mContext;
    private List<tag> albumList;

    int[] myImageList = {R.drawable.gradienttag1, R.drawable.gradienttag2,R.drawable.gradienttag3,
            R.drawable.gradienttag4,R.drawable.gradienttag5};

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvTitle;
        public View viewGradient;
        RelativeLayout layout;
        CardView cvMain;

        public MyViewHolder(View view) {
            super(view);
            tvTitle = (TextView) view.findViewById(R.id.tvtitle);
            viewGradient = (View) view.findViewById(R.id.viewgradient);
            layout = (RelativeLayout) view.findViewById(R.id.rlmain);
            cvMain = (CardView) view.findViewById(R.id.cdmain);
        }
    }

    public TagAdapter(Context mContext, List<tag> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
    }
 
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.raw_tag, parent, false);
 
        return new MyViewHolder(itemView);
    }
 
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        tag tag = albumList.get(position);
        holder.tvTitle.setText(tag.getTitle());

//        holder.viewGradient.setBackgroundResource(myImageList[position%myImageList.length]);
        holder.cvMain.setBackgroundResource(myImageList[position%myImageList.length]);

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        holder.viewGradient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
 
    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }
}