import java.util.*;
public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("What is your team name? ");
	String playerName = scanner.nextLine();
	Team player = new Team(playerName);
	System.out.println("What is your opponent’s name? ");
	String oppName = scanner.nextLine();
	Team opponent = new Team(oppName);
    BasketGame game = new BasketGame(player, opponent);
    game.play();
  }
}

