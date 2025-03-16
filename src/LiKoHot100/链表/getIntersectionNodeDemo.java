package LiKoHot100.链表;

public class getIntersectionNodeDemo {


    /**
     * 思路：
     * 1. 先统计A和B的长度
     * 2. 让A和B进行长度对齐，
     * 3. 对齐之后，进行比较，如果相同返回，不相同就继续遍历指针
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int lenA = 0;
        int lenB = 0;
        // 统计A和B的长度
        ListNode ponitA = headA;
        ListNode pointB = headB;
        while (ponitA.next != null) {
            ponitA = ponitA.next;
            lenA++;
        }

        while (pointB.next != null) {
            pointB = pointB.next;
            lenB++;
        }


        // 让A和B对齐
        int dis = 0;
        if (lenA > lenB) {
            dis = lenA - lenB;
            while (dis > 0) {
                headA = headA.next;
                dis--;
            }
        } else {
            dis= lenB -lenA;
            while (dis>0){
                headB=headB.next;
                dis--;
            }
        }

        while (headA!=null){
            if (headA == headB){
                return headA;
            }else {
                headA=headA.next;
                headB=headB.next;
            }
        }
        //不满足条件
        return null;
    }
}
