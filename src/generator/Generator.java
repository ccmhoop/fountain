package generator;

public class Generator {

    public static String[][][] gridSize;

    public Generator() {
    }

    public void runGenerator(int size){
        gridSize = new String[size*size][size][size];
        new GridGenerator(size);
    }




}
