/******************************************************
  * Solitaire.java
  * Avanti Prasanna, Kim Asenbeck, Amanda  Foun
  * CS 230 Final Project: Solitaire Class
  * Start Date: May 9, 2015 
  * End Date: May 12, 2015 
  * Amanda and Kim are primarily responsible for this class
  * ***************************************************/

//*********************************************************************
// Solitaire class contains methods that populates the 2D card array, 
// checks if the user has made a legal move and checks if the game is over.
//*********************************************************************

import java.io.*;
import java.util.*;
import javafoundations.VectorStack;

public class Solitaire {
  // instance variables
  public VectorStack<Card> spades;
  public VectorStack<Card> diamonds;
  public VectorStack<Card> hearts;
  public VectorStack<Card> clubs;
  public VectorStack<Card> restStack;
  public VectorStack<Card> showStack;
  public int moves;
  
  LinkedList<Card> newGame;
  
  public Card [][] cards; 
  
  // Constructor
  public Solitaire(){
    
    moves = 0; //initialize moves;
    ModifiedDeck temp = new ModifiedDeck(); // creates a LinkedList of 52 Cards 
    newGame = temp.randomShuffle(); // randomly shuffles the deck of Cards 
    cards = new Card[13][7]; //2D Array of Card Objects
    
    // Intializes Stacks
    restStack = new VectorStack<Card>();
    
    // newGame2 is useful for populating the restStack and 
    // the rest of the 2D card array
    LinkedList<Card> newGame2 = newGame; 
    
    // creates restStack of 23 labelCards 
    for (int i = 0; i < 24; i++){ 
      restStack.push(newGame2.pop());
    }
    
    // populates the 2D card array
    for (int i = 0; i < 7; i++){
      for (int j = 0; j < i+1; j++){
        cards[j][i] = newGame2.pop();
      }
    }
    
    // These stacks are empty at the beginning of the game because nothing has happened yet. 
    spades = new VectorStack<Card>();
    diamonds = new VectorStack<Card>();
    hearts = new VectorStack<Card>();
    clubs = new VectorStack<Card>();
    showStack = new VectorStack<Card>();
  }
  
  // increment number of moves
  public void plusMoves() {
    moves++;
  }
  
  // returns the number of moves the user has made
  public int getMoves() {
    return moves;
  }
  
  /* isLegal() returns true if suitCheck() returns false and compareTo() returns 1.
   * i.e. returns true if the color of the card that is being placed 
   * is the opposite color of the card it is being placed on and if the numbers
   * on the labelCards are consecutive. Else, returns false.
   */
  public boolean isLegal(Card c1, Card c2) {
    return (suitCheck(c1, c2)==false && c1.compareTo(c2)==1);
  }
  
  /* isGameOver() returns true if all four suit piles contain 13 labelCards. 
   * This can be determined by calling suitCount() on all of the piles. 
   * If suitCount of the piles returns 13, then the game is over.
   */ 
  public boolean isGameOver() {
    return (suitCount(spades)==13 && suitCount(diamonds)==13
              && suitCount(hearts)==13 && suitCount(clubs)==13);
  }
  
  /* suitCheck() returns true if two cards are of the same color
   */ 
  public boolean suitCheck(Card c1, Card c2){
    
    //Determine the suit of the two labelCards being compared  
    String suit1 = c1.getSuit();
    String suit2 = c2.getSuit();
    
    //Determine the color of the first card
    String color1 = ""; 
    if (suit1.equals("Clubs")) color1 = "Black";
    else if (suit1.equals("Hearts")) color1 = "Red";
    else if (suit1.equals("Diamonds")) color1 = "Red";
    else if (suit1.equals("Spades")) color1 = "Black";
    
    //Determine the color of the second card
    String color2 = "";
    if (suit2.equals("Clubs")) color2 = "Black";
    else if (suit2.equals("Hearts")) color2 = "Red";
    else if (suit2.equals("Diamonds")) color2 = "Red";
    else if (suit2.equals("Spades")) color2 = "Black";
    
    return (color1.equals(color2)); //if the two colors are same, return true  
  }
  
  /* suitCount() returns the number of cards in one of the
   * four suit piles in the game
   */ 
  public int suitCount(VectorStack suit){   
    return suit.size();
  }
  
  //Main Method
  public static void main(String args []) {
//    Solitaire game = new Solitaire(); // creates a new game of Solitaire. 
    
//    LinkedList<Card> randomShuffle = game.newGame; // LinkedList of Random Cards
//      
//    for (int i = 0; i < 13; i++){
//      game.spades.push(randomShuffle.get(i));
//      game.hearts.push(randomShuffle.get(i));
//      game.clubs.push(randomShuffle.get(i));
////      game.diamonds.push(randomShuffle.get(i));
//    }
//     
//    System.out.println("The suit count is: " + game.suitCount(game.spades)); // checks suitCount.
//    
//    System.out.println(game.isGameOver()); // checks suitCount.
//    
//    System.out.println("***Testing isLegal() ****");
//    
//    Card c1 = new Card(19);
//    Card c2 = new Card(5);
//    System.out.println("CompareTo Method: " + c1.compareTo(c2));
//    System.out.println("suitCheck Method: " + game.suitCheck(c1,c2));
//    System.out.println("Is " + c1 + " and " + c2 + " Is this a legal move?" + game.isLegal(c1, c2));
    
  }
}