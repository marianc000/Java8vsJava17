package samples;

public class SwitchExpressions {
    static String dayType(int dayOfWeek) {
        return switch (dayOfWeek) {
            case 1, 2, 3, 4, 5 -> "workday";
            case 6, 7 -> "weekend";
            default -> throw new RuntimeException("Invalid day");
        };
    }

    public static void main(String[] args) {
        System.out.println(dayType(1));
        System.out.println(dayType(7));
    }
}
