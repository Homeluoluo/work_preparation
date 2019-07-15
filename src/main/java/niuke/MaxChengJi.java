package niuke;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Classname MaxChengJi
 * @Description TODO
 * @Date 2019/4/6 13:23
 * @Created by luojia
 */
public class MaxChengJi {
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        List<String> strings=new ArrayList<>();
        BufferedOutputStream bos=new BufferedOutputStream(System.out);
        int n=sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i <n ; i++) {
            nums[i]=sc.nextInt();
        }
        if (n<3){
            System.out.println();
        }else{
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.valueOf(nums[i]);
            }
            Arrays.sort(nums);
            BigInteger a= new BigInteger(String.valueOf(nums[n-1])).multiply(new BigInteger(String.valueOf(nums[n-2]))).multiply(new BigInteger(String.valueOf(nums[n-3])));
            BigInteger b= new BigInteger(String.valueOf(nums[0])).multiply(new BigInteger(String.valueOf(nums[1]))).multiply(new BigInteger(String.valueOf(nums[n-1])));
            if(a.compareTo(b)>=0){
                System.out.println(a.toString());
            }else{
                System.out.println(b.toString());
            }

        }
    }
}
