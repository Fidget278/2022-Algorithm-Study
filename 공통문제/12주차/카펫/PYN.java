class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {0, 0};
        int total = brown + yellow;
        int half = total/2;
        int row = 0;
        
        for(int col = 3; col <= half; ++col) {
            
            if(total % col == 0)
                row = total / col;
            else
                continue;
        
            if((row-2) * (col-2) == yellow){
                answer[0] = row;
                answer[1] = col;
                break;
            }
        }
        
        return answer;
    }
}