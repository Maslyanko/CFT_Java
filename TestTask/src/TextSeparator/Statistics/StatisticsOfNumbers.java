package TextSeparator.Statistics;

import java.math.BigDecimal;

public class StatisticsOfNumbers extends InnerStatistics {
    private long count = 0;
    private BigDecimal min = null;
    private BigDecimal max = null;
    private BigDecimal sum = BigDecimal.ZERO;

    public void add(String value) {
        BigDecimal parsedValue = new BigDecimal(value);
        if (min == null) {
            min = max = parsedValue;
        }
        min = min.min(parsedValue);
        max = max.max(parsedValue);
        ++count;
    }

    public String getShortStatistics() {
        return "Number: " + count + ";\n"; 
    }

    public String getFullStatistics() {
        String statistics = getShortStatistics();
        if (count == 0) {
            statistics += "Maximum: no information available;\n" +
                          "Minimum: no information available;\n" +
                          "Average: no information available;";
        } else {
            BigDecimal average = sum.divide(BigDecimal.valueOf(count));
            statistics += "Maximum: " + max.toString() + 
                          ";\nMinimum: " + min.toString() + 
                          ";\nAverage: " + average.toString() + ";";
        }
        return statistics;
    }
}