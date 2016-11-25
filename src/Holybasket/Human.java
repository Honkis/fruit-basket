package Holybasket;

import java.util.Random;

public class Human implements Runnable {
	private String name;
	private FruitBasket fruitbasket;	// all humans share fruitbasket
	private int energy;
	
	public Human(String name, FruitBasket fruitbasket){
		this.name = name;
		this.fruitbasket = fruitbasket;
	}


	@Override
	public void run() {
		
		randomEnergy();  //gives random energy to the human
		System.out.println(name + " was created with "+ energy + " energy");
		
		while (true){
			
			
			if(energy < 20){	// if their energy drops below 20 they will get hungry.
				try{
				
					System.out.println(name + " is hungry ...... :(");
					
					humanEat();
					randomFruitGenerator();
				}catch (ArrayIndexOutOfBoundsException e){	// if they get hungry and there is no food they die. thread stops
					System.out.println(name +" died from hunger! :/");
					break;
				}
			}
			try{
				energy-= 10;
				Thread.sleep((int)(1000.0));
			}catch (InterruptedException e){
				System.out.println("No one sleeps when im awake");
			}
		}
		
		
	}
	public int randomEnergy() {	// returns a random nr between 30-90
		
		Random random = new Random();
		energy = random.nextInt(61)+ 30; // Generates a random nr between 0-60 and adds +30
		return energy;
	}
	public String toString(){
		return name + energy;
	}
	public int humanEat(){	// human eats last fruit added to the basket.
		synchronized(fruitbasket){
			energy += fruitbasket.topFruitToInt();
			System.out.println(name + " ate a " + fruitbasket.topFruitToString() + " with the energy of " + fruitbasket.topFruitToStringEnergy());
			fruitbasket.removeTopFruit();
			
			System.out.println(name + " has the new energy of " + energy);
			System.out.println("! Fruitbasket now countains " + fruitbasket.basketSize() + " fruits!");
			return energy;
		}
	}
	public void startHuman(){
		Thread t = new Thread(new Human(name, fruitbasket));
		t.start();
	}
	public void randomFruitGenerator(){ // has 1 out of 5 chans to add 5 moar fruits
		synchronized(fruitbasket){	
			int chansOnMoarFruitsTemp;
			
			Random r = new Random();
			chansOnMoarFruitsTemp = r.nextInt(6)+1; // generates a number between 1-5
			
			if(chansOnMoarFruitsTemp == 1){
				fruitbasket.addFruits(5);
				System.out.println("! Fruitbasket now countains " + fruitbasket.basketSize() + " fruits!");
			}
		}
	}

}
