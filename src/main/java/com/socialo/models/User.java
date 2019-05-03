package com.socialo.models;

public class User {

    private Long id;
    private String nickname;
    private boolean status;
    private String tags;
    public User() {
    }

    public User( String nickname) {
        this.nickname = nickname;
    }

    public User(boolean status) {
        this.status = status;
    }

    public User(String nickname, boolean status) {
        this.nickname = nickname;
        this.status = status;
    }

    public User(Long id, String nickname, boolean status) {
        this.id = id;
        this.nickname = nickname;
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}
