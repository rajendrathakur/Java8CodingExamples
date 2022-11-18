package org.example.funcpro.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FP10ExampleOnMapvsFlatMap {
    public static void main(String[] args) {
        Catalog grocery = new Catalog(101,  List.of("Maggi", "Fortune Oil", "Tata Salt"));
        Catalog electronics = new Catalog(102,  List.of(";aptop", "Air Conditioner", "Chimney"));
        List<Catalog> catalogList = Arrays.asList(grocery, electronics);

        //Print the products with Map
        List<List<String>> productsListWithMap = catalogList.stream().map(Catalog::getProducts)
                .collect(Collectors.toList());
        productsListWithMap.forEach(System.out::println);
        System.out.println("----------");
        /**
         [Maggi, Fortune Oil, Tata Salt]
         [;aptop, Air Conditioner, Chimney]
         */

        //Print the products with FlatMap
        List<String> productsListWithFlatMap = catalogList.stream().map(Catalog::getProducts)
                .flatMap(List::stream) // We can also use Collection::stream
                .collect(Collectors.toList());
        productsListWithFlatMap.forEach(System.out::println);
        System.out.println("----------");
        /**
         Maggi
         Fortune Oil
         Tata Salt
         ;aptop
         Air Conditioner
         Chimney
         */
    }
}
