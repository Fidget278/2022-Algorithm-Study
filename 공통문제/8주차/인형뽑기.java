import java.util.ArrayList;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        ArrayList<Integer> bucket = new ArrayList<Integer>();
        
      
        for(int i = 0; i < moves.length; ++i) {
            int row = moves[i]-1;
            for(int j = 0; j < board[row].length; ++j){
                if(board[j][row] != 0){
                    if(bucket.size() == 0 || bucket.get(bucket.size()-1) != board[j][row])
                        bucket.add(board[j][row]);
                    else {
                        bucket.remove(bucket.size()-1);
                        answer+=2;
                    }
                
                    board[j][row] = 0;
                    
                    break;
                }
                
            }
        }
        
        return answer;
    }
}