package LiKoHot100.二分查找;

public class bubbleSortDemo {
    
    /**
     * 冒泡排序算法
     * @param arr 需要排序的数组
     */
    public void bubbleSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        
        int n = arr.length;
        // 外层循环控制排序轮数
        for (int i = 0; i < n - 1; i++) {
            // 内层循环控制每轮比较的次数
            for (int j = 0; j < n - 1 - i; j++) {
                // 如果前面的数大于后面的数，则交换
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 优化后的冒泡排序算法
     * @param arr 需要排序的数组
     */
    public void optimizedBubbleSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        
        int n = arr.length;
        boolean swapped;
        // 外层循环控制排序轮数
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            // 内层循环控制每轮比较的次数
            for (int j = 0; j < n - 1 - i; j++) {
                // 如果前面的数大于后面的数，则交换
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // 如果这一轮没有发生交换，说明数组已经有序，可以提前退出
            if (!swapped) {
                break;
            }
        }
    }

    // 测试代码
    public static void main(String[] args) {
        bubbleSortDemo demo = new bubbleSortDemo();
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("排序前的数组：");
        printArray(arr);
        
        demo.optimizedBubbleSort(arr);
        
        System.out.println("排序后的数组：");
        printArray(arr);
    }

    // 打印数组的辅助方法
    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
} 