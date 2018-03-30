import java.awt.event.KeyListener;

public class CellKeyListener implements KeyListener{
    private final Sudoku grid;
    CellKeyListener(Sudoku grid){
        this.grid=grid;
    }

}
