package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.TGH_Generator;
import com.example.demo.repo.RSB_Repo;

@RestController
@RequestMapping("/RSP")
public class RSB_controller {

	@Autowired
	private RSB_Repo rs;
	
	@GetMapping("/getName")
	public String retriveNameByTelNum(String caller_number) 
	{
	    try {
			rs.retriveNameByTelNum(caller_number);
		    return 	rs.retriveNameByTelNum(caller_number);
		}
		catch (Exception e) {
			return "Not Found";
		}
	}

}
