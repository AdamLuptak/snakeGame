package snakeCore;

public class Snake extends GameElement {

	private String[] snakeBody;

	private int maxSnakeLength;

	public int getMaxSnakeLength() {
		return maxSnakeLength;
	}

	public void setMaxSnakeLength(int maxSnakeLength) {
		this.maxSnakeLength = maxSnakeLength;
	}

	public String[] getSnakeBody() {
		return snakeBody;
	}

	public void setSnakeBody(String[] snakeBody) {
		this.snakeBody = snakeBody;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		for (String body : snakeBody) {
			sb.append(body);
		}
		return sb.toString();
	}
}
