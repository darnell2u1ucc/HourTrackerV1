package com;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class info {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	int dummyvariable;
	private String month;
	private String day;
	private String year;
	private String hours;
	
	public void setrecord(String month, String day, String year, String hours){
		this.month = month;
		this.day = day;
		this.year = year;
		this.hours = hours;
		
	}
	
	public int getdummyvariable() {
		return dummyvariable;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getHours() {
		return hours;
	}

	public void setHours(String hours) {
		this.hours = hours;
	}
	
	
}
