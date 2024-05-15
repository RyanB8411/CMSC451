package Homework1;

class Problem1 {

    int n = 0;

    int square(int n) { 
        int result = 0; 
        for (int i = 1; i <= n; i++)
        result += 2 * i - 1; 
        return result; 
        } 

        /**
        * Returns the square of a given integer n.
        * 
        * Preconditions: n >= 0
        * Postconditions: returns the square of n
        */
    int recSquare(int n) {
        // Base case: 0 squared is 0
        if (n == 0) {
            return 0;
        } else {
        // Recursive case: n squared is (n-1) squared plus 2n - 1
            return recSquare(n - 1) + 2 * n - 1;
        }
    }
    
    public static void main(String[] args) {
        Problem1 p1 = new Problem1();
        p1.n = 2;
        System.out.println(p1.square(p1.n));
        Problem1 p2 = new Problem1();
        p2.n = 6;
        System.out.println(p2.square(p2.n));
        Problem1 p3 = new Problem1();
        p3.n = 0;
        System.out.println(p3.recSquare(p3.n));
        Problem1 p4 = new Problem1();
        p4.n = 2;
        System.out.println(p4.recSquare(p4.n));
        Problem1 p5 = new Problem1();
        p5.n = 6;
        System.out.println(p5.recSquare(p5.n));
    }
}