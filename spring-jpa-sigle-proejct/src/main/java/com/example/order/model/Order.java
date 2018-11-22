package com.example.order.model;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import com.example.member.model.Member;

@SqlResultSetMapping(
        name="OrderSummaryMapping",
        classes = @ConstructorResult(
                targetClass = OrderSummary.class,
                columns = {
                        @ColumnResult(name="orderId", type = BigInteger.class),
                        @ColumnResult(name="userName", type = String.class),
                        @ColumnResult(name="sumTotal", type = BigInteger.class),
                        @ColumnResult(name="representItemNm", type = String.class),
                        @ColumnResult(name="totalAmount", type = Integer.class)
                })
)
@Entity
@SequenceGenerator(name = "ORDER_SEQ_GENERATOR", sequenceName = "ORDER_SEQ")
@Table(name="ORDERS")
public class Order {
	
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="ORDER_SEQ_GENERATOR") 
	@Column(name = "ORDER_ID")
	private long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "USER_NAME")
	private Member orderer;
	
	@Embedded
	private ReciverInfo reciverInfo;
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	List<OrderItem> orderItems;

	long sumTotal;
	
	protected Order() {
		
	}
	
	public  Order(Member  orderer,ReciverInfo reciverInfo, List<OrderItem> orderItems) {
		this.orderer = orderer;
		this.reciverInfo = reciverInfo;
		this.orderItems = orderItems;
        for (OrderItem orderItem : orderItems) {
        	orderItem.addOrder(this);
        }
/*		회사 셋업 정첵에 따라서 다르게 선택
 *  	setorderer(orderer);
		setReciverInfo(reciverInfo);
		setOrderItems(orderItems);*/
		caculate(orderItems);
	}

/*	private void setorderer(String  orderer) {
		this.orderer = orderer;
	}
	
	private void setReciverInfo(ReciverInfo reciverInfo) {
		this.reciverInfo = reciverInfo;
	}
	
	private void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}*/
	public void caculate(List<OrderItem> orderItems) {
		this.sumTotal = orderItems.stream().mapToLong(o->o.getAmount() * o.getOrderPrice()).sum();
	}

	public long getId() {
		return id;
	}

	public ReciverInfo getReciverInfo() {
		return reciverInfo;
	}

	public long getSumTotal() {
		return sumTotal;
	} 
	
}
