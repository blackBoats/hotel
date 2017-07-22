package com.fk.hotel.bean;

import java.util.List;

public class Result {

	private List<Account> accoount;
	private String resl;
	private Integer size;
	public List<Account> getAccoount() {
		return accoount;
	}
	public void setAccoount(List<Account> accoount) {
		this.accoount = accoount;
	}
	public String getResl() {
		return resl;
	}
	public void setResl(String resl) {
		this.resl = resl;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	
}
