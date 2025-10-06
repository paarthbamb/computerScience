public class Visual {
  private int res;

  public Visual(int r) {
    res = r;
  }
  public int getRes() {
    return res;
  }
  public void setRes(int r) {
    res = r;
  }

  public void printVis() {
    if(res == 0) {
      System.out.println("                             =_-___");
      System.out.println("                           o    \\__ \\");
      System.out.println("                          o       __| \\");
      System.out.println("                           o      \\__  \\");
      System.out.println("                             oooo    \\  \\");
      System.out.println("                                      \\  \\");
      System.out.println("        __________________             |   \\");
      System.out.println("       |__________________|             \\   |");
      System.out.println("        \\/\\/\\/\\/\\/\\/\\/\\/     _----_    |   |");
      System.out.println("         \\/\\/\\/\\/\\/\\/     |      \\   |   |");
      System.out.println("          \\/\\/\\/\\/\\/      |       |    |  |");
      System.out.println("           |/\\/\\/\\/\\|        |       \\__/    |");
      System.out.println("           |/\\/\\/\\/\\|         __---          |");
      System.out.println("           |/\\/\\/\\/\\|       /   \\            |");
      System.out.println("                             |     |          |");
      System.out.println("                             |   /            |");
      System.out.println("                             |   \\            |");
      System.out.println("                             |   | \\          |");
      System.out.println("                             |   |   \\____-----\\");
      System.out.println("                             |   |    \\____-----");
      System.out.println("                              |  |    |          \\");
      System.out.println("                              |  |   |             \\");
      System.out.println("                               \\  \\_|_      |       |");
      System.out.println("                                \\____/  ___/ \\_____/\\");
      System.out.println("                                   /    /       \\     \\");
      System.out.println("                                 /     /          \\     \\");
      System.out.println("                                /    /              \\    \\");
      System.out.println("                              /    /                  \\    \\");
      System.out.println("                             /   /                      \\   \\");
      System.out.println("                       /\\   /  /                          \\  |");
      System.out.println("                      |  \\/ \\/                              \\/ \\");
      System.out.println("                       \\    |                             __/   |");
      System.out.println("                         \\_/                            /______/ ");
    }

    if(res == 1) {
      System.out.println(" /|   o         o");
      System.out.println(" \\|=--            o");
      System.out.println("    ##");
      System.out.println("                   \\\\");
      System.out.println("                /   \\O");
      System.out.println("               O_/   T");
      System.out.println("               T    /|");
      System.out.println("               |\\  | |");
      System.out.println("_______________|_|________");
    }

    if(res == 2) {
      System.out.println("           ____|");
      System.out.println("        o  \\%/ |~~\\");
      System.out.println("  o//              |");
      System.out.println("  8                |");
      System.out.println(" / >               |");
      System.out.println("~ ~             ~~~~~~");
    }

    if(res == 3) {
      System.out.println("o- - -  \\o          __|");
      System.out.println("   o/   /|          vv`\\");
      System.out.println("  /|     |              |");
      System.out.println("   |    / \\_            |");
      System.out.println("  / \\   |               |");
      System.out.println(" /  |                   |");
    }
  }
}


