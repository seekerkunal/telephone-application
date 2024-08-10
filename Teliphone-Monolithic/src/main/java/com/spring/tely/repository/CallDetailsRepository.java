package com.spring.tely.repository;


import java.util.List;

import com.spring.tely.entity.CallDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CallDetailsRepository extends JpaRepository<CallDetails, Long> {

	List<CallDetails> findByCalledBy(long calledBy);
}
