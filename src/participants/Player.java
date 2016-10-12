/*
Klassen Player är basklass för HumanPlayer, LocalComputerPlayer och 
RemoteComputerPlayer. Klassen innehåller attributen namn och markör-id samt 
en abstrakt metod för att begära beräkning av nästa drag. 
Namnet sätts i dialogrutan SetUpGameDialog och används i 
WinnerDialog. Markör-id anger om spelaren har vita eller svarta brickor.
 */
package participants;

/**
 *
 * @author optimusprime
 */
public  abstract class Player {
    
    private String name;
    private int markerId;
    /**
     * Jag tänker mig att man ska kanske ge id till spelaren här eller någonstans 
     * genom att ha en statisk int variabel som ökar varje gång en spelare skulle skapas?
     * 
     * YEAH YEAH WHATEVER NICK ☻
     * 
     */
    
    public abstract int[] getMove();
    
}
