package snake;

import java.awt.Point;

public class Food {
	
	private Point point;
	private boolean isLive;
	
	
	
	
	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}



	public boolean isLive() {
		return isLive;
	}

	public void setLive(boolean isLive) {
		this.isLive = isLive;
	}

	public boolean isInSnake(Snake snake){
		
		for (int i = 0; i < snake.getBody().size(); i++) {
			if(point.getX() == snake.getBody().get(i).getX()
					&& point.getY() == snake.getBody().get(i).getY())
				return true;
		}
		return false;
	}


	public Food() {
		this.isLive = true;
		
		int x = (int) (Math.random()*25);
		int y = (int) (Math.random()*15);
	
		this.point = new Point(x, y);
	}

}
