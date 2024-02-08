import java.util.Vector;

public class Parser {
    private String str;
    private Vector<String> vecWords;
    Parser() {
        vecWords = new Vector();
    }

    private void parse() {
        char chars[] = str.toCharArray();
        StringBuilder tempStr = new StringBuilder();
        for (char ch: chars ) {
            boolean isLetter = Character.isLetterOrDigit((char) ch);
            if (tempStr.isEmpty() && !isLetter) {
                continue;
            }
            if (isLetter) {
                tempStr.append(ch);
            } else {
                vecWords.add(tempStr.toString());
                tempStr.delete(0, tempStr.length());
            }
        }
    }

    Vector<String> getWordsVector() {
        this.parse();
        Vector<String> vecCopy = new Vector<>(vecWords);
        vecWords.clear();
        return vecCopy;
    }

    void setString(String newStr) {
        str = newStr;
    }
}
