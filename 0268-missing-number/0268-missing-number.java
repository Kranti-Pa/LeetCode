class Solution {
    public int missingNumber(int[] nums) {
        //Brute Force Approach T.C=O(n^2)
        // int N=nums.length;
        // for(int i=1;i<=N;i++){
        //     int flag=0;
        //     for(int j=0;j<N;j++){
        //         if(i==nums[j]) flag=1;
        //     }
        //     if(flag==0) return i;
        // }
        // return -1;

        //Alternative - Hashing- O(2n)
        // int n=nums.length;
        // int[] hash=new int[n+1];
        // for(int el:nums){
        //     hash[el]=1;
        // }
        // for(int i=1;i<=n;i++){
        //     if(hash[i]==0)return i;
        // }
        //return -1;

        //Optimal Appraoch-Using Sum formula
        // int N=nums.length,s=0;
        // int sum=N*(N+1)/2;//----Might cause Overflow,need to use long int
        // for(int el:nums)s+=el;
        // return sum-s;

        //Using XOR 
        // int xor1=0,xor2=0,n=nums.length;
        // for(int i=1;i<=n;i++){
        //     xor1^=i;
        // }
        // for(int i=0;i<n;i++){
        //     xor2^=nums[i];
        // }
        // return xor1^xor2;
        int xor1=0,xor2=0,N=nums.length;
    
        for(int i=0;i<=N-1;i++){
            xor2^=nums[i];
            xor1^=(i+1);
        }
        return xor1^xor2;
     }
}