package com.fitnessgeek.ui;

import javax.faces.bean.ManagedBean;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

/**
 * Application Welcome Page UI Class
 * @author moku
 *
 */
@Named
@ManagedBean
@Scope("session")
public class ApplicationIntroInfo {
	final static Logger logger = Logger.getLogger(ApplicationIntroInfo.class);
	
	private String welcome = "Welcome to Fitness Geek.";
	
	//TODO:: create signin.xhtml and execute method for sign in

	/**
	 * get welcome slogan for home page of Fitness Geek
	 * @return welcome
	 */
	public String getWelcome() {
		logger.info("INFO: User started the app");
		return welcome;
	}
	/**
	 * set welcome slogan for home page of Fitness Geek
	 * @param welcome
	 */
	public void setWelcome(String welcome) {
		this.welcome = welcome;
	}
	
}
