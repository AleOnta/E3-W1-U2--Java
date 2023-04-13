package com.gf_pizza;

import java.util.ArrayList;
import com.gf_pizza.restaurant.*;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import com.gf_pizza.dec_pattern.component.Consummation;
import com.gf_pizza.dec_pattern.concrete_component.ConcretePizza;
import com.gf_pizza.config.*;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Component
public class RestaurantRunner implements CommandLineRunner {
	
	private static Scanner sc = new Scanner(System.in);

	@Override
	public void run(String... args) throws Exception {
		configWith_Beans();
	}
	
	public void configWith_Beans() {
		// exercise 2
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(MenuConfiguration.class);
		List<Table> tableList = new ArrayList<Table>();
		
		Table t1 = (Table) appContext.getBean("table", 6);
		tableList.add(t1);
		Table t2 = (Table) appContext.getBean("table", 4);
		tableList.add(t2);
		Table t3 = (Table) appContext.getBean("table", 2);
		tableList.add(t3);
		Table t4 = (Table) appContext.getBean("table", 4);
		tableList.add(t4);
		
		System.out.println("Welcome to GodFather's Pizza, how many persons are you?");
		int actualCovers = askForInteger();
		
		List<Table> availableTable = tableList.stream()
				.filter(t -> t.getStatus().equals(E_TableStatus.AVAILABLE))
				.filter(t -> t.getMaxCover() >= actualCovers)
				.collect(Collectors.toList());
		
		if (availableTable.size() > 0) {
			System.out.println("Okay then, accommodate yourself");
			Table assignedTable = availableTable.get(0);
			assignedTable.setStatus(E_TableStatus.OCCUPIED);
			List<Consummation> ordered = new ArrayList<Consummation>();
			
			int j = actualCovers;
			while (j > 0) {
				System.out.println("1 - Pizza & Drink \n"
						+ "2 - Only Pizza \n"
						+ "3 - Only Drink \n");
							
				int orderPick = askForInteger(1, 3);
								
				switch (orderPick) {
					case 1 -> {
						System.out.println("\nOkay, let's order a drink");
						String[] drinksArray = {"Still Water", "Sparkling Water", "CocaCola", "The", "Beer"};
									
						for (int i = 0; i < drinksArray.length; i++) {
							System.out.println((i+1) + " - " + drinksArray[i]);
						}
									
						System.out.println("\nSelect a drink by her own code");
						int drinkChoice = askForInteger(1, 5);
								
						Consummation drink = null;
						switch (drinkChoice) {
							case 1 -> drink = (Consummation) appContext.getBean("still_water");
							case 2 -> drink = (Consummation) appContext.getBean("sparkling_water");
							case 3 -> drink = (Consummation) appContext.getBean("coca_cola");
							case 4 -> drink = (Consummation) appContext.getBean("the");
							case 5 -> drink = (Consummation) appContext.getBean("beer");
						}
									
						System.out.println("\nWould you like to order a normal pizza or a large one?");
						String pizzaSize = askLetters("l", "n");
								
						System.out.println("\nOkay then, what pizza would you like to order?");
						String[] pizzasArray = {"Margherita", "With ham", "Ham & Mushrooms", "Hawaiian", "Double Ham", "Custom"};
							
						for (int i = 0; i < pizzasArray.length; i++) {
							System.out.println((i+1) + " - " + pizzasArray[i]);
						}
									
						System.out.println("\nSelect a pizza by his own code");
						int pizzaChoice = askForInteger(1, 6);
									
						Consummation pizza = null;
						switch (pizzaChoice) {
							case 1 -> pizza = (Consummation) appContext.getBean("margherita");
							case 2 -> pizza = (Consummation) appContext.getBean("ham", new ConcretePizza());
							case 3 -> pizza = (Consummation) appContext.getBean("mushrooms", (Consummation) appContext.getBean("ham", new ConcretePizza()));
							case 4 -> pizza = (Consummation) appContext.getBean("ham", (Consummation) appContext.getBean("ananas", new ConcretePizza()));
							case 5 -> pizza = (Consummation) appContext.getBean("doubleHam", new ConcretePizza());
							case 6 -> {
								System.out.println("\nOkay, what toppings would you like to add?");
								
								List<Integer> customerToppingsList = new ArrayList<Integer>();
								boolean otherTopping = true;
								do {
									String[] toppingsArray = {"Ham", "Mushrooms", "DoubleHam", "Ananas"};
									for (int i = 0; i < toppingsArray.length; i++) {
										System.out.println((i+1) + " - " + toppingsArray[i]);
									}								
									
									int toppingPicked = askForInteger(1, 4);
									customerToppingsList.add(toppingPicked);
												
									System.out.println("\nWould you like to add others toppings?");
									String others = askLetters("y", "n");
									if (others.equals("n")) {
										otherTopping = false;
									} 
								} while (otherTopping);
										
								pizza = (Consummation) appContext.getBean("margherita");
								for (Integer i : customerToppingsList) {
									switch (i) {
										case 1 -> pizza = (Consummation) appContext.getBean("ham", pizza); 
										case 2 -> pizza = (Consummation) appContext.getBean("mushrooms", pizza); 
										case 3 -> pizza = (Consummation) appContext.getBean("doubleHam", pizza); 
										case 4 -> pizza = (Consummation) appContext.getBean("ananas", pizza); 								}
									}
								}						
							}
									
							if (pizzaSize.equals("l")) {
								pizza = (Consummation) appContext.getBean("large", pizza);
							}
							
							ordered.add(pizza);
							ordered.add(drink);
						}
						
					case 2 -> {
						System.out.println("\nWould you like to order a normal pizza or a large one?");
						String pizzaSize = askLetters("l", "n");
							
						System.out.println("\nOkay then, what pizza would you like to order?");
						String[] pizzasArray = {"Margherita", "With ham", "Ham & Mushrooms", "Hawaiian", "Double Ham", "Custom"};
								
						for (int i = 0; i < pizzasArray.length; i++) {
							System.out.println((i+1) + " - " + pizzasArray[i]);
						}
								
						System.out.println("\nSelect a pizza by her own code");
						int pizzaChoice = askForInteger(1, 6);
								
						Consummation pizza = null;
						switch (pizzaChoice) {
							case 1 -> pizza = (Consummation) appContext.getBean("margherita");
							case 2 -> pizza = (Consummation) appContext.getBean("ham", new ConcretePizza());
							case 3 -> pizza = (Consummation) appContext.getBean("mushrooms", (Consummation) appContext.getBean("ham", new ConcretePizza()));
							case 4 -> pizza = (Consummation) appContext.getBean("ham", (Consummation) appContext.getBean("ananas", new ConcretePizza()));
							case 5 -> pizza = (Consummation) appContext.getBean("doubleHam", new ConcretePizza());
							case 6 -> {
								System.out.println("\nOkay, what toppings would you like to add?");
										
								List<Integer> customerToppingsList = new ArrayList<Integer>();
								boolean otherTopping = true;
								do {
									String[] toppingsArray = {"Ham", "Mushrooms", "DoubleHam", "Ananas"};
									for (int i = 0; i < toppingsArray.length; i++) {
										System.out.println((i+1) + " - " + toppingsArray[i]);
									}
											
									int toppingPicked = askForInteger(1, 4);
									customerToppingsList.add(toppingPicked);
										
									System.out.println("\nWould you like to add others toppings?");
									String others = askLetters("y", "n");
									if (others.equals("n")) {
										otherTopping = false;
									} 
								} while (otherTopping);
											
								pizza = (Consummation) appContext.getBean("margherita");
								for (Integer i : customerToppingsList) {
									switch (i) {
										case 1 -> pizza = (Consummation) appContext.getBean("ham", pizza); 
										case 2 -> pizza = (Consummation) appContext.getBean("mushrooms", pizza); 
										case 3 -> pizza = (Consummation) appContext.getBean("doubleHam", pizza); 
										case 4 -> pizza = (Consummation) appContext.getBean("ananas", pizza); 
									}
								}
							}
						}
								
						if (pizzaSize.equals("l")) {
							pizza = (Consummation) appContext.getBean("large", pizza);
						}					
						
						ordered.add(pizza);
					}
								
					case 3 -> {
									
						System.out.println("\nOkay, let's order a drink");
						String[] drinksArray = {"Still Water", "Sparkling Water", "CocaCola", "The", "Beer"};
							
						for (int i = 0; i < drinksArray.length; i++) {
							System.out.println((i+1) + " - " + drinksArray[i]);
						}
								
						System.out.println("\nSelect a drink by his own code");
						int drinkChoice = askForInteger(1, 5);
							
						Consummation drink = null;
						switch (drinkChoice) {
							case 1 -> drink = (Consummation) appContext.getBean("still_water");
							case 2 -> drink = (Consummation) appContext.getBean("sparkling_water");
							case 3 -> drink = (Consummation) appContext.getBean("coca_cola");
							case 4 -> drink = (Consummation) appContext.getBean("the");
							case 5 -> drink = (Consummation) appContext.getBean("beer");
						}		
						
						ordered.add(drink);
					}	
				}	
				j--;	
			}
			
			Order order = (Order) appContext.getBean("order", assignedTable.getTableId(), actualCovers, ordered);
			System.out.println("\n\n");
			System.out.println(assignedTable);
			System.out.println(order);
		} else {
			System.out.println("Sorry, at the moment we don't have enough space for your group");
		}
		appContext.close();
	}		

	public static int askForInteger() {
		boolean isRunning = true;
		int pick = 10;
		while (isRunning) {
			pick = sc.nextInt();
			if(pick >= 1) {
				break;
			} else {
				System.out.println("Invalid value, try again\n");
				continue;
			}		
		}
		return pick;
	}
	
	public static int askForInteger(int s, int f) {
		boolean isRunning = true;
		int pick = 10;
		while (isRunning) {
			System.out.println("\nSelect an option between the available");
			pick = sc.nextInt();
			if(pick >= s && pick <= f) {
				break;
			} else {
				System.out.println("Invalid value, try again\n");
				continue;
			}		
		}
		return pick;
	}
	
	public static String askLetters(String uno, String due) {
		boolean isRunning = true;
		String pick = "";
		while (isRunning) {
			System.out.print (uno + " / " + due + "\n");
			pick = sc.next();
			String[] pickArray = pick.split("");
			pick = pickArray[0].toLowerCase();
			if(pick.equals(uno) || pick.equals(due)) {
				break;
			} else {
				System.out.println("Invalid char, try again\n");
				continue;
			}
		}
		return pick;
	}
}
