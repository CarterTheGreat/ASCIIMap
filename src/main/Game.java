package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Arrays;

import javax.swing.JLabel;
import javax.swing.KeyStroke;

import worldObjects.Dec;
import worldObjects.Player;

public class Game implements Runnable{
	
	
	private Display display;
	public int width,height;
	public String title;
	
	private boolean running;
	
	private Thread thread;
	
	static int turnNum = 1;
	
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		
	}
	
	private static boolean isBoarder(int x, int y) {
		return (x >= 0 && y<= 1);
	}
	
	private void init() {
		System.out.println("init started");
		display = new Display(title, width, height);
		Dec dec = new Dec();
		Display.up.getInputMap().put(KeyStroke.getKeyStroke('w'), "up");
		turn();
		
	}
	
	public static void turn() {
		System.out.println("turn "+turnNum);
		turnNum++;
		tick();
		render();
	}
	
	private static void tick() {
		
		Display.up.getActionMap().put("up", Map.w());
	}
	
	private static void render() {
		
		//Draw Map
		
		//System.out.println(Arrays.deepToString(Map.map).replace("[", "").replace("], ", "\n").replace("[[", "").replace("]]", " ").replace(",", " "));
		Display.mapLabel.setText((Arrays.deepToString(Map.map).replace("[[", "<html>").replace("]]", "</html>").replace("], ", "<br/>").replace("[", "").replace(",", " ")));
		Display.waterHealth.setText("Water: "+ Map.waterCount+ " Health: "+Dec.player.getHealth());
		Display.event.setText(Map.eventText);
		Display.health.setText("<html> Player Health <br/>" +Dec.player.getHealth()+"/10 </html>");
		Display.enemyHealth.setText("<html> Enemy health <br/>" + Dec.enemy.getHealth()+"/6 </html>");
		if(isBoarder(Map.x,Map.y)){ 
			//Display.color = Color.RED;
			//System.out.println("Color change runs");
		}
		Display.mapLabel.setForeground(Display.color);
		//End drawing
		

	}
	
	public void run() {
		System.out.println("run started");
		init();
		
		/*
		while(running) {
			tick();
			render();
		}
		*/
	}
	
	public synchronized void start() {
		System.out.println("starting");
		if(running) 
			return;
		
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	public synchronized void stop() {
		System.out.println("stopping");
		if(!running)
			return;
		
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

