package selectors;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import org.json.simple.parser.ParseException;

public abstract class WordSelector {
  private ArrayList<String> wordList;

  abstract protected ArrayList<String> loadList(String path) throws FileNotFoundException, IOException, ParseException;

  public String randomWord() {
    Random random = new Random();
    int randomIndex = random.nextInt(this.wordList.size());
    return this.wordList.get(randomIndex);
  }
}
