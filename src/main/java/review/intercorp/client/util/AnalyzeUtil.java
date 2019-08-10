package review.intercorp.client.util;

import review.intercorp.client.model.ClientResponse;

import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;

public class AnalyzeUtil {

    /**
     * Cácula promedio de edaddes.
     */
    public static Function<List<Integer>, Float> average = lisItem -> {

        if (lisItem.isEmpty() || lisItem.get(0) > 0) {
            return 0.f;
        }

        Integer ageSum = lisItem.stream()
                .flatMapToInt(IntStream::of)
                .sum();

        return Float.valueOf((ageSum / lisItem.size()));
    };

    public static Function<Date, Float> desviationStandard = date -> {


        return 0.f;
    };
}
