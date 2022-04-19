import org.w3c.dom.ranges.Range;
import java.math.BigDecimal;
public class ShannonFano {
    public  static double getIndex(char s){
        char xinhaos[] = { 'A', 'B', 'C', 'D' };
        double gsilv[] = {0.1,0.2,0.3,0.4};
        for (int i = 0;i<xinhaos.length;i++){
            if (s==xinhaos[i]){

                return gsilv[i];
            }
        }
        return 0;
    }
    public static double getLow(char s){

        char xinhaos[] = { 'A', 'B', 'C', 'D' };
        double gsilv[] = {0.0, 0.1,0.3,0.6};
        for (int i = 0;i<xinhaos.length;i++){
            if (s==xinhaos[i]){
                return gsilv[i];
            }
        }
        return 0;
    }
    public static void getInfos() {
        String[] rresResult = {"BBA","DCAB","CCB","ABCD","BCA","AC"};

        for (int i =0;i<rresResult.length;i++){
            char[] res =rresResult[i].toCharArray();
            double low = 0;
            double high =1;
            double codeRange = 0;
            double LowRange = 0;
            double range = 1.0;
            double zwl;

            for (int j = 0; j < res.length; j++) {
                LowRange = getLow(res[j]);
                codeRange = getIndex(res[j]);
                range = high - low;
                low = add(low , mul(range,LowRange));
                high = add(low , mul(range,codeRange));

            }
            zwl = mul(add(low , high),Math.pow(10,res.length)/2)%256;
            String zwll= Integer.toHexString((int) zwl); // Десятичное в шестнадцатеричное
            System.out.println(zwll);
        }
    }
    public static double mul(double v1,double v2){
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.multiply(b2).doubleValue();
    }
    public static double add(double v1,double v2){
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2).doubleValue();
    }
    public static double div(double v1,double v2,int scale){
        if(scale<0){
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.divide(b2,scale,BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public  static void main(String args[]){

        getInfos();
    }



}
