package gamelogic;

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
    extractYellowLetters(selectedWord);
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
    char[] selectedLetters = selectedWord.toCharArray();
    for(byte i = 0; i < selectedLetters.length; i++) {
        String remainingLetters = new String(letters);
        String subString = String.valueOf(selectedLetters[i]);
        if(remainingLetters.contains(subString)) {
          yellowLetters[i] = selectedLetters[i];
          letters[i] = '*';
        }
    }
  }

  public String generateColoredString(){ 
    StringBuilder builder = new StringBuilder();
    for(byte i = 0; i < 5; i++) {
      char currentChar = word.charAt(i);
       if( greenLetters[i] == currentChar) {
         builder.append(TextColor.GREEN.text + currentChar + TextColor.RESET.text);
         continue;
       }

       if(yellowLetters[i] == currentChar) {
         builder.append(TextColor.YELLOW.text + currentChar + TextColor.RESET.text);
        continue;
       }
          builder.append(currentChar);
      }
      return builder.toString();
    }
  }

