package com.example;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;

public class Game {
  private String selectedWord; 
  private boolean won;
  private byte attempts;
  private byte maxAttempts;
  private ArrayList<String> guesses;
  private UserInput userInput;

  Game(byte maxAttempts) throws FileNotFoundException, IOException, ParseException {
    this.selectedWord = new WordSelector("src/main/java/com/example/data/word-list.json").randomWord();
    this.won = false;
    this.attempts = 0;
    this.maxAttempts = maxAttempts;
    this.guesses = new ArrayList<>();
    this.userInput = new UserInput();
  }



  public void compareWords(String input) {
    if(input.equals(selectedWord)) {
      this.won = true;
      this.guesses.add(TextColor.GREEN.text + input + TextColor.RESET.text);
      return; 
    }

    char[] inputChars = input.toCharArray();
    char[] selectedWordChars = this.selectedWord.toCharArray();
    StringBuilder guessBuilder = new StringBuilder();
    for(int i = 0; i < inputChars.length; i++ ) {
      String substring = String.valueOf(inputChars[i]);
      if(inputChars[i] == selectedWordChars[i]) {
        guessBuilder.append(TextColor.GREEN.text + substring + TextColor.RESET.text );
        selectedWordChars[i] = 0;
        continue;
      }

      if(new String(selectedWordChars).contains(substring)) {
        guessBuilder.append(TextColor.YELLOW.text + substring + TextColor.RESET.text);
        continue;
      }
      guessBuilder.append(substring);
    }
    this.guesses.add(guessBuilder.toString());
  }

  public void run() {
    while (this.attempts < this.maxAttempts && !this.won) {
      this.printGuesses();
      String guess = this.userInput.takeValidInput(); 
      this.compareWords(guess);
      this.attempts++;
    }
    System.out.println(generateResultMessage());
  }

 

  public void printGuesses(){
    if(this.attempts == 0) return;
    System.out.println("Guesses: ");
    System.out.println();
    for (String word : this.guesses) {
      System.out.println(word);
    }
  }


  public String generateResultMessage() {
    if(this.won) {
      return String.format("Congratulations, you gussed the word in %d attempts", this.attempts);
    }
    return String.format("Bad Luck, you failed to guess the word. It was %s", this.selectedWord);
  }
  public String getSelectedWord() {
    return selectedWord;
  }
}
