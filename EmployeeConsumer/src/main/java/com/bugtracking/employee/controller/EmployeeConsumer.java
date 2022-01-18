package com.bugtracking.employee.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bugtracking.employee.dto.Bug;
import com.bugtracking.employee.enums.bugstatus;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api
@RestController
public class EmployeeConsumer {
	RestTemplate rt = new RestTemplate();
	
	@ApiOperation("Used to fetch bugs by status(BY ADMIN)")
	@GetMapping("/employee/bystatus/{bugStatus}")
	public List<Bug> bugsbystatus(@PathVariable String bugStatus) {
		String endpoint = "http://localhost:8054/bugs/bystatus/" + bugStatus;
		List<Bug> m = Arrays.asList(rt.getForObject(endpoint, Bug[].class));
		return m;
	}
	@ApiOperation("Used to create bug(BY EMPLOYEE)")
	@PostMapping("/employee/bugs")
	public String createBug(@Valid @RequestBody Bug b) {
		String endpoint = "http://localhost:8054/bugs/";
		rt.postForLocation(endpoint, b);
		return "created successfully";
	}


}
