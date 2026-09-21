package com.example.myapplication;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ArticleViewHolder extends RecyclerView.ViewHolder {
    public ImageView imgCover;
    public TextView tvTitle;
    public TextView tvContent;
    public TextView tvViews;

    public ArticleViewHolder(@NonNull View itemView) {
        super(itemView);
        imgCover = itemView.findViewById(R.id.imgCover);
        tvTitle = itemView.findViewById(R.id.tvTitle);
        tvContent = itemView.findViewById(R.id.tvContent);
        tvViews = itemView.findViewById(R.id.tvViews);
    }
}