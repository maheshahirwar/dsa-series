//Couting Approach
class Solution {
    public void sortColors(int[] nums) {
        int zero =0, one=0,two=0;
        for(int num:nums){
            if(num==0)zero++;
            else if(num==1)one++;
            else two++;
        }
        for(int i=0;i<nums.length;i++){
            if(zero>0){
                nums[i]=0;
                zero--;
            }
            else if(one>0){
                nums[i]=1;
                one--;
            }
            else nums[i]=2;
        }
    }
}


//Ductch national flag algo
class Solution {
    public void sortColors(int[] nums) {
        int low=0,mid=0,high=nums.length-1;
        while(mid<=high){
            if(nums[mid]==0)swap(low++,mid++,nums);
            else if(nums[mid]==2)swap(high--,mid,nums);
            else mid++;
        }
    }
    public void swap(int i, int j, int[]arr){
        arr[i] = (arr[i]+arr[j])-(arr[j]=arr[i]);
    }
}
