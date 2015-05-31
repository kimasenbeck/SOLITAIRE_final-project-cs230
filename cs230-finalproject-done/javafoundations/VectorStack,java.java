/////////////////////////
// Lab 5: Vector Array
// Created by: Avanti Prasanna
// Date: February 26, 2015
////////////////////////

package javafoundations; 

import javafoundations.exceptions.*;

public class VectorStack<T> { /// implements Stack<T>
  Vector<T> stack;
  
    public VectorStack(){
    stack = new Vector<T> (); // cast array of objects to arrays of T. 
  }

}