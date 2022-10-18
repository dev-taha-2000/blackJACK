import com.sun.jdi.Value;

import java.util.ArrayList;
import java.util.Random;

public class Genarate {
    private ArrayList<Card> cards;

    public Genarate() {
        this.cards = new ArrayList<Card>();
    } 

    public void dmasCarta(){
        ArrayList<Card> generate = new ArrayList<Card>();
        Random random = new Random();
        int cardIndex = 0;
        int cardsSize = this.cards.size();
        for (int i=0;i<cardsSize;i++){
            cardIndex = random.nextInt((this.cards.size()-1-0)+1)+0;
            generate.add(this.cards.get(cardIndex));
            this.cards.remove(cardIndex);
        }
        this.cards=generate;
    }
    public void createCard(){
        for (Coleur cardColeur : Coleur.values()){
            for(Hauteur cardHauteur : Hauteur.values()){
                this.cards.add(new Card(cardColeur,cardHauteur));
            }
        }
    }

    public void movaAll(Genarate move){
        int thisCardSize = this.cards.size();
        for (int i=0;i<thisCardSize;i++){
            move.addCard(this.getCard(i));
        }
        for (int i=0;i<thisCardSize;i++){
            this.removeCard(0); 
        }
    }
    @Override
    public String toString() {
        String cardsOutput = "";
        //int i=0;
        for (Card aCard : this.cards){
            cardsOutput+="\n"+/**i+**/"-"+aCard.toString();
            //i++;
        }
        return cardsOutput;
    }
    public void removeCard(int i){
        this.cards.remove(i);
    }
    public Card getCard(int i){
        return this.cards.get(i);
    }
    public void addCard(Card addCard){
        this.cards.add(addCard);
    }
    public void getCard(Genarate comFrom){
        this.cards.add(comFrom.getCard(0)); 
        comFrom.removeCard(0);
    }
    public int deckSize(){
        return this.cards.size();
    }
    public int getValueOfCards(){
        int totalValue =0;
        int Lace = 0;
        for (Card acard : this.cards) {
            switch (acard.getValue()){
                case DEUX:
                    totalValue += 2;
                    break;
                case trois:
                    totalValue += 3;
                    break;
                case quatre:
                    totalValue += 4;
                    break;
                case cinq:
                    totalValue += 5;
                    break;
                case six:
                    totalValue += 6;
                    break;
                case sept:
                    totalValue += 7;
                    break;
                case huit:
                    totalValue += 8;
                    break;
                case neuf:
                    totalValue += 9;
                    break;
                case dix:
                    totalValue += 10;
                    break;
                case dame:
                    totalValue += 10;
                    break;
                case valet:
                    totalValue += 10;
                    break;
                case roi:
                    totalValue += 8;
                    break;
                case LAS:
                    Lace += 1;
                    break;
            }
        }
        for (int i=0;i<Lace;i++){
            if(totalValue>10){
                totalValue+=1;
            }else {
                totalValue+=11;
            }
        }

        return totalValue;
    }
}
