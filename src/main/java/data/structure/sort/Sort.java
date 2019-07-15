package data.structure.sort;

/**
 * @Classname Sort
 * @Description TODO
 * @Date 2019/4/5 12:22
 * @Created by luojia
 */
public class Sort {
//    快速排序
    public static void quickSort(int[] nums,int legnth){

    }

    public static int partition(int[] nums,int low,int high){
        int temp=nums[low];
        while (low<high){
            while(nums[high]>=temp){
                high--;
            }
            if(nums[high]<temp){
                nums[low]=nums[high];
                low++;
            }
            while(nums[low]<=temp){
                low++;
            }
            if(nums[low]>temp){
                nums[high]=nums[low];
                high--;
            }
        }
        nums[low]=temp;
        return low;
    }

}
