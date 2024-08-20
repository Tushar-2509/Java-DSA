public class fibo_dynamic {
    int fibo_dyn(int n,int arr[]){
        if(arr[n]!=0){
            return arr[n];
        }
        else if(n==0){
            return 0;
        }
        else if(n==1){
            return 1;
        }
        else{
            int fib_val=fibo_dyn(n-1,arr)+fibo_dyn(n-2,arr);
            arr[n]=fib_val;
            return fib_val;
        }
    }
    int fibo_bottomup(int n,int arr1[]){
        if(n>1){
            arr1[1]=1;
        }
        for(int i=2;i<n;i++){
            arr1[i]=arr1[i-1]+arr1[i-2];
        }
        return arr1[n-1];
    }
    public static void main(String[] args) {
        fibo_dynamic obj=new fibo_dynamic();
        int n=7;
        int arr[]=new int[n+1];
        int arr1[]=new int[n+1];
        System.out.println("Fibonacci series using dynamic programming ....."+obj.fibo_dyn(n-1, arr));
        System.out.println();
        System.out.println("Fibonacci using bottom up :"+obj.fibo_bottomup(n, arr1));

    }
}
