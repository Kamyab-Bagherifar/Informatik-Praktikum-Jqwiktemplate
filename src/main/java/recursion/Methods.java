package recursion;

public class Methods {
  static int add(int x, int y){
    return y == 0
            ? x
            : add(++x,--y);
  }

}

