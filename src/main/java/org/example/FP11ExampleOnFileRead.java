package org.example;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class FP11ExampleOnFileRead {
    public static void main(String[] args) throws Exception{
        Files.lines(Paths.get("file.txt"))
                .map(s -> s.split(" "))
                .flatMap(Arrays::stream)//flatMap is used to convert String[] to Strings
                .distinct()
                .forEach(System.out::println);
        /**
         Iam
         good
         Java
         is
         nice
         Spring
         Boot
         cool
         */
    }
}
