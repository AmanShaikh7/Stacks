
class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new         
    InputStreamReader(System.in));
    String str = br.readLine();
    Solution Obj = new Solution();
    System.out.print(Obj.smallestNumber(str));
  }
}