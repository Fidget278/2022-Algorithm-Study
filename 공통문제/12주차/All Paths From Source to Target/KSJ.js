// https://leetcode.com/problems/all-paths-from-source-to-target/
// LeetCode - 797. All Paths From Source to Target
// 작성자 : 김성중

const allPathsSourceTarget = (graph) => {
  const target = graph.length - 1; // last node
  const output = [];

  const traverse = (node, path) => {
    if (node === target) return output.push(path);

    // traverse adjacent nodes
    for (const adjacent of graph[node]) {
      path.push(adjacent);
      traverse(adjacent, [...path]); // copy path

      path.pop(); // pop off last node as backtracking
    }
  };

  traverse(0, [0]);
  return output;
};
