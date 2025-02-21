// -2, 1, -3, 4, -1, 2, 1, -5, 4
//        p1. p2
// maxSum: 
// sum: 

class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 1) return nums[0];

        int p1 = 0;
        int p2 = 0;
        int sum = 0;
        int maxSum = -100000;
        // iterate with my pointers
        while(p2 < nums.length) {
            sum += nums[p2];
            maxSum = Math.max(maxSum, sum);
            
            // System.out.println(p1 + " " + p2 + " " + sum);
            // if sum < 0, move p1++
            if(sum < 0) {
                p1 = p2+1;  // nums[1]
                p2 = p1;  // nums[2]
                if(p1 >= nums.length) {
                    break;
                }
                sum = 0;
            }
            else {
                maxSum = Math.max(maxSum, sum);
                p2++;
            }

        }
        return maxSum;
        
    }
}