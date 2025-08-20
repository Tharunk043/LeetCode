class Solution {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int row = 0;
        int col = 0;
        
        for (String command : commands) {
            switch (command) {
                case "UP":
                    row = Math.max(0, row - 1);
                    break;
                case "DOWN":
                    row = Math.min(n - 1, row + 1);
                    break;
                case "LEFT":
                    col = Math.max(0, col - 1);
                    break;
                case "RIGHT":
                    col = Math.min(n - 1, col + 1);
                    break;
            }
        }
        
        return row * n + col;
    }
}