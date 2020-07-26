package leetcode.minarray;

/**
 * leetcode
 * <p>
 * https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 *
 * @author YangQi
 */
public class Solution {

    public int minArray(int[] array) {
        // 思路 二分查找，数组指针移动
        int low = 0;
        int height = array.length - 1;
        int mid = 0;
// [3,4,5,1,2,3]
        while (low < height) {
            mid = (height - low) / 2 + low;
            // 取右侧
            if (array[mid] > array[height]) {
                low = mid + 1;
            } else if (array[mid] < array[height]) {
                // 取左侧
                height = mid;
            } else {
                height = height - 1;
            }
        }
        return array[low];
    }

    // 0 1 2 3 4 5 6 7 8
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = {3, 3, 4, 5, 0, 1, 2, 3, 3};
        System.out.println("solution result = " + solution.minArray(array));
    }
}
