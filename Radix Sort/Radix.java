import java.util.Arrays;

public class Radix {
    public static void main(String[] args) {
        int[] input = new int[args.length];
        for(int i = 0; i < args.length; i++) {
            input[i] = Integer.parseInt(args[i]);
        }
        int[] output = radix_sort(input);
        System.out.println(Arrays.toString(output));
    }

    public static int[] radix_sort(int[] input) {
        return input;
    }
}