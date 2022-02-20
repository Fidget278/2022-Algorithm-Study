import java.util.PriorityQueue;

public class Scoville {

    /**
     * 모든 음식들의 스코빌 지수가 K 이상이 되도록 만들어라.
     * K보다 낮은 음식이 있다면 음식을 섞는다.
     * 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + ( 두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
     * @param scoville 음식 list
     * @param K 기준 지수
     * @return 섞은 횟수
     */
    public int solution(int[] scoville, int K) {
        int answer = 0;
        //우선순위 큐를 사용하기 위해 선언
        //우선순위 큐: 높은 우선순위의 요소를 먼저 꺼내서 처리하는 구조.
        //FIFO의 구조를 가지고 있다.
        //우선순위 숫자가 낮은 순
        //참고주소: https://coding-factory.tistory.com/603
        PriorityQueue<Integer> heap = new PriorityQueue();

        //큐안에 음식들을 입력.
        for (int aScoville : scoville) {
            heap.offer(aScoville);
        }

        //heap.peak() 큐의 첫번째 값 참조
        while (heap.peek() <= K) {
            if (heap.size() == 1) {
                return -1;
            }
            //heap.poll(): 첫번째 값을 반환하고 제거, 만약 비어있다면 null
            int a = heap.poll(); // 가장 맵지 않은 음식
            int b = heap.poll(); // 두번째로 맵지 않은 음식

            //음식 섞기
            int result = a + (b * 2);

            //섞은 음식 heap에 추가.
            heap.offer(result);
            //음식 섞은 횟수+1
            answer++;
        }
        return answer;
    }
}

