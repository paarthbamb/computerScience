import java.util.*;
public class Team {
  private String name;
  private int score;
  private double dynamicAccMod;

  public Team(String n) {
    name = n;
    score = 0;
    dynamicAccMod = 1.0;
  }

  public String getName() {
    return name;
  }
  public int getScore() {
    return score;
  }
  public double getDynamicAccMod() {
    return dynamicAccMod;
  }
  public double distOptMod(int shotType, int ballDist) {
    if(shotType == 1) {
      if(ballDist == 1) {
        return 0.15;
      }
      else if(ballDist == 2) {
        return 0.05;
      }
      else if(ballDist == 3) {
        return -0.02;
      }
      else {
        return -0.6;
      }
    }
    if(shotType == 2) {
      if(ballDist == 1) {
        return 0.08;
      }
      else if(ballDist == 2) {
        return 0.2;
      }
      else if(ballDist == 3) {
        return 0.01;
      }
      else {
        return -0.02;
      }
    }
    if(shotType == 3) {
      if(ballDist == 1) {
        return -0.2;
      }
      else if(ballDist == 2) {
        return 0.01;
      }
      else if(ballDist == 3) {
        return 0.2;
      }
      else {
        return 0.03;
      }
    }
    if(shotType == 4) {
      if(ballDist == 1) {
        return -0.5;
      }
      else if(ballDist == 2) {
        return -0.4;
      }
      else if(ballDist == 3) {
        return -0.3;
      }
      else {
        return 0.6;
      }
    }
    return 0.0;
  }
  public boolean takeShot(int shotType, int ballDist, double defenseFactor, boolean isPlayer) {
    double accuracy = 0.0;
    switch(shotType) {
      case 1:
        accuracy = 0.45;
        break;
      case 2:
        accuracy = 0.60;
        break;
      case 3:
        accuracy = 0.75;
        break;
      case 4:
        accuracy = 0.55;
        break;   
      default:
        accuracy = 0.0;
        break;
    }
    double optimalMod = distOptMod(shotType, ballDist);
    accuracy += optimalMod;
    double adjustedAccuracy = accuracy * ((8 - defenseFactor) / 2.0);
      if(!isPlayer) {
        adjustedAccuracy *= dynamicAccMod;
      }

      boolean madeShot = Math.random() < adjustedAccuracy;
      if(madeShot) {
        if(ballDist <= 2) {
          score +=3;
        }
        else {
         score += 2; 
        }
      }
      return madeShot;

  }
  
  public int randomShot() {
    return (int) (Math.random() *4) + 1;
  }
  
  public void increaseDifficulty() {
    dynamicAccMod += 0.01;
  }

  public void decreaseDifficulty() {
    dynamicAccMod -= 0.01;
  }  
}
