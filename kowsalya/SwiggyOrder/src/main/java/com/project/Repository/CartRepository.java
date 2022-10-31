package com.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.project.Entity.Cart;
@Repository
public interface CartRepository extends JpaRepository<Cart,Integer>{

}
