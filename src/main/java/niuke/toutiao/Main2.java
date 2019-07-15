package niuke.toutiao;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Classname Main2
 * @Description TODO
 * @Date 2019/4/14 11:05
 * @Created by luojia
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
//        测试用例组数
        int n=Integer.parseInt(sc.nextLine());
        int result=0;
        for (int i = 0; i < n; i++) {
            Map<String,Integer> featureMap=new HashMap<>();
//            视频帧数
            int m=Integer.parseInt(sc.nextLine());
            for (int j = 0; j < m; j++) {
                String[] strings=sc.nextLine().split(" ");
                int num=Integer.parseInt(strings[0]);
                if (num!=0){
                    for (int k = 1; k < strings.length;) {
                        String temp=strings[k]+","+strings[k+1];
                        if(featureMap.containsKey(temp)){
                            featureMap.put(temp,featureMap.get(temp)+1);
                        }else{
                            featureMap.put(temp,1);
                        }
                        k+=2;
                    }
                    for(String key:featureMap.keySet()){
                        boolean flag = false;
                        String temp="";
                        for (int k = 1; k < strings.length;) {
                            temp=strings[k]+","+strings[k+1];
                            if (key.equals(temp)){
                                flag=true;
                            }
                            k+=2;
                        }
//                        特征在该帧中消失
                        if(!flag){
//                            长度大于之前已有的最大运动长度，则赋值给result
                            if(featureMap.get(temp)>result){
                                result=featureMap.get(temp);
                            }else{
                                featureMap.remove(temp);
                            }
                        }
                    }
                }
            }
        }
        if(result<=2){
            System.out.println(1);
        }else{
            System.out.println(result);
        }
    }
}
