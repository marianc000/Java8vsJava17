package samples;

public class Records {

    public static void main(String[] args) {
        record Point(int x, int y){}
        System.out.println(new Point(1, 2)); // Point[x=1, y=2]
        System.out.println(new Point(1, 2).equals(new Point(1, 2))); //true
    }
}

