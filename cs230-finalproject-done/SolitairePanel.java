/******************************************************
  * SolitairePanel.java
  * Avanti Prasanna, Kim Asenbeck, Amanda  Foun
  * CS 230 Final Project: SolitairePanel Class
  * Start Date: May 9, 2015 
  * End Date: May 12, 2015
  * Avanti and Kim are primarily responsible for this class
  * ***************************************************/

//*********************************************************************
// SolitairePanel class  creates the first main panels: 
// (1) the title panel (2) the game panel 
//*********************************************************************

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SolitairePanel extends JPanel{
  Solitaire game; 
  
  public SolitairePanel(Solitaire game2){
    setLayout(new BorderLayout());
    
    game = game2; 
    
    TopPanel top = new TopPanel(game);
    GamePanel newGame = new GamePanel(game);
    
    add(top, BorderLayout.NORTH);
    add(newGame, BorderLayout.CENTER);
  }
}