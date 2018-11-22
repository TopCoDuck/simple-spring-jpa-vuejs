package com.example.order.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.example.order.model.OrderItemDTO;
import com.example.order.model.OrderSummary;

@Repository
public class OrderViewRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	private String orderSummaryMappingSql =
			 		  "SELECT                                                                                          "
					 +" o.ORDER_ID AS orderId, o.USER_NAME AS userName , o.SUM_TOTAL AS sumTotal, 					   "
					 +" MAX(i.ITEM_NM) AS  representItemNm, SUM(oi.AMOUNT)  AS totalAmount                             "
					 +"FROM (                                                                                          "
					 +"  SELECT                                                                                        "
					 +"   *                                                                                            "
					 +"  FROM (                                                                                        "
					 +"    SELECT                                                                                      "
					 +"     o.ORDER_ID , o.USER_NAME , o.SUM_TOTAL                                                     "
					 +"    FROM ORDERS o                                                                               "
					 +"    WHERE USER_NAME = ?                                                                  	   "
					 +"    ORDER BY ORDER_ID DESC                                                                      "
					 +"  ) WHERE ROWNUM <= ?                                                                           "
					 +") o , ORDER_ITEM oi , ITEM i                                                                    "
					 +"WHERE o.ORDER_ID = oi.ORDER_ID                                                                  "
					 +"  AND oi.ITEM_CD = i.ITEM_CD                                                                    "
					 +"GROUP BY o.ORDER_ID , o.USER_NAME , o.SUM_TOTAL                                                 ";
	
	public List<OrderSummary> findOrderSummaryList(String userName,int limit){

		Query nativeQuery = em.createNativeQuery(orderSummaryMappingSql, "OrderSummaryMapping");
		nativeQuery.setParameter(1, userName);
		nativeQuery.setParameter(2, limit);
		return nativeQuery.getResultList();
		
	}
	
	private String orderItemDTOSql = "SELECT  new com.example.order.model.OrderItemDTO(i.itemCd , i.itemNm  , oi.amount , oi.orderPrice) "
								   + "FROM OrderItem oi join oi.item i "
								   + "WHERE oi.order.id = :orderId";
	
	public List<OrderItemDTO> findOrderItemDetail(long orderId){
		
		TypedQuery<OrderItemDTO> query = em.createQuery(orderItemDTOSql, OrderItemDTO.class);
		query.setParameter("orderId", orderId);
		return query.getResultList();
	}
}
