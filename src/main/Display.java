package main;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import worldObjects.Dec;
import worldObjects.Enemy;

public class Display implements KeyListener{

	
	static JButton up;
	
	
	static JPanel cards;
	static JFrame frame;
	JPanel panel;
	static JPanel panel2;
	JPanel panel3;
	static Color color = Color.WHITE;

	final static String MAP = "Map";
	final static String BATTLE = "Battle";
	final static String DEAD = "Dead";
	
	static JLabel mapLabel = new JLabel((Arrays.deepToString(Map.map).replace("[[", "<html>").replace("]]", "</html>").replace("], ", "<br/>").replace("[", "").replace(",", " ")));
	static JLabel waterHealth = new JLabel("Water: "+ Map.waterCount+ " Health: "+Dec.player.getHealth());
	static JLabel event = new JLabel(Map.eventText);
	
	public static JLabel health = new JLabel("<html> Player Health <br/>" +Dec.player.getHealth()+"/10 </html>");
	public static JLabel enemyHealth = new JLabel("<html> Enemy health <br/>" + Dec.enemy.getHealth()+"/6 </html>");
	
	private String title;
	private int width,height;
	
	public Display(String title,int width,int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		
		createDisplay();
	}
	
	
	

	private void createDisplay() {
		System.out.println("createDisplay started");
		
//Frame	
		
		JFrame frame  = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setBackground(Color.BLACK);
		frame.setLayout(new BorderLayout());
		
//Map
		up =  new JButton("^");
		JButton down =  new JButton("v");
		JButton left =  new JButton("<");
		JButton right =  new JButton(">");

		//up.addKeyListener(this);
		//down.addKeyListener(this);
		//left.addKeyListener(this);
		//right.addKeyListener(this);	
		
		
		
		panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setLayout(new BorderLayout());
		
		mapLabel.setForeground(color);
		panel.add(mapLabel, BorderLayout.CENTER);
		panel.add(up, BorderLayout.SOUTH);
		panel.add(down, BorderLayout.SOUTH);
		panel.add(right, BorderLayout.SOUTH);
		panel.add(left, BorderLayout.SOUTH);
		waterHealth.setForeground(Color.WHITE);
		panel.add(waterHealth, BorderLayout.NORTH);
		event.setForeground(Color.WHITE);
		panel.add(event, BorderLayout.SOUTH);
		
		
		
//Battle
	
		panel2 = new JPanel();
		panel2.setFocusable(true);
		panel2.setBackground(Color.BLACK);
		panel2.setLayout(new BorderLayout());
		
		JButton punch = new JButton("Punch");
		punch.addKeyListener(this);
		//Key Binding
		

		
		panel2.add(health, BorderLayout.WEST);
		panel2.add(enemyHealth, BorderLayout.EAST);
		panel2.add(punch, BorderLayout.SOUTH);
		panel2.setFocusable(true);
		
//You Died
		
		panel3 = new JPanel();
		panel3.setBackground(Color.BLACK);
		panel3.setLayout(new BorderLayout());
		
		JLabel dead = new JLabel("You died");
		panel3.add(dead, BorderLayout.CENTER);
		
//Cards		
		cards = new JPanel(new CardLayout());
	
		cards.add(panel, MAP);
		cards.add(panel2, BATTLE);
		cards.add(panel3, DEAD);
		
		frame.add(cards, BorderLayout.CENTER);
		
		frame.pack();
		frame.setVisible(true);
	}

	public static void map() {
		CardLayout cl = (CardLayout)(cards.getLayout());
		cl.show(cards, "Map");
	}
	
	public static void battle() {

		Dec.enemy = new Enemy(6,2);
		CardLayout cl = (CardLayout)(cards.getLayout());
		cl.show(cards, "Battle");
		Dec.enemy.attackTimer();
		Dec.player.attackTimer();	
	    
	}

	public static void death() {
		CardLayout cl = (CardLayout)(cards.getLayout());
		cl.show(cards, "dead");
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		/*
		char key = e.getKeyChar();
		
		if(key == 'w'|key == 'a'|key == 's'|key == 'd') {
			Map.dir = e.getKeyChar();
			Map.move(Map.dir);
			System.out.println("KeyEvent "+key);
		}
		
		*/
	}


	
	public Action actionEvent() {
		
		return null;
	}

	@Override
	public void keyPressed(KeyEvent e) {

		
	}




	@Override
	public void keyReleased(KeyEvent e) {

		
	}

	
	

}