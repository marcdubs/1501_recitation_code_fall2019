public class XGCD {

    public XGCD(int a, int b) {
        XGCD_Struct res = new XGCD_Struct();
        res.a = a;
        res.b = b;
        runXGCD(res);
        System.out.println(struct);
    }

    public void runXGCD(XGCD_Struct struct) {
        
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