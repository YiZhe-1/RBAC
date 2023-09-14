package com.huike.advice;

import com.huike.exception.LoginException;
import com.huike.util.ReturnObject;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 拦截自定义异常
 * @author jy
 * @version 1.0
 * @date 2022/2/10 21:50
 */
@ControllerAdvice
public class AdviceController {
    
    @ExceptionHandler(LoginException.class)
    @ResponseBody
    public ReturnObject loginException(LoginException e){
        return new ReturnObject(false,e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public String runException(RuntimeException e){
        e.printStackTrace();
        return "/error";
    }
}
