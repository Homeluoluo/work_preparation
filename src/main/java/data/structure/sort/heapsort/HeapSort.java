package data.structure.sort.heapsort;

/**
 * @Classname HeapSort
 * @Description TODO
 * @Date 2019/4/23 23:46
 * @Created by luojia
 */
public class HeapSort {
    public static int heapsize=0;
    public static void main(String[] args) {
        int[] nums={0,52,6,5,79,55,24,15,36,16,62,6,38};
        heapsize=nums.length-1;
       /* nums=initialHeap(nums);
        for (int i = 0; i <nums.length ; i++) {
            System.out.print(nums[i]+" ");
        }
        System.out.println();
        nums=deleteTop(nums);
        for (int i = 0; i <nums.length ; i++) {
            System.out.print(nums[i]+" ");
        }
        System.out.println();*/
        nums=heapSort(nums);
        for (int i = 0; i <nums.length ; i++) {
            System.out.print(nums[i]+" ");
        }
    }

    public static int[] initialHeap(int[] nums){
        for (int i = heapsize/2; i > 0; i--) {
            //下标为0的位置用来暂存遍历过程中的根节点
            nums[0]=nums[i];
            int son=2*i;
            while (son<=heapsize){
//                使son指向孩子中较大的节点下标
                if (son<heapsize&&nums[son+1]>nums[son]){
                    son++;
                }
//                根节点大于较大的孩子节点，则结束循环
                if(nums[0]>nums[son]){
                    break;
                }
//              否则,将较大的孩子节点上移到根节点
                nums[son/2]=nums[son];
                son=son*2;//son下移一层
            }
            nums[son/2]=nums[0];
        }
        return nums;
    }

    public static int[] deleteTop(int[] nums){
        nums[0]=nums[heapsize];
        nums[heapsize]=nums[1];
        int son=2;
        //        从上到下调整堆
        while(son<=heapsize){
            if(son<heapsize&&nums[son+1]>nums[son]){
                son++;
            }
            if(nums[0]>=nums[son]){
                break;
            }
            nums[son/2]=nums[son];//大孩子上移
            son=son*2;
        }
        nums[son/2]=nums[0];
        heapsize--;
        return nums;
    }

    public static int[] heapSort(int[] nums){
        nums=initialHeap(nums);
        while (heapsize>0){
            nums=deleteTop(nums);
        }
        return nums;
    }
}
