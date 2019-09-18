public class Hand {
    private Card[] hand = new Card[2];
    private int numberOfCards = 0;

    public Hand() {
    }

    public boolean add(Card c) {
        if (numberOfCards != 2) {
            hand[numberOfCards] = c;
            numberOfCards++;
            return true;
        }
        return false;
    }

    public Card[] getCards() {
        return hand;
    }
}
