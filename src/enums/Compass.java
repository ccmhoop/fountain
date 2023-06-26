package enums;

public enum Compass {
    BARING;
    String baring;

    public String direction(String bar){
        switch(bar) {
            case "S" -> bar = "N";
            case "W" -> bar = "E";
            case "N" -> bar = "S";
            case "E" -> bar = "W";
        }
        return bar;
    }
}
