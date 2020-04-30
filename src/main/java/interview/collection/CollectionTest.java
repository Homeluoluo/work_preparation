package interview.collection;

import java.util.*;

/**
 * @Classname CollectionTest
 * @Description TODO
 * @Date 2019/4/18 8:47
 * @Created by luojia
 */
public class CollectionTest {
    public static void main(String[] args) throws InterruptedException {
//        mapTest();
        ArrayListTest();
//        Object
    }

    public static void mapTest(){
        HashMap<Integer,String> map=new HashMap<>();
//        HashMap最大容量为2的30次方，初始容量为2的四次方16
//        System.out.println(1<<30);
//        System.out.println(1 >>> 16);
        map.put(1,"test 1");
        map.put(null,"test null");
        map.put(2,null);
        System.out.println(map.size());

        Hashtable<Integer,String> table=new Hashtable<>();
//        下面两个语句会报错，hashtable中的key和value都不可以为null
//        table.put(null,"test null");
//        table.put(1,null);
        System.out.println(table.size());

//        线程安全的map
        Map<Integer,String> map1= Collections.synchronizedMap(new HashMap<Integer, String>());
    }
    public static void setTest(){
//        SortedSet<>
//        Vector
    }

//    测试ArrayList的线程不安全性
//    两个线程同时往一个ArrayList里面添加元素
    public static void ArrayListTest() throws InterruptedException {
        final List<Integer> list = new ArrayList<Integer>();

        // 线程A将0-1000添加到list
        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 1000 ; i++) {
                    list.add(i);
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        // 线程B将1000-2000添加到列表
        new Thread(new Runnable() {
            public void run() {
                for (int i = 1000; i < 2000 ; i++) {
                    list.add(i);

                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        Thread.sleep(1000);

        // 打印所有结果
        for (int i = 0; i < list.size(); i++) {
            System.out.println("第" + (i + 1) + "个元素为：" + list.get(i));
        }
    }

//    测试TreeSet
    public static void ttreeSet(){

    }
}
