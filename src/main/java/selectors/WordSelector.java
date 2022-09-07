package selectors;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import org.json.simple.parser.ParseException;

public interface WordSelector {
  

  public ArrayList<String> loadList(String path) throws FileNotFoundException, IOException, ParseException;

  public String randomWord();
}
