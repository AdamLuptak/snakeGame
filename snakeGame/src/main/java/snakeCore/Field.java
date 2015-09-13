package snakeCore;

import java.util.*;

public class Field {

	private GameElement[][] field;

	private int rowCount;

	private int columnCount;

	private GameState gameState = GameState.Playing;

	private RandomPosition rp;

	public Field(int rowCount, int columnCount) {
		this.columnCount = columnCount;
		this.rowCount = rowCount;
		this.field = new GameElement[rowCount][columnCount];
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

		putSnakeRandom(rp.getRowPosition(), rp.getColumnPosition());
		putFoodRandom(rp.getRowPosition(), rp.getColumnPosition());

	}

	private void putFoodRandom() {
		// TODO Auto-generated method stub

	}

	private void putSnakeRandom(int row, int column) {
		GameElement gameElement = field[row][column];
		if (gameElement instanceof Food) {
			putSnakeRandom(rp.getRowPosition(), rp.getColumnPosition());
		} else {
			field[row][column] = new Food();
		}

	}

	public GameElement getFieldElement(int row, int column) {

		return field[row][column];
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

}
