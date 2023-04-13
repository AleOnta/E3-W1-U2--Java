package com.gf_pizza.restaurant;

import java.util.List;

import com.gf_pizza.dec_pattern.component.Consummation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {

	private static long orderCounter = 100;
	private long orderId;
	private long tableId;
	private int covers;
	private E_OrderStatus status;
	private List<Consummation> consList;
	
	public Order() {
		orderCounter++;
		orderId = orderCounter;
	}
	
	public Order(Table table, E_OrderStatus status, int covers, List<Consummation> consummationsList) {
		orderCounter++;
		orderId = orderCounter;
		tableId = table.getTableId();
		this.covers = covers;
		this.status = status;
		consList = consummationsList;
	}
	
	public double calculateCoversCosts() {
		return 1.5 * covers;
	}
	
	public double getTotalAmount() {
		double total = 0;
		for (Consummation c : consList) {
			total += c.getPrice();
		}
		total += this.calculateCoversCosts();
		return total;
	}
	
	public String consToString() {
		int count = 1;
		String toReturn = "";
		for (Consummation c : consList) {
			toReturn += count + " - " + c.toString() + "\n"; 
			count++;
		}
		return toReturn;
	}

	@Override
	public String toString() {
		return "Order --> orderId=" + orderId + ", tableId=" + tableId + ", covers=" + covers + ", status=" + status
				+ ", totAmount=" + String.format("%.2f", this.getTotalAmount()) + "€, \nProducts ordered: \n" + consToString();
	}
	
	
	
}
