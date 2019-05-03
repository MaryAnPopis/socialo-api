package com.socialo.models;

public class Like {

    Long postId;
    String userNickname;


    public Like() {
    }

    public Like(Long postId, String userNickname) {
        this.postId = postId;
        this.userNickname = userNickname;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }
}
