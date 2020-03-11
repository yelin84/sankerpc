package com.snaker.pc.controller;

import com.snaker.pc.exception.UserNotExistException;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HelloWorldController {

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
            throw new UserNotExistException((String)"dddd");
        }
        return "hi world";
    }
}
