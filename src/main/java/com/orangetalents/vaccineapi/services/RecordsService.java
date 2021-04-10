package com.orangetalents.vaccineapi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.orangetalents.vaccineapi.entities.Records;
import com.orangetalents.vaccineapi.entities.User;
import com.orangetalents.vaccineapi.entities.dto.RecordsDTO;
import com.orangetalents.vaccineapi.repositories.RecordsRepository;
import com.orangetalents.vaccineapi.services.exception.DatabaseException;
import com.orangetalents.vaccineapi.services.exception.ResourceNotFoundException;

@Service
public class RecordsService {

	@Autowired
	private RecordsRepository repository;
	
	@Transactional(readOnly = true)
	public Page<RecordsDTO> findAllPaged(PageRequest pageRequest) {
		Page<Records> list = repository.findAll(pageRequest);		
		return list.map(x -> new RecordsDTO(x));				
		}
	
	@Transactional(readOnly = true)
	public RecordsDTO findById(Long id) {
		Optional<Records> obj = repository.findById(id);
		Records entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity Not Found"));
		return new RecordsDTO(entity);
	}

	@Transactional
	public RecordsDTO insert(RecordsDTO dto) {
		try {
		Records entity = new Records();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new RecordsDTO(entity) ;
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Erro no cadastro");
		}
	}

	public void delete(Long id) {
		try {
		repository.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id não encontrado " + id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Violação de integridade");
		}
	}
	
	private void copyDtoToEntity(RecordsDTO dto, Records entity) {
		entity.setVaccineName(dto.getVaccineName());
		entity.setAppliedDate(dto.getAppliedDate());
		entity.setUser(new User(dto.getUserId()));
	}
}

