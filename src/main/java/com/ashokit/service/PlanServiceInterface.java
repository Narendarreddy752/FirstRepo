package com.ashokit.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ashokit.binding.Plan;
import com.ashokit.entity.PlanMaster;

@Service
public interface PlanServiceInterface {
	
	public Map<Integer,String> getPlanCategories();
	
	public boolean createPlan(Plan plan);
	
	public List<PlanMaster> getAllPlans();
	
	public PlanMaster getPlanById(Integer planId);
	
	public boolean editPlan(Plan plan);
	
	public boolean deletePlan(Integer planId);
	
	public boolean actionChangeStatus(Integer planId, String status);

}
