import java.util.*;

public class Position {
  private int pos;
  private String posS;
  public Position(int initialLevel) {
    pos = initialLevel;
    switch(pos) {
      case 1:
        posS = "Half Court";
        break;
      case 2:
        posS = "Three Point Range";
        break;
      case 3:
        posS = "Free Throw Range";
        break;
      case 4:
        posS = "Close Range";
        break;   
    }
  }
  public void moveUp() {
    pos += 1;
    if(pos > 4) {
      pos = 4;
    }
    switch(pos) {
      case 1:
        posS = "Half Court";
        break;
      case 2:
        posS = "Three Point Range";
        break;
      case 3:
        posS = "Free Throw Range";
        break;
      case 4:
        posS = "Close Range";
        break;   
    }
    System.out.println("You are at " + posS);
  }

  public void moveDown() {
    pos -= 1;
    if(pos < 1) {
      pos = 1;
    }
    switch(pos) {
      case 1:
        posS = "Half Court";
        break;
      case 2:
        posS = "Three Point Range";
        break;
      case 3:
        posS = "Free Throw Range";
        break;
      case 4:
        posS = "Close Range";
        break;   
    }
    System.out.println("You are at " + posS);
  }

  public int getPos() {
    return pos;
  }

  public String getPosS() {
    return posS;
  }
}
