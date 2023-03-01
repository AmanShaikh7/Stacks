import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = sc.next();
    sc.close();
    System.out.println(reverseParentheses(s));
  }

	public static void reverse(char arr[],int l , int h){
		if(l<h){
			char ch = arr[l];
			arr[l] = arr[h];
			arr[h] = ch;
			reverse(arr,l+1,h-1);
		}
	}
  public static String reverseParentheses(String s) {
    // your code here
	  Stack<Integer> st = new Stack<>();
	  for(int i=0;i<s.length();i++){
		  if(s.charAt(i) == '('){
			  st.push(i);
		  }
		  else if ( s.charAt(i)==')'){
			  char arr[] = s.toCharArray();
			  reverse(arr,st.peek()+1,i);
			  s = String.copyValueOf(arr);
			  st.pop();
		  }
	  }
	  String ans ="";
	  for(int i=0;i<s.length();i++){
		  if(s.charAt(i)!='(' && s.charAt(i)!=')'){
			  ans+= s.charAt(i);
		  }
	  }
	  return ans;
  }
}