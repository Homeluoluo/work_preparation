package others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ReferenceSort {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        Scanner input =new Scanner(System.in);
        for (int i = 0; ; i++) {
            if (!input.hasNext()) {
                break;
            }
            nums.add(Integer.parseInt(input.nextLine()));
            System.out.println(Arrays.toString(Arrays.stream(nums.toArray()).sorted().toArray()));
        }
    }
}
