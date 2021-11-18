package samples;

public class PatternMatchingWithInstanceof {
    static Integer increment(Object o) {
        if (o instanceof Integer i) {
            return ++i;
        }

        if (o instanceof String s) {
            return Integer.parseInt(s) + 1;
        }
        throw new RuntimeException("unknown type");
    }

    public static void main(String[] args) {
        System.out.println(increment(1)); // 2
        System.out.println(increment("10")); //11
    }
}
