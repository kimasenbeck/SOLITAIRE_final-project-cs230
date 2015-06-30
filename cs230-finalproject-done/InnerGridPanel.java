/******************************************************
  * InnerGridPanel.java
  * Avanti Prasanna, Kim Asenbeck, Amanda  Foun
  * CS 230 Final Project: InnerGridPanel Class
  * Start Date: April 28, 2015
  * End Date: May 12, 2015 
  * Avanti, Kim and Amanda are responsible for this class
  * ***************************************************/

//*********************************************************************
// InnerGridPanel creates the game that the user interacts with. Includes 
// the grid of cards, decks, and suit stacks–all of which are represented
// JLabels. 
//*********************************************************************

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Component.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

import java.io.*;
import java.util.*;
import javafoundations.*;
import javafoundations.VectorStack;

public class InnerGridPanel extends JPanel{
  // All Instance Variables
  
  // Instance Variables for Deck
  protected JLabel randomDeck;
  protected JLabel numMoves;
  protected JLabel showCard2; 
  private JLabel showCard; 
  private JLabel heartsLabel;
  private JLabel spadesLabel;
  private JLabel clubsLabel;
  private JLabel diamondsLabel;
  
  
  // Instance Variables for Grid
  private JLabel [][] labelCards;
  private final int defaultWidth = 7; // number of columns
  private final int defaultHeight = 14; // number of rows: We have an extra row as the top one is for the deck and suit stacks 
  public ImageIcon card;
  public Solitaire game; 
  private int click; // keeps track of whether the user is on the first or second click when start
  private Card [] start = new Card[13]; // start contains the card that the user wants to move
  private Card end;
  
  // constructor takes in a Solitaire object
  public InnerGridPanel(Solitaire game2){
    setLayout (new GridLayout(defaultHeight, defaultWidth));
    
    game = game2; 
    
    // labelCards is a 2D array of JLabels that are images of the cards
    labelCards = new JLabel[defaultHeight][defaultWidth];
    
    //Sets Random Deck 
    ImageIcon backImage = new ImageIcon("cards_gif/b1fv.gif"); // back of card image
    randomDeck = new JLabel(backImage);
    labelCards[0][0] = randomDeck; 
    randomDeck.addMouseListener(new Listener());
    
    // Sets the JLabel for where the revealed Random Deck card will be displayed
    ImageIcon showImage = new ImageIcon("cards_gif/green.png"); // green/background image 
    showCard = new JLabel(showImage);
    labelCards[0][1] = showCard; 
    
//    //Number of Moves JLabel
    numMoves = new JLabel("  ");
//    numMoves.setFont(new Font("Courier New", Font.BOLD, 50)); //Sets Font
//    numMoves.setForeground(Color.white);
    labelCards[0][2] = numMoves;
    
    // Add the four cards in the top right, one for each suit
    ImageIcon cImage = new ImageIcon("cards_gif/clubs.jpg");
    clubsLabel = new JLabel(cImage);
    labelCards[0][3] = clubsLabel; 
    
    ImageIcon dImage = new ImageIcon("cards_gif/diamonds.jpg");
    diamondsLabel = new JLabel(dImage);
    labelCards[0][4] = diamondsLabel; 
    
    ImageIcon aImage = new ImageIcon("cards_gif/spades.jpg");
    spadesLabel = new JLabel(aImage);
    labelCards[0][5] = spadesLabel; 
    
    ImageIcon hImage = new ImageIcon("cards_gif/hearts.jpg");
    heartsLabel = new JLabel(hImage);
    labelCards[0][6] = heartsLabel; 
    
    click = 0; // click is set to 0 at the beginning of the game: There have been no moves yet. 
    
    // fill the entire grid with JLabels
    for (int i = 1; i < defaultHeight; i++){
      for (int j = 0; j < defaultWidth; j++){
        labelCards[i][j] = new JLabel();
        labelCards[i][j].setEnabled(false);
      }
    }
    
    // fill the top portion of the grid with images of card backs
    for ( int i = 0; i< 7; i++){
      for(int j = 1; j<= i;j++){
        card = new ImageIcon("cards_gif/b1fv.gif");
        labelCards[j][i].setIcon(card);
        labelCards[j][i].setEnabled(false);
        labelCards[j][i].setDisabledIcon(card); // whenever a JLabel is disabled, an image of the card back will appear
      }
    }
    
    // use the 2D array of card objects to get the images of the seven cards that the user can see
    Card card1 = game.cards[0][0]; 
    int order = card1.getOrder(); // will be a number 1-52
    card = new ImageIcon("cards_gif/"+order+".gif");
    labelCards[1][0].setIcon(card);
    labelCards[1][0].setEnabled(true); // since it's enabled, users can click on the card
    
    Card card2 = game.cards[1][1]; 
    int order2 = card2.getOrder();
    card = new ImageIcon("cards_gif/"+order2+".gif");
    labelCards[2][1].setIcon(card);
    labelCards[2][1].setEnabled(true);
    
    Card card3 = game.cards[2][2]; 
    int order3 = card3.getOrder();
    card = new ImageIcon("cards_gif/"+order3+".gif");
    labelCards[3][2].setIcon(card);
    labelCards[3][2].setEnabled(true);
    
    Card card4 = game.cards[3][3]; 
    int order4 = card4.getOrder();
    card = new ImageIcon("cards_gif/"+order4+".gif");
    labelCards[4][3].setIcon(card);
    labelCards[4][3].setEnabled(true);
    
    Card card5 = game.cards[4][4]; 
    int order5 = card5.getOrder();
    card = new ImageIcon("cards_gif/"+order5+".gif");
    labelCards[5][4].setIcon(card);
    labelCards[5][4].setEnabled(true);
    
    Card card6 = game.cards[5][5]; 
    int order6 = card6.getOrder();
    card = new ImageIcon("cards_gif/"+order6+".gif");
    labelCards[6][5].setIcon(card);
    labelCards[6][5].setEnabled(true);
    
    Card card7 = game.cards[6][6]; 
    int order7 = card7.getOrder();
    card = new ImageIcon("cards_gif/"+order7+".gif");
    labelCards[7][6].setIcon(card);
    labelCards[7][6].setEnabled(true);    
    
    for (int i = 0; i < defaultHeight; i++){
      for (int j = 0; j < defaultWidth; j++){
        add(labelCards[i][j]);
        (labelCards[i][j]).addMouseListener(new Listener());
      }
    }
  }
  
