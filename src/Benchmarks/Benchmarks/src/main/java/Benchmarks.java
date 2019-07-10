import Benchmarks.ForVsForeach;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@SuppressWarnings({"unchecked"})
public class Benchmarks {
    /**
     * Method that runs the benchmark. Comment the 'include' call for the
     * previous benchmark and include yours in order to run.
     *
     * Author: scamilo
     *
     * @param args
     * @throws RunnerException
     */
    public static void main(String[] args) throws RunnerException{
        Options opt = new OptionsBuilder()
                .include(ForVsForeach.class.getSimpleName())
                //.include(<YOUR CLASS HERE>.class.getSimpleName())
                .forks(1)
                .warmupIterations(1)
                .measurementIterations(1)
                .build();

        new Runner(opt).run();
    }

}
