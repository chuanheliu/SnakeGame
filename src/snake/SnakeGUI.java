
package snake;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class SnakeGUI extends JFrame implements ActionListener {


	GamePanel panel = new GamePanel();

	JMenuBar menuBar = new JMenuBar();
	JMenu menu = new JMenu("Play(G)");
	JMenuItem start = new JMenuItem("Start");
	JMenuItem exit = new JMenuItem("Exit");
	

	public SnakeGUI(){

		this.setBounds(300, 200, 540, 380);


		menu.setMnemonic('G');
		menu.add(start);
		menu.add(exit);
		menuBar.add(menu);
		setJMenuBar(menuBar);


		start.addActionListener(this);
		exit.addActionListener(this);
		start.setActionCommand("start");
		exit.setActionCommand("exit");

		GamePanel panel = new GamePanel();
		new Thread(panel).start();
		this.add(panel);
		this.addKeyListener(panel);

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		SnakeGUI gui = new SnakeGUI();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}



}
