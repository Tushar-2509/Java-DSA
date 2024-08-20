public class str_subseq {
    static int recursive(String str1,String str2,int n1,int n2){
        if(n1<0||n2<0){
            return 0;
        }
        else if(str1.charAt(n1)==str2.charAt(n2)){
            return 1+recursive(str1,str2,n1-1,n2-1);
        }
        return Math.max(recursive(str1,str2,n1-1,n2-1),recursive(str1,str2,n1-1,n2-1));
    }
    static int dynamic(String str1,String str2,int n1,int n2) {
        int dp[][]=new int[n1+1][n2+1];

        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n1][n2];
    }
    public static void main(String[] args) {
        String str1="ABC";
        String str2="ACD";
        int n1=str1.length();
        int n2=str2.length();

        System.out.println("len "+dynamic(str1, str2, n1, n2));
    }
}
