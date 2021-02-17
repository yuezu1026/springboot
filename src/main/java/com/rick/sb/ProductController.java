package com.rick.sb;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value = "/pro")
public class ProductController {
	
	@GetMapping("/v2/get")
    public Response<Map<String, Object>> get(){
	    
        Response<Map<String, Object>> response = new Response<>();
        Map<String, Object> user = new HashMap<>();
        user.put("name", "王耀祖1");
        user.put("age", 27);
        response.setData(user); 
        return  response;
    }
}
