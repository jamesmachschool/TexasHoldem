public enum Value {
    ONE(1), FIVE(5), TEN(10), TWENTYFIVE(25), FIFTY(50);

    private int value;
    private Color color;
     Value(int v){
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
