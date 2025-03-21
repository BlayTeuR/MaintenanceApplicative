package trivia;

import java.util.ArrayList;

public class Game implements IGame {

   public static int CASE_NUMBER = 12;
   private final Questions questions;
   ArrayList<Player> players = new ArrayList<>();

   int currentPlayer = 0;
   boolean isGettingOutOfPenaltyBox;

   public Game() {
      questions = new Questions();
   }

   public boolean add(String playerName) {
      Player player = new Player(playerName);
      players.add(player);

      System.out.println(playerName + " was added");
      System.out.println("They are player number " + players.size());
      return true;
   }

   public void roll(int roll) {
      System.out.println(players.get(currentPlayer) + " is the current player");
      System.out.println("They have rolled a " + roll);

      if (players.get(currentPlayer).isInPenalityBox()) {
         if (roll % 2 == 0) {
            System.out.println(players.get(currentPlayer).getName() + " is not getting out of the penalty box");
            isGettingOutOfPenaltyBox = false;
            return;
         }

         isGettingOutOfPenaltyBox = true;
         System.out.println(players.get(currentPlayer).getName() + " is getting out of the penalty box");
      }

      int newPlaces = players.get(currentPlayer).getPlaces() + roll;
      if (newPlaces > CASE_NUMBER) newPlaces -= CASE_NUMBER;
      players.get(currentPlayer).setPlaces(newPlaces);

      System.out.println(players.get(currentPlayer).getName()
              + "'s new location is " + players.get(currentPlayer).getPlaces());
      System.out.println("The category is " + currentCategory());
      askQuestion();
   }

   private void askQuestion(){
      System.out.println(questions.getNextQuestion(currentCategory()));
   }

   private String currentCategory() {
      switch ((players.get(currentPlayer).getPlaces() - 1) % 4){
         case 0 :
            return "Pop";
         case 1 :
            return "Science";
         case 2 :
            return "Sports";
         default:
            return "Rock";
      }
   }

   public boolean handleCorrectAnswer(){

      if(players.get(currentPlayer).isInPenalityBox() && !isGettingOutOfPenaltyBox){
         currentPlayer++;
         if(currentPlayer == players.size()){
            currentPlayer = 0;
         }
         return true;
      }

      System.out.println("Answer was corrent!!!!");
      players.get(currentPlayer).setPurses();
      System.out.println(players.get(currentPlayer)
              + " now has "
              + players.get(currentPlayer).getPurses()
              + " Gold Coins.");

      boolean winner = didPlayerWin();
      currentPlayer++;
      if (currentPlayer == players.size()) {
         currentPlayer = 0;
      }
      return winner;
   }

   public boolean wrongAnswer() {
      System.out.println("Question was incorrectly answered");
      System.out.println(players.get(currentPlayer).getName() + " was sent to the penalty box");
      players.get(currentPlayer).setInPenalityBox(true);

      currentPlayer++;
      if (currentPlayer == players.size()) currentPlayer = 0;
      return true;
   }

   private boolean didPlayerWin() {
      return !(players.get(currentPlayer).getPurses() == 6);
   }
}