package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;


import com.example.demo.model.TGH_Generator;
import com.example.demo.model.TGH_Telegraph_model;

@Repository

public interface TGH_Generator_Repo  extends  JpaRepository<TGH_Generator,Long>, JpaSpecificationExecutor<TGH_Generator>
{
//	@Transactional
//	@Modifying
//	@Query(value="INSERT INTO TGH_GENERATOR (GEN_ID,CALLER_NAME,CALLER_TEL_NO,TEMPLATE,TEMP_TYPE_CODE,TEMP_CODE,DELIVERY_NOTICE,URGENT,MESSAGE) VALUES (?1,?2,?3,?4,?5,?6,?7,?8,?9)",nativeQuery = true)
//	public void AddTel(Long GEN_ID,String CallerName,String caller_number,  int temp_flag, String code_type, String temp_code,int delivary_flag, int urgent_flag, String messg);
//	
	@Query(value="SELECT TGH_GENERATOR_SEQ1.NEXTVAL FROM DUAL",nativeQuery = true)
	public Long getId();

   public Optional<TGH_Generator> findById(Long id);
   @Query(value = "select * from TGH_Generator where CALL_DATE between ? and ?",nativeQuery = true)
   public List<TGH_Generator>getBetweenTwoDates(Date d1,Date d2);
	
//	@Transactional
//	@Modifying
//	@Query(value="INSERT INTO TGH_GENERATOR (CALLER_NAME)  VALUES (?)",nativeQuery = true)
//	public void thename(String name);


}
