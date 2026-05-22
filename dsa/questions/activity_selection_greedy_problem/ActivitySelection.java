import java.util.*;

class Solution {
    public int activitySelection(int[] start, int[] finish) {
        int n = start.length;
        int[][]meetings = new int[n][2];
        
        for(int i=0;i<n;i++){
            int[]meeting = meetings[i];
            meeting[0] = start[i];
            meeting[1] = finish[i];
        }
        
        Arrays.sort(meetings, (a,b)->a[1]-b[1]); // Sort by finish time
        
        int totalMeetings = 0;
        int lastMeetingEnded = -1;
        
        for(int i=0;i<n;i++){
            if(meetings[i][0]>lastMeetingEnded){
                lastMeetingEnded = meetings[i][1];
                totalMeetings++;
            }
        }
        
        return totalMeetings;
    }
}

public class ActivitySelection {
    public static void main(String[] args) {
      Solution solution = new Solution();
      int totalMeetings = solution.activitySelection(new int[]{1, 3, 0, 5, 8, 5},new int[]{2, 4, 6, 7, 9, 9});
      System.out.println(totalMeetings);
    }
}
