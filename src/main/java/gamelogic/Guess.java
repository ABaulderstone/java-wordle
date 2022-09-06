package gamelogic;

import java.util.Arrays;

import com.example.TextColor;

public class Guess {
  String word;
  String colorizedOutput;
  char[] letters;
  char[] greenLetters = {'_', '_', '_', '_', '_' };
  char[] yellowLetters = {'_', '_', '_', '_', '_' };
  
  public Guess(String word) {
    this.word = word;
    this.letters = word.toCharArray();
  }

  public boolean compare(String selectedWord) {
    extractGreenLetters(selectedWord);
    // System.out.println(new String(letters));
    extractYellowLetters(selectedWord);
    // System.out.println(new String(letters));
    // System.out.println("YELLOW");
    // System.out.println(new String(yellowLetters));
    // System.out.println("YELLOW");
    return word.equals(selectedWord);
  }

  public void extractGreenLetters(String selectedWord) {
    char[] selectedLetters = selectedWord.toCharArray();
    for(byte i = 0; i < selectedLetters.length; i++) {
        if(selectedLetters[i] == letters[i]) {
          greenLetters[i] = selectedLetters[i];
          letters[i] = '*';
        }
    }
  }

  public void extractYellowLetters(String selectedWord) {
    for(byte i = 0; i < letters.length; i++) {
        final char currentLetter = letters[i];
        String subString = String.valueOf(currentLetter);
        System.out.println("substring");
        System.out.println(subString);

        //check count of letter in actual word, 
        long actualCount = selectedWord.chars().filter(ch -> ch == currentLetter).count();
        // check count of letter in green letter array
        long alreadyOccuring = new String(greenLetters).chars().filter(ch -> ch == currentLetter).count();;
        // if > add to yellow, else don't. 
        if(selectedWord.contains(subString) && alreadyOccuring < actualCount) {
          yellowLetters[i] = currentLetter;
          letters[i] = '*';
          actualCount++;
        }
    }

  }

  public String generateColoredString(){ 
    StringBuilder builder = new StringBuilder();
    for(byte i = 0; i < 5; i++) {
      char currentChar = word.charAt(i);
       if( greenLetters[i] == currentChar) {
         builder.append(TextColor.GREEN.text + currentChar + TextColor.RESET.text);
        
       } else if(yellowLetters[i] == currentChar) {
         builder.append(TextColor.YELLOW.text + currentChar + TextColor.RESET.text);
       }else {
         
         builder.append(currentChar);
       }
      }
      return builder.toString();
    }
  }

