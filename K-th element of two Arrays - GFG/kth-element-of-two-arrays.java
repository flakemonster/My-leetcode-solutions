//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(stt.nextToken());
            int m = Integer.parseInt(stt.nextToken());
            int k = Integer.parseInt(stt.nextToken());
            int a[] = new int[(int)(n)];
            int b[] = new int[(int)(m)];
            
            
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            String inputLine1[] = br.readLine().trim().split(" ");
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(inputLine1[i]);
            }
            
            
            Solution obj = new Solution();
            System.out.println(obj.kthElement( a, b, n, m, k));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    public long kthElement( int arr1[], int arr2[], int n, int m, int k) {
        
        if(n > m)
            return kthElement(arr2, arr1, m, n, k);
        
        int low = Math.max(0, k-m), high = Math.min(k, n);
        int left = k;
        int total = m+n;
        int mid1, l1, l2, r1, r2, mid2;
        
        while(low<=high) {
            mid1 = (high +low)/2;
            mid2 = left - mid1;
            l1 = Integer.MIN_VALUE;
            l2 = Integer.MIN_VALUE;
            r1 = Integer.MAX_VALUE;
            r2 = Integer.MAX_VALUE;
            
            if(mid1 < n) {
                r1 = arr1[mid1];
            }
            if(mid2 < m) {
                r2 = arr2[mid2];
            }
            if(mid1-1 >= 0) {
                l1 = arr1[mid1-1];
            }
            if(mid2-1 >= 0) {
                l2 = arr2[mid2-1];
            }
            
            if(l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            } else if(l1 > r2) {
                high = mid1-1;
            } else {
                low = mid1+1;
            }
        }
        return 0;
    }
}