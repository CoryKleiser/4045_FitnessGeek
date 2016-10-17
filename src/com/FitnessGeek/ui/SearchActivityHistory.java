package com.4045_FitnessGeek.ui;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.4045_FitnessGeek.dto.ActivityHistory;



@Named
@ManagedBean
@Scope("session")
public class SearchActivityHistory {
	
	@Inject
	private ActivityHistory activityHistory;
	
	public String searchHistory() {
		//logic to return certain results
		if (){
		return find;
		}
	}

	public ActivityHistory getActivityHistory() {
		return activityHistory;
	}

	public void setActivityHistory(ActivityHistory activityHistory) {
		this.activityHistory = activityHistory;
	}

}