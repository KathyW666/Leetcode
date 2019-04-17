import java.util.Arrays;

public class Leetcode_41 {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) continue;
            else if (nums[i] != 1) return 1;
            else {
                for (int j = i; j < nums.length - 1; j++) {
                    if (nums[j+1] - nums[j] > 1) return nums[j]+1;
                }
                break;
            }
        }
        return nums[nums.length - 1] + 1;
    }

    //另一种思路
    //public int firstMissingPositive(int[] A) {
    //        int i = 0;
    //        while(i < A.length){
    //            if(A[i] == i+1 || A[i] <= 0 || A[i] > A.length) i++;
    //            else if(A[A[i]-1] != A[i]) swap(A, i, A[i]-1);
    //            else i++;
    //        }
    //        i = 0;
    //        while(i < A.length && A[i] == i+1) i++;
    //        return i+1;
    //    }
    //
    //    private void swap(int[] A, int i, int j){
    //        int temp = A[i];
    //        A[i] = A[j];
    //        A[j] = temp;
    //    }

    public static void main(String[] args) {
        Leetcode_41 o = new Leetcode_41();
        int[] nums = new int[]{0,2,2,1,1};
        System.out.println(o.firstMissingPositive(nums));

    }
}
