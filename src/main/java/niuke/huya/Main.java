package niuke.huya;

import java.util.*;

/**
 * @Classname Main
 * @Description TODO
 * @Date 2019/4/22 21:29
 * @Created by luojia
 */
public class Main {

    public static void main(String[] args) {
        String[] dict = {"中国","直播","游戏","游戏直播","综艺娱乐","互动直播平台"};
        Scanner input = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        SortedMap<Integer,String> map = new TreeMap<>();
        String s = input.nextLine();
        String t  = s;
        int l = s.length();
        for(int i = 0 ; i < l - 5 ; i++){
            String temp = s.substring(i,i+6);
            if(list.contains(i)){
                continue;
            }
            if(temp.equals(dict[5])){
                map.put(i ,dict[5]);
                for (int j = i ; j < i + 6 ; j++){
                    list.add(j);
                }
            }
        }
        for(int i = 0 ; i < l - 3; i++){
            String temp = s.substring(i,i+4);
            if(list.contains(i)){
                continue;
            }
            if(temp.equals(dict[3])){
                map.put(i ,dict[3]);
                for (int j = i ; j < i + 4 ; j++){
                    list.add(j);
                }
            }else if(temp.equals(dict[4])){
                map.put(i ,dict[4]);
                for (int j = i ; j < i + 4 ; j++){

                    list.add(j);
                }
            }
        }
        for(int i = 0 ; i < l - 1 ; i++){
            String temp = s.substring(i,i+2);
            if(list.contains(i)){
                continue;
            }
            if(temp.equals(dict[0])){
                map.put(i ,dict[0]);
                for (int j = i ; j < i + 2 ; j++){
                    list.add(j);
                }
            }else if(temp.equals(dict[1])){
                map.put(i ,dict[1]);
                for (int j = i ; j < i + 2 ; j++){
                    list.add(j);
                }
            }else if(temp.equals(dict[2])){
                map.put(i ,dict[2]);
                for (int j = i ; j < i + 2 ; j++){
                    list.add(j);
                }
            }
        }
        Collection values = map.values();
        Object[] res = values.toArray();
        for(int i = 0 ; i < res.length ; i++){
            if(i != res.length-1){
                System.out.print((String)res[i] + ",");
            }else{
                System.out.print((String)res[i]);
            }
        }
    }
}

