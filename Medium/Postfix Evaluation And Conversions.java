import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();
    Solution ob =new Solution();
    ob.evaluation(exp);
  }
}

class Solution{
	public int operation(int a,int b,char c){
		if(c=='+') return a+b;
		else if(c=='-') return a-b;
		else if(c=='*') return a*b;
		else if(c=='/') return a/b;
		else return -1;
	}
    public void evaluation(String exp){
        Stack<Integer> eval = new Stack<>();
		Stack<String> infix = new Stack<>();
		Stack<String> prefix = new Stack<>();
		// start travelling string from front as it is post fix
		// operand operand operator
		for(int i=0;i<exp.length();i++){
			char ch = exp.charAt(i);
			if(Character.isDigit(ch)==true){
				eval.push(ch-'0');
				infix.push(ch+"");
				prefix.push(ch+"");
			}else{
				// it is a operator
				int val2 = eval.pop();
				int val1 = eval.pop();
				int ans = operation(val1,val2,ch);
				eval.push(ans);

				String ival2 = infix.pop();
				String ival1 = infix.pop();
				String ians = "(" + ival1 + ch + ival2 + ")";
				infix.push(ians);

				String pval2 = prefix.pop();
				String pval1 = prefix.pop();
				String pans = ch + pval1 + pval2;
				prefix.push(pans);
			}
		}
		
			System.out.println(eval.peek());
			System.out.println(infix.peek());
			System.out.println(prefix.peek());
		
    }
}                         