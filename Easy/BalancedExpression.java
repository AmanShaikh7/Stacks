import java.io.*;
import java.util.*;

class Solution{
    boolean expBalanced(String str){
       Stack<Character> st = new Stack<>();
		for(int i=0;i<str.length();i++){
			char ch = str.charAt(i);
			if(ch=='(' || ch=='{' || ch=='['){
				st.push(ch);
				continue;
			}
			if (st.isEmpty())
                return false;
			if(ch==')') 
				// if(st.peek() == '{' || st.peek()='['){
				// 	return false;
				// }else{
				// 	st.pop();
				// }
				{if(st.peek()=='('){
					st.pop();
					continue;
				}else{
					return false;
				}}
			
		
		if(ch=='}')
				{if(st.peek()=='{'){
					st.pop();
					continue;
				}else{
					return false;
				}}
				
			
			if(ch==']')
				{if(st.peek()=='['){
					st.pop();
					continue;
				}else{
					return false;
				}}
			
				
	    }
		return (st.empty());
	}
	}
	

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Solution Obj = new Solution();
        System.out.println(Obj.expBalanced(str));
    }
}