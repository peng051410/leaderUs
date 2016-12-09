package tomyli;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * lizp@ishugui.com
 *
 * @author tomyli 2016/12/06 21:17.
 */
public class JavaBase {

    public static void main(String[] args) {


/*
        Double dbl[] = new Double[1000000];
        for(int i=0; i<dbl.length;i++){
            dbl[i]=Math.random();
        }
*/

/*
        long start = System.currentTimeMillis();
        Arrays.parallelSort(dbl);
        Arrays.sort(dbl);
        System.out.println("time taken :"+((System.currentTimeMillis())-start));
*/


//        testByte();
//        testByte2();
        testArray();
//        testSalary();
    }

    private static void testByte() {
        byte ba = 127;

        //位运算针对的是整形,除了long类型外,其它的类型都要扩展成int
//        byte bb  = ba << 2;
//        int bb = ba << 2;


    }

    private static void testByte2() {
        int a = -1024;
        // 00000000 00000000 00000100 00000000 原码
        // 11111111 11111111 11111011 11111111 取反
        // 11111111 11111111 11111100 00000000 +1

        // 11111111 11111111 11111100 00000000
        //>>1
        // 11111111 11111111 11111110 00000000

        // 11111111 11111111 11111100 00000000
        //>>>1
        // 01111111 11111111 11111110 00000000

        int rResult = a >> 1;
        System.out.println(rResult);

        int rrResult = a >>> 1;
        System.out.println(rrResult);
    }

    private static void testArray() {

        long start = System.currentTimeMillis();

        int number = 10240;

        long result = 0;
        byte[][] arr = new byte[number][number];
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                result += arr[j][i];
            }
        }

        System.out.println(result);
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    private static void testSalary() {

        long start = System.currentTimeMillis();

        int number = 10000;
        Object[] objects = new Object[number];
        for (int i = 0; i < number; i++) {

            Salary salary = new Salary();
            int baseSalary = ThreadLocalRandom.current().nextInt(5, 1000001);
            salary.setBaseSalary(baseSalary);

            int bonus = ThreadLocalRandom.current().nextInt(0, 100001);
            salary.setBonus(bonus);
            salary.setName(random(5));

            objects[i] = salary;
        }

        List<Object> objects1 = Arrays.asList(objects);
        List<Salary> salaries = (List<Salary>) (Object) objects1;

        Collections.sort(salaries, new SalaryComparator());
        for (int i = 0; i < 10; i++) {
            System.out.println(salaries.get(i).getName());
        }

        System.out.println(System.currentTimeMillis() - start);

    }

    private static String random(int length) {

        StringBuilder builder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            char b = (char) ThreadLocalRandom.current().nextInt(97, 122);
            builder.append(b);
        }
        return builder.toString();
    }

    private static class SalaryComparator implements Comparator<Salary> {

        @Override
        public int compare(Salary o1, Salary o2) {

            int baseSalary = o1.getBaseSalary();
            int bonus = o1.getBonus();
            int total1 = baseSalary * 13 + bonus;

            int baseSalary1 = o2.getBaseSalary();
            int bonus1 = o2.getBonus();
            int total2 = baseSalary1 * 13 + bonus1;

            return Integer.compare(total2, total1);
        }
    }
}
