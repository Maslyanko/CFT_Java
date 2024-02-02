package TextSeparator.Types;

import java.math.BigDecimal;

public class FloatString extends TextString {
    public FloatString(String value) {
        super(value);
    }

    public static boolean isType(String value) {
        try {
            BigDecimal parsedValue = new BigDecimal(value);
            if (parsedValue.toPlainString().indexOf('.') != -1) {
                return true;
            }
        } catch (Exception ex) {
            return false;
        }
        return false;
    }

    public String getFileName() {
        return "float.txt";
    }
}
