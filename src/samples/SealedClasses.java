package samples;

public class SealedClasses {
    abstract sealed class Shape permits Circle, Square {}

    final class Circle extends Shape {}

    non-sealed class Square extends Shape {}
}
