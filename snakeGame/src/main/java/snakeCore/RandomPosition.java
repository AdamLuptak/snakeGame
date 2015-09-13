package snakeCore;

import java.util.Random;

public class RandomPosition {

	private int rowPostionBorderMAX;
	private int rowPostionBorderMIN;
	private int columnPositionBorderMAX;
	private int columnPositionBorderMIN;
	private int rowPosition;
	private int columnPosition;
	private Random rn;

	public RandomPosition(int rowPostionBorderMAX, int rowPostionBorderMIN, int columnPositionBorderMAX,
			int columnPositionBorderMIN) {
		this.rowPostionBorderMAX = rowPostionBorderMAX;
		this.rowPostionBorderMIN = rowPostionBorderMIN;
		this.columnPositionBorderMAX = columnPositionBorderMAX;
		this.columnPositionBorderMIN = columnPositionBorderMIN;
		this.rn = new Random();
	}

	private void getRandom() {

		rowPosition = rn.nextInt(rowPostionBorderMAX) + rowPostionBorderMIN;
		columnPosition = rn.nextInt(columnPositionBorderMAX) + columnPositionBorderMIN;
	}

	public int getRowPosition() {
		getRandom();
		return rowPosition;
	}

	public int getColumnPosition() {
		getRandom();
		return columnPosition;
	}

	

}
