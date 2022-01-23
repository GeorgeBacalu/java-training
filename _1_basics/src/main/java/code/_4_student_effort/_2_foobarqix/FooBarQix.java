package code._4_student_effort._2_foobarqix;

public class FooBarQix {
    public static void main(String[] args) {
        System.out.println(compute(105));
        System.out.println(compute2(105));
    }

    private static StringBuilder compute(int x) {
        StringBuilder output= new StringBuilder();
        if(x % 3 == 0) output.append("Foo");
        else if(x % 5 == 0) output.append("Bar");
        else if(x % 7 == 0) output.append("Qix");

        char[] digits = String.valueOf(x).toCharArray();
        for(char digit : digits) {
            if(digit == '3') output.append("Foo");
            else if(digit == '5') output.append("Bar");
            else if(digit == '7') output.append("Qix");
        }
        if(output.length() == 0) output.append(x);
        return output;
    }

    private static StringBuilder compute2(int x) {
        StringBuilder output= new StringBuilder();
        boolean isDivisible = x % 3 == 0 || x % 5 == 0 || x % 7 == 0;

        if(x % 3 == 0) output.append("Foo");
        else if(x % 5 == 0) output.append("Bar");
        else if(x % 7 == 0) output.append("Qix");
        char[] digits = String.valueOf(x).toCharArray();
        for(char digit : digits) {
            if(digit == '3') output.append("Foo");
            else if(digit == '5') output.append("Bar");
            else if(digit == '7') output.append("Qix");
            else if(digit == '0') output.append('*');
            else if(!isDivisible) output.append(digit);
        }
        if(output.length() == 0) output.append(x);
        return output;
    }
}
