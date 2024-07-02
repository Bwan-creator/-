package com.javaee_2024_5_4_12.Service;

import com.javaee_2024_5_4_12.Mapper.ClassMapper;
import com.javaee_2024_5_4_12.entity.ClassInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {
    @Autowired
    private ClassMapper classMapper;

    public List<ClassInfo> getClassList(){
        return classMapper.getClassList();
    }
}
