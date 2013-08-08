package SodokuSolver;

public class Solution { 
    public boolean isValid(int value,int row,int col,char[][] board){
        boolean res = true;
        for(int i=0;i<9;i++){
            //check row
            if(Character.getNumericValue(board[row][i])==value){
                res = false;
                break;
            }
            //check col
            if(Character.getNumericValue(board[i][col])==value){
                res = false;
                break;
            }
            //check square
            int row_s = 3*(int)(row/3) + (int)(i/3);
            int col_s = 3*(int)(col/3) + i%3;
            if(Character.getNumericValue(board[row_s][col_s])==value){
                res = false;
                break;
            }
        }
        return res;       
    }
    
    public boolean DFS(ArrayList<int[]> empty,char[][] board,int i,int len){
        int[] index = empty.get(i);
        int row = index[0];
        int col = index[1];
        boolean res=false;
        for(int v = 1;v<=9;v++){
            if(isValid(v,row,col,board)){
                //System.out.print("("+row+","+col+")->"+v+"|");
                board[row][col] = (char) (v+'0');
                if(i<len-1){
                    res = DFS(empty,board,i+1,len);
                    if(res)
                        break;   
                    else
                    	board[row][col] = '.';
                }
                else{	// the last one
                    res = true;
                    break;
                }
            } 
        }
        return res;
        
    }
    
    public void solveSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        //scan board for empty spot
        ArrayList<int[]> empty = new ArrayList<int[]>();
        for(int row = 0;row<9;row++)
            for(int col = 0;col<9;col++)
                if(board[row][col]=='.'){
                	int [] tmp = {row,col};
                    empty.add(tmp);
                    }
        
        int len = empty.size();
        DFS(empty,board,0,len);
        
        return;
        
    }
}
