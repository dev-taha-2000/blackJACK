import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("==================welcome to blackJack!==========================");
        Genarate palaying = new Genarate(); 
        palaying.createCard();
        palaying.dmasCarta();
        Genarate player = new Genarate();
        Genarate dealer = new Genarate();
        double playerMoney = 1000;
        Scanner userinput = new Scanner(System.in);
        while (playerMoney > 0){
            System.out.println("you have"+playerMoney+"£"+",how much would you like to bet?");
            double playerMoney2 = userinput.nextDouble();
            if(playerMoney2>playerMoney){
                System.out.println("=========================fin awa radi================================");
                break;
            }
            boolean finishRound = false;
             player.getCard(palaying);
             player.getCard(palaying);
             dealer.getCard(palaying);
             dealer.getCard(palaying);
             while (true){
                 System.out.println("ta main:");
                 System.out.println(player.toString());
                 System.out.println("les valeur de cartes de player : "+player.getValueOfCards());
                 System.out.println("les  cates de dealer  : "+dealer.getCard(0).toString()+"\n"+"{hidden}");
                 System.out.println("================== Hit:1 or  stand:2 ================================");
                 int reponce = userinput.nextInt();
                 if(reponce==1){
                     player.getCard(palaying);
                     System.out.println("carts of player:"+player.getCard(player.deckSize()-1).toString());
                     if(player.getValueOfCards()>21){
                         System.out.println("============radi fi khsran a hmadi=================");
                         System.out.println("player value"+player.getValueOfCards()+">"+"dealer value"+dealer.getValueOfCards());

                     }
                 }
                 if (reponce==2){
                     break;
                 }
             }
             //découvert sur les cartes de dealer
             System.out.println("Dealer cartes: "+dealer.toString());
             if((dealer.getValueOfCards()>player.getValueOfCards())&& finishRound==false){
                 System.out.println("================================ khsrti a hmadi =======================================");
                 playerMoney-=playerMoney2;
                 finishRound = true;
             }
             while ((dealer.getValueOfCards()<17)&&finishRound==false){
                 dealer.getCard(palaying);
                 System.out.println("Dealer cards: "+dealer.getCard(dealer.deckSize()-1).toString());
             }
             // afficher total valeur de dealer
             System.out.println("total valeur de dealer"+dealer.getValueOfCards());
             //check who is stuped
             if((dealer.getValueOfCards()>21)&& finishRound==false){
                 System.out.println("===================================== dealer bustes! you win ======================================");
                 playerMoney+=playerMoney2;
                 finishRound=true;
             }
             //check if egale
             if((player.getValueOfCards()==dealer.getValueOfCards())&&finishRound==false){
                 System.out.println("=========================egale===============================");
                 finishRound=true;
             }
             if ((player.getValueOfCards()>dealer.getValueOfCards())&& finishRound==false){
                 System.out.println("===================== you win =====================================");
                 playerMoney+=playerMoney2;
                 finishRound=true;
             }else if(finishRound==false){
                 System.out.println("===================tu perds la main======================================");
                 playerMoney-=playerMoney2;
                 finishRound=true;
             }
             player.movaAll(palaying);
             dealer.movaAll(palaying);
             System.out.println("================================main vide======================================");
        }
        System.out.println("==========================machaaaaaaaaw lflisat========================================");








    }
}