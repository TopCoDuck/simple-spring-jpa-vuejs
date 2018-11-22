package com.example.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.order.model.Order;

public interface OrderRepository extends JpaRepository<Order,Long>{
	
//	@Query("select o from Order o where o.orderer.userName = :userName")
//	List<Order> findByUserName(@Param("userName") String userName,Pageable pageable);
}
