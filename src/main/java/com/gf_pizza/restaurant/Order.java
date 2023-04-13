package com.gf_pizza.restaurant;

import java.util.List;
import java.util.Random;

import com.gf_pizza.dec_pattern.component.Consummation;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Order {
	
	private static Random rd = new Random();
	private long orderId = Math.abs(rd.nextLong());
	private long tableId;
	private int covers;
	private E_OrderStatus status;
	private List<Consummation> consList;
	
	public Order(long tableId, int covers, E_OrderStatus status, List<Consummation> consList) {
		super();
		this.tableId = tableId;
		this.covers = covers;
		this.status = status;
		this.consList = consList;
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
				+ ", totAmount=" + String.format("%.2f", this.getTotalAmount()) + "€, \n\nOrdered products: \n" + consToString();
	}
}
