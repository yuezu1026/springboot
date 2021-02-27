package com.rick.sb;

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
        user.put("name", "王耀祖4");
        user.put("age", "244443242342");
        response.setData(user); 
        return  response;
    }
}
