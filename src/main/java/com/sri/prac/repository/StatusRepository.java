package com.sri.prac.repository;





import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.sri.prac.model.Status;
@Repository
public interface StatusRepository  extends MongoRepository<Status,String> {
	public Page<Status> findByUserId(String userId, Pageable pageable);
}
