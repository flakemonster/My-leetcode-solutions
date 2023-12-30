//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S[] = read.readLine().split(" ");
            int R = Integer.parseInt(S[0]);
            int C = Integer.parseInt(S[1]);
            int matrix[][] = new int[R][C];
            int c = 0;
            for(int i = 0; i < R; i++){
                String line[]=read.readLine().trim().split(" ");
                for(int j = 0; j < C; j++){
                    matrix[i][j] = Integer.parseInt(line[j]);
                }
            }
            Solution ob = new Solution();
            int ans = ob.median(matrix, R, C);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int median(int matrix[][], int R, int C) {
        // code here
        int low = matrix[0][0];
        int high = matrix[R-1][C-1];
        
        for(int i=0; i<R; i++) {
            low = Math.min(low, matrix[i][0]);
        }
        
        for(int i=0; i<R; i++) {
            high = Math.max(high, matrix[i][C-1]);
        }
        //System.out.println("low = "+low+" high = "+high);
        
        int mid, smallEqualElements;
        int req = (R*C)/2;
        while(low<=high) {
            mid = low+(high-low)/2;
            smallEqualElements = countElementsSmallerOrEqual(matrix, mid);
            if(smallEqualElements <= req) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        
        return low;
    }
    
    int upperBound(int[] arr, int x) {
        int ans = 0;
        for(int i=0; i<arr.length; i++) {
            //System.out.println("row = "+i+" arr[i] = "+arr[i]);
            if(arr[i] <= x) {
                ans++;
            }
        }
        //System.out.println("upperbound for element "+x+" = "+ans);
        return ans;
    }
    
    int countElementsSmallerOrEqual(int matrix[][], int x) {
        int count = 0;
        
        for(int i=0; i<matrix.length; i++) {
            count += upperBound(matrix[i], x);
        }
        //System.out.println("count for elements <= "+x+" in matrix = "+count);
        return count;
    }
}