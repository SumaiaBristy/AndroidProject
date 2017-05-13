package com.example.clinicalguide;

public class Country1 {
	  
	 String code = null;
	 String name = null;
	 String continent = null;
	 String region = null;
	  
	 public Country1( String name, String continent) {
	  super();
	  
	  this.name = name;
	  this.continent = continent;
	 
	 }
	  
	 
	 public void setCode(String code) {
	  this.code = code;
	 }
	 public String getName() {
	  return name;
	 }
	 public void setName(String name) {
	  this.name = name;
	 }
	 public String getContinent() {
	  return continent;
	 }
	 public void setContinent(String continent) {
	  this.continent = continent;
	 }
	 
	 @Override
	 public String toString() {
	  return   name + " "
	    + continent;
	 }
	  
	  
	}
