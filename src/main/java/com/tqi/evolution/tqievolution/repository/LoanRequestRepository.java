package com.tqi.evolution.tqievolution.repository;

import com.tqi.evolution.tqievolution.entity.LoanRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LoanRequestRepository extends JpaRepository<LoanRequest, Long> {

    @Query("SELECT lr FROM loan_request lr JOIN lr.user u ON u.email = ?1")
    List<LoanRequest> findByUserUsername(String username);

}
