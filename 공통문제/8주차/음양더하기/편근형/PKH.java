class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        int len = absolutes.length;
        for (int i = 0; i < len; i++) {
            if (signs[i] == true) {
                answer += absolutes[i];
            }
            else {
                answer -= absolutes[i];
            }
        }
        return answer;
    }
}
