//Jose Rodriguez
//Java 1
//start the class
public class CardGame{
    public static final int NUMCARDS = 52;
    public int[] cardLoc = new int [NUMCARDS];

    //declare the arrays within the deck
    public String[] suitName = {"hearts", "clubs","spades","diamonds"};
    public String[] rankName = {"Ace", "Two", "Three", "Four", "Five", "Six",
                                        "Seven", "Eight", "Nine", "Ten", "Jack",
                                        "Queen", "King"};
    //declare the location
    public String[] location = {"deck", "player", "computer"};

    public final int DECK=0;
    public final int PLAYER=1;
    public final int COMP=2;

    //start main
    public static void main(String[] args){
        new CardGame();
    }//end main

    //initialize a constructor
    public CardGame(){
        for (int i = 0; i < 5; i++){
            assignCard(PLAYER);
            assignCard(COMP);
        }// END FOR LOOP
        showDeck();

        showHand(PLAYER);
        showHand(COMP);

    }//end constructor


    public void showDeck(){
        // go thought cards and prints their location
        for (int cardNum = 0; cardNum < NUMCARDS; cardNum++){
            int loc = cardLoc[cardNum];

            System.out.println(cardNum+ ":  "+ getCardName(cardNum)+": "+ location[loc]);
        } //end for
    } //end showdeck

    //public void

    public String getCardName(int cardNum){
        //figure out the rank and suit
        // return an string(name)

        int suit = (int)(cardNum / 13);
        int rank = cardNum % 13;

        String cardName = rankName[rank] + " of " + suitName[suit];
        return cardName;
    } //end getCardName

    public void assignCard(int hand){
        int cardNum;

        //given a hand (0,1, or 2)
        // pick a random int btw 0 and 51
        //repeat until you can get a card

        boolean Success = true;
        while(Success){

        cardNum = (int)(Math.random() * NUMCARDS);
        if (cardLoc[cardNum] == DECK){

        // change the value of the card at the location to hand
        cardLoc[cardNum] = hand;
        Success = false;
            }
        }
    }//end assignCard

    public void showHand(int hand){
        System.out.println();
        System.out.println(location[hand].toUpperCase() + ": ");
        //given a hand number
        // go through all the cards
        for(int cardNum = 0; cardNum < NUMCARDS; cardNum++){
        //if the current card is in the hand
       if (cardLoc[cardNum] == hand){
            // prints its name
            System.out.println(getCardName(cardNum));
            }//end if
        }//end for
    }//end show

} //end class def