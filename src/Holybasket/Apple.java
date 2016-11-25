package Holybasket;

import java.util.Random;

public class Apple extends Fruit{
	private int energy = randomEnergy();
	private String fruit = "Apple";
	
	@Override
	public int randomEnergy() { // returns a random nr between 20-30
		
		Random random = new Random();
		energy = random.nextInt(11)+20; // Generates a random nr between 0-10 and adds +20
		return energy; 
	}

	@Override
	public int toInt() {
		return energy;
	}

	@Override
	public String FruiTtoString() {
		return fruit;
	}



	@Override
	public String energyToString() {
		return energy + "";
	}
}


