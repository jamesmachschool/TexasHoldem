import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Game {
    private static Game theInstance = new Game();
    private int numberOfPlayers;
    private Player[] players;
    private Deck deck;
    private Card[] communityCards;

    private Game() {
    }

    public static Game getTheInstance() {
        return theInstance;
    }

    public void loadGame() {
        try {
            loadPlayers();
            deck = new Deck();
        } catch (Exception e) {

        }

    }

    public void loadPlayers() throws IOException {
        String fileName = "players.txt";

        Scanner scan = new Scanner(new File(fileName));
        numberOfPlayers = scan.nextInt();
        scan.nextLine();
        players = new Player[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++) {
            String player = scan.nextLine();
            Scanner s = new Scanner(player);
            String name = s.next();
            String type = s.next();
            if (type.charAt(0) == 'C') {
                players[i] = new ComputerPlayer(name);
            } else {
                players[i] = new HumanPlayer(name);
            }
        }

    }

    public void dealHands(){
        if(deck.getCardsNotDealt()>2*players.length){
            for(Player p : players){
                p.giveCard(deck.dealCard());
            }
            for(Player p : players){
                p.giveCard(deck.dealCard());
            }
        } else {
            deck.Shuffle(2);
            dealHands();
        }

    }

    public void dealFlop(){
        if(deck.getCardsNotDealt()>3){
            deck.discardCard();
            for(int i = 0; i<3;i++){
                communityCards[i]=deck.dealCard();
            }
        } else {
            deck.Shuffle(2);
            dealFlop();
        }

    }
    public void dealTurn(){
        if(deck.getCardsNotDealt()>1){
            deck.discardCard();
            communityCards[4]=deck.dealCard();
        } else {
            deck.Shuffle(2);
            dealTurn();
        }
    }
    public void dealRiver(){
        if(deck.getCardsNotDealt()>1){
            deck.discardCard();
            communityCards[5]=deck.dealCard();
        } else {
            deck.Shuffle(2);
            dealFlop(); 
        }
    }

    public void clearCommunityCards(){
        communityCards = new Card[5];
    }

    public String printPlayers(){
        String output = "";
        for (Player p : players){
            output+=p.getName()+"\n";
        }
        return output;
    }
    public static void main(String[] args){
        Game game = Game.getTheInstance();
        game.loadGame();
        System.out.println(game.printPlayers());
    }
}


