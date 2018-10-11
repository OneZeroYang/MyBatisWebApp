package com.yang.web.bean;

public class UserInFo {
     private String id;
     private String name;
     private int age;
     private String mobile;
     private String portrait;
     private String major;
     private String autograph;

    public UserInFo(String id, String name, int age, String mobile, String portrait, String major, String autograph) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.mobile = mobile;
        this.portrait = portrait;
        this.major = major;
        this.autograph = autograph;
    }
    public UserInFo(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getAutograph() {
        return autograph;
    }

    public void setAutograph(String autograph) {
        this.autograph = autograph;
    }

    @Override
    public String toString() {
        return "UserInFo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", mobile='" + mobile + '\'' +
                ", portrait='" + portrait + '\'' +
                ", major='" + major + '\'' +
                ", autograph='" + autograph + '\'' +
                '}';
    }
}
