package Array;

public class compareDemo2 {

    public static void main(String[] args) {

    }

    public int compare (String version1, String version2) {

        int index1=0;
        int index2=0;

        int n1=version1.length();
        int n2=version2.length();

        while (index1<n1 || index2 <n2){
            int nums1=0;
            while (index1<n1 && version1.charAt(index1)!='.'){
                // 统计. 之前的元素和；
                nums1= nums1 * 10 + (version1.charAt(index1) - '0');
                index1++;
            }

            int nums2=0;
            while (index2<n2 && version2.charAt(index2)!='.'){
                // 统计. 之前的元素和；
                nums2= nums2 * 10 + (version2.charAt(index2) - '0');
                index2++;
            }

            if (nums1>nums2)  return 1;
            else if (nums1<nums2) return -1;
            //相等的话，继续执行

            // 跳过当前的.
            index1++;
            index2++;
        }
        return 0;
    }
}
