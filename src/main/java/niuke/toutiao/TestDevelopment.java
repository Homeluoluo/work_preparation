package niuke.toutiao;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Classname TestDevelopment
 * @Description TODO
 * @Date 2019/5/7 14:49
 * @Created by luojia
 */
public class TestDevelopment {
    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        System.out.println(getMinimalOccurrenceChar(sc.nextLine()));
//        test();

//        测试合并两个有序数组
        int[] a={1,3,5,7,9};
        int[] b={1,2,4,7,10,25};
        int[] result=mergeList(a,b);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]+" ");
        }
    }
//    找出一个字符串中出现次数最少的第一个字符
    public static char getMinimalOccurrenceChar(String str){
        Map<String,Integer> charMap=new HashMap<>();
        char[] chars=str.toCharArray();
        for(char ch:chars){
            if (charMap.containsKey(String.valueOf(ch))){
                charMap.put(String.valueOf(ch),charMap.get(String.valueOf(ch))+1);
            }else{
                charMap.put(String.valueOf(ch),1);
            }
        }
        int min=999;
        String result="";
        for(String key:charMap.keySet()){
            if(charMap.get(key)<min){
                min=charMap.get(key);
                result=key;
            }
        }
        return result.toCharArray()[0];
    }

//    测试String和char
    public static void test(){
        char a='a';
        String a2="a";
        Map<String,Integer> charMap=new HashMap<>();
        charMap.put(a2,0);
        System.out.println(charMap.containsKey(a));
    }

//    合并两个有序数组
    public static int[] mergeList(int[] arrayA,int[] arrayB){
        int[] result=new int[arrayA.length+arrayB.length];
        int i=0,j=0;
        int k=0;
        while (i<arrayA.length&&j<arrayB.length){
            if(arrayA[i]<=arrayB[j]){
                result[k++]=arrayA[i++];
            }else{
                result[k++]=arrayB[j++];
            }
        }
        while (i<arrayA.length){
            result[k++]=arrayA[i++];
        }
        while (j<arrayB.length){
            result[k++]=arrayB[j++];
        }
        return result;
    }
}
