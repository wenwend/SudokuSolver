import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import javax.swing.border.Border;
import java.util.Scanner;

public class Sudoku extends JPanel{
    private static final int GRID_SIZE;
    //public static final int SURGRID_SIZE = 3;

    //public static final int CELL_SIZE = 100; //pixels
    //public static final int CANVAS_WIDTH = CELL_SIZE * GRID_SIZE;
    //public static final int CANVAS_HEIGHT = CELL_SIZE * GRID_SIZE;

    /* some color variable
    public static final Color OPEN_CELL_BGCOLOR = Color.yellow;
    public static final Color OPEN_CELL_TEXT_YES = Color.blue;
    public static final Color OPEN_CELL_TEXT_NO = Color.red;
    public static final Color CLOSED_CELL_BGCOLOR = Color.lightGray;
    public static final Color CLOSED_CELL_TEXT = Color.black;
    */
    public static final Font FONT = new Font("Verdana",Font.BOLD,20);

    private JTextField[][] grid;
    private Map<JTextField,Point> mapFieldToCoordinate = new HashMap<>();
    private final JPanel gridPanel;
    private final JPanel buttonPanel;
    private final JPanel solveButton;
    private final JPanel clearButton;
    private final JPanel[][] subPanels;

    public Sudoku(int size) {
        this.GRID_SIZE = size;
        this.grid = new JTextField[GRID_SIZE][GRID_SIZE];

        for(int y=0;y<GRID_SIZE;y++){
            for(int x=0;x<GRID_SIZE;x++){
                JTextField field=new JTextField();
                field.addKeyListener(new CellKeyListener(this));
                mapFieldToCoordinate.put(field,new Point(x,y));
                grid[y][x]=field;
            }
        }

        this.gridPanel=new Panel();
        this.buttonPanel=new Panel();

        Border border = BorderFactory.createLineBorder(Color.lightGray,1);
        Dimension fieldDimension = new Dimension(20,20);

        for(int y=0;y<GRID_SIZE;y++){
            for(int x=0;x<GRID_SIZE;x++){
                JTextField field = grid[y][x];
                field.setBorder(border);
                field.setFont(FONT);
                field.setPreferredSize(fieldDimension);
            }
        }

        int subGridDimension = (int) Math.sqrt(GRID_SIZE);
        this.gridPanel.setLayout(new GridLayout(subGridDimension, subGridDimension));
        this.subPanels = new JPanel[subGridDimension][subGridDimension];

        Border subGridBorder = BorderFactory.createLineBorder(Color.darkGray,1);

        for(int y=0;y<subGridDimension;y++){
            for(int x=0;x<subGridDimension;x++){
                JPanel panel = new JPanel();
                panel.setLayout(new GridLayout(subGridDimension,subGridDimension));
                panel.setBorder(subGridBorder);
                subPanels[y][x]=panel;
                gridPanel.add(panel);
            }
        }

        for(int y=0;y<GRID_SIZE;y++){
            for(int x=0;x<GRID_SIZE;x++){
                int subX=x/subGridDimension;
                int subY=y/subGridDimension;
                subPanels[subY][subX].add(grid[y][x]);
            }
        }

        this.gridPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        this.clearButton=new JButton("Clear");
        this.solveButton=new JButton("Solve");

        this.buttonPanel.setLayout(new BorderLayout());
        this.buttonPanel.add(clearButton,BorderLayout.WEST);
        this.buttonPanel.add(solveButton,BorderLayout.EAST);

        this.setLayout(new BorderLayout());
        this.add(gridPanel,BorderLayout.NORTH);
        this.add(buttonPanel,BorderLayout.SOUTH);

        //add functions point to the clear button
        clearButton.addActionListener((ActionEvent e)->{
            clearAll();
        });
        //add functions points to the solvo button
        solveButton.addActionListener((ActionEvent e)->{
            solve();
        });
    }
    void clearAll(){
        for(JTextField[] row : grid){
            for(JTextField[] field : row) {
                    field.setText("");
                }
            }
    }
    void solve(){

        Sudoku sudoku = new Sudoku(dimension);


    }
}

