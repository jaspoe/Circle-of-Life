package application;

import java.util.Random;

public class Dice {
	private int min = 1;
	private Random random = new Random();

	public int roll(int dice){
		return random.nextInt(dice + 1 - min) + min;
	}
}
