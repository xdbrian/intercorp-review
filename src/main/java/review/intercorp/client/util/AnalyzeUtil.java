package review.intercorp.client.util;

import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;

public class AnalyzeUtil {

    /**
     * Cácula promedio de edaddes.
     */
    public static Function<List<Integer>, Float> average = lisItem -> {

        if (lisItem.isEmpty()) {
            return 0.f;
        }

        Integer ageSum = lisItem.stream()
                .flatMapToInt(IntStream::of)
                .sum();

        return Float.valueOf((ageSum / lisItem.size()));
    };


    /**
     * Calcula desviación estandar.
     */
    public static Function<List<Integer>, Double> desviationStandard = listAge -> {
        double sd;
        Integer size = listAge.size();
        double listAverage = listAge.stream().reduce(0, (x, y) -> x + y) / listAge.size();
        sd = listAge.stream().mapToDouble(item -> ((item - listAverage) * (item - listAverage)) / (size - 1)).sum();
        return Math.sqrt(sd);
    };
}
