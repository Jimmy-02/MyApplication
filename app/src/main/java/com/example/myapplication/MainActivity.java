package com.example.myapplication;

import android.os.Bundle;
import android.content.Intent;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Article> articleList = new ArrayList<>();
    ArticleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        articleList.add(new Article(
                "Lập trình Android cho người mọi bắt đầu",
                "Android là hệ điều hành di động phổ biến nhất hiện nay. Bài viết này giới thiệu các thành phần cơ bản như Activity, Layout, RecyclerView và cách chúng phối hợp với nhau để tạo nên một ứng dụng hoàn chỉnh.",
                R.drawable.cover1));
        articleList.add(new Article(
                "RecyclerView hoạt động như thế nào?",
                "RecyclerView tái sử dụng các ô đã cuộn ra khỏi màn hình để hiển thị dữ liệu mới, giúp danh sách dài vẫn mượt và tiết kiệm bộ nhớ. Adapter và ViewHolder là hai thành phần quan trọng nhất của cơ chế này.",
                R.drawable.cover2));
        articleList.add(new Article(
                "Truyền dữ liệu giữa các Activity",
                "Để chuyển dữ liệu từ màn hình này sang màn hình khác, ta dùng Intent kèm theo Bundle. Với đối tượng phức tạp, có thể cho lớp implements Parcelable rồi gửi cả đối tượng đi bằng putExtra.",
                R.drawable.cover3));

        recyclerView = findViewById(R.id.recyclerView);
        adapter = new ArticleAdapter(this, articleList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener((article, position) -> {
            article.increaseView();
            adapter.notifyItemChanged(position);

            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_ARTICLE, article);
            startActivity(intent);
        });
    }
}