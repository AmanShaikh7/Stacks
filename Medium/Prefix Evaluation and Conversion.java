import java.util.*;
  
public class Main{
  
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str=scn.nextLine();
        valueOfExpression(str);

    }
	public static int operations(int a,int b,char op){
		if(op=='+'){
			return a+b;
		}else if(op=='-'){
			return a-b;
		}else if(op =='*'){
			return a*b;
		}else if(op=='/'){
			return a/b;
		}
		return -1;
	}
    public static void valueOfExpression(String str)
    {
        Stack<Integer> eval = new Stack<>();
        Stack<String> infix = new Stack<>();
		Stack<String> postfix = new Stack<>();

		for(int i=str.length()-1;i>=0;i--){
			char ch = str.charAt(i);
			if(Character.isDigit(ch)==true){
				eval.push(ch-'0'); // convert the char in int and store
				infix.push(ch+"");
				postfix.push(ch+"");
				
			}else{
				int val1 = eval.pop();
				int val2 = eval.pop();
				int ans =operations(val1,val2,ch);
				eval.push(ans); 

				String in1 = infix.pop();
				String in2 = infix.pop();
				String ians ="("+in1+ch+in2+")";
				infix.push(ians);

				String po1 = postfix.pop();
				String po2 = postfix.pop();
				String pans = po1+po2+ch;
				postfix.push(pans);
			}
			
		}
		while(eval.size()!=0){
			System.out.println(eval.pop());
		}
		while(infix.size()!=0){
			System.out.println(infix.pop());
		}
		while(postfix.size()!=0){
			System.out.println(postfix.pop());
		}
    }
}