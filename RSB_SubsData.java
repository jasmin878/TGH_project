package com.example.demo.model;

import java.util.List;

import javax.management.relation.Role;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Columns;

@Entity
@Table(name="SUBS_INFO")
public class RSB_SubsData 
{
  @Id
  @Column(name="TEL_NO")
  private String telephone_number;
  @Column(name="SUB_NAME")
  private String subject_name;
  @Transient
  private List< Role >kk;
  
  
public RSB_SubsData(String telephone_number, String subject_name, List<Role> kk) {
	super();
	this.telephone_number = telephone_number;
	this.subject_name = subject_name;
	this.kk = kk;
}
public RSB_SubsData(String telephone_number, String subject_name) {
	super();
	this.telephone_number = telephone_number;
	this.subject_name = subject_name;
}
public RSB_SubsData() {
	super();
}
public String getTelephone_number() {
	return telephone_number;
}
public void setTelephone_number(String telephone_number) {
	this.telephone_number = telephone_number;
}
public String getSubject_name() {
	return subject_name;
}
public void setSubject_name(String subject_name) {
	this.subject_name = subject_name;
}
//public List< Role > getKk() {
//	return kk;
//}
public void setKk(List< Role > kk) {
	this.kk = kk;
}
public List<Role> getKk() {
	return kk;
}

}
