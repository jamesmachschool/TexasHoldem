public class Card {
    private int value;
    private String symbol, name;
    private Suit suit;
    private Color color;

    public Card() {
        value = -1;
    }

    public Card(int v, char s) {
        if (v == 1) {
            value = 14;
        } else {
            value = v;
        }
        switch (s) {
            case 'S':
                suit = Suit.SPADE;
                color = Color.BLACK;
                break;
            case 'C':
                suit = Suit.CLUB;
                color = Color.BLACK;
                break;
            case 'D':
                suit = Suit.DIAMOND;
                color = Color.RED;
                break;
            case 'H':
                suit = Suit.HEART;
                color = Color.RED;
                break;
        }
        switch (value) {
            case 14:
                name = "The Ace of " + suit.getName();
                symbol = "A " + suit.getName().charAt(0);
                break;
            case 13:
                name = "The King of " + suit.getName();
                symbol = "K " + suit.getName().charAt(0);
                break;
            case 12:
                name = "The Queen of " + suit.getName();
                symbol = "Q " + suit.getName().charAt(0);
                break;
            case 11:
                name = "The Jack of " + suit.getName();
                symbol = "J " + suit.getName().charAt(0);
                break;
            default:
                name = value + " " + suit.getName();
                symbol = value + " " + suit.getName().charAt(0);
                break;
        }
    }

    public Suit getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public String toString() {
        return symbol;
    }
}
