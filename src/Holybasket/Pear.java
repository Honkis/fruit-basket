package Holybasket;

import java.util.Random;

public class Pear extends Fruit{
	private int energy= randomEnergy();
	private String fruit = "Pear";
	
	@Override
	public int randomEnergy() { // returns a random nr between 20-40
		
		Random random = new Random();
		energy = random.nextInt(21)+20; // Generates a random nr between 0-20 and adds +20
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
