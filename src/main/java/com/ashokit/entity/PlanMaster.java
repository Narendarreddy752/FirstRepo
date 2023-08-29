package com.ashokit.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "PLAN_MASTER")
public class PlanMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer planId;

	private String planName;

	private LocalDate planStartDate;

	private LocalDate planEndDate;

	private Integer planCategoryId;

	private String actionStatus;

	private String createdBy;

	private String updatedBy;

	@CreationTimestamp
	@Column(name = "CREATED_DATE", updatable = false)
	private LocalDate createdDate;

	@UpdateTimestamp
	@Column(name = "UPDATED_DATE", insertable = false)
	private LocalDate updatedDate;

}
