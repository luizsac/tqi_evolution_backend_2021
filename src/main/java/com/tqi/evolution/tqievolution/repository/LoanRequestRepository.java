package com.tqi.evolution.tqievolution.repository;

import com.tqi.evolution.tqievolution.entity.LoanRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LoanRequestRepository extends JpaRepository<LoanRequest, Long> {

    @Query(value = "SELECT * FROM loan_request WHERE user_id = ?1", nativeQuery = true)
    List<LoanRequest> findByUserId(long id);

}
