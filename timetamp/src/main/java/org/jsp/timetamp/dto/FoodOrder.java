package org.jsp.timetamp.dto;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class FoodOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String foodName;
	private double cost;
	@CreationTimestamp
	private LocalDateTime order_time;
	@UpdateTimestamp
	private LocalDateTime delevry_time;

	public int getId() {
		return id;
	}

	public String getFoodName() {
		return foodName;
	}

	public double getCost() {
		return cost;
	}

	public LocalDateTime getOrder_time() {
		return order_time;
	}

	public LocalDateTime getDelevry_time() {
		return delevry_time;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public void setOrder_time(LocalDateTime order_time) {
		this.order_time = order_time;
	}

	public void setDelevry_time(LocalDateTime delevry_time) {
		this.delevry_time = delevry_time;
	}

}
