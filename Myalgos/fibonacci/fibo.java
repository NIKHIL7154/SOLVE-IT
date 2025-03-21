
public class fibo {

    public int getFibonacciNumber(int num) {

        int a = 0;
        int b = 1;
        int temp;
        for (int i = 1; i < num; i++) {
            temp = a + b;
            a = b;
            b = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        fibo mm = new fibo();
        int result = mm.getFibonacciNumber(400);
        System.out.println("Fibonacci number: " + result);

    }
}
