package com.javaee_2024_5_4_12.Mapper;

import com.javaee_2024_5_4_12.entity.ClassInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ClassMapper {
    @Select("SELECT class_no ,concat(class_no,'-',class_name) as class_name" +
            " FROM class_info")
    List<ClassInfo> getClassList();
}
