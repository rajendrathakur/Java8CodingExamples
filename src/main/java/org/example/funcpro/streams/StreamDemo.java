package org.example.funcpro.streams;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {

    public static void main(String[] args) {

      List<Integer> list = List.of(1,2,4,6,3,8,5,9);
      Stream<Integer> stream1 = list.stream();

      Stream<Integer> stream2 = stream1.filter(n -> {
          System.out.println("Filter element : "+ n);
          return n%2 == 0;
      });

      Stream<Integer> stream3 = stream2.map(n -> {
          System.out.println("Map element : "+ n);
          return n+2;
      });

        stream3.forEach(System.out::println);

        System.out.println(" -------------  ");
        Stream<Integer> stream4 = list.stream();

        Stream<Integer> stream5 = stream4.map(n -> {
            System.out.println("Map element : "+ n);
            return n;
        });

        Stream<Integer> stream6 = stream5.sorted( (a,b) -> {
            System.out.println("Sorted elements : "+ a + " , " + b);
            return a.compareTo(b);
        });

        Stream<Integer> stream7 = stream6.map(n -> {
            System.out.println("Map element : "+ n);
            return n+2;
        });

        stream7.findFirst().ifPresent(System.out::println);

        System.out.println(" -------------  ");

        list.stream().map(n -> n/1)
                .sorted((a,b)-> a.compareTo(b))
                .map(n -> n+2)
                .findFirst().ifPresent(System.out::println);

        System.out.println(" -------------  ");

        Stream.of(List.of(1,2,3), List.of(4,5,6))
                .flatMap(Collection::stream)
                .map(n-> n*2)
                .forEach(System.out::println);

        System.out.println(" -------------  ");

        Stream.of(1,2,4,6,3,2,4,3)
                .distinct()
                .forEach(System.out::println);

        System.out.println(" -------------  ");

        Stream.of(1,2,4,6,3,2,4,3)
                .distinct()
                .limit(3)
                .forEach(System.out::println);

        System.out.println(" -------------  ");

        Stream.of(1,2,4,6,3,2,4,3)
                .distinct()
                .skip(2)
                .forEach(System.out::println);

        System.out.println(" -------------  ");

        Stream.of(1,2,4,6,3,2,4,3)
                .distinct()
                .min(Integer::compareTo)
                .ifPresent(System.out::println);

        System.out.println(" -------------  ");

        Stream.of(1,2,4,6,3,2,4,3)
                .distinct()
                .mapToInt(n -> n)
                .min()
                .ifPresent(System.out::println);

        System.out.println(" -------------  ");

        Stream.of(1,2,4,6,3,2,4,3)
                .distinct()
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println(" -------------  ");

        boolean b = Stream.of(1,2,4,6,3,2,4,3)
                .distinct()
                .anyMatch(n -> n%2 == 0);
        System.out.println(b);














    }
}
