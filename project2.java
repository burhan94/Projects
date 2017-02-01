import java.util.Random;

final class Card{

//  RANK NAME. Printable names of card suits. We don't use the name at index 0,
//  because no card has rank 0.

  private static final String [] rankName =
   { "",
     "ace",      //  1
     "two",      //  2
     "three",    //  3
     "four",     //  4
     "five",     //  5
     "six",      //  6
     "seven",    //  7
     "eight",    //  8
     "nine",     //  9
     "ten",      //  10
     "jack",     //  11
     "queen",    //  12
     "king" };   //  13

//  SUIT NAME. Printable names of card suits.

  private static final String [] suitName =
   { "spade",    //  0
     "heart",    //  1
     "diamond",  //  2
     "club" };   //  3

  private int rank;  //  Card rank, between 1 and 13 inclusive.
  private int suit;  //  Card suit, between 0 and 3 inclusive.

//  CARD. Constructor. Make a new CARD with the given RANK and SUIT.

  public Card(int rank, int suit)
  {
    if (0 <= suit && suit <= 3 && 1 <= rank && rank <= 13)
    {
      this.rank = rank;
      this.suit = suit;
    }
    else
    {
      throw new IllegalArgumentException("No such card.");
    }
  }

//  GET RANK. Return the RANK of this card.

  public int getRank()
  {
    return rank;
  }

//  GET SUIT. Return the SUIT of this card.

  public int getSuit()
  {
    return suit;
  }

//  TO STRING. Return a string that describes this card, for printing only. For
//  example, we might return "the queen of diamonds" or "the ace of hearts".

  public String toString()
  {
    return "the " + rankName[rank] + " of " + suitName[suit] + "s";
  }
}//Card class





class Deck{
  private Card[] cards;
  private static final int numcards=52; 
  private Random r;
  private int currentDeal;

  public Deck(){
    int ind=0;
    cards=new Card[numcards];
    for(int i=0;i<4;i++){
      for(int j=1;j<14;j++){
        cards[ind]=new Card(j,i);
        ind++;
      }
    }
    currentDeal=-1;
  }

  public void shuffle(){
    int i, j, k;
    Random r=new Random();
    if(currentDeal>0){
      throw new IllegalStateException("Cannot shuffle after card is dealt");
    }
    for(k=cards.length-1;k>=1;k--){
      i=r.nextInt(numcards);
      j=r.nextInt(numcards);
      Card temp=cards[i];
      cards[i]=cards[j];
      cards[j]=temp;
    }
  }

  public boolean canDeal(){
    return (currentDeal<numcards);
  }

  public Card deal(){
    if(canDeal()){
      currentDeal+=1;
      return (cards[currentDeal]);
    }
    throw new IllegalStateException("Cannot deal card");
  }
}

class Tableau{
  private class Pile{
    private Card card;
    private Pile next;

    private Pile(Card card, Pile next){
      this.card=card;
      this.next=next;
    }
  }
  private Pile head;
  private int count;

  public Tableau(){
    head=new Pile(null,null);
    count=0;
  }

  private void addPile(Card card){ 
    head=new Pile(card,head);
    count+=1;

    System.out.println("Added "+card+". ");
  }

  private boolean canMerge(){
    if(hasManyPiles() && canPutOn(head.card,head.next.card)){
      return true;
    }
    return false;
  }

  private boolean canPutOn(Card left, Card right){
    int rightSuit=right.getSuit();
    int leftSuit=left.getSuit();
    int rightRank=right.getRank();
    int leftRank=left.getRank();

    if(leftSuit==rightSuit || leftRank>rightRank){
      return true;
    }
    return false;
  }

  private boolean hasManyPiles(){
    if(count>=2){
      return true;
    }
    return false;
  }

  private void mergeTwoPiles(){
    if(canMerge() && head!=null){
      Pile temp=head.next;
      head.next=temp.next;
      count--;
      System.out.println("Merged "+(head.card)+" and "+(temp.card));
    }
  }

  public void results(){
    if(count==1){
      System.out.println("You've won the game. ");
    }
    else{
      System.out.println("You've lost the game. ");
    }
  }

  public void play(){
    int ind=0;
    int num=0;
    Deck d=new Deck();
    d.shuffle();
    
    while(ind<52){
      ind++;
      addPile(d.deal());
      num++;
      while(canMerge()){
        mergeTwoPiles();
      }
      
      
      
    }
    results();
  }

}









class project2{
  public static void main(String [] args){
    Tableau t=new Tableau();
    t.play();
  }
}


*/

