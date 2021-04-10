package com.orangetalents.vaccineapi.entities.dto;

import java.time.Instant;

import com.orangetalents.vaccineapi.entities.Records;

public class RecordsDTO {

	private Long id;
	private String vaccineName;
	private Instant appliedDate;
	private Long userId;

	public RecordsDTO() {
	}

	public RecordsDTO(Long id, String vaccineName, Instant appliedDate, Long userId) {
		this.id = id;
		this.vaccineName = vaccineName;
		this.appliedDate = appliedDate;
		this.userId = userId;
	}

	public RecordsDTO(Records entity) {
		this.id = entity.getId();
		this.vaccineName = entity.getVaccineName();
		this.appliedDate = entity.getAppliedDate();
		this.userId = entity.getUser().getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVaccineName() {
		return vaccineName;
	}

	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}

	public Instant getAppliedDate() {
		return appliedDate;
	}

	public void setAppliedDate(Instant appliedDate) {
		this.appliedDate = appliedDate;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
