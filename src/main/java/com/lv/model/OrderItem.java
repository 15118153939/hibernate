package com.lv.model;

import java.io.Serializable;

public class OrderItem implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;// ����
	private OrderForm orderForm;
	private Commodity commodity;// ������Ʒ
	private Double discount;// �ۿ�
	private Double actPrice;// �۸�
	private Double amount;// ����
	private Integer position;
	
	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}







	public OrderForm getOrderForm() {
		return orderForm;
	}



	public void setOrderForm(OrderForm orderForm) {
		this.orderForm = orderForm;
	}



	public Commodity getCommodity() {
		return commodity;
	}



	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}



	public Double getDiscount() {
		return discount;
	}



	public void setDiscount(Double discount) {
		this.discount = discount;
	}



	public Double getActPrice() {
		return actPrice;
	}



	public void setActPrice(Double actPrice) {
		this.actPrice = actPrice;
	}



	public Double getAmount() {
		return amount;
	}



	public void setAmount(Double amount) {
		this.amount = amount;
	}



	public Integer getPosition() {
		return position;
	}



	public void setPosition(Integer position) {
		this.position = position;
	}



	public String toString() {
		return "������ϸ����:" + this.getId() + "    |    ��Ʒ:"
				+ this.getCommodity().getName() + "    |     �ۿ�:"
				+ this.getDiscount() + "    |   �۸� :" + this.getActPrice()
				+ "    |   ����:" + this.getAmount();
	}
}