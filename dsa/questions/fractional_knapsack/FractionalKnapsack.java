import java.util.*;

class Solution {
    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        int n = val.length;
        int[][]items = new int[n][2];
        for(int i=0;i<n;i++){
            int[]item = items[i];
            item[0] = val[i];
            item[1] = wt[i];
        }
        
        // val should be max and weight should be min, so the combo val/wt
        /*
        
        val1  _   val2 
        wt1       wt2
        
        this will give val in ascending just reverse it 
        
        val2. _.  val1
        wt2        wt1
        Simplify,
        (val2 * wt1 - val1 * wt2)
        
        */
        
        Arrays.sort(items, (item1,item2)->item2[0]*item1[1]-item1[0]*item2[1]);
        
        double total = 0;
        
        for(int i=0;i<n;i++){
            int itemCap = items[i][1];
            int itemVal = items[i][0];
            
            if(capacity>itemCap){
               capacity -= itemCap;
               total += itemVal;
            }else{
                double fraction = (double)((double)capacity/(double)itemCap);
                total += fraction * itemVal;
                break;
            }
        
        }
        return total;
        
    }
}

public class FractionalKnapsack {
    public static void main(String[] args) {
      Solution solution = new Solution();
      double total = solution.fractionalKnapsack(new int[]{60, 100, 120},new int[]{10, 20, 30},50);
      
      System.out.println(total);
    }
}
