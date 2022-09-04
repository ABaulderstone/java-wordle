package com.example.input;

import java.util.Scanner;

import com.example.TextColor;

public class UserInput {
  private Scanner s;
  
  public UserInput() {
    this.s = new Scanner(System.in);
  }

  public String takeValidInput() {
    System.out.println("Please enter a valid 5 letter word");
		
		while(!s.hasNext("[a-zA-Z]{5}")) { 
			System.out.println(TextColor.RED.text + "Input must be a 5 letter word" + TextColor.RESET.text );
			s.next();
		}
		String validInput = s.next();
	
		return validInput.toLowerCase();
  }

  
}
