package com.gf_pizza.restaurant;

import java.util.Random;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Table {
	
	private static Random rd = new Random();
	private long tableId = Math.abs(rd.nextLong());
	private int maxCover;
	private E_TableStatus status;

	public Table(int maxCover, E_TableStatus status) {
		this.maxCover = maxCover;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Table [tableId=" + tableId + ", maxCover=" + maxCover + ", status=" + status + "]";
	}
}
