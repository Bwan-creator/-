package com.javaee_2024_5_4_12.Service;

import com.javaee_2024_5_4_12.Mapper.StudentMapper;
import com.javaee_2024_5_4_12.entity.StudentInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentMapper stuMapper;
    public StudentInfo checkstuLogin(String no,String pwd){
        StudentInfo stu = null;
        stu = stuMapper.checkStuLogin(no,pwd);
        return stu;
    }

    public List<StudentInfo> getStuList(int college_id) {
        return stuMapper.getStuList(college_id);
    }

    public List<StudentInfo> getStuList(String qry_field,String qry_condition) {
        String whereCondition =  "where 1=1";
        whereCondition += "   and " + qry_field + " like '%" + qry_condition + "%'";
        System.out.println("查询where:"  + whereCondition);

        return stuMapper.getStudentList(whereCondition);
    }

    public List<StudentInfo> getStuList(String qry_field,String qry_condition,int current_page,int page_size) {
        int pos = (current_page - 1) * page_size;
        String whereCondition =  "where 1=1";
        whereCondition += "   and " + qry_field + " like '%" + qry_condition + "%'"
        + "    limit   " + pos + "," +page_size;
        System.out.println("查询where:"  + whereCondition);

        return stuMapper.getStudentListPages(whereCondition);
    }



    public StudentInfo getAEditStu(String stu_no){
        return stuMapper.getAEditStu(stu_no);
    }

    public int saveAEditStu(StudentInfo stu){
        return stuMapper.saveAEditStu(stu);
    }

    public int insertAStudent(StudentInfo stu){
        return stuMapper.insertAStudent(stu);
    }

    public int deleteAStudent(String stu_no){
        return stuMapper.deleteAStudent(stu_no);
    }

}
