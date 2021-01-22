import java.util.HashMap;
import java.util.Map;

public class PokerHand {
    //field variables
    //we'll "compose" a poker hand from multiple sub-objects that we pull into a collection
    private Card[] cards;

    //need a constructor to make sure every hand is built with all the cards needed
    public PokerHand( Card[] cards ) {
        //for now we'll cross our fingers and hope its always 5
//        if( cards.length < 5 ){
//            //TODO: create a specific exception for this
//            throw new Exception("Invalid number of cards.");
//        }


        this.cards = cards;

        sortCards();
    }

    private void sortCards() {

        //bubble sort
        boolean sorted = false;

        while( !sorted ){

            sorted = true;
            for( int i = 0; i < cards.length - 1; i++){
                //does the element at i need to be flipped with the element at i + 1?
                if( (cards[i].getCardValue().value < cards[i+1].getCardValue().value) ||

                        (cards[i].getCardValue().value == cards[i+1].getCardValue().value
                        && cards[i].getCardSuit().value < cards[i+1].getCardSuit().value
                        )
                ){
                    //we need to swap elements at i and i + 1
                    //it also means we found elements out of order
                    sorted = false;
                    Card temp = cards[i+1];
                    cards[i+1] = cards[i];
                    cards[i] = temp;
                }
            }

        }

    }

    public Card[] getCards(){
        return cards;
    }

    public Map<FaceValue, Integer> countFaceValues(){

        Map<FaceValue, Integer> count = new HashMap<>();

        for( Card toCount : cards ){
            if( !count.containsKey(toCount.getCardValue())){
                count.put(toCount.getCardValue(), 0);
            }

            Integer currentCount = count.get(toCount.getCardValue());

            count.put( toCount.getCardValue(),
                    1 + currentCount );

        }

        return count;
    }

    public Map<Suit, Integer> countSuits(){

        Map<Suit, Integer> count = new HashMap<>();

        for( Card toCount : cards ){
            if( !count.containsKey(toCount.getCardSuit())){
                count.put(toCount.getCardSuit(), 0);
            }

            Integer currentCount = count.get(toCount.getCardSuit());

            count.put( toCount.getCardSuit(),
                    1 + currentCount );

        }

        return count;
    }


    //if no straight, return a null
    public FaceValue straightHighCardValue(){
        Map<FaceValue, Integer> straFlush = countFaceValues();
        int start = this.cards[0].getCardValue().value;
        for(int i = start; i > start-5; i--)
            if (straFlush.keySet().contains(i)) {
            } else {
                return null;
            }
        return null;
    }

    public boolean isFlush(){
        return countSuits().keySet().size() == 1;
    }

    public boolean isStraightFlush(){

        if(isFlush() && straightHighCardValue() != null){
            return true;
        }
       return false;
    }

    public boolean isFullHouse(){
        return pairValue() != null && threeOfAKindValue() != null;
    }

    public boolean isRoyalFlush(){
        return isStraightFlush() && cards[0].getCardValue() == FaceValue.ACE;
    }

    //if not 4 of a kind, return null
    public FaceValue fourOfAKindValue(){
        Map<FaceValue, Integer> face = countFaceValues();
        if(face.keySet().size() == 2){
            for( FaceValue key : face.keySet() ){
                if(key.value == 4){
                    return key;
                }
            }
        }
        return null;
    }

    //should return null if there are really 4
    public FaceValue threeOfAKindValue(){
        Map<FaceValue, Integer> face = countFaceValues();
        if(face.keySet().size() == 3){
            for( FaceValue key : face.keySet() ){
                if(key.value == 3){
                    return key;
                }
            }
        }
        return null;
    }

    //should return null if there are really 3 (or more of the same card)
    public FaceValue pairValue(){
        Map<FaceValue, Integer> face = countFaceValues();
        if(face.keySet().size() == 4){
            for( FaceValue key : face.keySet() ){
                if(key.value == 2){
                    return key;
                }
            }
        }
        return null;
    }

    //should return null when there is only one pair
    public FaceValue lowerPairValue(){
        if(pairValue() != null){
            return null;
        }
        return null;
    }




    //return 0 if "this" ties with "that"
    //return negative number if "this" wins over "that"
    //return positive number if "this" loses to "that"
    public int compareTo( PokerHand that ){
        int player = 0;
        if(this.isRoyalFlush()){
            player = 10;
        }
        else if(this.isStraightFlush()){
            player = 9;
        }
        else if(this.fourOfAKindValue() != null){
            player = 8;
        }
        else if(this.isFullHouse()){
            player = 7;
        }
        else if(this.isFlush()){
            player = 6;
        }
        else if(this.straightHighCardValue()!= null){
            player = 5;
        }
        else if(this.threeOfAKindValue() != null){
            player = 4;
        }
        else if(this.pairValue()!= null){
            player = 3;
        }
        return 0;    //for now
    }

    //in general compareTo() sematics are
    // - means "this before that"
    // 0 means "they're equal"
    // + means "that before this"




}
