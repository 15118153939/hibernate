package com.lv.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class OrderForm implements Serializable{
	private Long id;// 主键
	private Customer customer;// 客户
	private Date tradeDate;// 交易日期
	private String status;// 订单状态
	private Double amount;// 订单金额
	private Set<OrderItem> orderItems = new HashSet<OrderItem>();// 订单明细
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public String toString() {
		return "订单主键:" + this.getId() + "    |    客户:"
				+ this.getCustomer().getName() + "    |     交易日期:"
				+ this.getTradeDate() + "    |   订单状态 :" + this.getStatus()
				+ "    |   订单金额:" + this.getAmount();
	}

}
