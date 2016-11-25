package Holybasket;

import java.util.Random;

public class Banana extends Fruit{
	private int energy = randomEnergy();
	private String fruit = "Banana";
	
	@Override
	public int randomEnergy() { // returns a random nr between 25-35
		
		Random random = new Random();
		energy = random.nextInt(11)+25; // Generates a random nr between 0-10 and adds +25
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


