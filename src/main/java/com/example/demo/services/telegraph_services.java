package com.example.demo.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Sender;
import com.example.demo.model.TGH_Generator;
import com.example.demo.model.TGH_Recepient;
import com.example.demo.model.TGH_Telegraph_model;
//import com.example.demo.model.TGH_Telegraph_model.TGH_Telegraph_modelBuilder;
import com.example.demo.repo.Search_specification;
import com.example.demo.repo.TGH_Telegraph_repo;
//import com.example.demo.repo.searchObjectForGenerator;
import com.example.demo.repo.search_object;

@Service
public class telegraph_services 
{   @Autowired
	private TGH_Telegraph_repo re;
//service
	public List<TGH_Telegraph_model>getBetweenTwoDates(Date d1, Date d2)
	{
		return re.getBetweenTwoDates(d1,d2);
	}

	
	public String save_telegragh( TGH_Generator gen )

	{ 
		List<TGH_Telegraph_model>list_tgh=new ArrayList<>(); 
		Date d = new Date();
		TGH_Telegraph_model m=TGH_Telegraph_model.builder()
		.caller_name(gen.getCaller_name())
		.gen_id(gen.getthgeneratorid())
		.urgent(gen.getUrgent_flag())
		.mess(gen.getMessg())
		.send_date(gen.getSend_date())
		.admin(gen.getAdmin())
		.temp(gen.getTemplate_flag())
		.international(gen.getInternational())
		.decoration(gen.getDecoration())
		.plan_code(gen.getPlan_code())
		.user_code(gen.getUser_code())
		.notes(gen.getNotes())
		.tgh_code("code")
		.seq_no(1)
		.country_code(gen.getCountryCode())
		.gene_by("Adnan")
		.redirect(1)
		.status_code("New")
		.delv_notice(1)
		.address("h")
		.tgh_date(d)
		.build();
		TGH_Telegraph_model.TGH_Telegraph_modelBuilder mbulider=m.toBuilder();
//        System.out.println("------------> \t the bulider object :   \n"+mbulider);
		for ( Sender s: gen.getSenders() ) 
		{
			for(TGH_Recepient R:gen.getRecepients())
			{
		
				  TGH_Telegraph_model new_m=mbulider
						.address(R.getAddress())
						.sendername(s.getSender_name())
						.rec_name(R.getRec_name())
						.build();
//				     System.out.println("-------------> \t the bulider object in loop :/n"+mbulider);
				  list_tgh.add(new_m);
			}
		}
		
		re.saveAll(list_tgh);
	    return "**  Done  **";

	}
                        /**      org.springframework.data.domain.Pageable               ???????????????     */
	
	public Page<TGH_Telegraph_model> findBySpecification( search_object sc,int offset, int pagesize)
  {
		Search_specification  spec= new Search_specification(sc);
		org.springframework.data.domain.Pageable p=PageRequest.of(offset, pagesize,Sort.by("id"));
		return  re.findAll(spec,p);
  }
		
	public List<TGH_Telegraph_model>find()
		{
			return  re.findAll();
		}
	
	public Page<TGH_Telegraph_model> fetch (int offset,int pagesize )
		{
			 Page<TGH_Telegraph_model> p=re.findAll(PageRequest.of(offset, pagesize));
			 return p;
		}
		
}
