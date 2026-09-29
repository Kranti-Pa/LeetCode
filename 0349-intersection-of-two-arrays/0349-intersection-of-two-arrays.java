import java.util.Vector;
import java.util.Arrays;
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        //Brute Force Approach-T.C=O(n^2)
        //Alternative 1

        // Arrays.sort(nums1);
        // Arrays.sort(nums2);
        // int n=nums1.length,m=nums2.length;
        // int vis[]=new int[m];
        // Vector<Integer> vec=new Vector<>();
        // for(int i=0;i<n;i++){
        //     if(i>0 && nums1[i]==nums1[i-1])continue;//skip duplicates
        //     for(int j=0;j<m;j++){
        //         if(nums1[i]==nums2[j] && vis[j]==0){
        //             vec.add(nums1[i]);
        //             vis[j]=1;
        //             break;
        //         }
        //         if(nums2[j]>nums1[i]) break;//if given arrays are sorted
        //     }
        // }

        //Alternative 2
        // int n=nums1.length,m=nums2.length;
        // int vis[]=new int[m];
        // Vector<Integer> vec=new Vector<>();//use it instead of vis
        // for(int i=0;i<n;i++){
        //     if(vec.contains(nums1[i])) continue;//skip duplicates
        //     for(int j=0;j<m;j++){
        //         if(nums1[i]==nums2[j]){
        //             vec.add(nums1[i]);
        //             break;
        //         }
        //     }
        // }
        // int[] arr = vec.stream().mapToInt(i -> i).toArray();
        // return arr;

        //Optimal Two Pointer Approach-T.C=O(n1+n2)
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> st=new HashSet<>();
        int n=nums1.length,m=nums2.length;
        int i=0,j=0;
        while(i<n && j<m){
            if(nums1[i]<nums2[j])i++;
            else if (nums1[i]>nums2[j])j++;
            else{
                st.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] arr=st.stream().mapToInt(x -> x).toArray();
        return arr;
    }
}