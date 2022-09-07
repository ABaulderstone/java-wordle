package com.example;

import java.io.IOException;

import org.json.simple.parser.ParseException;

import dictionary.Dictionary;
import gamelogic.Game;
import selectors.JsonSelector;

public class App 
{
    public static void main( String[] args ) throws InterruptedException, ParseException
    {
        try {
            // JsonSelector jsonSelector = new JsonSelector("src/main/java/com/example/data/word-list.json");
            // Game game = new Game(jsonSelector);
            // System.out.println(TextColor.GREEN.text + game.getSelectedWord() + TextColor.RESET.text);
            // game.run();
            Dictionary dict = new Dictionary();
            String word = dict.getDefinition("pretty");
            System.out.println(word);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
