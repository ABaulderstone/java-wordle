package com.example;

import java.util.Scanner;

public class UserInput {
  private Scanner s;
  
  UserInput() {
    this.s = new Scanner(System.in);
  }

  public String takeValidInput() {
    
		
		while(!s.hasNext("[a-zA-Z]{5}")) { 
			System.out.println(TextColor.RED.text + "Input must be a 5 letter word" + TextColor.RESET.text );
			s.next();
		}
		String validInput = s.next();
	
		return validInput.toLowerCase();
  }

  
}
