package com.plantplaces.ui;

import javax.faces.bean.ManagedBean;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

@Named
@ManagedBean
@Scope("session")
public class TestInfo {
	
	private String text = "This is a Test!!";

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}


}
