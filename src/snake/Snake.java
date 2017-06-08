package snake;

import java.awt.Point;
import java.util.LinkedList;

public class Snake implements Runnable{
	
	private boolean isLive = true;
	private Point head;
	private int length = 3;
	
	//body including head
	private LinkedList<Point> body = new LinkedList<Point>();
	
	//up:1 right:2 down:3 left:4
	private int direct;
	
	
	private int level;
	


	public Snake() {
		
		int x = GamePanel.WIDTH/2;
		int y = GamePanel.HEIGHT/2;
		body.addFirst(new Point(x-1, y));
		body.addFirst(new Point(x, y));
		body.addFirst(new Point(x+1, y));
		
		this.head = body.getFirst();
		this.direct = 2;
		this.level = 0;
	}

	@Override
	public void run() {
		
		//make the snake keep running 
		while (this.isLive) {
			isDead();
			level = body.size()/5;
	
			switch (this.direct) {
			case 1:
				body.addFirst(new Point(head.x, head.y-1));
				break;
			case 2:
				body.addFirst(new Point(head.x+1, head.y));
				break;
			case 3:
				body.addFirst(new Point(head.x, head.y+1));
				break;
			case 4:
				body.addFirst(new Point(head.x-1, head.y));
				break;
			default:
				break;
			}
			body.removeLast();
			head = body.getFirst();
			
			try {
				Thread.sleep(400-4*level);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	
	
	public void isDead() {
		if(head.getX() > 24 || head.getY() > 14 
				|| head.getX() < 0 || head.getY() < 0){
			isLive = false;
		}
			
		for (int i = 1; i < body.size(); i++) {
			if(head.getX() == body.get(i).getX() 
				&& head.getY() == body.get(i).getY()){
				isLive = false;
			}
					
		}
	}
	
	
	
	public void moveUp() {
		if(direct == 2 || direct == 4){
			this.direct = 1;
		}
		
	}

	public void moveRight() {
		if(direct == 1 || direct == 3){
			this.direct = 2;
		}
	}

	public void moveDown() {
		if(direct == 2 || direct == 4){
			this.direct = 3;
		}
	}

	public void moveLeft() {
		if(direct == 1 || direct == 3){
			this.direct = 4;
		}	
	}

	
	
	
	public boolean isLive() {
		return isLive;
	}

	public void setLive(boolean isLive) {
		this.isLive = isLive;
	}

	public Point getHead() {
		return head;
	}

	public void setHead(Point head) {
		this.head = head;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public LinkedList<Point> getBody() {
		return body;
	}

	public void setBody(LinkedList<Point> body) {
		this.body = body;
	}

	public int getDirect() {
		return direct;
	}

	public void setDirect(int direct) {
		this.direct = direct;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	
	
	
	
	
	
	
	
	
}
