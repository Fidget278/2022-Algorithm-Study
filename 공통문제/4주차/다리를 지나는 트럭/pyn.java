public int solution(int bridge_length, int weight, int[] truck_weights) {

        ArrayList<Integer> bridge = new ArrayList<Integer>();

        int index = 0;
        int answer = 1;
        for(int i = 0; i < bridge_length-1; ++i)
            bridge.add(0);

        bridge.add(truck_weights[index]);
        int sum = truck_weights[index++];

        while(index < truck_weights.length || !bridge.isEmpty()) {
            ++answer;
            sum -= bridge.get(0);
            bridge.remove(0);

            if(index >= truck_weights.length)
                continue;

            if(sum + truck_weights[index] <= weight) {
                sum += truck_weights[index];
                bridge.add(truck_weights[index++]);
            } else {
                bridge.add(0);
            }

        }
        return answer;
    }