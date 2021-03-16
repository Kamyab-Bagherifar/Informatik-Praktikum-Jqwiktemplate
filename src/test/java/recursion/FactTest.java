package recursion;
import net.jqwik.api.*;
import static recursion.Methods.fact;
import org.assertj.core.api.Assertions;
import static org.assertj.core.api.Assertions.*;
public class FactTest  {
  @Example
  void exampleTest() {
    assertThat(fact(12) == 479001600);
    assertThat(fact(0) == 1);

  }
    @Data
    Iterable<? extends Tuple.Tuple2<Integer, Integer>> preStored() {
        return Table.of(
                Tuple.of(0, 1), Tuple.of(1, 1), Tuple.of(2, 2), Tuple.of(3, 6), Tuple.of(4, 24),
                Tuple.of(5, 120), Tuple.of(6, 720), Tuple.of(7, 5040), Tuple.of(8, 40320), Tuple.of(9, 362880)
        );
    }
    @Property
    @FromData("preStored")
    void dataTest(@ForAll int n,@ForAll int result){
      assertThat(fact(n) == result);
    }
}


