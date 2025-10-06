import java.util.*;
public class BasketGame {
  private final Scanner scanner = new Scanner(System.in);
  private Team player;
  private Team opponent;
  private final Defense defense = new Defense(6.5);
  private final Position position = new Position(1);
  private final Scoreboard scoreboard = new Scoreboard();
  private final Visual vis = new Visual(0);
  private final int totalTurns = 20;

  public BasketGame(Team p, Team o) {
    player = p;
    opponent = o;
  }
  

  public void play() {
    vis.printVis();
    System.out.println("CTRL + ALT + Elite Studios");
    System.out.println("Welcome to Basketball! Here are your game options. ");
    System.out.println("1: Long Jump Shot (30 ft)");
    System.out.println("2: Short Jump Shot (15 ft)");
    System.out.println("3: Lay Up");
    System.out.println("4: Set Shot");
	System.out.println("11: Move Up Court");
	System.out.println("12: Move Down Court");
    System.out.println("0: Change Defense");

    for(int turn = 1; turn <= totalTurns; turn++) {
      System.out.print("\nTurn " + turn + " - Your Shot? ");
      System.out.println("You are at " + position.getPosS());
      System.out.println("1: Long Jump Shot (30 ft)");
      System.out.println("2: Short Jump Shot (15 ft)");
      System.out.println("3: Lay Up");
      System.out.println("4: Set Shot");
      System.out.println("11: Move Up Court");
      System.out.println("12: Move Down Court");
      System.out.println("0: Change Defense");
      int shot = scanner.nextInt();

      if(shot == 0) {
        defense.change(scanner);
        turn--;
        continue;
      }
      
      if(shot == 11) {
        position.moveUp();
        turn--; 
        continue;
      }

      if(shot == 12) {
        position.moveDown();
        turn--; 
        continue;
      }

      boolean userScored = player.takeShot(shot, position.getPos(), defense.getLevel(), true);
      if(userScored) {
        if(shot == 1 || shot == 2) {
          vis.setRes(1);
          vis.printVis();
        }
        else {
          vis.setRes(2);
          vis.printVis();
        }
        System.out.println("Shot is GOOD! You score.");
      }
            
      else {
        vis.setRes(3);
        vis.printVis();
        System.out.println("Shot is MISSED.");
      }

      boolean oppScored = opponent.takeShot(opponent.randomShot(), (int)Math.random() * 3 + 1, 6.5, false);
      if(oppScored) {
        System.out.println("Opponent scores.");
      }
      else {
        System.out.println("Opponent misses.");
      }
      if(player.getScore() > 20){
        opponent.increaseDifficulty();
      }

      if(opponent.getScore() > 20) {
        opponent.decreaseDifficulty();
      }
      scoreboard.board(player.getScore(), opponent.getScore());       
    }
    System.out.println("FINAL SCORE");
    scoreboard.board(player.getScore(), opponent.getScore()); 
    if(player.getScore() > opponent.getScore()) {
      System.out.println(player.getName() + " WINS!");
    }
    else if(player.getScore() == opponent.getScore()) {
      System.out.println("GAME IS TIED!");
    }
    else {
      System.out.println(opponent.getName() + " WINS!");
    }
    System.out.println("Thanks for playing!");
  }
}
