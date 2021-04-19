package leetCode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Question169 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int mid=(nums.length-1)/2;
        return nums[mid];
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Question169 t=new Question169();
        while (true) {
            String[] split = sc.next().split(",");
            int[] nums = new int[split.length];
            for (int i = 0; i < split.length; i++) {
                nums[i] = Integer.parseInt(split[i]);
            }
            System.out.println(t.majorityElement(nums));
        }
    }
}
