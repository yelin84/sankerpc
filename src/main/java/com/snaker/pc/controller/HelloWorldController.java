package com.snaker.pc.controller;


import com.snaker.pc.entity.Department;
import com.snaker.pc.exception.UserNotExistException;
import com.snaker.pc.mapper.DepartmentMapper;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RestController
public class HelloWorldController {


    private DepartmentMapper departmentMapper;

    @Autowired
    public void setDepartmentMapper(DepartmentMapper departmentMapper) {
        this.departmentMapper = departmentMapper;
    }

    @ResponseBody
    //@RequestMapping (value = "/h",produces= MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping("/h")
    public String hello(@RequestParam("user") String user)
    {
        Map<String,Object> map = new HashMap();
        map.put("hello","gggg");
        map.put("ddd","wwww");
        Logger logger1 = LoggerFactory.getLogger(getClass());
        logger1.info(map.toString());
        //Logger log = Logger
        //System.exit(0);
        JSONObject index = new JSONObject(map);
        return map.toString();
    }
    @ResponseBody
    @RequestMapping("/hi")
    public String hi (@RequestParam("user") String user){
        if(user.equals("aaa")){
            throw new UserNotExistException("dddd");
        }
        return "hi world";
    }

    @RequestMapping("/all")
    public List<Department> findAll() {
        JSONObject json = new JSONObject();
        Logger logger1 = LoggerFactory.getLogger(getClass());
        List<Department> userList = departmentMapper.findAll();
        try {

            json.put("data", userList);
        } catch (JSONException e) {
            logger1.info("lll");
        }

        return userList;
    }

    @GetMapping("/insert/{id}/{department}")
    public Integer insert(@PathVariable("id") Integer id, @PathVariable("department") String department) {

        Department dep = new Department();
        dep.setId(id);
        dep.setDepartmentName(department);
        return departmentMapper.insertdep(dep);
    }
}
