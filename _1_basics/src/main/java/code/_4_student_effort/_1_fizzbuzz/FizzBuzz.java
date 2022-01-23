package code._4_student_effort._1_fizzbuzz;

public class FizzBuzz {
    public static void main(String[] args) {
        System.out.println(fizzBuzz(100));
        System.out.println(fizzBuzz2(100));
    }

    private static StringBuilder fizzBuzz(int counter) {
        StringBuilder output = new StringBuilder();
        for(int i = 1; i <= counter; i++) {
            if(i % 3 == 0 && i % 5 == 0) output.append("FizzBuzz, ");
            else if(i % 3 == 0) output.append("Fizz, ");
            else if(i % 5 == 0) output.append("Buzz, ");
            else output.append(i).append(", ");
        }
        return output;
    }

    private static StringBuilder fizzBuzz2(int counter) {
        StringBuilder output = new StringBuilder();
        for(int i = 1; i <= counter; i++) {
            if(i % 3 == 0 && i % 5 == 0) output.append("FizzBuzz, ");
            else if(i % 3 == 0) output.append("Fizz, ");
            else if(i % 5 == 0) output.append("Buzz, ");
            else if(i % 7 == 0) output.append("Rizz, ");
            else if(i % 11 == 0) output.append("Jazz, ");
            else output.append(i).append(", ");
        }
        return output;
    }
}
