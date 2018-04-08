

public class AllCombination {

    /**
     * [a,b,c] all combination are [a],[b],[c],[a,b],[a,c],[b,c],[a,b,c] <br>
     * Set binary a = 1, b = 10, c = 100. <br>
     * So loop 1 to 2^arr.length - 1. <br>
     * <pre>
     * 1 = 0b1 = [a], 
     * 2 = 0b10 = [b],
     * 3 = 0b11 = [a,b],
     * 4 = 0b100 = [c],
     * 5 = 0b101 = [a,c],
     * 6 = 0b110 = [b,c],
     * 7 = 0b111 = [a,b,c]
     * </pre>
     * @param arr 
     * @author luoyh(Roy) - 4/8/2018
    **/
    public static void allCombination(String[] arr) {
        if (null == arr || arr.length > 64) return ; // too much
        long max = java.util.Math.pow(2, arr.length); // max = 2^n-1
        for (int comb = 1; comb < max; comb ++) {
            StringBuilder result = new StringBuilder();
            int combs = comb, shift = 0;
            while (combs > 0) {
                combs = comb >>> shift; // get all combination
                int c = combs & 0x1; // when 1 be found
                if (c == 1) {
                    result.append(arr[shift]).append(",");
                }
                shift ++;
            }
            System.out.println(sb.toString());
        }
    }

}
