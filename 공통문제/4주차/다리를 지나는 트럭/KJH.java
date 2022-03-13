public int solution(int bridge_length, int weight, int[] truck_weights) {
            //트럭은 1 time에 1 length 이동한다.
            //bridge_length: 다리의 길이
            //weight: 다리가 견딜 수 있는 무게
            //truck_weights: 대기중인 트럭들(무게)

            //다리
            Queue<Integer> bridge = new LinkedList<>();

            int sum = 0; //현재 다리위의 트럭들의 무게의 합
            int time = 0; //시간

            for (int i = 0; i < truck_weights.length; i++) {
                int truck = truck_weights[i];

                while (true) {

                    //1. 다리가 비어있는경우
                    if (bridge.isEmpty()) {
                        bridge.offer(truck);
                        sum += truck;
                        time++;
                        break;
                    }
                    //2. 다리가 모두 채워진 경우
                    else if (bridge.size() == bridge_length) {
                        Integer poll = bridge.poll();
                        sum -= poll;
                    }
                    //3. 다리에 여유 공간이 있는 경우
                    else {
                        //새로운 트럭을 올려도 최대 허용 무게를 넘지 않는 경우
                        if (sum + truck <= weight) {
                            bridge.offer(truck);
                            sum += truck;
                            time++;
                            break;
                        } else {
                            //무게를 넘는다면 0을 넣어 트럭들이 1칸씩 전진
                            bridge.offer(0);
                            time++;
                        }
                    }
                }
            }
            return time + bridge_length;
}


//다리에 먼저 올라간 트럭이 먼저 빠져야 하기 때문에 LIFO 방식인 스택보다는 FIFO 방식을 쓰는 큐를 활용해서 구현하였다.
//어려웠던 부분
//1. 다리 위에 올라간 트럭들을 1 time 당 1 length만큼 움직이는 것
// -> 트럭을 올리질 못할 때에는 큐에 0을 삽입하는 방식으로 해결하였다.
//2. 트럭이 모두 지나갔을 때는 반복을 멈추게 하는 조건을 설정
// -> 마지막 트럭이 다리에 올라간다면 반복문을 중지하고 time(걸린 시간)에 bridge_length를 더해서 return 하는 방식으로 해결하였다.
