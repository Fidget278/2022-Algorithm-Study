// https://leetcode.com/problems/path-sum-ii/
// LeetCode - 113. Path Sum II
// 작성자 : 김성중

/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number} targetSum
 * @return {number[][]}
 */
var pathSum = function (root, targetSum) {
  const path = [];

  if (root !== null) {
    const temp = [];

    function DFS(node) {
      if (node === null) {
        return node;
      }

      // 처음 root값을 넣고 재귀로 노드 진행
      temp.push(node.val);

      // leaf까지 도달 후 temp 값을 다 더한값이 targetSum과 동일하면 배열복사로 path에 넣는다.
      if (node.left === null && node.right === null) {
        let sum = temp.reduce((acc, cur) => {
          return acc + cur;
        }, 0);

        if (sum === targetSum) {
          path.push([...temp]);
        }
      }

      DFS(node.left);
      DFS(node.right);

      temp.pop();
    }

    DFS(root);
  }

  return path;
};
