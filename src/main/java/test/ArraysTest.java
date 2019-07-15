package test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @Classname ArraysTest
 * @Description TODO
 * @Date 2019/4/4 21:42
 * @Created by luojia
 */
//Arrays实现降序排序
public class ArraysTest {
    public static void main(String[] args) {
        Integer[] a = {9, 8, 7, 2, 3, 4, 1, 0, 6, 5};
        //定义一个自定义类MyComparator的对象
        Comparator cmp = new MyComparator();
        Arrays.sort(a,cmp);
        for(int arr:a) {
            System.out.print(arr + " ");
        }
    }
}
//实现Comparator接口
class MyComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2-o1;
    }
}
