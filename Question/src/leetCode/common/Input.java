package leetCode.common;

import java.util.Scanner;

public class Input {
    public static int[] getNums(){
        Scanner sc=new Scanner(System.in);
        String s = sc.next();
        String[] split = s.split(",");
        int[] nums = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            nums[i]=Integer.parseInt(split[i]);
        }
        return nums;
    }
}
