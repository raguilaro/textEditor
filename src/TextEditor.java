import java.util.Scanner;
import java.util.Stack;

public class TextEditor {

    public static void main(String[] args) {
        Stack<String> words = new Stack() {{ push(""); }};
        StringBuilder result = new StringBuilder();

        Scanner in = new Scanner(System.in);
        int operations = in.nextInt();

        for (int i = 0; i < operations; i++) {
            switch (in.nextInt()) {
                case APPEND:
                    appendToCurrent(words, in.next());
                    break;
                case DELETE:
                    deleteCharsFromCurrent(words, in.nextInt());
                    break;
                case PRINT:
                    storeCharFromCurrent(words, in.nextInt(), result);
                    break;
                case UNDO:
                    words.pop();
            }
        }
        System.out.println(result);
    }

    private static void appendToCurrent(Stack<String> words, String toAppend) {
        words.push(words.peek() + toAppend);
    }

    private static void deleteCharsFromCurrent(Stack<String> words, int charsToDelete) {
        words.push(words.peek().substring(0, words.peek().length() - charsToDelete));
    }

    private static void storeCharFromCurrent(Stack<String> words, int charToPrint, StringBuilder result) {
        result.append(words.peek().charAt(charToPrint - 1)).append(System.getProperty("line.separator"));
    }

    public static final int APPEND = 1;
    public static final int DELETE = 2;
    public static final int PRINT = 3;
    public static final int UNDO = 4;

}
