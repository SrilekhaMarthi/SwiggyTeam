package com.project.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.project.Entity.DeliveryMan;

@Repository
public interface DeliveryManRepository extends JpaRepository<DeliveryMan,Integer>{

	@Query("select dm from DeliveryMan dm where deliveryManLocation = ?1")
	DeliveryMan getDetails(String l);
}