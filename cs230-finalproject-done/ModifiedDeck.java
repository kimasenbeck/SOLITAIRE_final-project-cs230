/******************************************************
  * ModifiedDeck.java
  * Avanti Prasanna, Kim Asenbeck, Amanda  Foun
  * CS 230 Final Project: ModifiedDeck Class
  * Start Date: April 28, 2015
  * End Date: May 12, 2015 
  * Amanda is primarily responsible for this class
  * ***************************************************/

//*************************************************************************************
// Modified Deck class represents a collection of 52 cards. 
// Uses a LinkedList data structure as the container of the collection of cards.
// This class contains a method that allows us to randomly shuffle the 52 cards.
//*************************************************************************************

import java.util.*;
import java.lang.*;

public class ModifiedDeck {
  //instance variables
  LinkedList<Card> cards; // linked list of card objects
  
  // constructor that creates a deck of 52 Card objects.
  public ModifiedDeck(){
    cards = new LinkedList<Card>();//create a new LinkedList to contain the deck
    for (int h = 1; h <= 52 ; h++){//iterate 52 times to create 52 cards
      Card x = new Card(h); //during each iteration, create a new card with the given order
      cards.push(x); //note that deck is in reverse order, since items are pushed on.
    }
  }
  
  // toString returns a String representation of a deck.
  public String toString(){
    StringBuilder sb = new StringBuilder(); //create a new StringBuilder
    for (int i = 51; i>=0; i--){ //iterate in reverse, since cards were pushed onto the LinkedList stack
      sb.append(cards.get(i) + "\n");} //append each card to the StringBuilder
    return sb.toString(); //return the String version of that StringBuilder
  }
  
  // randomShuffle() randomly shuffles the cards in the deck by
  // getting a random number between 1 and 52 and adding the card
  // with that order to the shuffled linked list
  public LinkedList<Card> randomShuffle(){
    int i = 1;
    LinkedList<Card> shuffled = new LinkedList<Card>(); // will contain a list of the shuffled cards
    Vector<Integer> marked = new Vector<Integer>(); // stores numbers we have already chosen
    while (marked.size() < 52){//iterate until you have marked all 52 nums
      Random rand = new Random(); 
      int num = rand.nextInt(52) +1; //add one, because last card needs to be number 52.
      if (! marked.contains(num)){ //if the num is not already in the marked vector
        i++;
        marked.add(num); //add the num so it won't be picked again
        Card c = new Card(num);
        shuffled.add(c);//add it to the shuffled deck. 
      }
      cards = shuffled;
    }
    return shuffled;//at the end, return your randomly shuffled deck
  }
  
  // inOrder() method that returns true if and only if the deck has all its cards in order.
  public boolean inOrder(){ 
    if(cards.get(0).compareTo(cards.get(1)) != 1){
      //if the distance between first two cards is not 1
      return false; // then the deck is not in order
    }
    return true; //if the first two cards are in order, then the whole deck is in order.   
  }
  
  // main method
  public static void main (String[]args){
//    ModifiedDeck a = new ModifiedDeck(); //creates a new deck
//    System.out.println(a); //prints out the entire deck
//    System.out.println("Is the deck in order? (true)  " + a.inOrder()); //deck hasn't been shuffled yet
//    Card ace = new Card(52);//create a new card
//    Card club = new Card("2", "Clubs");//try using both constructors
//    System.out.println(a.findInDeck(ace));//look for both cards in deck
//    System.out.println(a.findInDeck(club));
//    a.randomShuffle(); //randomly shuffles the deck
//    System.out.println(a); // prints out the shuffled deck
//    System.out.println("Is the deck in order? (false)  " + a.inOrder());
  }
}