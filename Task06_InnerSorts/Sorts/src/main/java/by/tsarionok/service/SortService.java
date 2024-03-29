package by.tsarionok.service;

import java.util.List;

public interface SortService<T extends Number> {
    List<T> sort();

    void setNumbers(List<T> numbers);
}
