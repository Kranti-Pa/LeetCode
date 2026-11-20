class Solution {
public:
//MEMOIZATION APPROACH - T.C=O(n²) S.C=O(N²)+O(N)
    int func(int idx,int prev,vector<int>& nums,vector<vector<int>>& dp){
        int n=nums.size();
        if(idx==n)return 0;
        if(dp[idx][prev+1]!=-1)return dp[idx][prev+1];
        int notTake=0+func(idx+1,prev,nums,dp);
        int take=0;
        if(prev==-1 || nums[idx]>nums[prev])
        take=1+func(idx+1,idx,nums,dp);
        return dp[idx][prev+1]=max(take,notTake);//prev+1 for co-ordinate change
    }
    // int lengthOfLIS(vector<int>& nums) {
    //     int n=nums.size();
    //     vector<vector<int>> dp(n,vector<int>(n+1,-1));
    //     return func(0,-1,nums,dp);       
    // }

//TABULATION APPROACH - T.C=O(n²) S.C=0(N)
    // int lengthOfLIS(vector<int>& nums){
    //     int n=nums.size();
    //     vector<int> dp(n,1);//Initially everyone assigned with length 1
    //     int mx=1;
    //     for(int i=0;i<n;i++){
    //         for(int prev=0;prev<i;prev++){
    //             if(nums[prev]<nums[i])
    //               dp[i]=max(dp[i],1+dp[prev]);
    //         }
    //         mx=max(mx,dp[i]);
    //     }
    //     return mx;
    // }

//BINARY SEARCH APPROACH
      int lengthOfLIS(vector<int>& nums){
        int n=nums.size();
        vector<int> temp;
        temp.push_back(nums[0]);
        for(int i=1;i<n;i++){
            if(nums[i]>temp.back())
               temp.push_back(nums[i]);
            else{
                int idx=lower_bound(temp.begin(),temp.end(),nums[i])-temp.begin();
                temp[idx]=nums[i];
            }
        }
        return temp.size();
      }
 };