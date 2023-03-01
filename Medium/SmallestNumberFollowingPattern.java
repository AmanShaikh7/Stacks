
import java.util.Stack;


class Solution{
    public String smallestNumber(String str){
		String ans = "";
        Stack<Integer> st = new Stack<>();
		int no =1;
		for(int i=0;i<str.length();i++){
			char ch = str.charAt(i);
			if(ch =='d'){
				st.push(no);
				no++;
			}else{
				st.push(no);
				no++;
				while(st.size()>0){
					ans+=st.pop();
				}
			}
		}
		st.push(no);
		while(st.size()>0){
			ans+=st.pop();
		}
		return ans;
    }
}

/*public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    Solution Obj = new Solution();
    System.out.print(Obj.smallestNumber(str));
  }
}*/