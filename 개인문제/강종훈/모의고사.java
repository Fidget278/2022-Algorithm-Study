import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] answers) {
        int[] s1 = {1,2,3,4,5}; //5
        int[] s2 = {2,1,2,3,2,4,2,5}; //8
        int[] s3 = {3,3,1,1,2,2,4,4,5,5}; //10
        int a=0, b=0, c=0;
        for(int i=0; i<answers.length; i++){
            if(answers[i]==s1[i%5])
                a++;
            if(answers[i]==s2[i%8])
                b++;
            if(answers[i]==s3[i%10])
                c++;
        }
        int max = Math.max(Math.max(a, b), c);
        
        List<Integer> list = new ArrayList<>();
        if(max==a) list.add(1);
        if(max==b) list.add(2);
        if(max==c) list.add(3);
        
        int[] arr = new int[list.size()];
        for(int i=0; i<arr.length; i++)
            arr[i] = list.get(i);
        
        return arr;
    }
}