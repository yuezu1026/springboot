package com.rick.sb.config;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
 
@Configuration
public class DruidConfig {
 
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource dataSource(){
       return new DruidDataSource();
    }
 
    @Bean
    public ServletRegistrationBean<StatViewServlet> statViewServlet(){
       ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<StatViewServlet>(new StatViewServlet(), "/druid/*");
        Map<String, String> map = new HashMap<>();
        map.put("loginUsername","admin");
        map.put("loginPassword","123456");
        map.put("allow","");
        map.put("deny","");
          bean.setInitParameters(map);
          return bean;
    }
 
    @Bean
    public FilterRegistrationBean<WebStatFilter> webStatFilter(){
        FilterRegistrationBean<WebStatFilter> bean = new FilterRegistrationBean<WebStatFilter>();
        bean.setFilter(new WebStatFilter());
        Map<String, String> initParams = new HashMap<>();
        initParams.put("exclusions","*.js,*.css,/druid/*");
        bean.setInitParameters(initParams);
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }
}