package org.example.funcpro.streams;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@AllArgsConstructor
@Data
public class Catalog {
    private int id;
    private List<String> products;
}
