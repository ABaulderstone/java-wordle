package gamelogic;

import java.util.ArrayList;


import com.example.input.UserInput;

import selectors.JsonSelector;
import selectors.WordSelector;

public class Game {
  private WordSelector selector;
  private String selectedWord; 
  private boolean won;
  private byte attempts;
  private ArrayList<Guess> guesses;
  private UserInput userInput;
  
  final byte MAX_ATTEMPTS = 6;
  
  public Game(WordSelector selector) {
    this.selector = selector;
    this.selectedWord = this.selector.randomWord();
    this.won = false;
    this.attempts = 0;
    this.guesses = new ArrayList<>();
    this.userInput = new UserInput();
  }



  public void compareWords(String input) {
    Guess currentGuess = new Guess(input);
    this.guesses.add(currentGuess);
    if(currentGuess.compare(this.selectedWord)) {
      this.won = true;
    }
    return; 
  }

  public void run() {
    while (this.attempts < this.MAX_ATTEMPTS && !this.won) {
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
    for (Guess g: this.guesses) {
      String output = g.generateColoredString();
      System.out.println(output);
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
