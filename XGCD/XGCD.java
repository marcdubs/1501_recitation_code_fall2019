public class XGCD {

    public XGCD(int a, int b) {
        XGCD_Struct res = new XGCD_Struct();
        res.a = a;
        res.b = b;
        runXGCD(res);
        System.out.println(res);
    }

    public void runXGCD(XGCD_Struct struct) {
        if(struct.b == 0) {
            struct.d = struct.a;
            struct.s = 1;
            struct.t = 0;
            return;
        }

        int a_div_b = struct.a / struct.b;
        int a_mod_b = struct.a % struct.b;
        struct.a = struct.b;
        struct.b = a_mod_b;
        runXGCD(struct);
        int s_prev = struct.s;
        int t_prev = struct.t;
        struct.s = t_prev;
        struct.t = s_prev - a_div_b*t_prev;
    }

    private class XGCD_Struct {
        int a, b, d, s, t;

        public String toString() {
            return "{a: " + a + ", b: " + b + ", d: " + d + ", s: " + s + ", t: " + t + "}";
        }
    }

    public static void main(String[] args) {
        new XGCD(240, 98); //d = 2, s = -20, t = 49
        new XGCD(37440, 35597); //d = 1, s = 6567 t = -6907
    }
}