package tomyli;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.function.IntUnaryOperator;

/**
 * lizp@ishugui.com
 *
 * @author tomyli 2016/12/07 17:07.
 */
public class StudyBase {

    public static void main(String[] args) {
//        testNetHeader();
//        testBase();
//        testBig();
        testArray();
    }

    private static void testArray() {

        int[] arr = new int[10];
        Arrays.setAll(arr, IntUnaryOperator.identity());

    }

    private static void testBig() {
        //BigInt and BigDecimal
        BigInteger bigInteger1 = new BigInteger("20");
        BigInteger bigInteger2 = new BigInteger("20");
        System.out.println(bigInteger1.compareTo(bigInteger2));

        BigDecimal bigDecimal1 = new BigDecimal("1.0");
        BigDecimal bigDecimal2 = new BigDecimal("1");
        System.out.println(bigDecimal1.compareTo(bigDecimal2));
        System.out.println(bigDecimal1.equals(bigDecimal2));
    }

    private static void testNetHeader() {

        byte a = (byte) 0xf0;
        System.out.println(a);

        int real = a & 0xff;
        System.out.println(real);

        int flg = 0B01101000;
        byte b = (byte) ((flg & 0B00110000) >> 4);
        System.out.println(b);

        short aInt = (short) 0xff00;
        System.out.println(aInt);
        int bInt = aInt & 0xffff;
        System.out.println(bInt);
    }

    private static void testBase() {
        int a = (int) 1023.999999999999;
        System.out.println(a);
    }
}
