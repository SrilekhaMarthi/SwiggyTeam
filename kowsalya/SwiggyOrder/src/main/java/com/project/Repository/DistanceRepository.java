package com.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.Entity.Distance;
@Repository
public interface DistanceRepository extends JpaRepository<Distance,Integer>{

	@Query("select s from Distance s where location = ?1")
	Distance getChargeByLocation(String dec);

   

}
