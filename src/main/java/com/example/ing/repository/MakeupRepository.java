package com.example.ing.repository;

import com.example.ing.domain.Makeup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MakeupRepository extends JpaRepository<Makeup, Long>, JpaSpecificationExecutor<Makeup> {

}
