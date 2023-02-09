import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    
	public static void main (String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
        long n = Long.parseLong(br.readLine().trim());
        String inputLine[] = br.readLine().trim().split(" ");
        long[] arr = new long[(int)n];
        for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
        System.out.println(new Solution().maximumArea(arr, n));
	}
}

class Solution
{
	public static int[] getNSTLI(long arr[]){
        Stack<Integer> st = new Stack<>();
        int ans[] = new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            while(st.size()>0 && arr[i] < arr[st.peek()] ){
                ans[st.peek()] = i;
                st.pop();
            }
            st.push(i);
        }
        while(st.size() >0){
            ans[st.peek()] = -1;
            st.pop();
        }
        return ans;
    }
    public static int[] getNSTRI(long arr[]){
         Stack<Integer> st = new Stack<>();
        int ans[] = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            while(st.size()>0 && arr[i] < arr[st.peek()] ){
                ans[st.peek()] = i;
                st.pop();
            }
            st.push(i);
        }
        while(st.size() >0){
            ans[st.peek()] = arr.length;
            st.pop();
        }
        return ans;
    }
      public static long maximumArea(long hist[], long n){
		 long OverAllMax =0;
        int NSTLI[] = getNSTLI(hist); // this will give me all the index for NSTL
        int NSTRI[] = getNSTRI(hist);
        for(int i=0;i<hist.length;i++){
            int width = NSTRI[i]-NSTLI[i]-1;
            long  height = hist[i];
            long  area = width*height;
            OverAllMax = Math.max(OverAllMax,area);
        }
        return OverAllMax;
    }
}



