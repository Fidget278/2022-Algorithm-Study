import java.util.Deque;
import java.util.Iterator;
import java.util.ArrayDeque;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0; int time = 0;
        Deque<Integer> queue = makeDeque(truck_weights);
        Deque<Integer> onWeight = new ArrayDeque<Integer>();
        Deque<Integer> onLength = new ArrayDeque<Integer>();
        
        while(true) {
            int nowTruck = 0;
            if (queue.size() > 0) {
                nowTruck = queue.poll();
                onWeight.add(nowTruck);
                onLength.add(0);
            }
            
            if (sum(onWeight) > weight) {
                onWeight.removeLast(); onLength.removeLast();
                queue.addFirst(nowTruck);
            }
            
            for(int i = 0; i < onLength.size(); i++) {
                int temp = onLength.poll();
                temp += 1;
                onLength.addLast(temp);
            }
            
            if (onLength.getFirst() >= bridge_length) {
                onWeight.removeFirst(); onLength.removeFirst();
            }
            
            answer += 1;
            
            if (onWeight.size() == 0 && queue.size() == 0) {
                answer += 1;
                break;
            }
        }
        return answer;
    }
    
    public static Deque<Integer> makeDeque(int[] nums) {
        Deque<Integer> queue = new ArrayDeque<Integer>();
        for(int i : nums) {
            queue.add(i);
        }
        return queue;
    }
    
    public static int sum(Deque<Integer> deq) {
        int total = 0;
        Iterator<Integer> i = deq.iterator();
        while(i.hasNext()) {
            total += i.next();
        }
        return total;
    }
}
