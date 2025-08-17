package test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindow {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        int j = 1 - k;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++, j++) {
            if (j > 0 && deque.getFirst() == nums[j - 1]) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && deque.getLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            if (j >= 0) {
                ans[j] = deque.getFirst();
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-7,-8,7,5,7,1,6,0};
        int[] ints = maxSlidingWindow(nums, 4);
        System.out.println(Arrays.toString(ints));
    }

}
