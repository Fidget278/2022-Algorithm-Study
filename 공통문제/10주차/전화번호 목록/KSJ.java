import java.util.HashMap;

class Solution {
    public boolean solution(String[] phone_book) {
        HashMap<String, Integer> map = new HashMap<>();
        boolean answer = true;

        // 해시맵에 번호 뽑아서 입력
        for (int i = 0; i < phone_book.length; i++) {
            map.put(phone_book[i], 0);
        }

        // 목록을 기준으로 반복 돌리면서 번호의 접두 부분을 하나씩 늘려가며 해시에 저장한 값하고 비교 후 리턴
        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 1; j < phone_book[i].length(); j++) {
                String prefix = phone_book[i].substring(0, j);
                if (map.containsKey(prefix)) {
                    answer = false;
                }
            }
        }
        return answer;

    }

    public static void main(String[] args) {
        String[] phone_book = { "119", "97674223", "1195524421" };

        Solution sol = new Solution();
        System.out.println(sol.solution(phone_book));

    }
}
