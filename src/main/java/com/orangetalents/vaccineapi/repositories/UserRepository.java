package com.orangetalents.vaccineapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orangetalents.vaccineapi.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
