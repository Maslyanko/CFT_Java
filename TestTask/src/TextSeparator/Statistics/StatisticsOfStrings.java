package TextSeparator.Statistics;

public class StatisticsOfStrings extends InnerStatistics {
    private long count = 0;
    private int minLength = Integer.MAX_VALUE;
    private int maxLength = Integer.MIN_VALUE;

    public void add(String string) {
        minLength = Math.min(minLength, string.length());
        maxLength = Math.max(maxLength, string.length());
        ++count;
    }

    public String getShortStatistics() {
        return "Number: " + count + ";\n";
    }

    public String getFullStatistics() {
        String statistics = getShortStatistics();
        if (count == 0) {
            statistics += "Minimum length: no information available;\n"+
                          "Maximum length: no information available;";
        } else {
            statistics += "Minimum length: " + minLength + 
                          ";\nMaximum length: " + maxLength + ";";
        }
        return statistics;
    }
}
