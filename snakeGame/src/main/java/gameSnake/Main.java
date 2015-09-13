package gameSnake;

import java.io.Console;

import consoleUI.ConsoleUI;
import snakeCore.Field;

public class Main {

	public Main() {
		Field field = new Field(20, 50);
		ConsoleUI consoleUI = new ConsoleUI();

		consoleUI.newGame(field);
	}

	public static void main(String[] args) {
		new Main();

	}

}
