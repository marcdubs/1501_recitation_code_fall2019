import java.util.Arrays;
import java.util.ArrayList;

public class Radix {
    public static void main(String[] args) {
        int[] input = new int[args.length];
        for(int i = 0; i < args.length; i++) {
            input[i] = Integer.parseInt(args[i]);
        }
        radix_sort(input);
        System.out.println(Arrays.toString(input));
    }

    public static void radix_sort(int[] input) {
        ArrayList<Integer>[] bins = new ArrayList[10];

        for(int i = 0; i < bins.length; i++) {
            bins[i] = new ArrayList<Integer>();
        }

        int divider = 1;

        //Loop through every digit from LSD to MSD
        outer: while(true) {
            boolean done = true;

            for(int i = 0; i < input.length; i++) {
                if(input[i]/divider != 0) {
                    done = false;
                }

                int digit = (input[i]/divider) % 10;
                bins[digit].add(input[i]);
            }

            if(done) {
                break outer;
            }

            int input_position = 0;
            for(int i = 0; i < bins.length; i++) {
                while(bins[i].size() != 0) {
                    input[input_position++] = bins[i].remove(0);
                }
            }

            divider *= 10;
        }

    }
}