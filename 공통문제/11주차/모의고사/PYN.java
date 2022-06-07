import java.util.*;

class Solution {
    public List<Integer> solution(int[] answers) {
        List<Integer> answer = new ArrayList<Integer>();
        
        int[] supo1 = {1, 2, 3, 4, 5};
        int[] supo2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] supo3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int supo1Index = supo1.length, supo2Index = supo2.length, supo3Index = supo3.length;
        int[] scores = {0, 0, 0};
        
        for(int i = 0; i < answers.length; ++i) {
            if(answers[i] == supo1[i%supo1Index])
                ++scores[0];
            if(answers[i] == supo2[i%supo2Index])
                ++scores[1];
            if(answers[i] == supo3[i%supo3Index])
                ++scores[2];
        }
            
        int max = scores[0];
        for(int i = 1; i < 3; ++i)
            if(max < scores[i])
                max = scores[i];
        
        for(int i = 0; i < 3; ++i){
            if(max <= scores[i])
                answer.add(i+1);
        }
        
        
        return answer;
    }
}