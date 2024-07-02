package com.javaee_2024_5_4_12.entity;

public class CollegeInfo {
    private int college_id;
    private  String college_name;

    public int getCollege_id() {
        return college_id;
    }

    public void setCollege_id(int college_id) {
        this.college_id = college_id;
    }

    public String getCollege_name() {
        return college_name;
    }

    public void setCollege_name(String college_name) {
        this.college_name = college_name;
    }

    @Override
    public String toString() {
        return "CollegeInfo{" +
                "college_id=" + college_id +
                ", college_name='" + college_name + '\'' +
                '}';
    }
}
