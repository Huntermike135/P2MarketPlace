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
@Table( name="Market_Orders")
public class Orders{
  @Id
  @Column(name = "order_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer orderId;
  @Column(name = "user_id")
  private Integer userId;
  
  
  @Column(name = "date_created")
  private LocalDate dateCreated;

public Orders() {
	super();
	// TODO Auto-generated constructor stub
}

public Orders(Integer orderId, Integer userId, LocalDate dateCreated) {
	super();
	this.orderId = orderId;
	this.userId = userId;
	this.dateCreated = dateCreated;
}

public Integer getOrderId() {
	return orderId;
}

public void setOrderId(Integer orderId) {
	this.orderId = orderId;
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

@Override
public int hashCode() {
	return Objects.hash(dateCreated, orderId, userId);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Orders other = (Orders) obj;
	return Objects.equals(dateCreated, other.dateCreated) && Objects.equals(orderId, other.orderId)
			&& Objects.equals(userId, other.userId);
}

@Override
public String toString() {
	return "Orders [orderId=" + orderId + ", userId=" + userId + ", dateCreated=" + dateCreated + "]";
}


  
}