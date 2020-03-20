package com.snaker.pc.mapper;

import com.snaker.pc.entity.Department;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;


import java.util.List;

@Mapper
public interface DepartmentMapper {


    @Select("SELECT * FROM department WHERE id=#{id}")
    Department findById(Integer id);

    @Select("SELECT * FROM department")
    List<Department> findAll();

    @Insert("INSERT INTO department (departmentName) VALUES (#{departmentName})")
    int insertdep(Department department);

}
