public class Calculator {

    @FunctionalInterface
    interface IntegerMath {
        int operation(int a, int b);
    }

    public int operateBinary(int a, int b, IntegerMath op) {
        return op.operation(a, b);
    }

    public static void main(String... args) {

        Calculator myApp = new Calculator();
        System.out.println("40 + 2 = " + myApp.operateBinary(40, 2, (a, b) -> a + b));
        System.out.println("20 - 10 = " + myApp.operateBinary(20, 10, (a, b) -> a - b));
        System.out.println("20 * 10 = " + myApp.operateBinary(20, 10, (a, b) -> a * b));
        System.out.println("20 / 10 = " + myApp.operateBinary(20, 10, (a, b) -> a / b));
    }
}

