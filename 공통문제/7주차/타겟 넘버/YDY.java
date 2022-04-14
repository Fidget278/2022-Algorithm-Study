package common;
//https://programmers.co.kr/learn/courses/30/lessons/43165

public class AlgorithmStudy7 {
    public static int solution(int[] numbers, int target) {
        int answer = 0, sum = 0, depth = 0, n = 0;
        return dfsAlgorithm(numbers, target, answer, sum, depth, n);
    }

    public static int dfsAlgorithm(int[] numbers, int target, int answer, int sum, int depth, int n) {
        sum = sum + n;

        if(depth == numbers.length) {
            if(sum == target) {
                answer++;
                return answer;
            }
            return 0;
        }

        n = numbers[depth];
        depth++;

        return dfsAlgorithm(numbers, target, answer, sum, depth, n)
                + dfsAlgorithm(numbers, target, answer, sum, depth, -n);
    }
}
