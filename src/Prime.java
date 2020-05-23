public class Prime {

    public static boolean isPrime(long num) {
        long temp;
        boolean isPrime = true;

        if (num < 2) return false;

        for (int i = 2; i <= num / 2; i++) {
            temp = num % i;
            if (temp == 0) {
                isPrime = false;
                break;
            }
        }
        String filler = isPrime ? "" : "not ";
        System.out.println(num + " is " + filler + "prime!");
        return isPrime;
    }

    public static boolean isDescrescendo(final long number) {
        //System.out.println("Crescendo!");
        int lastDigit;
        long temp = number;
        while (temp > 9) {
            lastDigit = (int) temp % 10;
            temp /= 10;
            long nextDigit = temp % 10;
            if (lastDigit >= nextDigit) {
                //System.out.println(number + " is not descrescendo!");
                return false;
            }
        }

        System.out.println(number + " is crescendo!");
        return true;
    }
}
