package Benchmarks;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
public class ForVsForeach {

    volatile List<TestObject> ListA;
    volatile List<TestObject> ListB;

    @Param({"10", "200"})
    public int Size;

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(ForVsForeach.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }

    @Benchmark
    @BenchmarkMode({Mode.AverageTime, Mode.SingleShotTime, Mode.Throughput})
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void UsingWhile(){
        int i = 0;
        while (i < Size){
            int j = 0;
            while (j < Size){
                if (ListA.get(i).getP1() == ListB.get(j).getP1()) {
                    ListA.get(i).setP2(ListB.get(j).getP2());
                    break;
                }
                j++;
            }
            i++;
        }
    }

    @Benchmark
    @BenchmarkMode({Mode.AverageTime, Mode.SingleShotTime, Mode.Throughput})
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void UsingFor(){
        for (int i = 0; i < Size; i++) {
            for (int j = 0; j < Size; j++) {
                if (ListA.get(i).getP1() == ListB.get(j).getP1()) {
                    ListA.get(i).setP2(ListB.get(j).getP2());
                    break;
                }
            }
        }
    }

    @Benchmark
    @BenchmarkMode({Mode.AverageTime, Mode.SingleShotTime, Mode.Throughput})
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void UsingForeach(){
        for (TestObject t1 : ListA) {
            for (TestObject t2: ListB) {
                if(t1.getP1() == t2.getP2()){
                    t1.setP2(t2.getP2());
                    break;
                }
            }
        }
    }

    @Setup(Level.Invocation)
    public void Setup(){
        ListA = new ArrayList<TestObject>();
        ListB = new ArrayList<TestObject>();

        Random rn = new Random();
        int count = 1;

        while(count <= Size){
            int n = rn.nextInt(Size);

            TestObject t = new TestObject();
            t.setP1(count);

            if(ListA.contains(t)){
                continue;
            }

            ListA.add(t);
            count++;

        }

        count = 1;

        while(count <= Size){
            int n = rn.nextInt(Size);

            TestObject t = new TestObject();
            t.setP1(count);

            if(ListB.contains(t)){
                continue;
            }

            ListB.add(t);
            count++;
        }
    }


    public class TestObject{
        private int P1;
        private int P2;

        public int getP1() {
            return P1;
        }

        public void setP1(int p1) {
            P1 = p1;
        }

        public int getP2() {
            return P2;
        }

        public void setP2(int p2) {
            P2 = p2;
        }
    }
}
