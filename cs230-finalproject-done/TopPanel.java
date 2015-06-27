/******************************************************
  * TopPanel.java
  * Avanti Prasanna, Kim Asenbeck, Amanda  Foun
  * CS 230 Final Project: TopPanel Class
  * Start Date: May 9, 2015 
  * End Date: May 12, 2015
  * Avanti and Kim are primarily responsible for this class
  * ***************************************************/

//*********************************************************************
// TopPanel class creates the title, infoPanel and ButtonPanel
//*********************************************************************

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TopPanel extends JPanel{
  private JLabel name; 
  public Solitaire game;
  
  public TopPanel(Solitaire game2){
    //create the border layout
    setLayout(new BorderLayout()); 
    
    //create and modify title
    name = new JLabel("    solitaire"); 
    name.setFont(new Font("Courier New", Font.BOLD, 65));
    name.setForeground(Color.white);
    add(name, BorderLayout.NORTH); 
    
    game = game2; //the instance variable game refers to game2 (which was the parameter for the TopPanel) 
    
    // add the InfoPanel
    InfoPanel info = new InfoPanel(game);
    add(info, BorderLayout.CENTER);
    
    // add the ButtonPanel
    ButtonPanel buttons = new ButtonPanel();
    add(buttons, BorderLayout.SOUTH);
  }
  
}