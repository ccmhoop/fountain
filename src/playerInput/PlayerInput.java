package playerInput;

import generator.Generator;
import generator.GridGenerator;

import java.util.Scanner;

public class PlayerInput {
    static Scanner scanner = new Scanner(System.in);
    static String input;
    static String prev = "-";

    static int x = 3;
    static int y = 0;

    static int room = 0;

    public static String playerInput() {
        return input;
    }

    public static String inputcheck() {
        while (true) {
            input = scanner.next();
            if (input.matches("[a-zA-Z]+")) {
                break;
            } else if (input.matches("[0-9]+")) {
                input.trim();
                break;
            }
        }
        return input;
    }

    public static void playerPosition() {
        Generator.gridSize[room][y][x] = prev;
        switch (inputcheck()) {
            case "w" -> {
                y--;
                prev = Generator.gridSize[room][y][x];
            }
            case "s" -> {
                y++;
                prev = Generator.gridSize[room][y][x];
            }
            case "d" -> {
                x++;
                prev = Generator.gridSize[room][y][x];
            }
            case "a" -> {
                x--;
                prev = Generator.gridSize[room][y][x];
            }
        }
        if (prev.equals("+") && (x == 7 || x == 0) && y != 0 && y != 7) {
            if (x==0){
                x=6;
            }else{
                x = 1;
            }

            room++;
        }
        if (prev.equals("-") && (x == 7 || x == 0) && y != 0 && y != 7) {
            if (x==7){
                x=1;
            }else{
                x = 6;
            }
            room -= 1;
        }

        if (prev.equals("+") && (y == 7 || y == 0) && x != 0 && x != 7) {
            y = 1;
            room++;
        }
        if (prev.equals("-") && (y == 7 || y == 0) && x != 0 && x != 7) {
            y = 6;
            room -= 1;
        }

        Generator.gridSize[room][y][x] = "PP";
        GridGenerator.mapPrinter(8, room);
    }
}

