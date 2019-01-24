package worldObjects;

import java.util.Timer;
import java.util.TimerTask;

import main.Display;

public class Enemy  {

	int health;
	int power;
	
	public Enemy(int health, int power){
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
				attack();
			}	
		}).start();
	
	}
	
	public void attack() {
		if(getHealth() == 0) {
			Display.map();
			attackTimer();
		}
		System.out.println("Enemy attacking");
		if(getHealth()>0 && Dec.player.getHealth()>0) {
		Dec.player.setHealth(Dec.player.getHealth()-power);
		Display.health.setText("<html> Player Health <br/>" +Dec.player.getHealth()+"/10 </html>");		
		attackTimer();
		
		}
		if(Dec.enemy.getHealth() == 0) {
	    	Display.map();
	    }
		
	}
	
}
