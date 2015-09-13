package snakeCore;

public class Snake extends GameElement {

	private String[] snakeBody;

	private String snakeBodyChar;

	private int maxSnakeLength;

	public Snake(int maxSnakeLength, String snakeBodychar) {
		this.maxSnakeLength = maxSnakeLength;
		this.snakeBodyChar = snakeBodychar;
	}

	public int getMaxSnakeLength() {
		return maxSnakeLength;
	}

	public void setMaxSnakeLength(int maxSnakeLength) {
		this.maxSnakeLength = maxSnakeLength;
	}

	public String[] getSnakeBody() {
		return snakeBody;
	}

	public String getSnakeBodyChar() {
		return snakeBodyChar;
	}

	public void setSnakeBody(String[] snakeBody) {
		this.snakeBody = snakeBody;
	}

	@Override
	public String toString() {

		return snakeBodyChar.toString();
	}
}
