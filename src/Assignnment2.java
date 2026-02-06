/*************************************************************************
* Project 2 for CSCI 271-001 Spring 2026
*
* Author: Jesse Helms
* OS: Ubuntu Debian Linux 21.1
* Compiler: OpenJDK 11.0.19
* Date: February 5, 2026
*
* Purpose
* This program implements a Fraction class with methods to add, subtract,
* multiply, divide, raise to a power, negate, and convert to a string. while
* keeping the fractions in integer division.
*.
*
*************************************************************************/

/*******************************************************************
* I declare and confirm the following:
* - I have not discussed this program code with anyone other than my
* instructor or the teaching assistants assigned to this course.
* - I have not used programming code obtained from someone else,
* or any unauthorised sources, including the Internet, either
* modified or unmodified.
* - If any source code or documentation used in my program was
* obtained from other sources, like a text book or course notes,
* I have clearly indicated that with a proper citation in the
* comments of my program.
* - I have not designed this program in such a way as to defeat or
* interfere with the normal operation of the supplied grading code.
*
* Jesse Helms
* Told not to include ID
********************************************************************/

public class Assignnment2 {


    public static class Fraction {
    private int numerator;      // variable to hold numerator
    private int denominator;    // variable to hold denominator
    
public Fraction(int num, int denom){
    int divisor = gcd(num, denom);
    numerator = num / divisor;
    denominator = denom / divisor;

    if(num == 0){   // if numerator is zero, set denominator to 1
        denominator = 1;
        return;
    }

   if(denom < 0){    // if denominator is negative, make numerator negative and denominator positive
        numerator = -numerator;
        denominator = -denominator;
        return;
    }

}
public Fraction(int num){
    if(denominator == 1){
        numerator =num;
        return;
    }
}
    

public Fraction add(Fraction inFraction) {
    return new Fraction(
        numerator * inFraction.denominator + inFraction.numerator * denominator, denominator * inFraction.denominator);
    
}

public Fraction subtract(Fraction inFraction) {
    return new Fraction(
        numerator * inFraction.denominator - inFraction.numerator * denominator, denominator * inFraction.denominator);
    
}
public Fraction multiply(Fraction inFraction) {
    return new Fraction(numerator * inFraction.numerator, denominator * inFraction.denominator);
  

}
public Fraction divide(Fraction inFraction) {
    return new Fraction(numerator * inFraction.denominator, denominator * inFraction.numerator);

}
public Fraction pow(int n) {
    if(n==0){
        return new Fraction(1,1);
    }
    else if(n>0){
        return new Fraction((int)Math.pow(numerator, n), (int)Math.pow(denominator, n));
    }
    else if(n<0){
        return new Fraction((int)Math.pow(denominator, -n), (int)Math.pow(numerator, -n));
    }
    return new Fraction(numerator, denominator);


}
    public Fraction negate() {
        return new Fraction(-numerator, denominator);
}
    @Override
    public String toString() {
    
        if(numerator == 0 && denominator != 0){
            return "NaN";
    }
        else if (numerator < 0 && denominator == 0){
            return "-infinity";
        }
        else if(numerator > 0 && denominator == 0){
            return "infinity";
        }
        else if(denominator == 1){
            return Integer.toString(numerator);
        }
        else{
            return numerator + "/" + denominator;
    }   
    }
    

    public static int gcd(int a, int b) {
    
    if ( a < 0 )
     a = -a; 
    while (b != 0) {
        int remainder = a % b;
        a = b;
        b = remainder;
    }
    if (a == 0) a = 1;
    return a;
    }
    public static void main(String[] args) throws Exception {
       System.out.println(new Fraction(6, -24));   // -1/4
        System.out.println(new Fraction(0, 8));     // 0
        System.out.println(new Fraction(23, 0));    // Infinity
        System.out.println(new Fraction(-6, 0));    // -Infinity
        System.out.println(new Fraction(0, 0));     // NaN
        System.out.println(new Fraction(7, 1));     // 7

        // Assignment sample calculation
        Fraction a = new Fraction(16);
        Fraction b = new Fraction(3, 5).add(new Fraction(7));
        Fraction c = new Fraction(6, 7);

        Fraction result = c.multiply(a.divide(b));
        System.out.println(result); // 240/133

        //  arithmetic tests
        System.out.println(c.add(b));
        System.out.println(c.subtract(b));
        System.out.println(c.multiply(b));
        System.out.println(c.divide(b));
        System.out.println(c.negate());
        System.out.println(c.pow(3));
        System.out.println(c.pow(-2));
    
        }
    }
}
