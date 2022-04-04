// https://leetcode.com/problems/add-two-numbers/

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}


public class AddTwoNumbers {

    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode current = new ListNode();
        ListNode head = current;

        int advance = 0;

        while(l1 != null || l2 != null) {

            current.next = new ListNode();
            current = current.next;

            current.val = advance;
            advance = 0;
            if(l1 != null) {
                current.val += l1.val;
                l1 = l1.next;
            }

            if(l2 != null) {
                current.val += l2.val;
                l2 = l2.next;
            }

            if(current.val >= 10){
                advance = 1;
                current.val -= 10;
            }

            // 이 조건문을 빼고 while() 에 조건문을 넣는 형식으로 바꿨더니 3ms 에서 1ms 로 단축되었음.. ||와 && 의 차이인가..?
//            if( l1 == null && l2 == null )
//                break;
        }

        if(advance > 0)
            current.next = new ListNode(advance);


        return head.next;
    }
}
