public class Chip {
    private int value;
    private Color color;

    public Chip(int v){
        value = v;
        switch(value){
            case 1:
                color = Color.WHITE;
            case 5:
                color = Color.RED;
            case 10:
                color = Color.BLUE;
            case 25:
                color = Color.GREEN;
            case 50:
                color = Color.BLACK;
        }
    }

    public Color getColor() {
        return color;
    }

    public int getValue() {
        return value;
    }
}
