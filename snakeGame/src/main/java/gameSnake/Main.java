package gameSnake;

import snakeCore.Field;

public class Main {

	public Main() {
		Field field = new Field(20, 50);
		System.out.println(field.toString());
	}

	public static void main(String[] args) {
		new Main();

	}

}
