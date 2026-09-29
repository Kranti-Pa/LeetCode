class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int cnt=0,mx=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                cnt++;
                mx=Math.max(mx,cnt);
            }else{
                cnt=0;
            }
        }return mx;       
    }
}