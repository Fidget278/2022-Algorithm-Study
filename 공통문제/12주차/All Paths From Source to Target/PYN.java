class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        List<List<Integer>> answer = new ArrayList<List<Integer>>();

        findPath(graph, 0, new ArrayList<Integer>(), answer);
        
        return answer;
    }
    
    public void findPath(int [][] graph, int node, List<Integer> list, List<List<Integer>> answer) {

        if(node == graph.length - 1) {
            list.add(node);
            answer.add(list);
            return;
        }

        list.add(node);
        for(int i = 0; i < graph[node].length; ++i)
            findPath(graph, graph[node][i], new ArrayList<Integer>(list), answer);

    }
}