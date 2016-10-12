/*
Då nästa drag begärs från GameManager väntar man tills användaren utfört draget.
 */
package participants;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

/**
 *
 * @author Grupp 4
 * 
 */

public class HumanPlayer extends Player {
    
    public void mouseChipDisplay(GridPane reversi, StackPane stackPane) {
        
        stackPane.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent me) {
                
                int pointY = reversi.getRowIndex(stackPane);
                int pointX = reversi.getColumnIndex(stackPane);                               
            }
        });
    } 
    
       public void highLightSquare(GridPane gridPane, StackPane stackPane) {
           
           int pX = gridPane.getRowIndex(stackPane);
           int pY = gridPane.getColumnIndex(stackPane);
           
       stackPane.setOnMouseEntered(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent me) {               
               
                /* DO NICE STUFF... */
            }
        });
        
        stackPane.setOnMouseExited(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent me) {
                
                /* DO NICE STUFF TOO... */
            }
        });
    }
}
