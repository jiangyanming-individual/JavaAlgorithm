package Tree;

import java.util.*;
import java.util.stream.Collectors;

public class findModeDemo {

    private TreeNode pre;
    private int count = 0;//统计频率
    private int MAX_COUNT=0; //最大

    public int[] findMode(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> resultList = new ArrayList<>();
        if (root!=null) stack.add(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.peek();
            if (node!=null){
                stack.pop();
                if (node.right!=null) stack.add(node.right);
                stack.add(node);
                stack.add(null);
                if (node.left!=null) stack.add(node.left);
            }else {
                stack.pop();
                TreeNode cur = stack.pop();

                if (pre== null){
                    count=1;
                }else if (pre.val == cur.val){
                    count+=1;
                }else {
                    count=1;
                }

                //更新pre
                pre=cur;
                if (count == MAX_COUNT){
                    resultList.add(pre.val);
                }
                if (count > MAX_COUNT ){
                    resultList.clear(); //清除；
                    MAX_COUNT=count;
                    resultList.add(pre.val); //更新最多的
                }

            }

        }
        int i=0;
        int[] resultArray = new int[resultList.size()];
        for (Integer item : resultList) {

            resultArray[i++]=item;
        }
        return resultArray;
    }

    /**
     * 暴力求解 hashmap排序：
     * @param root
     * @return
     */
    public int[] findMode2(TreeNode root) {
        HashMap<Integer, Integer> resultMap = new HashMap<>();
        ArrayList<Integer> resultList = new ArrayList<>();
        if (root == null) return new int[0];
        traversal(root,resultMap);
        //排序，按value排序
        //resultMap.entrySet() 得到键值对组成的set集合
        List<Map.Entry<Integer, Integer>> mapList= resultMap.entrySet().
                stream().
                sorted((c1, c2) -> c2.getValue().compareTo(c1.getValue())). //排序，按comparable的接口实现
                collect(Collectors.toList());

        resultList.add(mapList.get(0).getKey());//加入第一最多的元素；
        for (int i = 1; i < mapList.size(); i++) {
            if (mapList.get(0).getValue() == mapList.get(i).getValue()){
                resultList.add(mapList.get(i).getKey()); //加入其他的key；
            }else {
                break;
            }
        }
        // Integer::intValue Integer类内置的一个返回int的函数
        return resultList.stream().mapToInt(Integer::intValue).toArray();//list转数组；
    }

    public void traversal(TreeNode root,Map<Integer,Integer> resultMap){
        if (root == null) return;
        traversal(root.left,resultMap);
        resultMap.put(root.val,resultMap.getOrDefault(root.val,0)+1);
        traversal(root.right,resultMap);
    }
}
