package test2;

public class nextLargerNodesDemo {


    public int [] nextLargerNodes(ListNode head){
        ListNode cur =head;
        int count =0;
        while (cur!=null){
            cur=cur.next;
            count++;
        }
        int[] nums =new int[count];
        int[] res= new int[count];

        cur=head;
        int index=0;
        while (cur!=null){
            nums[index++]=cur.val;
            cur=cur.next;
        }

        for (int i=0;i<nums.length;i++){

            for (int j=i+1;j<nums.length;j++){
                if (nums[j] > nums[i]){
                    res[i]= nums[j];
                    break;
                }else {
                    res[i]=0;
                }
            }
        }
        return res;
    }
}
