/**
 * Copyright (c) www.bugull.com
 */
package NiuKeWangZhenTi;

import junit.framework.Test;

import java.util.Scanner;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package NiuKeWangZhenTi
 * @date 2017/3/22/022
 */
public class ReserveBase {

    private static String getSubString(String signText, Integer index, Integer length) {
        Integer size = signText.length();

        String preSub = signText.substring(0, index + length);
        String endSub = signText.substring(index + length);

        String targetSub = signText.substring(index, index + length);
        StringBuffer reverseSub = new StringBuffer(targetSub).reverse();

        StringBuffer sb = new StringBuffer(preSub);
        sb.append(reverseSub).append(endSub);
        return sb.toString();
    }

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();


        int count = Integer.valueOf(scanner.nextLine());


        for (int i = 0; i < count; i++) {
            String getScanneer = scanner.nextLine();

            String[] s = getScanneer.split(" +");

            text = getSubString(text, Integer.valueOf(s[0]), Integer.valueOf(s[1]));
        }

        System.out.println(text);
    }
}
