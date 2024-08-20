public class SumOfDigitsInRange {
    public static void main(String[] args) {
        int a = 10;
        int b = 15;

        int start = Math.min(a, b);
        int end = Math.max(a, b);

        int sumOfDigits = 0;

        for (int i = start; i <= end; i++) {
            sumOfDigits += sumOfDigitsInNumber(i);
        }

        System.out.println("Sum of all digits between " + a + " and " + b + " is: " + sumOfDigits);
    }

    // Function to sum the digits of a number
    private static int sumOfDigitsInNumber(int number) {
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
