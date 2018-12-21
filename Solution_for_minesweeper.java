public class Solution_for_minesweeper {
    public char[][] updateBoard(char[][] board, int[] click) {
        return update(board,click[0],click[1]);
    }

    private char[][] update(char[][] board, int x, int y) {
        if(board[x][y] == 'M'){
            board[x][y] = 'X';
        }
        else if(board[x][y] == 'E'){
            int count = 0;
            for (int i = x-1;i<=x+1;i++){
                for (int j = y-1;j<=y+1;y++){
                    if(i<board.length && i>=0 && j<board[0].length && 0<=j && board[i][j] == 'M'){
                        count++;
                    }
                }
            }
            if(count == 0){
                board[x][y] = 'B';
                for(int i = x-1; i <= x+1; i++){
                    for(int j = y-1; j <= y+1; j++){
                        if(i < board.length && 0 <= i && j < board[0].length && 0 <= j){
                            if(board[i][j] == 'E')
                                update(board, i, j);
                        }
                    }
                }
            }
            else{
                board[x][y] = (char)('0' + count);
            }
        }
        return board;
    }
}
