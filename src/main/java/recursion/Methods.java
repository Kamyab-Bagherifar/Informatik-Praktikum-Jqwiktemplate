package recursion;

public class Methods {
  static int add(int x, int y){
    return y == 0
            ? x
            : add(++x,--y);
  }

  static int collatz(int n) {
    if (n == 1) return 1;
    else if (n % 2 == 0) return collatz(n / 2);
    else return collatz(3*n + 1);
  }

  static int bad(int a, int b, int c, int d, int e, int f, int g){
    return 1;
  }
  static int fact(int n){
      if(n == 0 || n == 1){
          return 1;
      }else{
          return (n) * fact(n-1);
      }

  }
    static int ggT(int a, int b){
        if(a==b||b==0) return a;
        else return ggT(b,a%b);
    }
    public static int binomialkoeffizient(int n, int k) {
        if (n == k || k == 0) return 1;
        if (k == 1) return n;
        if (k > n || k < 0) return 0;
        return binomialkoeffizient(n - 1, k) + binomialkoeffizient(n - 1, k - 1);
    }

    static int fib(int n) {
        if (n==0) return 0;
        else if (n==1) return 1;
        else return fib(n-1) + fib(n-2);
    }



}





