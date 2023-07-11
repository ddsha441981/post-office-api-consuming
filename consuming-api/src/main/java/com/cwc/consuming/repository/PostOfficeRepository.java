package com.cwc.consuming.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cwc.consuming.model.PostOfficeRequest;

@Repository
public interface PostOfficeRepository extends JpaRepository<PostOfficeRequest, Integer>{

}
