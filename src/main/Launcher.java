package main;

public class Launcher {

	public static void main(String[] args) {
		Game game =new Game("Game",500,800);
		game.start();
		System.out.println("launcher started");
	}

}
