/******************************************************
  * Card.java
  * Avanti Prasanna, Kim Asenbeck, Amanda  Foun
  * CS 230 Final Project: Card Class
  * Start Date: April 28, 2015
  * End Date: May 12, 2015 
  * Amanda is primarily responsible for this class
  * ***************************************************/

//***********************************************************************************
// Card.java
// Creates Card objects with an integer parameter that denotes the order of the card
//***********************************************************************************

import java.io.*;
import java.util.*;

public class Card implements Comparable<Card>{
  
  // Instance Variables 
  public String value; 
  public String suit; 
  public int order; // [1,52]
  
  // in the values array, King appears first because this made it easier to get the 
  // value in the constructor (see the end of the constructor below)
  private String [] values = {"King", "Ace","2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen"};
 
  // in the values2 array, King appears last because this made it easier to compare
  // two card objects (see the compareTo() method below)
  private String [] values2 = {"Ace","2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
  
  // constructor creates a Card Object that is represented by order from 1 to 52 included
  public Card(int o){
    this.order = o;
    
    // Get Suit of the Card
    if (1 <= o && o <= 13){
      this.suit = "Clubs";
    }
    if (14 <= o && o <= 26){
      this.suit = "Diamonds";
    }
    if (27 <= o && o <= 39){
      this.suit = "Hearts";
    }
    if (40 <= o && o <= 52){
      this.suit = "Spades";
    }
    
    //Get Value
    int val = o%13;
    this.value = values[val];
  }
  
  //Getter Methods
  
  //Returns the Order of the Card
  public int getOrder(){
    return this.order; 
  }
  
  //Returns the Value of the Card
  public String getValue(){
    return this.value;
  }
  
  //Returns the Suit of the Card
  public String getSuit(){
    return this.suit;
  }
  
//compareTo Method compares two card objects based on their values 
  public int compareTo(Card two){
    String val1 = this.getValue();
    String val2 = two.getValue();
    int index1 = Arrays.asList(values2).indexOf(val1);
    int index2 = Arrays.asList(values2).indexOf(val2);
    return index1 - index2; // returns the difference of value of the two cards 
  }
  
//toString Method returns a string representation of a card object
  public String toString(){
    String s = this.value + " of " + this.suit; 
    return s;
  }
  
//Main Method
  public static void main(String args []) {
    
//    // prints out all 52 labelCards
//    for (int i=1; i<=52; i++) {
//      Card c= new Card(i);
//      System.out.println(c);
//    }
//    
//    Card c1 = new Card(22);
//    System.out.println(c1);
//    Card c2 = new Card(51);
//    System.out.println(c2);
//    System.out.println(c1.suitCheck(c2));
//    
    
//    
//    Card card1 = new Card("Jack", "Clubs");
//    System.out.println("Card1 is " + card1);
//    System.out.println("Card1 has an order of " + card1.getOrder());
//    
//    Card card2 = new Card("Ace", "Diamonds");
//    System.out.println("Card2 is " + card2);
//    System.out.println("Card2 has an order of " + card2.getOrder());
//    
//    System.out.println("Card1 should be less than Card2." + " Actual answer is: "+ card1.compareTo(card2));
//      Card tens = new Card();
//      Card jd = new Card();
  } 
}