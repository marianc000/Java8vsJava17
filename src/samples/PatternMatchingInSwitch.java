package samples;

public class PatternMatchingInSwitch {
    static Integer increment(Object o) {
        return switch (o) {
            case Integer i -> ++i;
            case String s -> Integer.parseInt(s) + 1;
            default -> throw new RuntimeException("unknown type");
        };
    }

    public static void main(String[] args) {
        System.out.println(increment(1)); // 2
        System.out.println(increment("10")); //11
    }
}
