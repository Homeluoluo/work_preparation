package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstring {
/*
* 暴力法
*

时间复杂度：O(n3)O(n^3)O(n3) 。

要验证索引范围在 [i,j)[i, j)[i,j) 内的字符是否都是唯一的，我们需要检查该范围中的所有字符。 因此，它将花费 O(j−i)O(j - i)O(j−i) 的时间。

对于给定的 i，对于所有 j∈[i+1,n]j \in [i+1, n]j∈[i+1,n] 所耗费的时间总和为：

∑i+1nO(j−i) \sum_{i+1}^{n}O(j - i) ∑i+1n​O(j−i)

因此，执行所有步骤耗去的时间总和为：

O(∑i=0n−1(∑j=i+1n(j−i)))=O(∑i=0n−1(1+n−i)(n−i)2)=O(n3) O\left(\sum_{i = 0}^{n - 1}\left(\sum_{j = i + 1}^{n}(j - i)\right)\right) = O\left(\sum_{i = 0}^{n - 1}\frac{(1 + n - i)(n - i)}{2}\right) = O(n^3) O(∑i=0n−1​(∑j=i+1n​(j−i)))=O(∑i=0n−1​2(1+n−i)(n−i)​)=O(n3)

空间复杂度：O(min(n,m))，我们需要 O(k)O(k)O(k) 的空间来检查子字符串中是否有重复字符，其中 kkk 表示 Set 的大小。而 Set 的大小取决于字符串 nnn 的大小以及字符集/字母 mmm 的大小。
* */
    public int lengthOfLongestSubstring1(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j <= n; j++)
                if (allUnique(s, i, j)) ans = Math.max(ans, j - i);
        return ans;
    }

    public boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) return false;
            set.add(ch);
        }
        return true;
    }

    /*
    滑动窗口法
滑动窗口是数组/字符串问题中常用的抽象概念。 窗口通常是在数组/字符串中由开始和结束索引定义的一系列元素的集合，即 [i,j)（左闭，右开）。而滑动窗口是可以将两个边界向某一方向“滑动”的窗口。例如，我们将 [i,j) 向右滑动 1 个元素，则它将变为 [i+1,j+1)（左闭，右开）

时间复杂度：O(2n)=O(n)，在最糟糕的情况下，每个字符将被 i 和 j 访问两次。

空间复杂度：O(min(m,n))，与之前的方法相同。滑动窗口法需要 O(k) 的空间，其中 k 表示 Set 的大小。而Set的大小取决于字符串 n 的大小以及字符集/字母 m 的大小。
    */
    public static int lengthOfLongestSubstring2(String s){
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    /*优化的滑动窗口
    上述的方法最多需要执行 2n 个步骤。事实上，它可以被进一步优化为仅需要 n 个步骤。我们可以定义字符到索引的映射，而不是使用集合来判断一个字符是否存在。 当我们找到重复的字符时，我们可以立即跳过该窗口。

也就是说，如果 s[j] 在 [i,j) 范围内有与 j′ 重复的字符，我们不需要逐渐增加 i。 我们可以直接跳过 [i，j′]范围内的所有元素，并将 i 变为 j′+1。
    * */
    public static int lengthOfLongestSubstring3(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    /*Java（假设字符集为 ASCII 128）

以前的我们都没有对字符串 s 所使用的字符集进行假设。

当我们知道该字符集比较小的时侯，我们可以用一个整数数组作为直接访问表来替换 Map。

常用的表如下所示：

    int [26] 用于字母 ‘a’ - ‘z’或 ‘A’ - ‘Z’
    int [128] 用于ASCII码
    int [256] 用于扩展ASCII码

    * */
    public static int lengthOfLongestSubstring4(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            System.out.println(index[s.charAt(j)]);
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }

    public static int lengthOfLongestSubstring_my(String s){
        int result=0;
        int temp=0;
        int index_start=0;

        for(int i=0;i<s.length();i++){
            int index=s.substring(0,i).lastIndexOf(s.charAt(i));//这个耗时太多了？
            System.out.println("index="+index);
            if (index!=-1&&index>=index_start){
                temp=i-index;
                index_start=index+1;
            }else{
                temp++;
            }
            result=temp>result?temp:result;
            System.out.println("result="+result);
        }
        return result;
    }

    public static void main(String[] args){
        String s="abfba";
        System.out.println(lengthOfLongestSubstring4(s));
    }
}
