给一串数组，找到下一个大的数字， 123，132， 213， 231， 312， 321， 123

class Solution {
    public void nextPermutation(int[] nums) {
        //158476321->find 4 is the first that is not larger than its next
        //check all the number after 4 find the one that is just bigger than 4, switch two, and reverse the rest
        int i = nums.length-2;
        while (i >= 0 && nums[i] >= nums[i+1]) {
            i--;
        }
        if (i < 0) {
            reverse(0, nums);
            return;
        } else {
            for (int j = nums.length-1; j > i; j--) {
                if (nums[j] > nums[i]) {
                    swap(i, j, nums);
                    reverse(i+1, nums);
                    break;
                }
            }
        }
    }
    public void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    } 
    public void reverse(int i, int[] nums) {
        int start = i;
        int end = nums.length-1;
        while (start <= end){
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}  
