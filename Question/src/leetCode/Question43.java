package leetCode;

import com.sun.media.sound.RIFFInvalidDataException;
import sun.misc.OSEnvironment;

import javax.swing.*;
import java.util.ArrayDeque;
import java.util.Scanner;

public class Question43 {
    public String add(String num1, String num2) {
        ArrayDeque<Character> left=new ArrayDeque<>();
        ArrayDeque<Character> right=new ArrayDeque<>();
        for (char c : num1.toCharArray()) {
            left.push(c);
        }
        for (char c : num2.toCharArray()) {
            right.push(c);
        }
        int offset=0;
        StringBuilder sb=new StringBuilder();
        while (!left.isEmpty()&&!right.isEmpty()){
            int sum=(left.pop()-'0')+(right.pop()-'0');
            sb.append((offset+sum)%10);
            offset=(sum+offset)/10;
        }
        while (!left.isEmpty()) {
            int sum = left.pop() - '0';
            sb.append((offset + sum) % 10);
            offset = (offset + sum) / 10;
        }
        while (!right.isEmpty()){
            int sum=right.pop()-'0';
            sb.append((offset+sum)%10);
            offset=(offset+sum)/10;
        }
        if (offset!=0){
            sb.append(offset);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Question43 t=new Question43();
        while (true){
            String multiply = t.add(sc.next(), sc.next());
            System.out.println(multiply);
        }
    }
}
