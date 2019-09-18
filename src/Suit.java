public enum Suit {
    SPADE("Spades"), CLUB("Clubs"), HEART("Heart"), DIAMOND("Diamonds");

    private String name;

    Suit(String n){
        name = n;
    }

    public String getName(){
        return name;
    }
}
