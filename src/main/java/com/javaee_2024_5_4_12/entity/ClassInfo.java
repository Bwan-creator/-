package com.javaee_2024_5_4_12.entity;

public class ClassInfo {
    private String class_no;
    private String class_name;

    public String getClass_no() {
        return class_no;
    }

    public void setClass_no(String class_no) {
        this.class_no = class_no;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    @Override
    public String toString() {
        return "ClassInfo{" +
                "class_no='" + class_no + '\'' +
                ", class_name='" + class_name + '\'' +
                '}';
    }
}
