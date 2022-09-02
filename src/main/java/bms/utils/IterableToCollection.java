package bms.utils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class IterableToCollection {
    public static List<?> getCollectionFromIterable(Iterable<?> itr) {

        return StreamSupport.stream(itr.spliterator(), false)
                .collect(Collectors.toList());
    }
}
