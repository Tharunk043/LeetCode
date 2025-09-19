import java.util.*;

class Spreadsheet {
    private int rows;
    private int[][] grid; // rows x 26

    public Spreadsheet(int rows) {
        this.rows = rows;
        this.grid = new int[rows][26]; // all initialized to 0 by default
    }
    
    // Convert "A1" -> row=0, col=0
    private int[] parseCell(String cell) {
        char colChar = cell.charAt(0);
        int col = colChar - 'A';
        int row = Integer.parseInt(cell.substring(1)) - 1; // 1-indexed to 0-indexed
        return new int[]{row, col};
    }

    public void setCell(String cell, int value) {
        int[] pos = parseCell(cell);
        grid[pos[0]][pos[1]] = value;
    }
    
    public void resetCell(String cell) {
        int[] pos = parseCell(cell);
        grid[pos[0]][pos[1]] = 0;
    }
    
    public int getValue(String formula) {
        // formula always of the form "=X+Y"
        formula = formula.substring(1); // remove '='
        String[] parts = formula.split("\\+");
        
        return eval(parts[0].trim()) + eval(parts[1].trim());
    }

    private int eval(String token) {
        // if it's a number
        if (token.matches("\\d+")) {
            return Integer.parseInt(token);
        }
        // else it's a cell reference
        int[] pos = parseCell(token);
        return grid[pos[0]][pos[1]];
    }
}
