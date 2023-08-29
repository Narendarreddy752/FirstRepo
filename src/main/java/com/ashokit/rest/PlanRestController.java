package com.ashokit.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.binding.Plan;
import com.ashokit.entity.PlanMaster;
import com.ashokit.service.PlanServiceInterface;

@RestController
public class PlanRestController {
	
	@Autowired
	PlanServiceInterface service;
	
	String msg="";
	
	@GetMapping("/categories")
	public ResponseEntity<Map<Integer,String>> getPlanCategories(){
		Map<Integer,String> planCategories = service.getPlanCategories();
		return new ResponseEntity<Map<Integer,String>>(planCategories, HttpStatus.OK);
	}
	
	@PostMapping("/saveplan")
	public ResponseEntity<String> savePlan(@RequestBody Plan plan){
		 boolean isSaved = service.createPlan(plan);
		 
		 if(isSaved) {
			 msg="Plan Saved Successfully";
		 }else {
			 msg="plan not saved";
		 }
		 return new ResponseEntity<String> (msg, HttpStatus.OK);
	}
	
	@GetMapping("/getPlans")
	public ResponseEntity<List<PlanMaster>> getAllPlans(){
		List<PlanMaster> allPlans = service.getAllPlans();
		return new ResponseEntity<List<PlanMaster>>(allPlans, HttpStatus.OK);
	}
	
	@GetMapping("/getPlan/{planId}")
	public ResponseEntity<PlanMaster> getPlanById (@PathVariable Integer planId){
		PlanMaster planById = service.getPlanById(planId);
		return new ResponseEntity<PlanMaster> (planById, HttpStatus.OK);
	}
	
	@PutMapping("/editPlan")
	public ResponseEntity<String> editPlan(@RequestBody Plan plan){
		boolean editPlan = service.editPlan(plan);
		 
		if(editPlan) {
			msg="Plan edited Successfully";
		}else {
			msg="plan is not edited";
		}
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
	@DeleteMapping("/deletePlan/{planId}")
	public ResponseEntity<String> deletePlan(@PathVariable Integer planId){
		boolean deletePlan = service.deletePlan(planId);
		if(deletePlan) {
			msg="plan deleted successfully";
		}else {
			msg="plan not deleted";
		}
		return new ResponseEntity<String> (msg, HttpStatus.OK);
	}
	
	@GetMapping("/changeStatus/{planId}/{status}")
	public ResponseEntity<String> ChangeActiveStatus(@PathVariable Integer planId, String status){
		boolean actionChangeStatus = service.actionChangeStatus(planId, status);
		if(actionChangeStatus) {
			 msg="Status is changed";
		}else {
			msg="status is not changed";
		}
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}

}
