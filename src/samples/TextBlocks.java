package samples;

public class TextBlocks {
    static String textBlock = """
 one
  two
   three""";

static String ordinaryString=" one\n" +
        "  two\n" +
        "   three";

    public static void main(String[] args) {
        System.out.println(textBlock);
        System.out.println(ordinaryString);
        System.out.println(textBlock.equals(ordinaryString)); // false
    }
}