  // gets the indices of the JLabel in the 2D array
  public int[] getIndex(JLabel label) { 
    int [] indices = new int[2];
    // loop through entire array and compare each element to the passed in JLabel
    for (int i = 0; i < defaultHeight; i++){
      for (int j = 0; j < defaultWidth; j++){
        if (labelCards[i][j].equals(label)){
          indices[0] = i;
          indices[1] = j;
        }
      }
    }
    return indices; // returns an array with [y,x] coordinates in labelCard 2D Array
  }
  
  // second getIndex method takes in a Card object
  public int[] getIndex(Card c) { 
    int [] indices = new int[2];
    // loop through entire array and compare each element to the passed in card
    for (int i = 0; i < defaultHeight; i++){
      for (int j = 0; j < defaultWidth; j++){
        if (game.cards[i][j].equals(c)){
          indices[0] = i;
          indices[1] = j;
        }
      }
    }
    return indices; // returns an array with [y,x] coordinates in 2D Card Object array
  }
  
  // Returns true is the JLabel is in the middle grid
  public boolean inGrid(JLabel j) {
    int[] indices = getIndex(j);
    return (indices[0]>0); // true if the JLabel is not in the first row
  }
  
  // Listener class listens for mouse clicks
  // handles situations when the user clicks on cards in the inner grid panel
  private class Listener implements MouseListener{
    // y and x are the vertices of the JLabels 
    public int y;
    public int x;
    
    // since Listener implements MouseListener, must include the folloring methods
    public void mousePressed(MouseEvent e) {
      System.out.print("");
    }
    public void mouseExited(MouseEvent e) {
      System.out.print("");
    }
    public void mouseEntered(MouseEvent e) {
      System.out.print("");
    }
    public void mouseReleased(MouseEvent e) {
      System.out.print("");
    }
    
