package p1;

public class revursion {
    public static  int power(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        return base * power(base, exponent - 1);
    }
    
    public static  int findMissing(int[] arr, int n) {
        if (n == 0) {
            return 1;
        }
        if (!contains(arr, n)) {
            return n;
        }
        return findMissing(arr, n - 1);
    }
    
    public static  boolean contains(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                return true;
            }
        }
        return false;
    }

    public static String decimalToHexadecimal(int n) {
        char[] hexChars = "0123456789ABCDEF".toCharArray();
        if (n < 16) {
            return Character.toString(hexChars[n]);
        } else {
            return decimalToHexadecimal(n / 16) + hexChars[n % 16];
        }
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
    
    public static int fibonacci(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public int findMax(int[] arr, int n) {
        if (n == 1) {
            return arr[0];
        }
        return Math.max(arr[n - 1], findMax(arr, n - 1));
    }
    
    public static int findMin(int[] arr, int n) {
        if (n == 1) {
            return arr[0];
        }
        return Math.min(arr[n - 1], findMin(arr, n - 1));
    }

    public static int sumOfNNumbers(int[] arr, int n) {
        if (n == 0) {
            return 0;
        }
        return arr[n - 1] + sumOfNNumbers(arr, n - 1);
    }
public static void main(String[] args) {
    int arr[] = {1,2,4,5,6};
    int n = 3;
     System.out.println(sumOfNNumbers(arr, n));
     System.out.println(findMissing(arr, n));
     System.out.println(findMin(arr, n));
      
}    
}
