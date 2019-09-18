public class MissingCardsException extends Exception {

    public MissingCardsException(){
        super("There were not 52 cards loaded.");
    }
}