    // handles when the user clicks 
    public void mouseClicked(MouseEvent e){
      
//      // increments number of moves
//      int num = Integer.parseInt(numMoves.getText())+1;
//      numMoves.setText("" + num); 
      
      //MouseListener for Show Stack and Rest Stack.
      if (e.getComponent() == randomDeck) { // if the user clicks on the deck of cards
        
        if (game.restStack.isEmpty() && game.showStack.isEmpty()){
           ImageIcon empty = new ImageIcon("cards_gif/empty.gif");
           showCard.setIcon(empty);
        }
        
        else if (game.restStack.isEmpty()){ // if the deck of cards is empty
          game.restStack = game.showStack; // restStack stores the cards that the user has not seen
          game.showStack = new VectorStack<Card>(); // showStack stores the cards that the user sees/has seen
        }
        try{
        Card card = game.restStack.pop(); // pop the top card from the restStack
        
        game.showStack.push(card); // put card on the showStack
        
        int order = card.getOrder(); // need the order to get the right card image on the JLabel
        ImageIcon c = new ImageIcon("cards_gif/"+order+".gif");
        showCard.setIcon(c); // updates icon
        }
        catch(javafoundations.exceptions.EmptyCollectionException ex){};
      }
      
      /// MouseListener for Moving Cards in Grid. 
      JLabel label = (JLabel) e.getSource(); // get the label that user clicked on
      
      if (inGrid(label) && label.isEnabled()) { // check if the label is in the grid
        if (click==0){ // first click
          
          JLabel current = (JLabel) e.getSource(); // current is the desired destination that the user clicked on
          int[] indices = getIndex(current); // get the coordinates of the desired destination
          y = indices[0];
          x = indices[1];
          start[0] = game.cards[y-1][x]; //add the applicable cards to the start array
          
          ImageIcon green = new ImageIcon("cards_gif/green.gif"); // the card is being moved, so now the old spot becomes green
          labelCards[y][x].setIcon(green);
          
          // make sure the selected card is not the card at 0,0
          if (y != 1){
            labelCards[y][x].setEnabled(false);
          }
          
          labelCards[y][x].setDisabledIcon(green);
          game.cards[y-1][x] = null;
          // try to get the card above the moved card to appear on GUI
          try{
            if (! labelCards[y-1][x].isEnabled()){
              int order2 = (game.cards[y-2][x]).getOrder();
              ImageIcon card2 = new ImageIcon("cards_gif/"+order2+".gif");
              labelCards[y-1][x].setIcon(card2); // set the image of the new card
              labelCards[y-1][x].setEnabled(true);}}
          catch(ArrayIndexOutOfBoundsException ex){}
          catch(NullPointerException ex){}
          click = 1; // increment click
        } else { // second click
          
          JLabel current = (JLabel) e.getSource();//this is the JLabel that you are trying to click on the second time
          int[] indices = getIndex(current); // get the coordinates of where the user clicked
          int i = indices[0];
          int j = indices[1];
          Card end2 = game.cards[i-1][j]; // get the card object associated with where the user clicked
          int a = 0;
          if(game.cards[i-1][j] != null){ //if the destination is not null
            if (game.isLegal(end2, start[0])) { // if this is a legal move
              game.cards[i][j] = start[0];
              int order = start[0].getOrder(); // set the image of the card in the new location
              card = new ImageIcon("cards_gif/"+order+".gif");
              labelCards[i+1][j].setIcon(card);
              labelCards[i+1][j].setEnabled(true);
              click = 0; }  
          } else { // if game.cards[i][j] == null then we don't need to check if it's legal
            game.cards[i-1][j] = start[0];
            int order = start[0].getOrder();
            card = new ImageIcon("cards_gif/"+order+".gif");
            labelCards[i][j].setIcon(card);
            labelCards[i][j].setEnabled(true);
            click = 0;
          }
        }
      }
      
      //MouseListener for ShowStack and JLabel Grid.
      if (e.getComponent() == showCard){ 
        if (click==0){ // first click
        Card card = game.showStack.pop(); // pop the top card from the showStack;
        start[0] = card; // puts it in start 
        ImageIcon green= new ImageIcon("cards_gif/green.png"); // green/background image 
        showCard.setIcon(green); 
        click = 1;
        }else{ 
          game.showStack.push(start[0]);
          int order = start[0].getOrder();
          ImageIcon undo = new ImageIcon("cards_gif/"+order+".gif");
          showCard.setIcon(undo);
          click = 0;
        }
      }
      
      //MouseListener for the Four Suit Stacks
      
      // Hearts Stack
      if (e.getComponent() == heartsLabel) { // on the second click
        if (game.hearts.isEmpty()) { // if nothing is in the stack
          if (start[0].getValue().equals("Ace") && start[0].getSuit().equals("Hearts")) { // if it's ace card
            int order = start[0].getOrder();
            card = new ImageIcon("cards_gif/"+order+".gif");
            heartsLabel.setIcon(card);
            game.hearts.push(start[0]); // add the new card to the hearts stack            
            click = 0;
          }  
        } else { // if the stack is not empty
          Card previous = game.hearts.peek(); // peek top of stack
          if (previous.compareTo(start[0])==-1 && start[0].getSuit().equals("Hearts")) {
            int order = start[0].getOrder();
            card = new ImageIcon("cards_gif/"+order+".gif");
            heartsLabel.setIcon(card);
            game.hearts.push(start[0]); // add the new card to the hearts stack            
            click = 0;
            boolean over = game.isGameOver(); // checks if game is over
            if (over == true) {
              ImageIcon win = new ImageIcon("cards_gif/win.jpeg");
              ImageIcon winImage = new ImageIcon("cards_gif/fireworks.gif");
              JLabel winLabel = new JLabel(winImage);
              JOptionPane.showMessageDialog(null, winLabel, "You Won! Congratulations.", JOptionPane.PLAIN_MESSAGE, null);
              clubsLabel.setIcon(win);
              diamondsLabel.setIcon(win);
              heartsLabel.setIcon(win);
              spadesLabel.setIcon(win);
              //JOptionPane.showMessageDialog(null, "You win! Congratulations.");
            }
          }
        }
      }
      
      // Spades Stack
      if (e.getComponent() == spadesLabel) { // on the second click
        if (game.spades.isEmpty()) { // if nothing is in the stack
          if (start[0].getValue().equals("Ace") && start[0].getSuit().equals("Spades")) { // if it's ace card
            int order = start[0].getOrder();
            card = new ImageIcon("cards_gif/"+order+".gif");
            spadesLabel.setIcon(card);
            game.spades.push(start[0]); // add the new card to the hearts stack            
            click = 0;
          }        
        } else { // if the stack is not empty
          
          Card previous = game.spades.peek(); // peek top of stack
          if (previous.compareTo(start[0])==-1 && start[0].getSuit().equals("Spades")) {
            
            int order = start[0].getOrder();
            card = new ImageIcon("cards_gif/"+order+".gif");
            spadesLabel.setIcon(card);
            game.spades.push(start[0]); // add the new card to the hearts stack            
            click = 0;
            boolean over = game.isGameOver(); // checks if game is over
            if (over == true) {
              ImageIcon win = new ImageIcon("cards_gif/win.jpeg");
              clubsLabel.setIcon(win);
              diamondsLabel.setIcon(win);
              heartsLabel.setIcon(win);
              spadesLabel.setIcon(win);
              ImageIcon winImage = new ImageIcon("cards_gif/fireworks.gif");
              JLabel winLabel = new JLabel(winImage);
              JOptionPane.showMessageDialog(null, winLabel, "You Won! Congratulations.", JOptionPane.PLAIN_MESSAGE, null);
            }
          }
        }
      }
      
      // Diamonds Stack
      if (e.getComponent() == diamondsLabel) { // on the second click
        if (game.diamonds.isEmpty()) { // if nothing is in the stack
          if (start[0].getValue().equals("Ace") && start[0].getSuit().equals("Diamonds")) { // if it's ace card
            
            int order = start[0].getOrder();
            card = new ImageIcon("cards_gif/"+order+".gif");
            diamondsLabel.setIcon(card);
            game.diamonds.push(start[0]); // add the new card to the hearts stack            
            click = 0;
          }         
        } else { // if the stack is not empty
          
          Card previous = game.diamonds.peek(); // peek top of stack
          if (previous.compareTo(start[0])==-1 && start[0].getSuit().equals("Diamonds")) {
            
            int order = start[0].getOrder();
            card = new ImageIcon("cards_gif/"+order+".gif");
            diamondsLabel.setIcon(card);
            game.diamonds.push(start[0]); // add the new card to the hearts stack            
            click = 0;
            boolean over = game.isGameOver(); // checks if game is over
            if (over == true) {
              ImageIcon win = new ImageIcon("cards_gif/win.jpeg");
              clubsLabel.setIcon(win);
              diamondsLabel.setIcon(win);
              heartsLabel.setIcon(win);
              spadesLabel.setIcon(win);
              ImageIcon winImage = new ImageIcon("cards_gif/fireworks.gif");
              JLabel winLabel = new JLabel(winImage);
              JOptionPane.showMessageDialog(null, winLabel, "You Won! Congratulations.", JOptionPane.PLAIN_MESSAGE, null);
            }
          }
        }
      }
      
      // Clubs Stack
      if (e.getComponent() == clubsLabel) { // on the second click
        if (game.clubs.isEmpty()) { // if nothing is in the stack
          if (start[0].getValue().equals("Ace") && start[0].getSuit().equals("Clubs")) { // if it's ace card
            int order = start[0].getOrder();
            card = new ImageIcon("cards_gif/"+order+".gif");
            clubsLabel.setIcon(card);
            game.clubs.push(start[0]); // add the new card to the hearts stack            
            click = 0;
          }         
        } else { // if the stack is not empty
          Card previous = game.clubs.peek(); // peek top of stack
          if (previous.compareTo(start[0])==-1 && start[0].getSuit().equals("Clubs")) {
            int order = start[0].getOrder();
            card = new ImageIcon("cards_gif/"+order+".gif");
            clubsLabel.setIcon(card);
            game.clubs.push(start[0]); // add the new card to the hearts stack            
            click = 0;
            boolean over = game.isGameOver(); // checks if game is over
            if (over == true) {
              ImageIcon win = new ImageIcon("cards_gif/win.jpeg");
              clubsLabel.setIcon(win);
              diamondsLabel.setIcon(win);
              heartsLabel.setIcon(win);
              spadesLabel.setIcon(win);
              ImageIcon winImage = new ImageIcon("cards_gif/fireworks.gif");
              JLabel winLabel = new JLabel(winImage);
              JOptionPane.showMessageDialog(null, winLabel, "You Won! Congratulations.", JOptionPane.PLAIN_MESSAGE, null);
            }
           }
          }
        }
      }
    }
  }
