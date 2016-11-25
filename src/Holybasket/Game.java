package Holybasket;

public class Game {
	private FruitBasket fruitbasket = new FruitBasket();
	
	public void startGame(){
		fruitbasket.addFruits(20); // adds 20 fruits at the start of the game to the basket
		
		System.out.println(" Fruitbasket was created with 20 fruits");
		
		Human Greger = new Human("Greger", fruitbasket); // makes the human threads
		Human Sven = new Human("Sven", fruitbasket);
		Human Lisa = new Human("Lisa", fruitbasket);
		Lisa.startHuman();	//starts all threads.
		Greger.startHuman();
		Sven.startHuman();
	}
	
}
