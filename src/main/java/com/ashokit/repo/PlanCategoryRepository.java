package com.ashokit.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.ashokit.entity.PlanCategory;

@Repository
public interface PlanCategoryRepository extends JpaRepository<PlanCategory, Integer> {

}
