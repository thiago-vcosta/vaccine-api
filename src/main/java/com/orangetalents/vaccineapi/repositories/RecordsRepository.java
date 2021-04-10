package com.orangetalents.vaccineapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orangetalents.vaccineapi.entities.Records;

@Repository
public interface RecordsRepository extends JpaRepository<Records, Long>{

}
