package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.TGH_Template;
import com.example.demo.repo.Repo_temp_TGH;
import com.example.demo.services.SERVICES_Temp_TGH;

@RestController
@RequestMapping("/template")
public class controller_Temp_TGH {

	@Autowired
	private SERVICES_Temp_TGH TEMP_SERV;
	@Autowired
	private Repo_temp_TGH rp;
	

	@GetMapping("/all")
	public List<TGH_Template> getByCode( )
	{
		return rp.findAll() ;
	}

	@GetMapping("/GetByCode")
	public List<TGH_Template> getByCode( String code)
	{
		return  TEMP_SERV.getByCode(code);
	}
	
	
	
	
}
