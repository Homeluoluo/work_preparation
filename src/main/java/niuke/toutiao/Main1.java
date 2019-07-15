package niuke.toutiao;

import java.util.*;

/**
 * @Classname Main1
 * @Description TODO
 * @Date 2019/4/27 10:06
 * @Created by luojia
 */
public class Main1 {
    public static SortedMap<Integer,Integer> map=new TreeMap<>();;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] nums_str=sc.nextLine().split(" ");
        int length=nums_str.length;
        if(length!=13){
            return;
        }
        int[] nums=new int[length];
        for (int i = 0; i < length; i++) {
            nums[i]=Integer.parseInt(nums_str[i]);
        }
//        用SortedMap存放麻将的情况
        for (int i = 0; i < length; i++) {
            if (map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
        }
        for (Integer key:map.keySet()) {
            System.out.println(key+": "+map.get(key));
        }
//        依次加入1-9每个数字，判断是否能胡牌
        SortedMap<Integer,Integer> map_origin=map;
        for(int i=1;i<=9;i++){
            map=map_origin;
            if (map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }else{
                map.put(i,1);
            }
            if(canHu())
                System.out.print(i+" ");
        }
    }

    public static boolean canHu(){
        SortedMap<Integer,Integer> map_origin_1=map;
        for (Integer key:map.keySet()) {
            int length=14;
            map=map_origin_1;
            if(map.get(key)>=2){
//                减去一个对子
                map.put(key,map.get(key)-2);
                length-=2;
                for (Integer key2:map.keySet()) {
                    while (map.get(key2)>0){
//                        数量小于3，remove顺子
                        if(map.get(key2)<3){
                            if(!removeShunZi()){
                                break;
                            }else{
                                length-=3;
                            }
                        }else{
//                            数量大于3 remove 刻子
                            removeKezi();
                            length-=3;
                        }
                    }
                }
                if(length==0){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean removeKezi(){
        for (Integer key:map.keySet()) {
            if(map.get(key)>=3){
                map.put(key,map.get(key)-3);
                return true;
            }
        }
        return false;
    }

    public static boolean removeShunZi(){
        for (Integer key:map.keySet()) {
            if(map.get(key)>0&&map.containsKey(key+1)&&map.get(key+1)>0&&map.containsKey(key+2)&&map.get(key+2)>0){
                map.put(key,map.get(key)-1);
                map.put(key+1,map.get(key+1)-1);
                map.put(key+2,map.get(key+2)-1);
                return true;
            }
        }
        return false;
    }
}
