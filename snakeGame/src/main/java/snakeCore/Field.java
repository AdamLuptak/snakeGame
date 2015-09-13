package snakeCore;

import java.util.*;

public class Field {

	private GameElement[][] field;

	private int rowCount;

	private int columnCount;

	private GameState gameState = GameState.Playing;

	private RandomPosition rp;

	private Snake snake;

	public Field(int rowCount, int columnCount) {
		this.columnCount = columnCount;
		this.rowCount = rowCount;
		this.field = new GameElement[rowCount][columnCount];
		this.snake = new Snake(3, "*");
		rp = new RandomPosition(rowCount - 1, 1, columnCount - 1, 1);
		GenerateField();
	}

	/**
	 * Generate playing field with snake and bordes and food for snake
	 */
	private void GenerateField() {
		for (int row = 0; row < rowCount; row++) {
			for (int column = 0; column < columnCount; column++) {
				if ((row == 0 || row == rowCount - 1) || (column == 0 || column == columnCount - 1)) {
					field[row][column] = new Wall();
				} else {
					field[row][column] = new FreeSpace();
				}
			}
		}
		putFoodRandom(rp.getRowPosition(), rp.getColumnPosition());
		putSnakeRandom(rp.getRowPosition(), rp.getColumnPosition());
	}

	public GameState isSolved() {

		return gameState;
	}

	private void putSnakeRandom(int row, int column) {
		if (!canIPutSnake(row, column)) {
			putSnakeRandom(rp.getRowPosition(), rp.getColumnPosition());
		} else {
			putSnakeToField(row, column, false);
		}

	}

	private void putSnakeToField(int row, int column, boolean move) {
		for (int columnChanger = column - snake.getMaxSnakeLength(); columnChanger < column; columnChanger++) {
			field[row][columnChanger] = snake;
		}
		if (move) {
			field[row][(column - snake.getMaxSnakeLength()) - 1] = new FreeSpace();
		}
	}

	private void putFoodRandom(int row, int column) {
		GameElement gameElement = field[row][column];
		if (gameElement instanceof Snake) {
			putFoodRandom(rp.getRowPosition(), rp.getColumnPosition());
		} else {
			field[row][column] = new Food();
		}

	}

	private boolean canIPutSnake(int row, int column) {
		int counter = 0;
		for (int columnChanger = column - snake.getMaxSnakeLength(); columnChanger < column; columnChanger++) {
			if (columnChanger > 0) {
				if (!(field[row][columnChanger] instanceof Food) && !(field[row][columnChanger] instanceof Wall)) {
					counter++;
				}
			} else {
				return false;
			}
		}
		return (counter == snake.getMaxSnakeLength()) ? true : false;
	}

	public void moveSnakeForward(int row, int column) {
		if (checkBoarders(row, column + 2)) {
			putSnakeToField(row, column + 2, true);
		} else {
			System.out.println("out of boundce");
		}
	}

	public boolean checkBoarders(int row, int column) {
		return (row > 0 && column > 0 && row < rowCount && column < columnCount) ? true : false;
	}

	public GameElement getFieldElement(int row, int column) {
		return field[row][column];
	}

	public SnakeHeadPostition findHead() {
		for (int row = 0; row < rowCount; row++) {
			for (int column = 0; column < columnCount; column++) {
				if (field[row][column] instanceof Snake && field[row][column - 1] instanceof Snake
						&& field[row][column + 1] instanceof FreeSpace) {
					return new SnakeHeadPostition(row, column);
				}
			}
		}
		return null;
	}

	public GameElement[][] getField() {
		return field;
	}

	public void setField(GameElement[][] field) {
		this.field = field;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public int getColumnCount() {
		return columnCount;
	}

	public void setColumnCount(int columnCount) {
		this.columnCount = columnCount;
	}

	@Override
	public String toString() {
		String returnString;
		GameElement gameElement;
		StringBuilder sb = new StringBuilder();
		for (int row = 0; row < rowCount; row++) {
			for (int column = 0; column < columnCount; column++) {
				gameElement = field[row][column];
				sb.append(gameElement.toString());
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	public void moveUp() {
		// TODO Auto-generated method stub

	}

	public void moveDown() {
		// TODO Auto-generated method stub

	}

	public void moveLeft() {
		// TODO Auto-generated method stub

	}

	public void moveRight() {
		// TODO Auto-generated method stub

	}

	public void moveForward() {
		SnakeHeadPostition snakeHeadPostition = findHead();
		if (snakeHeadPostition != null) {
			moveSnakeForward(snakeHeadPostition.getRow(), snakeHeadPostition.getColumn());
		}
	}

}
