/*
GameBoard kan t.ex. vara av typen javafx.scene.layout.Pane och utgör den grafiska
representationen av spelplanen och används för att presentera den aktuella ställningen.
GameBoard fångar dessutom upp användarens (HumanPlayer) val av ruta då denne gör ett drag.
Observera att trots att gränssnittsobjekten ritar spelplanen och brickorna i den,
så är det inte deras uppgift att hålla reda på den aktuella ställningen. När 
spelplanen skall ritas om hämtas all information från GameGriden.
 */
package othello.interfaces;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author Grupp 4
 * 
 */

public class GameBoard extends Application {
    
    final int player1 = 1;
    final int player2 = 2;
    final int numSqr = 8;
    private StackPane square;

    GameManager acc2GM = new GameManager();
    DrawChip chip = new DrawChip();

    public void initBoard(Stage primaryStage) {
      
        GridPane board = new GridPane();
        
        /* Here we get access to the functions for displaying chips in GM */

        for (int row = 0; row < numSqr; row++) {
            for (int col = 0; col < numSqr; col++) {

                square = new StackPane();
                String color;

                if ((row + col) % 2 == 0) {
                    color = "FORESTGREEN";
                } else {
                    color = "GREEN";
                }
                square.setStyle("-fx-background-color: " + color + ";");
                board.add(chip.fixBoardSize(), col, row);
                board.add(square, col, row);
                
                acc2GM.highLightSquare(board, square);
                acc2GM.mouseChipDisplay(board, square);
                
                /* 
                * Here are displayed and set to busy as well the two white and
                * the two black chips typical in the onset of the game 
                */
                board.add(chip.drawBlackChip(), 4, 3);
                acc2GM.acc2Model.setBlackNodeToBusy(4, 3);
                board.add(chip.drawBlackChip(), 3, 4);
                acc2GM.acc2Model.setBlackNodeToBusy(3, 4);
                board.add(chip.drawWhiteChip(), 3, 3);
                acc2GM.acc2Model.setWhiteNodeToBusy(3, 3);
                board.add(chip.drawWhiteChip(), 4, 4);
                acc2GM.acc2Model.setWhiteNodeToBusy(4, 4);                
            }
        }

        for (int i = 0; i < numSqr; i++) {

            board.getColumnConstraints().add(new ColumnConstraints(10, Control.USE_COMPUTED_SIZE, Double.POSITIVE_INFINITY, Priority.ALWAYS, HPos.CENTER, true));
            board.getRowConstraints().add(new RowConstraints(10, Control.USE_COMPUTED_SIZE, Double.POSITIVE_INFINITY, Priority.ALWAYS, VPos.CENTER, true));
        }

        Scene scene = new Scene(board, 400, 400);
        primaryStage.setTitle("Othello - Grupp 4");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void start(Stage primaryStage) {
        
        initBoard(primaryStage);
    }    
    
    /* Class for drawing chips and shit and handling them */
    static class DrawChip{

        public StackPane drawBlackChip() {

            StackPane chip = new StackPane();
            Circle bChip = new Circle(30, 30, 15);
            
            bChip.setStroke(Color.WHITE);
            bChip.setFill(Color.BLACK);
            
            chip.getChildren().add(bChip);

            return chip;
        }

        public StackPane drawWhiteChip() {

            StackPane chip = new StackPane();
            Circle wChip = new Circle(30, 30, 15);
            
            wChip.setStroke(Color.BLACK);
            wChip.setFill(Color.WHITE);
            
            chip.getChildren().add(wChip);

            return chip;
        }
        
        public StackPane highLightSqr(){
            
            StackPane highSqr = new StackPane();
            highSqr.setStyle("-fx-border-color: " + "BLUE" + ";");
            
            return highSqr;
        }
        
        public Circle fixBoardSize() {

            Circle fixSize;
            fixSize = new Circle(40, 40, 20);

            return fixSize;
        }

        /* This method shows a node's info */
        public Node getNode(final int row, final int column, GridPane gridPane) {

            Node result = null;

            ObservableList <Node> children = gridPane.getChildren();

            for (Node node : children) {

                if (gridPane.getRowIndex(node) == row && gridPane.getColumnIndex(node) == column) {
                    result = node;
                    break;
                }
            }
            return result;
        }   
    }    
}
