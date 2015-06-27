/******************************************************
  * ButtonPanel.java
  * Avanti Prasanna, Kim Asenbeck, Amanda  Foun
  * CS 230 Final Project: ButtonPanel Class
  * Start Date: April 28, 2015
  * End Date: May 12, 2015
  * Avanti and Kim are primarily responsible for this class
  * ***************************************************/

//**********************************************************************************
// Button Panel provides the help button, the quit button, and the newGame button
//**********************************************************************************

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonPanel extends JPanel{
  private JButton quit; 
  private JButton help; 
  private JButton newGame; 
  
  public ButtonPanel(){
    
    setLayout(new GridLayout(1,4));
    
    // create the three buttons
    
    // Quit Button 
    quit = new JButton("Quit");
    quit.addActionListener(new ButtonListener());
    
    // New Game Button
    newGame = new JButton("New Game");
    newGame.addActionListener(new ButtonListener());   
    
    // Help Button 
    help = new JButton("Help!");
    help.addActionListener(new ButtonListener());
    
    // add the three buttons
    add(help);
    add(newGame);
    add(quit);  
  }
  
  /* Button Listener handles the event in which the user clicks 
   * the help, new game or quit button
   */ 
  private class ButtonListener implements ActionListener{
    public void actionPerformed(ActionEvent event){
      if (event.getSource() == quit) {
        System.exit(0);
      }
      if (event.getSource() == help) {
        JOptionPane helpBox = new JOptionPane();
        helpBox.showMessageDialog(null, "Rules:\nThe goal of the game is to sort the cards into four "+
                                  "piles,\neach containing cards in one suit. Cards must be in order \n"+
                                  "from Ace to King, and must contain all 13 cards in each suit.\nTo achieve " + 
                                  "this goal, you may manipulate the order of the\ncards by sorting them. " + 
                                  "Cards must be sorted in alternating\ncolors, and may only be place under a" + 
                                  "card that is one value\nbigger than the be the next value, sequentially.\n" + 
                                  "\nCreated by:\nKim Asenbeck, Amanda Foun, and Avanti Prasanna for CS230", "Help", JOptionPane.PLAIN_MESSAGE);
      }
      if (event.getSource() == newGame) {
        int n = JOptionPane.showConfirmDialog(null, "Are you sure you want to start a new game?", "New Game", JOptionPane.YES_NO_OPTION);
        if (n == 0){
          System.exit(0); // close the GUI
        }
        else{
          System.out.print("");
        }
      }
    }
  }
}
