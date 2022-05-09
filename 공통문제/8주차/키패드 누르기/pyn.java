import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        
        boolean isRight = hand.equals("right");
        
        int leftHand = 10;
        int rightHand = 12;
        
        for(int num : numbers) {
            if(num == 0)
                num = 11;
            
            int remainder = num % 3;
            
            if(remainder == 0) {
                rightHand = num;
                answer.append("R");
            } else if(remainder == 1) {
                leftHand = num;
                answer.append("L");
            } else if(remainder == 2) {
                int leftDistance = calcDistance(leftHand, num);
                int rightDistance = calcDistance(rightHand, num);
                
                if(leftDistance > rightDistance){
                    answer.append("R");
                    rightHand = num;
                    continue;
                }
                else if(leftDistance < rightDistance) {
                    answer.append("L");
                    leftHand = num;
                    continue;
                }
                
                if(isRight){
                    answer.append("R");
                    rightHand = num;
                } else {
                    answer.append("L");
                    leftHand = num;
                }
            }
            
        }
        
        return answer.toString();
    }
    
    public int calcDistance(int from, int dst) {
        if(from == dst)
            return 0;
   
        int gap = 0;
        
        if(from > dst)
            gap = from - dst;
        else
            gap = dst - from;

        if(gap == 1 || gap == 3)
            return 1;
        
        return (gap / 3) + (gap % 3);
    
    }
}