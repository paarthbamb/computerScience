import java.util.*;    // required to use ArrayList

class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");
    //CardPlayerLevel1 cp1 = new CardPlayerLevel1();
    //TestCardPlayerLevel1();
    TestCardGame();
  }

  public static void TestCardGame()
  {

    String [] names = {"Betty","Bob","Sue","Albert"};
    // game 2
    CardGame game2 = new CardGame("Hearts",4,names,0);
    System.out.println(">>> Printing game in TestCardGame");
    System.out.println(game2);
    for (int i=1; i <= 20; i++) {
       // INFO
       //game2.initializeDeckOfCards();
       game2.getDeckOfCards().initializeDeck();
       game2.getDeckOfCards().shuffle();
       game2.deal(13,0);
       game2.deal(13,1);
       game2.deal(13,2);
       game2.deal(13,3);
       // INFO
       //System.out.println(game2);
       game2.playGame();
    }
    int total = 0;
    for (int i=0; i <= 3; i++) {
      total = total + game2.getPlayer(i).getScore();
    }
    System.out.println(">>> Printing Total Score and Player % in TestCardGame");
    System.out.println("Total Score = " + total);
    double percent;
    for (int i=0; i <= 3; i++) {
      percent = ((int) ((game2.getPlayer(i).getScore()/(double) total) * 10000))/ 100.0;
      System.out.println(game2.getPlayer(i).getName() + " " + percent + "%");
    }    
  }



  // test the getValue() and compareCard() methods
  public static void TestCardPlayerLevel1() {
   
    ArrayList<Card> hand = new ArrayList<Card>();
    CardPlayer player1 = new CardPlayer("Kara Jones",0,hand);
    System.out.println("New CardPlayer -> " + player1);
    Card card1 = new Card("2","clubs",2);
    Card card2 = new Card("3","clubs",3);
    Card card3 = new Card("3","diamonds",3);
    Card card4 = new Card("A","hearts",14);
    Card card5 = new Card("7","spades",7);
    Card card6 = new Card("6","spades",6);
    player1.addCard(card1);
    player1.addCard(card2);
    player1.addCard(card3);
    player1.addCard(card4);
    player1.addCard(card5);
    player1.addCard(card6);
    System.out.println("After adding 6 cards. Player -> " + player1);
    Card cardPlayed = player1.playCard(5);
    player1.updateScore(27);
    System.out.println("Played " +  cardPlayed + " at index 5 and updated score to 27 points. Player -> " + player1);
    ArrayList<Card> cardsPlayedInRound = new ArrayList<Card>();
    ArrayList<Card> cardsPlayedInGame = new ArrayList<Card>();
    System.out.println("Cards played in round -> " + cardsPlayedInRound);
    System.out.println("Cards played in game -> " + cardsPlayedInGame);
    Card chosenCard = player1.chooseCard(cardsPlayedInRound, cardsPlayedInGame);
    System.out.println("Chose 2 of clubs -> " + chosenCard + " Player -> " + player1);
    Card card7 = new Card("10","spades",10);
    cardsPlayedInRound.add(card7);
    cardsPlayedInGame.add(card7);
    System.out.println("Cards played in round -> " + cardsPlayedInRound);
    chosenCard = player1.chooseCard(cardsPlayedInRound, cardsPlayedInGame);
    cardsPlayedInGame.add(chosenCard);
    System.out.println("RANDOMLY chosen spade -> " + chosenCard + " Player -> " + player1);
    cardsPlayedInRound.clear();
    Card card8 = new Card("9","clubs",9);
    cardsPlayedInRound.add(card8);
    System.out.println("Cards played in round -> " + cardsPlayedInRound);
    chosenCard = player1.chooseCard(cardsPlayedInRound, cardsPlayedInGame);
    System.out.println("heart chosen -> " + chosenCard + " Player -> " + player1);
    cardsPlayedInRound.clear();
    System.out.println("Cards played in round -> " + cardsPlayedInRound);
    chosenCard = player1.chooseCard(cardsPlayedInRound, cardsPlayedInGame);
    System.out.println("RANDOMLY chosen card -> " + chosenCard + " Player -> " + player1);
  }

}