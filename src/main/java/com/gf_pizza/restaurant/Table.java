package com.gf_pizza.restaurant;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Table {
	
	private static long tableCounter = 0;
	private long tableId;
	private int maxCover;
	private E_TableStatus status;
	
	public Table() {
		tableCounter++;
		tableId = tableCounter;
	}
	
	public Table(int maxCover, E_TableStatus status) {
		tableCounter++;
		tableId = tableCounter;
		this.maxCover = maxCover;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Table [tableId=" + tableId + ", maxCover=" + maxCover + ", status=" + status + "]";
	}
}
