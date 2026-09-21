package com.example.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Article implements Parcelable {
    private String title;
    private String content;
    private int imgCover;
    private int view;

    public Article(String title, String content, int imgCover) {
        this.title = title;
        this.content = content;
        this.imgCover = imgCover;
        this.view = 0;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getImgCover() {
        return imgCover;
    }

    public int getView() {
        return view;
    }

    public void increaseView() {
        this.view++;
    }

    protected Article(Parcel in) {
        title = in.readString();
        content = in.readString();
        imgCover = in.readInt();
        view = in.readInt();
    }

    public static final Creator<Article> CREATOR = new Creator<Article>() {
        @Override
        public Article createFromParcel(Parcel in) {
            return new Article(in);
        }

        @Override
        public Article[] newArray(int size) {
            return new Article[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(content);
        dest.writeInt(imgCover);
        dest.writeInt(view);
    }
}