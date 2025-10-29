package DSA.Graphs.Medium;

public class SurroundedRegions {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        for(int i=0; i<cols; i++){
            if(board[0][i]=='O'){
                dfs(board,0,i);
            }
            if(board[rows-1][i]=='O'){
                dfs(board,rows-1,i);
            }
        }
        for(int i=0; i<rows; i++){
            if(board[i][0]=='O'){
                dfs(board,i,0);
            }
            if(board[i][cols-1]=='O'){
                dfs(board,i,cols-1);
            }
        }
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(board[i][j]=='O'){
                    board[i][j] = 'X';
                }else if(board[i][j]=='T'){
                    board[i][j]='O';
                }
            }
        }
    }
    public void dfs(char[][] board, int st, int ed){
        if(st<0 || ed<0 || st>=board.length || ed>=board[0].length){
            return;
        }
        if(board[st][ed]!='O'){
            return;
        }
        board[st][ed] = 'T';
        dfs(board,st+1,ed);
        dfs(board,st-1,ed);
        dfs(board,st,ed+1);
        dfs(board,st,ed-1);
    }
}
