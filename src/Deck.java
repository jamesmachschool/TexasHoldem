import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Vector;

public class Deck {
    private final int TOTAL_CARDS = 52;
    private int cardsNotDealt, cardsDealt;
    private Vector<Card> unshuffled;
    private Queue<Card> deck;

    private String cardsFile = "cards.txt";

    public Deck() throws IOException, MissingCardsException {
        deck = new LinkedList<>();
        try {
            unshuffled = new Vector<>();
            this.loadCards();
            this.Shuffle(10);
        } catch (Exception e) {
            throw e;
        }
    }

    public static void main(String[] args) throws MissingCardsException, IOException {
        Deck deck = new Deck();
        System.out.println(deck.toString());

    }

    public void loadCards() throws MissingCardsException, IOException {
        try {
            Scanner scan = new Scanner(new File(cardsFile));

            while (scan.hasNextInt()) {
                String c = scan.nextLine();
                Scanner scan2 = new Scanner(c);
                unshuffled.add(new Card(scan2.nextInt(), scan2.next().charAt(0)));
            }
        } catch (Exception e) {
            throw e;
        }
        if (unshuffled.size() != TOTAL_CARDS) {
            throw new MissingCardsException();
        }

    }

    public void Shuffle(int n) {
        Queue<Card> temp = new LinkedList<>();
        deck.clear();
        cardsNotDealt = TOTAL_CARDS;
        cardsDealt = 0;
        while (n > 0) {
            while (unshuffled.size() > 0) {
                int r = (int) (Math.random() * 99999989) % unshuffled.size();
                Card c = unshuffled.get(r);
                temp.add(c);
                unshuffled.remove(c);
            }
            while (temp.peek() != null) {
                unshuffled.add(temp.poll());
            }
            n--;
        }
        for (Card c : unshuffled) {
            deck.add(c);
        }
    }

    public Card dealCard() {
        cardsDealt++;
        cardsNotDealt--;
        return deck.poll();
    }

    public void discardCard() {
        cardsDealt++;
        cardsNotDealt--;
        deck.poll();
    }

    public String toString() {
        String output = "";
        for (Card c : deck) {
            output += c.toString() + "\n";
        }
        return output;
    }

    public int getCardsDealt() {
        return cardsDealt;
    }

    public int getCardsNotDealt() {
        return cardsNotDealt;
    }

}
