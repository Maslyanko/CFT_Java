package TextSeparator.Types;

public class TextString {
    private String text;
    public TextString(String text) {
        this.text = text;
    }

    public static boolean isType(String value) {
        return value.isEmpty()? false: true;
    }

    public String getFileName() {
        return "string.txt";
    }

    public String toString() {
        return text;
    }
}
