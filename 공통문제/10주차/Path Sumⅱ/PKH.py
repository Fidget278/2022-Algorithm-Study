# 시간 : 52ms
from copy import deepcopy

class Solution:
    def pathSum(self, root, targetSum):
        answer = []
        def check(lst, target, cur):
            if cur.left == None and cur.right == None:
                ret = sum(lst)
                if ret == target:
                    ans = deepcopy(lst)
                    answer.append(ans)
                lst.pop()
                return 
            left = True if cur.left != None else False
            right = True if cur.right != None else False
            if left:
                new_cur = cur.left
                lst.append(new_cur.val)
                check(lst, target, new_cur)
                left = False
            if right:
                new_cur = cur.right
                lst.append(new_cur.val)
                check(lst, target, new_cur)
                right = False
            if left == False and right == False:
                lst.pop()
                
        q = []
        if root == None:
            return []
        q.append(root.val)
        check(q, targetSum, root)
        return answer
