package recursion;

import net.jqwik.api.*;

import static recursion.Methods.ggT;

import net.jqwik.api.constraints.IntRange;


public class GgtTest {
    @Example
    boolean exampleTest() {
        return ggT(12,6) == 6 && ggT(1,0) == 1;

    }

    @Data
    Iterable<? extends Tuple.Tuple3<Integer, Integer, Integer>> preStored() {
        return Table.of(
                Tuple.of(0, 1, 1), Tuple.of(12, 6, 6), Tuple.of(2, 2, 2), Tuple.of(12, 4, 4),
                Tuple.of(8, 6, 2), Tuple.of(18, 6, 6)
        );
    }

    @Property
    @FromData("preStored")
    boolean dataTest(@ForAll int a, @ForAll int b, @ForAll int result) {
        return (ggT(a,b)) == (result);
    }

    @Property(tries = 1000)
    boolean idempotenzgesetz(@ForAll @IntRange(min = 0, max = 100000) int a){
        return ggT(a,a) == a;
    }
    @Property(tries = 1000)
    boolean neutralesElement(@ForAll @IntRange(min = 0, max = 100000) int a){
        return ggT(a,0) == a;
    }
    @Property(tries = 1000)
    boolean absorbierendesElement(@ForAll @IntRange(min = 0, max = 100000) int a){
        return ggT(a,1) == 1;
    }
    @Property(tries = 1000)
    boolean kommutattivgesetz(@ForAll @IntRange(min = 0, max = 100000) int a,
                              @ForAll @IntRange(min = 0, max = 100000) int b){
        return ggT(a,b) == ggT(b,a);
    }
    @Property(tries = 1000)
    boolean assoziativgesetz(@ForAll @IntRange(min = 0, max = 100000) int a,
                              @ForAll @IntRange(min = 0, max = 100000) int b,
                             @ForAll @IntRange(min = 0, max = 100000) int c){
        return ggT(a,ggT(b,c)) == ggT(ggT(a,b),c);
    }
    @Property(tries = 1000)
    boolean disitributibgesetz(@ForAll @IntRange(min = 0, max = 10000) int a,
                              @ForAll @IntRange(min = 0, max = 10000) int b,
                               @ForAll @IntRange(min = 0, max = 10000) int m){
        return ggT(m*a,m*b) == m*ggT(b,a);
    }
    @Property(tries = 1000)
    boolean lastTest(@ForAll @IntRange(min = 0, max = 10000) int a, @ForAll @IntRange(min = 0, max = 10000) int b){
        if(a > b){
            return ggT(a,b) == ggT(a-b,b);
        }else{
            return ggT(a,b) == ggT(a,b-a);
        }
    }







}



