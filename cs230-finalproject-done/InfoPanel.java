
/******************************************************
  * InfoPanel.java
  * Avanti Prasanna, Kim Asenbeck, Amanda  Foun
  * CS 230 Final Project: InfoPanel Class
  * Start Date: April 28, 2015
  * End Date: May 12, 2015 
  * Avanti and Kim are primarily responsible for this class
  * ***************************************************/

//************************************************************************************
// Info panel provides information about the game such as how to play the game 
// the amount of time elapsed in the game in seconds and the option to quit the game
// should the user chose to do so.
//************************************************************************************

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InfoPanel extends JPanel{
  
  // Instance Variables
  private JLabel welcome; 
  private JLabel timer;
  public Solitaire game; 
  
  // Constructor takes in a Solitaire object
  public InfoPanel(Solitaire game2){
    game2 = game;
    
    setLayout(new GridLayout(1,4));
    
    JLabel empty = new JLabel();
    add(empty);
    
    // Welcome Message 
    welcome = new JLabel("Welcome player!");
    welcome.setFont(new Font("Courier New", Font.BOLD, 20)); //Sets Font
    welcome.setForeground(Color.white);
    add(welcome);
    
    // Timer 
    timer = new JLabel(""); //initialize at 0 seconds
    timer.setFont(new Font("Courier New", Font.BOLD, 20)); //Sets Font of label
    timer.setForeground(Color.white);
    add(timer);//add the label to the gui
    ActionListener listener = new ActionListener() { //create new action listener
      int timez = 0; 
      int mins, secs;
      String m, s; 
      public void actionPerformed(ActionEvent actionEvent) {//this action listener increments seconds by 1 each second
        timez++;
        mins = timez/60;
        secs = timez%60;
        if (mins < 10){
        m = "0" + mins;
        }else{m = "" + mins;}
        if (secs < 10){
        s = "0" + secs;
        }else{s = "" + secs;}
        String formatted = m + ":" + s;
        //int t = Integer.parseInt(timer.getText())+1; //get the previous time, add one to it
        timer.setText("" + formatted);//set the text of the label
      }};
    Timer update = new Timer(1000, listener);//create a label with delay 1000 milliseconds and the above listener
    update.start(); //start the timer when GUI opens 
  }
}
