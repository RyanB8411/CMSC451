package Homework1;

class Problem1 {

    int n = 0;

    int square(int n) { 
        int result = 0; 
        for (int i = 1; i <= n; i++)
        result += 2 * i - 1; 
        return result; 
        } 
    public static void main(String[] args) {
        Problem1 p1 = new Problem1();
        p1.n = 2;
        System.out.println(p1.square(p1.n));
    }
}