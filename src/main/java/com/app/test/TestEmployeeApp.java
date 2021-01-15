package com.app.test;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.app.model.Employee;

@Component
public class TestEmployeeApp implements CommandLineRunner{
	
	private static Logger log=LoggerFactory.getLogger(TestEmployeeApp.class);
	@Autowired
	private RestTemplate rt;
	@Override
public void run(String... args) throws Exception {
log.info("Consumer Execution started");
	
    String url="http://localhost:8009/data";
   
   ResponseEntity<Employee[]> resp= rt.getForEntity(url,Employee[].class);
    log.info("After response, data is");
    
   // 5. Read/Print/User Http Response Status and Body.
  
   /*System.out.println(resp.getStatusCodeValue());
	System.out.println(resp.getStatusCode().name());
	System.out.println(resp.getStatusCode().value());
	System.out.println(resp.getBody());
    */
    List<Employee> info = Arrays.asList(resp.getBody());
    for(Employee e:info) {
    log.info("Data is:" + e);
	log.info("Data is:" + resp.getBody());
	log.info("Status Code:" + resp.getStatusCode());
	log.info("Status Val:" + resp.getStatusCodeValue());
	log.info("Headers:" + resp.getHeaders());
    }
	System.exit(0);
}
}
