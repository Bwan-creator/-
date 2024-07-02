package com.javaee_2024_5_4_12.Mapper;

import com.javaee_2024_5_4_12.entity.CollegeInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CollegeMapper {
    @Select("SELECT college_id ,concat(college_id,'-',college_name) as college_name" +
            " FROM college_info")
    List<CollegeInfo> getCollegeList();
}
