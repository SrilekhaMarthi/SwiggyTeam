package com.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.project.Entity.Offers;

@Repository
public interface OfferRepository extends JpaRepository<Offers,Integer> {

	@Query("select v from Offers v where value=?1")
	Offers value(String grd);


}
