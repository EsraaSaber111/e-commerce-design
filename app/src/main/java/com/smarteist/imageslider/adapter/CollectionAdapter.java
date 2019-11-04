package com.smarteist.imageslider.adapter;

import android.content.Context;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.smarteist.imageslider.Main2Activity;
import com.smarteist.imageslider.R;
import com.smarteist.imageslider.model.collection;


import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by World Of UI/UX on 17/4/19.
 */
public class CollectionAdapter extends RecyclerView.Adapter<CollectionAdapter.MyViewHolder> {

    private Context mContext;
    private List<collection> albumList;

    int[] myImageList = {R.drawable.gradient1, R.drawable.gradient2,R.drawable.gradient3,
            R.drawable.gradient4,R.drawable.gradient5};

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvTitle,tvDescription;
        public ImageView imgThumbnail;
        public View viewGradient;
        RelativeLayout layout;

        public MyViewHolder(View view) {
            super(view);
            tvTitle = (TextView) view.findViewById(R.id.tvtitle);
            tvDescription = (TextView) view.findViewById(R.id.tvdesc);
            imgThumbnail = (ImageView) view.findViewById(R.id.imgitem);
            viewGradient = (View) view.findViewById(R.id.viewgradient);
            layout = (RelativeLayout) view.findViewById(R.id.rlmain);
        }
    }


    public CollectionAdapter(Context mContext, List<collection> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
    }
 
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.raw_collection, parent, false);
 
        return new MyViewHolder(itemView);
    }
 
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        collection collection = albumList.get(position);
        holder.tvTitle.setText(collection.getTitle());
        holder.tvDescription.setText(collection.getDescription());

        // loading album cover using Glide library
        Glide.with(mContext).load(collection.getImage()).into(holder.imgThumbnail);

        holder.viewGradient.setBackgroundResource(myImageList[position%myImageList.length]);
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

        holder.imgThumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(mContext, Main2Activity.class);
                mContext.startActivity(intent);
            }
        });
 
    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }
}