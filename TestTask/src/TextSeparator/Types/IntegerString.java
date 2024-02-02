package TextSeparator.Types;

import java.math.BigDecimal;

public class IntegerString extends TextString {
    public IntegerString(String value) {
        super(value);
    }
    
    public static boolean isType(String value) {
        try {
            BigDecimal parsedValue = new BigDecimal(value);
            if (parsedValue.toPlainString().indexOf('.') != -1) {
                return false;
            }
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    public String getFileName() {
        return "integer.txt";
    }
}
