# Benchmarks-Java

Benchmarks for Java

JMH documentation: https://openjdk.java.net/projects/code-tools/jmh/

Fork this repository, create your benchmark, add the results to this file and send a Pull Request.

Brief about Benchmark MODES:

- Mode.Throughput:    Calculate number of operations in a time unit.

- Mode.AverageTime:   Calculate an average running time.

- Mode.SampleTime:    Calculate how long does it take for a method to run
(including percentiles). 

- Mode.SingleShotTime:    Just runs a method
once (useful for cold-testing mode).


## For vs Foreach vs While - Iteração, comparação e alteração entre listas (scamilo77)

```
Benchmark                             (Size)   Mode  Cnt     Score   Error   Units
Benchmarks.ForVsForeach.UsingFor          10  thrpt       3230,613          ops/ms
Benchmarks.ForVsForeach.UsingFor         200  thrpt         11,018          ops/ms
Benchmarks.ForVsForeach.UsingForeach      10  thrpt       5227,024          ops/ms
Benchmarks.ForVsForeach.UsingForeach     200  thrpt         26,530          ops/ms
Benchmarks.ForVsForeach.UsingWhile        10  thrpt       3197,602          ops/ms
Benchmarks.ForVsForeach.UsingWhile       200  thrpt         11,180          ops/ms
Benchmarks.ForVsForeach.UsingFor          10   avgt         ≈ 10⁻⁴           ms/op
Benchmarks.ForVsForeach.UsingFor         200   avgt          0,088           ms/op
Benchmarks.ForVsForeach.UsingForeach      10   avgt         ≈ 10⁻⁴           ms/op
Benchmarks.ForVsForeach.UsingForeach     200   avgt          0,038           ms/op
Benchmarks.ForVsForeach.UsingWhile        10   avgt         ≈ 10⁻⁴           ms/op
Benchmarks.ForVsForeach.UsingWhile       200   avgt          0,078           ms/op
Benchmarks.ForVsForeach.UsingFor          10     ss          0,026           ms/op
Benchmarks.ForVsForeach.UsingFor         200     ss          2,498           ms/op
Benchmarks.ForVsForeach.UsingForeach      10     ss          0,037           ms/op
Benchmarks.ForVsForeach.UsingForeach     200     ss          3,229           ms/op
Benchmarks.ForVsForeach.UsingWhile        10     ss          0,020           ms/op
Benchmarks.ForVsForeach.UsingWhile       200     ss          2,576           ms/op
```

