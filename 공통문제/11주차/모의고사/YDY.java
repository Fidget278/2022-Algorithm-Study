public class AlgorithmStudy16 {
    public static int[] solution(int[] answers) {
        int[] answer = {};
        int answersLength = answers.length;
        int[] student1 = new int[answersLength];
        int[] student2 = new int[answersLength];
        int[] student3 = new int[answersLength];

        //student1의 답
        int stu1j = 0;
        for(int i = 0; i < answersLength; i++) {
            student1[i] = ++stu1j;
            if( (stu1j) == 5) {
                stu1j = 0;
            }
        }

        //student2의 답
        int stu2j = 2;
        for(int i = 0; i < answersLength; i ++) {
            if( (i % 2) == 0 ) {
                student2[i] = 2;
            } else if((i % 2) == 1 && (i % 8) == 1) {
                student2[i] = 1;
            } else if( (i % 2) == 1 ) {
                if(stu2j == 5) {
                    stu2j = 2;
                }
                student2[i] = stu2j + 1;
                stu2j++;
            }
        }

        //student3의 답
        int temp[] = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int stu3j = 0;
        for(int i = 0; i < answersLength; i++) {
            student3[i] = temp[stu3j++];
            if(stu3j == 10) {
                stu3j = 0;
            }
        }

        int[] count = new int[3];
        for(int i = 0; i < answersLength; i++) {
            if(answers[i] == student1[i]) {
                count[0]++;
            }
            if(answers[i] == student2[i]) {
                count[1]++;
            }
            if(answers[i] == student3[i]) {
                count[2]++;
            }
        }

        List<Integer> list = new ArrayList<>();
        int maxCount = Math.max(count[0], Math.max(count[1], count[2]));
        if(maxCount == count[0]) {
            list.add(1);
        }
        if(maxCount == count[1]) {
            list.add(2);
        }
        if(maxCount == count[2]) {
            list.add(3);
        }

        answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }


    public static void main(String[] args) {
        int[] answers = {1,2, 3, 4, 5};
        solution(answers);


    }
}
