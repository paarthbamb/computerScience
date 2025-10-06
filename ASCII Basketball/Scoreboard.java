public class Scoreboard {
  private int highScoreMargin = Integer.MIN_VALUE;
  public void update(int currentMargin) {
    if(currentMargin > highScoreMargin) {
      highScoreMargin = currentMargin;
      System.out.println("New High Score Margin: " + currentMargin + " points!");
    } 
    else {
      System.out.println("Current High Score Margin: " + highScoreMargin + " points.");
    }
  }
  public void board(int p, int o) {
    System.out.println("------------------------------------------");
    System.out.println("|-----Player-------------Opponent--------|");
    System.out.println("|-------" + p + "--------------------" + o + "---------|");
    System.out.println("|----------------------------------------|");
    System.out.println("------------------------------------------");
  }
}
