package recursion;

import net.jqwik.api.*;

import static recursion.Methods.binomialkoeffizient;

import net.jqwik.api.constraints.IntRange;


public class BinomTest {
    @Example
    boolean exampleTest() {
        return binomialkoeffizient(12,6) == 924 && binomialkoeffizient(4,3) == 4;


    }

    @Data
    Iterable<? extends Tuple.Tuple3<Integer, Integer, Integer>> preStored() {
        return Table.of(
                Tuple.of(12, 6, 924), Tuple.of(4, 3, 4), Tuple.of(2, 1, 2), Tuple.of(2, 2, 1), Tuple.of(12, 4, 495),
                Tuple.of(8, 6, 28), Tuple.of(10, 6, 210)
        );
    }

    @Property
    @FromData("preStored")
    boolean dataTest(@ForAll int n, @ForAll int k, @ForAll int result) {
        return (binomialkoeffizient(n,k)) == (result);
    }

    @Property(tries = 1000)
    boolean test1(@ForAll @IntRange(min = 0, max = 100000) int n){
        return binomialkoeffizient(n,0) == 1;
    }
    @Property(tries = 1000)
    boolean test2(@ForAll @IntRange(min = 0, max = 10000) int n){
        return binomialkoeffizient(n,n) == 1;
    }
    @Property(tries = 1000)
    boolean test3(@ForAll @IntRange(min = 0, max = 100000) int n){
        return binomialkoeffizient(n,1) == n;
    }
    @Property(tries = 2000)
    boolean test4(@ForAll @IntRange(min = 0, max = 25) int n, @ForAll @IntRange(min = 0, max = 25) int k ){
        if( n >= k){
            return binomialkoeffizient(n,k) == binomialkoeffizient(n, n-k);

        }else{
            return binomialkoeffizient(k,n) == binomialkoeffizient(k, k-n);
        }

        }

    @Property(tries = 1000)
    boolean test5(@ForAll @IntRange(min = 1, max = 30) int n, @ForAll @IntRange(min = 1, max = 30) int k) {
        return Methods.binomialkoeffizient(n, k) ==
                (int) ((double)(Methods.binomialkoeffizient(n - 1,k - 1)) * (double)n / k);
    }


    @Property(tries = 2000)
    boolean test6(@ForAll @IntRange(min = 1, max = 30) int n, @ForAll @IntRange(min = 1, max = 30) int k,
                  @ForAll @IntRange(min = 1, max = 30) int h){
        if( n-k > h && n-h > k){
            return binomialkoeffizient(n,h) * binomialkoeffizient(n-h,k) == binomialkoeffizient(n,k) * binomialkoeffizient(n-k,h);
        }else {
            return true;
        }


    }




}

















