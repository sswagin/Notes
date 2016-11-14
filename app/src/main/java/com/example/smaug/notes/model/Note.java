package com.example.smaug.notes.model;

/**
 * Created by Smaug on 07.11.2016.
 */

public class Note {
    private String mTitle = null;
    private String mText = null;
    private String mText2 = null;
    private String mTime = null;

    public String getText2() {   return mText2;    }

    public void setText2(String mText2) {        this.mText2 = mText2;    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getText() {
        return mText;
    }

    public void setText(String mText) {
        this.mText = mText;
    }

    public String getTime() {
        return mTime;
    }

    public void setTime(String mTime) {
        this.mTime = mTime;
    }

    //public Note
}
