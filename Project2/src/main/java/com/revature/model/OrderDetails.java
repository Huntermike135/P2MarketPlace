package com.revature.model;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "Market_orderdetails")
public class OrderDetails {
	@Id
	@Column(name = "orderline_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer orderlineId;

	@Column(name = "order_id")
	public Integer orderId;

	@Column(name = "item_id")
	public Integer itemId;

	@Column(name = "user_id")
	public Integer userId;

	@Column(name = "date_created")
	public LocalDate dateCreated;

	@Column(name = "quantity")
	public Integer quantity;

	public OrderDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderDetails(Integer orderlineId, Integer orderId, Integer itemId, Integer userId, LocalDate dateCreated,
			Integer quantity) {
		super();
		this.orderlineId = orderlineId;
		this.orderId = orderId;
		this.itemId = itemId;
		this.userId = userId;
		this.dateCreated = dateCreated;
		this.quantity = quantity;
	}

	public Integer getOrderlineId() {
		return orderlineId;
	}

	public void setOrderlineId(Integer orderlineId) {
		this.orderlineId = orderlineId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public LocalDate getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateCreated, itemId, orderId, orderlineId, quantity, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderDetails other = (OrderDetails) obj;
		return Objects.equals(dateCreated, other.dateCreated) && Objects.equals(itemId, other.itemId)
				&& Objects.equals(orderId, other.orderId) && Objects.equals(orderlineId, other.orderlineId)
				&& Objects.equals(quantity, other.quantity) && Objects.equals(userId, other.userId);
	}

	@Override
	public String toString() {
		return "OrderDetails [orderlineId=" + orderlineId + ", orderId=" + orderId + ", itemId=" + itemId + ", userId="
				+ userId + ", dateCreated=" + dateCreated + ", quantity=" + quantity + "]";
	}
	
}
