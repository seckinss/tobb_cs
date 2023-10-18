import java.util.Scanner;

public class FractionalNumberDemo {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter the first fractional number in string representation");
        FractionalNumber fractionalNumber1 = new FractionalNumber(keyboard.nextLine());
        System.out.println("Please enter the second fractional number in string representation");
        FractionalNumber fractionalNumber2 = new FractionalNumber(keyboard.nextLine());
        System.out.println("Please enter the third fractional number in numerator and denominator form");
        FractionalNumber fractionalNumber3 = new FractionalNumber(keyboard.nextInt(), keyboard.nextInt());

        System.out.println("First fractional number is " + fractionalNumber1.toString() + " and its double value is " + fractionalNumber1.getDoubleValue());
        System.out.println("Second fractional number is " + fractionalNumber2.toString() + " and its double value is " + fractionalNumber2.getDoubleValue());
        System.out.println("Third fractional number is " + fractionalNumber3.toString() + " and its double value is " + fractionalNumber3.getDoubleValue());
        System.out.println();

        System.out.println("First fractional number is " + fractionalNumber1.toString() + " and its simplified version is " + fractionalNumber1.simplify());
        System.out.println("Second fractional number is " + fractionalNumber2.toString() + " and simplified version is " + fractionalNumber2.simplify());
        System.out.println("Third fractional number is " + fractionalNumber3.toString() + " and simplified version is " + fractionalNumber3.simplify());

        System.out.println();

        if (fractionalNumber1.equals(fractionalNumber2))
            System.out.println("First and second fractional numbers are equal");
        else
            System.out.println("First and second fractional numbers are not equal");

        if (fractionalNumber1.equals(fractionalNumber3))
            System.out.println("First and third fractional numbers are equal");
        else
            System.out.println("First and third fractional numbers are not equal");

        if (fractionalNumber2.equals(fractionalNumber3))
            System.out.println("Second and third fractional numbers are equal");
        else
            System.out.println("Second and third fractional numbers are not equal"); 



        System.out.println();
        System.out.println(fractionalNumber1.toString() + " + " + fractionalNumber2.toString() + " = " + fractionalNumber1.add(fractionalNumber2));
        System.out.println(fractionalNumber1.toString() + " + " + fractionalNumber3.toString() + " = " + fractionalNumber1.add(fractionalNumber3));
        System.out.println(fractionalNumber2.toString() + " + " + fractionalNumber3.toString() + " = " + fractionalNumber2.add(fractionalNumber3));
        System.out.println();

        System.out.println(fractionalNumber1.toString() + " - " + fractionalNumber2.toString() + " = " + fractionalNumber1.subtract(fractionalNumber2));
        System.out.println(fractionalNumber1.toString() + " - " + fractionalNumber3.toString() + " = " + fractionalNumber1.subtract(fractionalNumber3));
        System.out.println(fractionalNumber2.toString() + " - " + fractionalNumber3.toString() + " = " + fractionalNumber2.subtract(fractionalNumber3));
        System.out.println();

        System.out.println(fractionalNumber1.toString() + " * " + fractionalNumber2.toString() + " = " + fractionalNumber1.multiply(fractionalNumber2));
        System.out.println(fractionalNumber1.toString() + " * " + fractionalNumber3.toString() + " = " + fractionalNumber1.multiply(fractionalNumber3));
        System.out.println(fractionalNumber3.toString() + " * " + fractionalNumber2.toString() + " = " + fractionalNumber3.multiply(fractionalNumber2));

        System.out.println();

        System.out.println(fractionalNumber1.toString() + " / " + fractionalNumber2.toString() + " = " + fractionalNumber1.divide(fractionalNumber2));
        System.out.println(fractionalNumber1.toString() + " / " + fractionalNumber3.toString() + " = " + fractionalNumber1.divide(fractionalNumber3));
        System.out.println(fractionalNumber3.toString() + " / " + fractionalNumber2.toString() + " = " + fractionalNumber3.divide(fractionalNumber2));


    }
}
