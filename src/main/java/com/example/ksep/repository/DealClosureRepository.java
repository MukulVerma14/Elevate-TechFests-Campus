package com.example.ksep.repository;

import com.example.ksep.models.DealClosure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DealClosureRepository extends JpaRepository<DealClosure, Long> {
}
