package level03;

public class Task32 {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {
        
        int a = number / 100;
        System.out.println(a);
        int b = (number / 10 - a*10);
        System.out.println(b);
        int c = (number - a*100)- b*10;
        System.out.println(c);
        int s = a + b + c;
        return s;

    }
}
