package main;

import generator.Generator;
import generator.GridGenerator;
import playerInput.PlayerInput;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

  static Generator generator = new Generator();
    public static void main(String[] args) {
        generator.runGenerator(8);
        while (true) {
            PlayerInput.playerPosition();
        }
    }


    }
