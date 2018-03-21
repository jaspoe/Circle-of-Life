package application;

import java.util.Random;

public class Dice {
	private Random random = new Random();

	public int roll(int dice){
		return random.nextInt(dice) + 1;
	}
}