Added the nine of spades.                                                                                                                                                                                                                      
Added the eight of hearts.                                                                                                                                                                                                                     
Added the three of spades.                                                                                                                                                                                                                     
Added the queen of spades.                                                                                                                                                                                                                     
Merged the queen of spades and the three of spades                                                                                                                                                                                             
Merged the queen of spades and the eight of hearts                                                                                                                                                                                             
Merged the queen of spades and the nine of spades                                                                                                                                                                                              
Added the king of spades.                                                                                                                                                                                                                      
Merged the king of spades and the queen of spades                                                                                                                                                                                              
Added the queen of clubs.                                                                                                                                                                                                                      
Added the jack of clubs.                                                                                                                                                                                                                       
Merged the jack of clubs and the queen of clubs  
Added the eight of spades.                                                                                                                                                                                                                     
Added the ace of hearts.                                                                                                                                                                                                                       
Added the king of diamonds.                                                                                                                                                                                                                    
Merged the king of diamonds and the ace of hearts                                                                                                                                                                                              
Merged the king of diamonds and the eight of spades                                                                                                                                                                                            
Merged the king of diamonds and the jack of clubs                                                                                                                                                                                              
Added the jack of spades.                                                                                                                                                                                                                      
Added the ace of clubs.                                                                                                                                                                                                                        
Added the ten of diamonds.                                                                                                                                                                                                                     
Merged the ten of diamonds and the ace of clubs                                                                                                                                                                                                
Added the two of hearts.                                                                                                                                                                                                                       
Added the six of hearts.                                                                                                                                                                                                                       
Merged the six of hearts and the two of hearts                                                                                                                                                                                                 
Added the five of diamonds.                                                                                                                                                                                                                    
Added the six of diamonds.                                                                                                                                                                                                                     
Merged the six of diamonds and the five of diamonds                                                                                                                                                                                            
Added the five of hearts.                                                                                                                                                                                                                      
Added the ten of hearts.                                                                                                                                                                                                                       
Merged the ten of hearts and the five of hearts                                                                                                                                                                                                
Merged the ten of hearts and the six of diamonds                                                                                                                                                                                               
Merged the ten of hearts and the six of hearts                                                                                                                                                                                                 
Added the queen of hearts.                                                                                                                                                                                                                     
Merged the queen of hearts and the ten of hearts                                                                                                                                                                                               
Merged the queen of hearts and the ten of diamonds                                                                                                                                                                                             
Merged the queen of hearts and the jack of spades                                                                                                                                                                                              
Added the four of diamonds.                                                                                                                                                                                                                    
Added the five of clubs.                                                                                                                                                                                                                       
Merged the five of clubs and the four of diamonds                                                                                                                                                                                              
Added the ace of spades.                                                                                                                                                                                                                       
Added the nine of clubs.                                                                                                                                                                                                                       
Merged the nine of clubs and the ace of spades                                                                                                                                                                                                 
Merged the nine of clubs and the five of clubs                                                                                                                                                                                                 
Added the three of clubs.                                                                                                                                                                                                                      
Merged the three of clubs and the nine of clubs                                                                                                                                                                                                
Added the five of spades.                                                                                                                                                                                                                      
Merged the five of spades and the three of clubs                                                                                                                                                                                               
Added the seven of hearts.                                                                                                                                                                                                                     
Merged the seven of hearts and the five of spades                                                                                                                                                                                              
Merged the seven of hearts and the queen of hearts                                                                                                                                                                                             
Added the eight of clubs.                                                                                                                                                                                                                      
Merged the eight of clubs and the seven of hearts                                                                                                                                                                                              
Added the three of diamonds.                                                                                                                                                                                                                   
Added the seven of diamonds.                                                                                                                                                                                                                   
Merged the seven of diamonds and the three of diamonds                                                                                                                                                                                         
Added the nine of diamonds.
Merged the nine of diamonds and the seven of diamonds                                                                                                                                                                                          
Merged the nine of diamonds and the eight of clubs                                                                                                                                                                                             
Merged the nine of diamonds and the king of diamonds                                                                                                                                                                                           
Added the four of hearts.                                                                                                                                                                                                                      
Added the ten of clubs.                                                                                                                                                                                                                        
Merged the ten of clubs and the four of hearts                                                                                                                                                                                                 
Merged the ten of clubs and the nine of diamonds                                                                                                                                                                                               
Added the seven of spades.                                                                                                                                                                                                                     
Added the four of spades.                                                                                                                                                                                                                      
Merged the four of spades and the seven of spades                                                                                                                                                                                              
Added the king of clubs.                                                                                                                                                                                                                       
Merged the king of clubs and the four of spades                                                                                                                                                                                                
Merged the king of clubs and the ten of clubs                                                                                                                                                                                                  
Added the ace of diamonds.                                                                                                                                                                                                                     
Added the queen of diamonds.                                                                                                                                                                                                                   
Merged the queen of diamonds and the ace of diamonds                                                                                                                                                                                           
Added the two of spades.                                                                                                                                                                                                                       
Added the nine of hearts.                                                                                                                                                                                                                      
Merged the nine of hearts and the two of spades                                                                                                                                                                                                
Added the six of spades.                                                                                                                                                                                                                       
Added the three of hearts.                                                                                                                                                                                                                     
Added the four of clubs.                                                                                                                                                                                                                       
Merged the four of clubs and the three of hearts                                                                                                                                                                                               
Added the jack of diamonds.                                                                                                                                                                                                                    
Merged the jack of diamonds and the four of clubs                                                                                                                                                                                              
Merged the jack of diamonds and the six of spades                                                                                                                                                                                              
Merged the jack of diamonds and the nine of hearts                                                                                                                                                                                             
Merged the jack of diamonds and the queen of diamonds                                                                                                                                                                                          
Added the ten of spades.                                                                                                                                                                                                                       
Added the seven of clubs.                                                                                                                                                                                                                      
Added the six of clubs.                                                                                                                                                                                                                        
Merged the six of clubs and the seven of clubs                                                                                                                                                                                                 
Added the jack of hearts.                                                                                                                                                                                                                      
Merged the jack of hearts and the six of clubs                                                                                                                                                                                                 
Merged the jack of hearts and the ten of spades                                                                                                                                                                                                
Added the two of diamonds.                                                                                                                                                                                                                     
Added the two of clubs.                                                                                                                                                                                                                        
Added the eight of diamonds.                                                                                                                                                                                                                   
Merged the eight of diamonds and the two of clubs                                                                                                                                                                                              
Merged the eight of diamonds and the two of diamonds                                                                                                                                                                                           
Added the king of hearts.                                                                                                                                                                                                                      
Merged the king of hearts and the eight of diamonds                                                                                                                                                                                            
Merged the king of hearts and the jack of hearts                                                                                                                                                                                               
Merged the king of hearts and the jack of diamonds                                                                                                                                                                                             
You've lost the game.
*/
