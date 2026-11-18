class Solution {
public:
    int func(int i,int amount,vector<int>& coins,vector<vector<int>>& dp){
        if(amount==0)return 1;
        if(i==0)return 0;
        if(dp[i][amount]!=-1)return dp[i][amount];
        int notTake=func(i-1,amount,coins,dp);
        int take=0;
        if(coins[i-1]<=amount){
            take=func(i,amount-coins[i-1],coins,dp);
        }
        return dp[i][amount]=take+notTake; 
    }
    int change(int amount, vector<int>& coins) {
        int n=coins.size();
        vector<vector<int>> dp(n+1,vector<int>(amount+1,-1));
        return func(n,amount,coins,dp);
        //TABULATION
        // vector<int> dp(amount+1,0);
        // dp[0]=1;
        // for(int coin:coins){
        //     for(int i=coin;i<=amount;i++){
        //         dp[i]+=dp[i-coin];
        //     }
        // }
        // return dp[amount];       
    }
};