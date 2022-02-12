import java.util.ArrayList;
import java.util.Arrays;

public class ExtraCredit1 {

//    LeetCode 88
//    You are given two integer arrays nums1 and nums2, sorted in non-decreasing order,
//    and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
//
//    Merge nums1 and nums2 into a single array sorted in non-decreasing order.
//
//    The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
//    To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged,
//    and the last n elements are set to 0 and should be ignored. nums2 has a length of n.n

    public void mergeSortedArray88(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1Temp = new int[m];

        for (int k = 0; k < m; k++){
            nums1Temp[k] = nums1[k];
        }

        int i = 0;
        int j = 0;
        int p = 0;

        while(p < m+n){
            if(i >= m) {
                nums1[p] = nums2[j];
                p++;
                j++;
            } else if (j >= n){
                nums1[p] = nums1Temp[i];
                p++;
                i++;
            } else {
                if (nums1Temp[i] < nums2[j]) {
                    nums1[p] = nums1Temp[i];
                    i++;
                } else {
                    nums1[p] = nums2[j];
                    j++;
                }
                p++;
            }
        }
    }

//    LeetCode 905
//    Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.
//    Return any array that satisfies this condition.

    public int[] sortArrayByParity905(int[] nums) {
        int[] result = new int[nums.length];

        int k = 0;

        while (k < result.length){
            for(int num: nums){
                if (num % 2 == 0){
                    result[k] = num;
                    k++;
                }
            }
            for(int num: nums){
                if (num % 2 == 1){
                    result[k] = num;
                    k++;
                }
            }

        }
        return result;
    }


//    LeetCode 1122
//    Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
//
//    Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.
//    Elements that do not appear in arr2 should be placed at the end of arr1 in ascending order.

    public int[] relativeSortArray1122(int[] arr1, int[] arr2) {
        ArrayList<Integer> AL1 = new ArrayList<>();
        ArrayList<Integer> AL2 = new ArrayList<>();

        for (int i = 0; i < arr2.length; i++){
            AL2.add(arr2[i]);
            for (int j = 0; j < arr1.length; j++){
                if (arr1[j] == arr2[i]){
                    AL1.add(arr2[i]);
                }
            }
        }

        Arrays.sort(arr1);
        for (int num: arr1){
            if (!AL2.contains(num)){
                AL1.add(num);
            }
        }

        int[] result = new int[AL1.size()];
        int k = 0;
        for (int element: AL1){
            result[k] = element;
            k++;
        }

        return result;

    }

}
