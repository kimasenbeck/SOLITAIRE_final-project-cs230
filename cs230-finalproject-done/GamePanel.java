/******************************************************
  * GamePanel.java
  * Avanti Prasanna, Kim Asenbeck, Amanda  Foun
  * CS 230 Final Project: GamePanel Class
  * Start Date: April 28, 2015
  * End Date: May 12, 2015 
  * Avanti and Kim are primarily responsible for this class
  * ***************************************************/

//*********************************************************************
// GamePanel.java
// Creates InnerGridPanel objects for the game.  
// Takes in the Solitaire game as a parameter.
//*********************************************************************

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePanel extends JPanel{
  
  // Instance Variables
    private JLabel welcome; 
    private InnerGridPanel grid;
    public Solitaire game; 
   
  // Constructor takes in a Solitaire object  
  public GamePanel(Solitaire game2){
    
    setLayout(new BorderLayout());
    
    game = game2; 

    grid = new InnerGridPanel(game);
     
    add(grid, BorderLayout.CENTER);
  }
}