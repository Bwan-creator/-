package com.javaee_2024_5_4_12.Service;

import com.javaee_2024_5_4_12.Mapper.CollegeMapper;
import com.javaee_2024_5_4_12.entity.CollegeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeService {
    @Autowired
    private CollegeMapper collegeMapper;
    public List<CollegeInfo> getCollegeList(){
        return collegeMapper.getCollegeList();
    }
}
