package selectors;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonSelector extends WordSelector {
  private ArrayList<String> wordList;

  public JsonSelector(String path) throws FileNotFoundException, IOException, ParseException { 
    this.wordList = loadList(path);
  }
  
  protected ArrayList<String> loadList(String path) throws FileNotFoundException, IOException, ParseException {
    JSONParser parser = new JSONParser();
    JSONArray words = (JSONArray) parser.parse(new FileReader(path));
    ArrayList<String> wordList = new ArrayList<>();
    for(Object word: words) {
      wordList.add(word.toString());
    }
    return wordList;

  }

  public String randomWord() {
    Random random = new Random();
    int randomIndex = random.nextInt(this.wordList.size());
    return this.wordList.get(randomIndex);
  }

  
  
}
