package worldObjects;

import java.awt.CardLayout;
import java.sql.Array;

import javax.swing.Action;

import main.Display;

public class Player {

	int health;
	int power;
	
	public Player(int health, int power){
		this.health = health;
		this.power = power;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}
	
	

	
	public void attackTimer() {

		
		new Thread( new Runnable() {
			public void run() {
				try { Thread.sleep(2000);}
				catch(InterruptedException ie) {}
				punch();
			}	
		}).start();
	
	}
	
	
	public void punch(){
		if(getHealth() == 0) {
			Display.death();
			
		}
		if(getHealth()>0 && Dec.enemy.getHealth()>0) {
		Dec.enemy.setHealth(Dec.enemy.getHealth()-power);
		System.out.println("Running punch");
		Display.enemyHealth.setText("<html> Enemy Health <br/>" +Dec.enemy.getHealth()+"/6 </html>");
		attackTimer();
		}
		
	}
	
	
}
