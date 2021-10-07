package com.example.class_8c.data;

public class DataPostItem {

    private int postLikeCount;
    private boolean isUserLike;
    private String userName;
    private String postImgUrl;
    private String postText;

    public DataPostItem(int postLikeCount, boolean isUserLike, String userName, String postImgUrl, String postText) {
        this.postLikeCount = postLikeCount;
        this.isUserLike = isUserLike;
        this.userName = userName;
        this.postImgUrl = postImgUrl;
        this.postText = postText;
    }

    public int getPostLikeCount() {
        return postLikeCount;
    }

    public void setPostLikeCount(int postLikeCount) {
        this.postLikeCount = postLikeCount;
    }

    public boolean isUserLike() {
        return isUserLike;
    }

    public void setUserLike(boolean userLike) {
        isUserLike = userLike;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPostImgUrl() {
        return postImgUrl;
    }

    public void setPostImgUrl(String postImgUrl) {
        this.postImgUrl = postImgUrl;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }
}
