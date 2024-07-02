package com.javaee_2024_5_4_12.Mapper;

import com.javaee_2024_5_4_12.entity.StudentInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentMapper {
    @Select("select * from student_info where stu_no=#{stu_no} and stu_pwd=#{stu_pwd}")
    StudentInfo checkStuLogin(@Param("stu_no") String no,
                              @Param("stu_pwd") String pwd);
    @Select("SELECT si.*, ci.college_name,ci.college_man,cin.class_name\n" +
            "  FROM student_info si\n" +
            "    INNER JOIN college_info ci ON ci.college_id=si.college_id\n" +
            "    INNER JOIN class_info cin ON cin.class_no=si.class_no\n" +
            "  WHERE ci.college_id=#{college_id}")
    List<StudentInfo> getStuList(@Param("college_id")int college_id);


    @Select("SELECT si.*, ci.college_name,ci.college_man,cin.class_name\n" +
            "  FROM student_info si\n" +
            "    INNER JOIN college_info ci ON ci.college_id=si.college_id\n" +
            "    INNER JOIN class_info cin ON cin.class_no=si.class_no\n" +
            "    ${whereCondition}")
    List<StudentInfo> getStudentList(@Param("whereCondition") String whereCondition);

    @Select("SELECT si.*, ci.college_name,ci.college_man,cin.class_name\n" +
            "  FROM student_info si\n" +
            "    INNER JOIN college_info ci ON ci.college_id=si.college_id\n" +
            "    INNER JOIN class_info cin ON cin.class_no=si.class_no\n" +
            "    ${whereCondition}")
    List<StudentInfo> getStudentListPages(@Param("whereCondition") String whereCondition);

    @Select("SELECT si.*, ci.college_name,ci.college_man,cin.class_name\n" +
            "  FROM student_info si\n" +
            "    INNER JOIN college_info ci ON ci.college_id=si.college_id\n" +
            "    INNER JOIN class_info cin ON cin.class_no=si.class_no\n" +
            "  WHERE si.stu_no=#{stu_no}")
    StudentInfo getAEditStu(@Param("stu_no")String stu_no);

    @Update("update student_info set stu_name=#{stu_name},telephone=#{telephone}," +
            " class_no=#{class_no},address=#{address},college_id=#{college_id}" +
            " where stu_no=#{stu_no}")
    int saveAEditStu(StudentInfo stu);


    @Insert("INSERT INTO student_info (stu_no, stu_pwd, address, telephone," +
            " class_no, pro_name, stu_name, college_id)\n" +
            " VALUES (#{stu_no},#{stu_pwd},#{address}," +
            "#{telephone},#{class_no},#{pro_name}," +
            "#{stu_name},#{college_id});")
    int insertAStudent(StudentInfo stu);




//    @Update("update student_info set stu_status = 0  where stu_no = #{stu_no} ;")
//    int deleteAStudent(@Param("stu_no") String stu_no);
    @Delete("DELETE FROM student_info where stu_no=#{stu_no}")
    int deleteAStudent(@Param("stu_no") String stu_no);

}
