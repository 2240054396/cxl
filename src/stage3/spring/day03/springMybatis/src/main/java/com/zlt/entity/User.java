package com.zlt.entity;

import java.util.Date;

public class User {
    private Long uid;

    private String tbUsername;

    private String password;

    private String nickname;

    private String email;

    private Date logintime;

    private Date regtime;

    private String photo;

    private String salt;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getTbUsername() {
        return tbUsername;
    }

    public void setTbUsername(String tbUsername) {
        this.tbUsername = tbUsername == null ? null : tbUsername.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Date getLogintime() {
        return logintime;
    }

    public void setLogintime(Date logintime) {
        this.logintime = logintime;
    }

    public Date getRegtime() {
        return regtime;
    }

    public void setRegtime(Date regtime) {
        this.regtime = regtime;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", tbUsername='" + tbUsername + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", logintime=" + logintime +
                ", regtime=" + regtime +
                ", photo='" + photo + '\'' +
                ", salt='" + salt + '\'' +
                '}';
    }
}