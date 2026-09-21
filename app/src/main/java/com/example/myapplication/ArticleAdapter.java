package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(Article article, int position);
    }

    private final List<Article> articleList;
    private final LayoutInflater mInflater;
    private OnItemClickListener listener;

    public ArticleAdapter(Context context, List<Article> list) {
        this.mInflater = LayoutInflater.from(context);
        this.articleList = list;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.article_layout, parent, false);
        return new ArticleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        Article article = articleList.get(position);

        holder.tvTitle.setText(article.getTitle());
        holder.tvContent.setText(article.getContent());
        holder.tvViews.setText("Views: " + article.getView());
        holder.imgCover.setImageResource(article.getImgCover());

        holder.itemView.setOnClickListener(v -> {
            int pos = holder.getBindingAdapterPosition();
            if (pos != RecyclerView.NO_POSITION && listener != null) {
                listener.onItemClick(articleList.get(pos), pos);
            }
        });
    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }
}