import org.apache.commons.lang3.RandomStringUtils;

import java.io.FileInputStream;
import java.util.Locale;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        String dot = ".";
        String id1 = RandomStringUtils.random(10, true, true).toLowerCase(Locale.ROOT);
        String id2 = RandomStringUtils.randomAlphanumeric(10);
        String id3 = RandomStringUtils.random(10, "12345abcde");
        String id4 = RandomStringUtils.randomAlphabetic(10);
        String id5 = RandomStringUtils.randomNumeric(10);
        String id6 = RandomStringUtils.randomAscii(10);
        String id7 = RandomStringUtils.randomGraph(10);

//        int num1 = 10;
//        int num2 = 20;
//        double flow = 3.49999;
//        int max = Math.max(num1,num2);
//        int max1 = Math.abs(num1);

//        int round = (int) Math.round(flow);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first number : ");
        int num1 = scanner.nextInt();
        System.out.println("Enter second number : ");
        int num2 = scanner.nextInt();
        int max = Math.max(num1,num2);
        System.out.printf("Max of (%d,%d) is %d %n",num1,num2,max);

        StringBuffer fapiId = new StringBuffer();
        fapiId.append(id1).append("-").append(id2).append("-").append(id3).append("-").append(id4).append("-").append(id5);
//        fapiId.append(id5).append(".").append(id1);

//        System.out.println("Random Count letters and numbers: " + id1);
//        System.out.println("Random alphanumeric: " + id2);
//        System.out.println("Random count given specific chars: " + id3);
//        System.out.println("Random alphabetic: " + id4);
//        System.out.println("Random numeric: " + id5);
//        System.out.println("Random Ascii: " + id6);
//        System.out.println("Random Graph: " + id7);

        String fapiInterID = String.valueOf(fapiId);
//System.setProperty(fapiInterID, String.valueOf(fapiId));
//        System.out.println(fapiInterID);
    }
}
