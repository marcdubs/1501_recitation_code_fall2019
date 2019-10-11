import java.util.Arrays;

public class KMPStart {
    public static final int CHAR_START = 0;
    public static final int CHAR_END = 256;

    public static void main(String[] args) {
        if(args.length < 2) {
            System.out.println("Usage: Java KMP <pattern> <toSearch>");
            return;
        }

        String pattern = args[0];
        String toSearch = args[1];

        KMP kmp = new KMP(pattern.toCharArray());
        System.out.println(kmp.search(toSearch));
    }

    private int[][] dfa;
    private char[] pattern;

    public KMP(char[] pattern) {
        this.pattern = pattern;


        // dfa[i][j] = k denotes the transition function will go k'th state 
        // with character i from state j

        dfa = new int[CHAR_END - CHAR_START][pattern.length + 1];

        //Build DFA
        dfa[pattern[0]][0] = 1;

        int X = 0; //longest prefix suffix
        for(int state = 1; state < pattern.length; state++) {
            for(int c = CHAR_START; c < CHAR_END; c++) {
                dfa[c][state] = dfa[c][X];
            }
            int c = pattern[state];
            dfa[c][state] = state + 1;
            X = dfa[c][X];
        }
    }

    public int search(String toSearch) {
        return -1;
    }
}