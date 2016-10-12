/*
GameManager är den som administrerar pågående parti. GameManagerns uppgift är enkel.
Den skall gång på gång, omväxlande, be de två spelarna att ange sitt nästa drag. 
Den skall också tala om för spelarna om de vunnit eller gjort ett felaktigt drag.
Eftersom GameManagern inte skall veta vilken typ av spelare den har att göra 
med skall dynamisk bindning användas vid anrop av spelarnas operationer.
 */
package othello;

/**
 *
 * @author Grupp 4
 */
public class GameManager {
    
    /* With modulus by now... cool the fuck down Nick ☻ 
    *
    * I'M JUST SPLITTING... I DON'T EVEN KNOW IF THIS SHIT WORKS...
    *
    */
    
    private int count = 0;
    private int turn = count % 2 + 1;
    final int player1 = 1;
    final int player2 = 2;
    
    public int playerTurn(int player){
        
    if (turn == player2) {     
        count++;
    }           
    else if(turn == player2){
        count++;
    }
     return turn;   
    }    
}
