/*
GameGrid är den klass som innehåller partiets tillstånd (exempelvis en matris).
När en spelare utför ett drag kommer detta att registreras i GameGriden. 
Då GameBoard ritar om spelplanen hämtas informationen om partiets aktuella 
ställning från denna klass.
Er uppgift blir nu att konstruera och testa dessa klasser. Ett spel avslutas 
när hela spelplanen är fylld med brickor eller när ingen av spelarna kan 
utföra ett drag. I båda fallen är det spelaren med mest brickor i sin egen
färg som har vunnit.
 */
package othello;

/**
 * @author Grupp 4
 */
public class GameGrid {
    
    final int player1 = 1;
    final int player2 = 2;
    final int matrixSize = 8;
    
    /*
    * Adjacency matrix to hold the status of the nodes in the grid
    */
    int[][] status = new int[matrixSize][matrixSize];

    void populateMatrix() {

        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {

                status[i][j] = 0;
            }
        }
    }
    /*
    * Simple functions to add, remove and check if a node is bussy or not
    */
    void setBlackNodeToBusy(int i, int j) {
        status[i][j] = this.player2;
    }

    void setWhiteNodeToBusy(int i, int j) {
        status[i][j] = this.player1;
    }

    void setNodeToFree(int i, int j) {
        status[i][j] = 0;
    }

    int getNodeStatus(int i, int j) {
        return status[i][j];
    }
    
    protected boolean isLegalMove(int player, int x, int y){
        
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                
                if (isL(player, x+i, y+j, i, j))
                    
                    return true;
            }
        }
        return false;
    }
    private boolean isL(int colour, int x, int y, int xChange, int yChange){
        
        if ((x >= matrixSize) || (y >= matrixSize) || (x < 0) || (y < 0))
            return false;
        if (status[x][y] == 0)
            return false;
        if ((status[x][y] == colour)){
            if (status[x-xChange][y-yChange] != 0)
                return true;
            else return false;
        }  
        return (isL(colour, x+xChange, y+yChange, xChange, yChange));
    }    
}
