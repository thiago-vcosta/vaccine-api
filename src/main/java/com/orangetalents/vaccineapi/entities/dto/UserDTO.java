package com.orangetalents.vaccineapi.entities.dto;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import com.orangetalents.vaccineapi.entities.Records;
import com.orangetalents.vaccineapi.entities.User;

public class UserDTO {

	private Long id;
	private String name;
	private String email;
	private String cpf;
	private Instant birthDate;
	
	Set<RecordsDTO> records = new HashSet<>();

	public UserDTO() {
	}

	public UserDTO(Long id, String name, String email, String cpf, Instant birthDate) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.cpf = cpf;
		this.birthDate = birthDate;
	}
	
	public UserDTO(User entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.cpf = entity.getCpf();
		this.email = entity.getEmail();
		this.birthDate = entity.getBirthDate();
	}
	
	public UserDTO(User entity, Set<Records> records) {
		this(entity);
		entity.getRecords().forEach(rec -> this.records.add(new RecordsDTO(rec)));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Instant getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Instant birthDate) {
		this.birthDate = birthDate;
	}

	public Set<RecordsDTO> getRecords() {
		return records;
	}
	
}
