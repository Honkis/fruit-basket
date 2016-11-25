package Holybasket;

import java.util.Random;
import java.util.Vector;

public class FruitBasket {
	private Vector<Fruit> fruitbasket = new Vector<Fruit>();
	Fruit fruit = null;
	
	public synchronized void addFruits(int numberOfFruitsToAdd){	// adds fruits randome fruits to the basket.
		for(int i = 1; i <= numberOfFruitsToAdd ; ++i){

			Random random = new Random();
			
			int whatFruitToAdd = random.nextInt(3)+1; // generates random number 1 2 or 3
			
			if(whatFruitToAdd == 1){	// adds a apple to the basket
				fruit = new Apple();
				fruitbasket.add(fruit);
			}else if (whatFruitToAdd == 2){ // adds banana to the basket
				fruit = new Banana();
				fruitbasket.add(fruit);
			}else {
				fruit = new Pear(); // adds pear to the basket
				fruitbasket.add(fruit);
			}
			System.out.println("- " + fruitbasket.get(fruitbasket.size()-1).FruiTtoString() + " Was added to the fruit basket. " +"with the energy of " + fruitbasket.get(fruitbasket.size()-1).energyToString());
		}
	}
	public synchronized void removeTopFruit(){	// removes last element of the fruitbasket
		 fruitbasket.remove(fruitbasket.lastElement());
	}
	public String topFruitToString(){
		return fruitbasket.get(fruitbasket.size()-1).FruiTtoString();
	}
	public String topFruitToStringEnergy(){
		return fruitbasket.get(fruitbasket.size()-1).energyToString();
	}
	public int topFruitToInt(){
		return fruitbasket.get(fruitbasket.size()-1).toInt();
	}
	public int basketSize(){
		return fruitbasket.size();
	}
	
}
