package com.javaee_2024_5_4_12.entity;

public class StudentInfo {
    private String stu_no;
    private String stu_pwd;
    private String address;
    private String telephone;
    private String class_no;
    private String class_name;
    private String pro_name;
    private String stu_name;
    private String college_id;
    private String college_name;
    private String college_man;

    public String getStu_no() {
        return stu_no;
    }

    public void setStu_no(String stu_no) {
        this.stu_no = stu_no;
    }

    public String getStu_pwd() {
        return stu_pwd;
    }

    public void setStu_pwd(String stu_pwd) {
        this.stu_pwd = stu_pwd;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getClass_no() {
        return class_no;
    }

    public void setClass_no(String class_no) {
        this.class_no = class_no;
    }

    public String getPro_name() {
        return pro_name;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public String getCollege_id() {
        return college_id;
    }

    public void setCollege_id(String college_id) {
        this.college_id = college_id;
    }

    public String getCollege_name() {
        return college_name;
    }

    public void setCollege_name(String college_name) {
        this.college_name = college_name;
    }

    public String getCollege_man() {
        return college_man;
    }

    public void setCollege_man(String college_man) {
        this.college_man = college_man;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    @Override
    public String toString() {
        return "StudentInfo{" +
                "stu_no='" + stu_no + '\'' +
                ", stu_pwd='" + stu_pwd + '\'' +
                ", address='" + address + '\'' +
                ", telephone='" + telephone + '\'' +
                ", class_no='" + class_no + '\'' +
                ", class_name='" + class_name + '\'' +
                ", pro_name='" + pro_name + '\'' +
                ", stu_name='" + stu_name + '\'' +
                ", college_id='" + college_id + '\'' +
                ", college_name='" + college_name + '\'' +
                ", college_man='" + college_man + '\'' +
                '}';
    }
}
