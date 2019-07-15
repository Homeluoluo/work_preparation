package leetcode;

public class MedianSortedArrays {
//    复杂度：O（m+n）
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        int i=0,j=0;
        int[] all=new int[m+n];
        while(i<m&&j<n){
            if(nums1[i]<nums2[j]){
                all[i+j]=nums1[i];
                i++;
            }else{
                all[i+j]=nums2[j];
                j++;
            }

        }
        if(i<m){
            for(int k=i+j;k<m+n;k++){
                all[k]=nums1[i];
                i++;
            }
        }
        if(j<n){
            for(int k=i+j;k<m+n;k++){
                all[k]=nums2[j];
                j++;
            }
        }
        if((m+n)%2==0){
            return ((double) all[(m+n)/2]+(double) all[(m+n)/2-1])/2;
        }else{
            return all[(m+n)/2];
        }
    }


    public static double findMedianSortedArrays3(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j-1] > A[i]){
                iMin = i + 1; // i is too small
            }
            else if (i > iMin && A[i-1] > B[j]) {
                iMax = i - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

    public static void main(String args[]){
        int[] nums1=new int[]{1,3};
        int[] nums2=new int[]{2};
        System.out.println(findMedianSortedArrays3(nums1,nums2));

    }
}
