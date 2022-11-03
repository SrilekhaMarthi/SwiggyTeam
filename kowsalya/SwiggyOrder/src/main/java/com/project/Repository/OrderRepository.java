package com.project.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.project.Entity.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders,Integer>{
    @Modifying
	@Query("update Orders set orderStatus='CANCELED' where order_id=?1 ")
	void cancelOrder(int id);
 
    @Modifying
   	@Query("update Orders set status='ON THE WAY TO DELIVERY' where order_id=?1 ")
	void changeStatus(int id);
    
    @Modifying
   	@Query("update Orders set status='DELIVERED' where order_id=?1 ")
	void changeToDelivered(int id);
}