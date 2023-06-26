package generator;

public class GridGenerator extends Generator {

    private boolean northSouthSwitch;
    private boolean eastWestSwitch;
    private int doorTrack;
    private String doorPlacer;

    public GridGenerator(int size) {
        generateGrid(size);
        gridSize[0][0][3] = "PP";
//        mapPrinter(size);

    }


    private void generateGrid(int size) {
        for (int room = 0; room < (size * size); room++) {
            for (int rows = 0; rows < size; rows++) {
                for (int columns = 0; columns < size; columns++) {
                    gridSize[room][rows][columns] = roomMaker(rows, columns, size);
                }
            }
            doorTrack++;
            northSouthSwitch = !northSouthSwitch;
            eastWestSwitch = !eastWestSwitch;
        }
    }

    private String roomMaker(int rows, int columns, int size) {
        if (columns == 0 || columns == size - 1 || rows == 0 || rows == size - 1) {
            doors(rows, columns, size);
        } else {
            return String.valueOf(columns);
        }
        return doorPlacer;
    }

    private void doors(int rows, int columns, int size) {
        doorPlacer = "M";
        if ((rows == size / 2 || rows == size / 2 - 1 || columns == size / 2 || columns == size / 2 - 1)) {
            if (rows == 0 || rows == size - 1) {
                doorSwitch(rows, size, northSouthSwitch);
            } else {
                if (doorTrack > 1) {
                    doorSwitch(columns, size, eastWestSwitch);
                    reverString();
                } else {
                    doorSwitch(columns, size, !eastWestSwitch);
                }
            }
        }
    }

    private void doorSwitch(int rowColumn, int size, boolean compass) {
        if (doorTrack == 4) {
            doorTrack = 0;
        }
        if (rowColumn == 0 && !compass) {
            doorPlacer = "-";
        } else if (rowColumn == size - 1 && compass) {
            doorPlacer = "+";
        }
    }

    private void reverString() {
        if (doorTrack > 1) {
            switch (doorPlacer) {
                case "-" -> doorPlacer = "+";
                case "+" -> doorPlacer = "-";
            }
        }
    }

//    private void mapPrinter(int size) {
//        int printRoom = 0;
//        for (int room = 0; room < (size * size); room++) {
//            System.out.println("room " + (room));
//            for (int rows = 0; rows < size; rows++) {
//                for (int columns = 0; columns < size; columns++) {
//                    printRoom++;
//                    System.out.print(gridSize[room][rows][columns] + " ");
//                    if (printRoom == (size * size * size)) {
//                        System.out.println();
//                        printRoom = 0;
//                    }
//                }
//                System.out.println("row " + rows);
//            }
//            System.out.println();
//        }
//    }

    public static void mapPrinter(int size,int playerRoom) {
        int printRoom = 0;
        for (int room = 0; room < (playerRoom+1); room++) {
            System.out.println("room " + (room));
            for (int rows = 0; rows < size; rows++) {
                for (int columns = 0; columns < size; columns++) {
                    printRoom++;
                    System.out.print(gridSize[room][rows][columns] + " ");
                    if (printRoom == (size * size * size)) {
                        System.out.println();
                        printRoom = 0;
                    }
                }
                System.out.println("row " + rows);
            }
            System.out.println();
        }
    }
}
