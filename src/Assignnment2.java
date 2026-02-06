/*************************************************************************
* Project 2 for CSCI 271-001 Spring 2026
*
* Author: Jesse Helms
* OS: Ubuntu Debian Linux 21.1
* Compiler: OpenJDK 25.0.2
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

/*****************************<Class Fraction>****************************
* Description: takes in the numerator and denominator of a fraction and stores them as integer values
*
* Parameters: none
*
* Pre: the fraction constructor is called with two integer arguments representing the numerator
* and denominator of the fraction.
*
* Post: the numerator and denominator are taken as integers and transformed into a string fraction
*
* Returns: the numerator and denominator of the fraction as a string in the form "numerator/denominator"
*
* Called by: main
* Calls: add, subtract, multiply, divide, pow, negate, toString, gcdja
************************************************************************/
    public static class Fraction {
    private int numerator;      // variable to hold numerator
    private int denominator;    // variable to hold denominator
    

/*****************************<Fraction>****************************
* Description:takes in a fraction in the form of a numerator and denominator, reduces it to lowest terms,
* and handles special cases such as zero denominators and negative values.
*
* Parameters: num: the numerator of the fraction, denom: the denominator of the fraction
*
* Pre: the fraction constructor is called with two integer arguments representing the
* numerator and denominator of the fraction. The numerator can be any integer value, while the 
* denominator must be a non-zero integer value. If the denominator is zero, the constructor should handle this
* case appropriately, such as by throwing an exception or setting the fraction to a special value like NaN or Infinity.
*
* Post: the fraction is reduced to lowest terms by dividing both the
* numerator and denominator by their greatest common divisor.
*
* Returns: The reduced fraction in lowest terms, the denominator is set to 1 if the numerator is zero,
* the numerator is made negative and the denominator is made positive if the denominator is negative, 
*and the fraction is set to a special value like NaN or Infinity if the denominator is zero.
*
* Called by: add, subtract, multiply, divide, pow, negate
* Calls: gcd
************************************************************************/
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
    /*****************************<Fraction>****************************
* Description: if the denominator is 1, it sets the numerator to the input value and returns. 
* Otherwise, it does nothing.
*
* Parameters: num
*
* Pre: the fraction object is passed and the denominator is set to 1
*
* Post: the numerator is set to an integer value and the denominator is set to 1,
* effectively creating a fraction that represents a whole number.
*
* Returns: the numerator as an integer value and the denominator as 1, representing a whole number fraction.
*
* Called by: Fraciotn constructor
************************************************************************/
public Fraction(int num){
    if(denominator == 1){
        numerator =num;
        return;
    }
}
    /*****************************<add>****************************
* Description: adds the fraction input to the current fraction and returns the result as a new Fraction object.
*
* Parameters: infraction
*
* Pre: the Fraction object is passed and the add method is called
*
* Post: the fraction is added with the input fraction and returns the result as a new Fraction object
*
* Returns: Describe what value the function returns, if any.
*
* Called by: list the name(s) of the function(s) that call this one.
* Calls: list the name(s) of the function(s) that this one calls.
************************************************************************/

public Fraction add(Fraction inFraction) {
    return new Fraction(
        numerator * inFraction.denominator + inFraction.numerator * denominator, denominator * inFraction.denominator);
    
}
/*****************************<Subtract>****************************
* Description: subtracts the input fraction from the current fraction and returns the result as a new Fraction object.
*
* Parameters: infraction
*
* Pre: the Fraction object is passed and the subtract method is called
*
* Post: subtracts the input fraction from the current fraction and returns the result as a new Fraction object
* The result is calculated by multiplying the numerator of the current fraction by the denominator of the input
* fraction, and then subtracting the product of the numerator of the input fraction and the denominator of the current
* fraction. The denominator of the result is calculated by multiplying the denominators of both fractions.
*
* Returns: Describe what value the function returns, if any.
*
* Calls: Fraction
************************************************************************/
public Fraction subtract(Fraction inFraction) {
    return new Fraction(
        numerator * inFraction.denominator - inFraction.numerator * denominator, denominator * inFraction.denominator);
    
}
/*****************************<multiply>****************************
* Description: multiplies the fractions by multiplying the numerators together and the denominators together
*
* Parameters: infraction
*
* Pre: the Fraction object is passed and the multiply method is called with another fraction as an argument.
*
* Post: the fractions are multiplied together
*
* Returns: The result of multiplying the two fractions together
*
* Called by: none
* Calls: none
************************************************************************/
public Fraction multiply(Fraction inFraction) {
    return new Fraction(numerator * inFraction.numerator, denominator * inFraction.denominator);
  

}
/*****************************<divide>****************************
* Description: divides the fractions by cross-multiplying
*
* Parameters: infraction
*
* Pre: the fraction object is passed and the divide method is called with another fraction as an argument.
*
* Post:the fractions are divided by one another
*
* Returns: the result of the division of the two fractions.
*
* Called by: none
* Calls: none
************************************************************************/
public Fraction divide(Fraction inFraction) {
    return new Fraction(numerator * inFraction.denominator, denominator * inFraction.numerator);

}
/*****************************<pow>****************************
* Description: takes the fraction and does the exponential function set
*
* parameters: n: the integer value that the fraction is raised to
*
* Pre: the fraction constructor is called and the pow method is called with an integer argument n.
*
* Post: the fraction will be set as the numerator raised to the power of n and the denominator raised to
* the power of n if n is positive.if n is 0 it is set to 1/1. If n is negative, the numerator 
* is set to the denominator raised to the power of -n and the denominator is set to the numerator raised 
* to the power of -n.
*
* Returns: a new Fraction object representing the result of raising the current fraction to the power of n.
*
* Called by: none
* Calls: none
************************************************************************/
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
/*****************************<negate>****************************
* Description: negates the fraction if it is a negative value
*
* Parameters: none
*
* Pre: lthe fraction object is passed and the negate method is called
*
* Post: the fraction entered is negated by multiplying the numerator by -1 and returns the result
* as a new Fraction object
*
* Returns: the negative of the fractions numerator and denominator as a new Fraction object.
************************************************************************/

    public Fraction negate() {
        return new Fraction(-numerator, denominator);
}
/*****************************<String tostring>****************************
* Description: takes the numerator and denominator of the fraction and converts it to a string.
* If the numerator is zero, it returns "0". If the denominator is one, it returns just the numerator as a string.
* If the denominator is zero, it returns "Infinity" or "-Infinity" depending on the sign of the numerator. 
*If both numerator and denominator are zero, it returns "NaN". Otherwise, it returns the fraction in the form
*"numerator/denominator".
*
* Parameters: none
*
* Pre: the fraction constructer is called and the numerator and denominator are set to integer values.
*
* Post: the numerator and denominator of the fraction are converted to a string representation of the fraction.
*
* Returns: numerator + denominaor as a string in the form "numerator/denominator", or "0" if the numerator is zero
* or just the numerator as a string if the denominator is one, or "Infinity" or "-Infinity" if the denominator is zero
* or "NaN" if both numerator and denominator are zero.
*
************************************************************************/
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
    
/*****************************<GCD>****************************
* Description: Takes the greatest common divisor of the numerator and denominator
* to reduce the fraction to lowest terms.
*
* Parameters: int a: the numerator of the fraction, int b: the denominator of the fraction
*
* Pre:numerator of the function must be an integer value greater than zero and the both the numerator and the
* denominator must have a factor that they can both be divided by.
*
* Post: List the postconditions; the fraction is reduced to lowest terms by dividing both the numerator and denominator
* by their greatest common divisor.
* Returns: the greatest common divisor of the numerator and denominator and returns the lowest possible value of 
* the fraction.
*
* Called by: Fraction constructor
* Calls: none
************************************************************************/
    public static int gcd(int a, int b) {
    
        if ( a < 0 )
        a = -a; 
        while(b != 0) {
        int remainder = a % b;
        a = b;
        b = remainder;
    }
    if (a == 0) a = 1;
    return a;
    }
    }
    public static void main(String[] args) {
        // Test cases for the Fraction class
        System.out.println(new Fraction(1, 2));     // 1/2
        System.out.println(new Fraction(-3, 4));    // -3/4
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
        System.out.println(a.add(b));
        System.out.println(c.subtract(b));
        System.out.println(a.multiply(b));
        System.out.println(c.divide(b));
        System.out.println(a.negate());
        System.out.println(c.pow(3));
        System.out.println(a.pow(-2));
    
        }

}
