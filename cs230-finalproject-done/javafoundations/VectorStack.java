//********************************************************************
//  VectorStack.java       Java Foundations
//
//  Represents a Vector implementation of a stack. The bottom of
//  the stack is kept at the lowest index.
//********************************************************************

package javafoundations;

import java.util.Vector;
import javafoundations.exceptions.*;

public class VectorStack<T> implements Stack<T> {
  private Vector<T> stack;
  
  /**
   * Creates an empty stack using the default 
   * initial capacity on Vector, which is 10.
   */
  public VectorStack() {
    stack = new Vector<T>();
  }
  
  /**
   *  Adds the specified element to the top of this stack, expanding
   *  the capacity of the stack array if necessary.
   */
  public void push (T element) {  
    stack.add(element);
  }
  
  /**
   *  Returns a string representation of this stack.
   */
  public String toString() {
    String result = "<bottom of stack>";
    result = result + stack.toString();
    return result + "<top of stack>";
  }
  
  /**
   *    Removes the element at the top of this stack and returns a
   *  reference to it. Throws an EmptyCollectionException if the
   *  stack contains no elements.
   */
  public T pop () throws EmptyCollectionException {
    if (stack.isEmpty())
      throw new EmptyCollectionException("Pop operation failed. Stack is empty.");
    return stack.remove(stack.size()-1);
  }
  
  /**
   *  Returns top without retrieving
   */
  public T peek () throws EmptyCollectionException {
    if(stack.isEmpty())
      throw new EmptyCollectionException("Peek operation failed. Stack is empty.");
    
    return stack.elementAt(stack.size()-1);
  }
  
  /**
   *  Checks if stack is empty
   */
  public boolean isEmpty() {
    return stack.isEmpty();
  }
  
  /**
   *  Returns the number of eleements in the stack
   */
  public int size() {
    return stack.size();
  }
  
  public static void main(String[] args) {
//    VectorStack<String> a = new VectorStack<String>();
//    a.push("hello1");
//    a.push("hello2");
//    a.push("hello3");
//    System.out.println(a);
//    try {
//    System.out.println("popped: " + a.pop());
//    System.out.println(a);
//    
//    System.out.println("popped: " + a.pop());
//    System.out.println(a);
//    
//    System.out.println("popped: " + a.pop());
//    System.out.println(a);
//    
//    System.out.println("popped: " + a.pop());
//    System.out.println(a);
//    } catch (EmptyCollectionException e) {
//      System.out.println("Stack is empty. Cannot pop.");
//    }  
  }
}