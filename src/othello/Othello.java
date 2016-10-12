/*
Othello är spelets huvudklass och (eftersom spelet är en JaxaFX applikation) 
ärver från javafx.application.Application.
 */
package othello;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author Group 4
 * 
 */
public class Othello extends Application{
    
    public void start(Stage primaryStage) {
      
        GameBoard board = new GameBoard();
        board.initBoard(primaryStage);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Application.launch(args);
    }
    
}
