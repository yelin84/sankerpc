package com.snaker.pc.exception;

import com.snaker.pc.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyexceptionHandler {

    @ResponseBody
    @ExceptionHandler(UserNotExistException.class)
    public Map<String,Object> handle1Exception(Exception e,HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        map.put("code","user not exist");
        map.put("msg","用户不存在");
       // Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        request.setAttribute("status_code",4001);
        Integer statusCode = (Integer)request.getAttribute("status_code");
        map.put("status",statusCode);
        String msg = e.getMessage();
        map.put("msg2",msg);
        return map;
    }
}
