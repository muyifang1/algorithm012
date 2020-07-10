package leetcode.movezeros;

public class Solution2 {

    public void moveZeroes(int[] numbers) {
        int j = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] != 0) {
                numbers[j] = numbers[i];
                if (i != j) {
                    numbers[i] = 0;
                }
                j++;
            }
        }
    }
}
