package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.IntentCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_ARTICLE = "article";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Article article = IntentCompat.getParcelableExtra(getIntent(), EXTRA_ARTICLE, Article.class);
        if (article == null) {
            finish();
            return;
        }

        ImageView imgCover = findViewById(R.id.imgCover);
        TextView tvTitle = findViewById(R.id.tvTitle);
        TextView tvViews = findViewById(R.id.tvViews);
        TextView tvContent = findViewById(R.id.tvContent);
        Button btBack = findViewById(R.id.btBack);

        imgCover.setImageResource(article.getImgCover());
        tvTitle.setText(article.getTitle());
        tvViews.setText("Views: " + article.getView());
        tvContent.setText(article.getContent());

        btBack.setOnClickListener(v -> finish());
    }
}