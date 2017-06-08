package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

import javax.swing.JPanel;


public class GamePanel extends JPanel implements Runnable,KeyListener {


	//width of map
	public static final int WIDTH = 25;

	//height of map
	public static final int HEIGHT = 15;

	Snake snake = new Snake();
	Food food = new Food();

	public GamePanel() {
		new Thread(snake).start();
		setFocusable(false);
		this.addKeyListener(this);
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		drawBackGround(g);
		drawFood(g);
		drawSnake(g);

	}


	public void drawFood(Graphics g) {
		if(food.isLive()){
			g.setColor(Color.GREEN);
			Point p = food.getPoint();
			g.fillRect(p.x*20 +20, p.y*20 +20, 20, 20);
		}else{
			food = new Food();
			if(food.isInSnake(snake))
				food = new Food();
		}
	}

	public void drawSnake(Graphics g) {
		Point head = snake.getHead();
		LinkedList<Point> body = snake.getBody();

		if(snake.isLive()){
			g.setColor(Color.RED);
			g.fillRect(head.x*20 +20, head.y*20 +20, 20, 20);
			for (int i = 1; i < body.size(); i++) {
				g.setColor(Color.BLACK);
				Point p = body.get(i);
				g.fillRect(p.x*20 +20, p.y*20 +20, 20, 20);
			}

		}

	}

	public void drawBackGround(Graphics g) {
		g.setColor(Color.lightGray);
		// draw horizontal line
		for (int i = 0; i <= 15; i++) {
			g.drawLine(20, 20 * i + 20, 520, 20 * i + 20);
		}
		// Perpendicular line
		for (int i = 0; i <= 25; i++) {
			g.drawLine(20 * i + 20, 20, 20 * i + 20, 320);
		}

	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(snake.isLive()){
			repaint();
			eat();
			
		}
	}

	private void eat() {
		if(snake.getHead().getX() == food.getPoint().getX() 
				&& snake.getHead().getY() == food.getPoint().getY()
				&& food.isLive()){
			food.setLive(false);
			snake.getBody().addLast(snake.getBody().getLast());
		}
			
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP)
            snake.moveUp();
        if(e.getKeyCode() == KeyEvent.VK_RIGHT)
        	snake.moveRight();
        if(e.getKeyCode() == KeyEvent.VK_DOWN)
        	snake.moveDown();
        if(e.getKeyCode() == KeyEvent.VK_LEFT)
        	snake.moveLeft();
        repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
