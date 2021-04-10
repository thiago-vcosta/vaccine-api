package com.orangetalents.vaccineapi.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

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
import com.orangetalents.vaccineapi.entities.dto.UserDTO;
import com.orangetalents.vaccineapi.repositories.RecordsRepository;
import com.orangetalents.vaccineapi.repositories.UserRepository;
import com.orangetalents.vaccineapi.services.exception.DatabaseException;
import com.orangetalents.vaccineapi.services.exception.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private RecordsRepository recordsRepository;
	
	@Transactional(readOnly = true)
	public Page<UserDTO> findAllPaged(PageRequest pageRequest) {
		Page<User> list = repository.findAll(pageRequest);		
		return list.map(x -> new UserDTO(x));				
		}
	
	@Transactional(readOnly = true)
	public UserDTO findById(Long id) {
		Optional<User> obj = repository.findById(id);
		User entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entidade não encontrada"));
		return new UserDTO(entity);
	}

	@Transactional
	public UserDTO insert(UserDTO dto) {
		try {
		User entity = new User();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new UserDTO(entity);
		} 
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Erro no cadastro");
		}
	}

	@Transactional
	public UserDTO update(Long id, UserDTO dto) {
		try {
			User entity = repository.getOne(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new UserDTO(entity);
		}
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id não encontrado " + id);
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
	
	private void copyDtoToEntity(UserDTO dto, User entity) {
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		entity.setCpf(dto.getCpf());
		entity.setBirthDate(dto.getBirthDate());
		
		entity.getRecords().clear();
		for(RecordsDTO recDto : dto.getRecords()) {
			Records records = recordsRepository.getOne(recDto.getId());
			entity.getRecords().add(records);
		}
	}
}

