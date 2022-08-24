package com.example;

public enum TextColor {
  RED("\u001B[31m"),
  GREEN("\u001B[32m"),
  YELLOW("\u001B[33m"),
  RESET("\u001B[0m");


  public final String text; 

  TextColor(String text) {
    this.text = text;
  }
}
