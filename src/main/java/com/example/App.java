package com.example;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            Game game = new Game((byte) 5);
            System.out.println(TextColor.GREEN.text + game.getSelectedWord() + TextColor.RESET.text);
            game.run();
        } catch (IOException | ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
