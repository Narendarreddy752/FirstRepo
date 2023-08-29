package com.ashokit.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashokit.entity.PlanMaster;

@Repository
public interface PlanRepository extends JpaRepository<PlanMaster, Integer> {

}
