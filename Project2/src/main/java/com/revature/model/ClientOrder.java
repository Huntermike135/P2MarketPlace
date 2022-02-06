package com.revature.model;
import java.util.List;
import java.util.Objects;


public class ClientOrder {
	 
	public Integer userId; 
	 
	  public List<Integer> itemIds; 
	
	  
	 public ClientOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ClientOrder(Integer userId, List<Integer> itemIds) {
		super();
		this.userId = userId;
		this.itemIds = itemIds;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public List<Integer> getItemIds() {
		return itemIds;
	}
	public void setItemIds(List<Integer> itemIds) {
		this.itemIds = itemIds;
	}
	@Override
	public int hashCode() {
		return Objects.hash(itemIds, userId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClientOrder other = (ClientOrder) obj;
		return Objects.equals(itemIds, other.itemIds) && Objects.equals(userId, other.userId);
	}
	@Override
	public String toString() {
		return "ClientOrder [userId=" + userId + ", itemIds=" + itemIds + "]";
	}

}
