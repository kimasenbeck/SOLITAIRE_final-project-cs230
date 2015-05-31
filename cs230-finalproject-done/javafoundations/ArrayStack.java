//********************************************************************
//  ArrayStack.java       Java Foundations
//
//  Represents an array implementation of a stack. The bottom of
//  the stack is kept at array index 0. So, pushing and popping happens at the higher 
//  end of the underlying array.
//********************************************************************

package javafoundations; 

import javafoundations.exceptions.*;

public class ArrayStack<T> //implements Stack<T>
{
  private final int DEFAULT_CAPACITY = 1; //keep it small for testing purposes
  private int count; //num of elements in the array
  private T[] stack; //array to hold the elements
  
  //-----------------------------------------------------------------
  //  Creates an empty stack using the default capacity.
  //-----------------------------------------------------------------
  public ArrayStack()
  {
    count = 0;
    stack = (T[])(new Object[DEFAULT_CAPACITY]); // cast array of objects to arrays of T. 
  }
  
  //-----------------------------------------------------------------
  //  Adds the specified element to the top of this stack, expanding
  //  the capacity of the stack array if necessary.
  //-----------------------------------------------------------------
  public void push (T element)
  {
    if (count == stack.length){
      expandCapacity();
    }
    
    stack[count] = element;
    count++;
  }
  
  //-----------------------------------------------------------------
  //  Returns a string representation of this stack.
  //-----------------------------------------------------------------
  public String toString()
  {
    String result = "<top of stack>\n";
    
    for (int index=count-1; index >= 0; index--)
      result += stack[index] + "\n";
    
    return result + "<bottom of stack>";
  }
  
  // expandCapacity Method
  private void expandCapacity(){
    int new_Capacity = stack.length*2;
    T[] stack1 = (T[])(new Object[new_Capacity]);
    
    for (int i = 0; i < count; i++){
      stack1[i] = stack[i];
    }
    
    stack = stack1;
  }
  
  // like Getters and Setters: Returns size of the ArrayStack
  public int size() {
    return count; 
  }
  
  // Checks if the ArrayStack is empty
  public boolean isEmpty() { 
    return count == 0; 
  }
  
  public T peek () throws EmptyCollectionException { 
    if (count == 0) {
      throw new EmptyCollectionException("Peek(): Cannot peek from an empty stack.");
    }
    return stack[count-1]; 
  }
  
  public T pop () throws EmptyCollectionException { 
    if (count == 0) {
      throw new EmptyCollectionException("Pop(): Cannot peek from an empty stack.");
    }
    count--;
    return stack[count]; 
  }
  
  // Main Method
  public static void main(String [] args){
    ArrayStack<String> socks = new ArrayStack<String>();
    socks.push("red socks");
    socks.push("black socks");
    System.out.println(socks);
    
    System.out.println(socks.peek());
    System.out.println(socks.pop());
    
    System.out.println(socks);
  }
  //-----------------------------------------------------------------
  //  The following methods are left as Programming Projects.
  //-----------------------------------------------------------------
}
