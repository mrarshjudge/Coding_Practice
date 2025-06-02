package com.practice.in.java8;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;

public class InfosysToTreeMapCollector implements Collector<Infosys, TreeMap<String, Integer>, TreeMap<String, Integer>> {

    @Override
    public Supplier<TreeMap<String, Integer>> supplier() {
        return TreeMap::new;
    }

    @Override
    public BiConsumer<TreeMap<String, Integer>, Infosys> accumulator() {
        return (map, infosys) -> map.put(infosys.getCeoName(), infosys.getCapacity());
    }

    @Override
    public BinaryOperator<TreeMap<String, Integer>> combiner() {
        return (map1, map2) -> {
            map1.putAll(map2);
            return map1;
        };
    }

    @Override
    public Function<TreeMap<String, Integer>, TreeMap<String, Integer>> finisher() {
        return Function.identity(); // No transformation needed
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.singleton(Characteristics.IDENTITY_FINISH);
    }
}
