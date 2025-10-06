import java.util.*;

public class Defense {
  private double level;
  public Defense(double initialLevel) {
    level = initialLevel;
  }

  public void change(Scanner scanner) {
    System.out.print("Set defense (6 = Press, 6.5 = Man, 7 = Zone, 7.5 = None): ");
    level = scanner.nextDouble();
    System.out.println("Defense set to: " + level);
  }

  public double getLevel() {
    return level;
  }
}
