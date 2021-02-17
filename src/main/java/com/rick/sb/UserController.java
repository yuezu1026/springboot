package com.rick.sb;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	
	@GetMapping("/v2/request")
    public Response<Map<String, Object>> get(){
        Response<Map<String, Object>> response = new Response<>();
        Map<String, Object> user = new HashMap<>();
        user.put("name", "杨璐嘉1");
        user.put("age", 27);
        response.setData(user); 
        return  response;
    }
}