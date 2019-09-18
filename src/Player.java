public abstract class Player {
    private String name;
    private Hand hand;

    public Player(String n) {
        name = n;
        hand = new Hand();
    }

    public void giveCard(Card c) {
        hand.add(c);
    }

    public void clearHand() {
        hand = new Hand();
    }

    public Hand getHand() {
        return hand;
    }

    public String getName(){
        return name;
    }


}
