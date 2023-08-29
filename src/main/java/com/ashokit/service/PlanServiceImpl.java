package com.ashokit.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.binding.Plan;
import com.ashokit.entity.PlanCategory;
import com.ashokit.entity.PlanMaster;
import com.ashokit.repo.PlanCategoryRepository;
import com.ashokit.repo.PlanRepository;


@Service
public class PlanServiceImpl implements PlanServiceInterface {

	@Autowired
	PlanCategoryRepository planCategoryRepo;

	@Autowired
	PlanRepository planRepo;

	PlanMaster planMaster = new PlanMaster();

	@Override
	public Map<Integer, String> getPlanCategories() {
		List<PlanCategory> planCategories = planCategoryRepo.findAll();
		Map<Integer, String> categoryMap = new HashMap<Integer, String>();
		for (PlanCategory pc : planCategories) {
			categoryMap.put(pc.getPlanCategoryId(), pc.getPlanCategoryName());
		}
		return categoryMap;
	}

	@Override
	public boolean createPlan(Plan plan) {
		BeanUtils.copyProperties(plan, planMaster);
		PlanMaster save = planRepo.save(planMaster);
		if (save.getPlanId() != null) {
			return true;
		}
		return false;
	}

	@Override
	public List<PlanMaster> getAllPlans() {
		List<PlanMaster> allPlans = planRepo.findAll();
		return allPlans;
	}

	@Override
	public PlanMaster getPlanById(Integer planId) {
		Optional<PlanMaster> planOptional = planRepo.findById(planId);
		if (planOptional.isPresent()) {
			PlanMaster planMaster2 = planOptional.get();
			return planMaster2;
		} else {
			return null;
		}
	}

	@Override
	public boolean editPlan(Plan plan) {
		BeanUtils.copyProperties(plan, planMaster);
		PlanMaster save = planRepo.save(planMaster);
		if (save.getPlanId() != null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean deletePlan(Integer planId) {
		boolean status;
		try {
			planRepo.deleteById(planId);
			status = true;
		} catch (Exception e) {
			status = false;
		}
		return status;
	}

	@Override
	public boolean actionChangeStatus(Integer planId, String status) {
		Optional<PlanMaster> planMasterOptional = planRepo.findById(planId);
		if (planMasterOptional.isPresent()) {
			PlanMaster planMaster2 = planMasterOptional.get();
			planMaster2.setActionStatus("Y");
			return true;
		}
		return false;
	}

}
