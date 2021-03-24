package question50.question59;

import javax.swing.*;
import javax.swing.plaf.DesktopIconUI;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Question59_01 {
    static Integer[] manInWindow(int[] arrays, int size) {
        if (arrays == null || size <= 0) return null;
        List<Integer> maxInWindow = new ArrayList<>();

        if (arrays.length >= size) {
            Deque<Integer> index = new ArrayDeque<>();
            //将滑动窗口填充满, 此时队列中只能有一个值.
            for (int i = 0; i < size; i++) {
                while (!index.isEmpty() && arrays[i] >= arrays[index.peekLast()]) {
                    index.pollLast();
                }
                index.addLast(i);
            }
            for (int i = size; i < arrays.length; i++) {
                maxInWindow.add(arrays[index.peekFirst()]);
                //队列首部值小于需要比较的元素, 则将队列清空,并把这个元素的下标放到队列首部.
                while (!index.isEmpty() && arrays[i] >= arrays[index.peekLast()]) {
                    index.pollLast();
                }
                //队首的下标超过了窗口的长度.
                if (!index.isEmpty() && index.peekFirst() <= (i - size)) {
                    index.pollFirst();
                }
                index.addLast(i);
            }
            maxInWindow.add(arrays[index.peekFirst()]);
        }
        if (!maxInWindow.isEmpty()) {
            Integer[] integers = maxInWindow.toArray(new Integer[maxInWindow.size()]);
            return integers;
        }
        return null;
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 4, 2, 6, 2, 5, 1};
        Integer[] integers = manInWindow(a, 3);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
}
