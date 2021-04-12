package com.orangetalents.vaccineapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.orangetalents.vaccineapi.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query("SELECT obj FROM User obj JOIN FETCH obj.records WHERE obj IN :users ")
	List<User> findUsersWithRecords(List<User> users);
}
