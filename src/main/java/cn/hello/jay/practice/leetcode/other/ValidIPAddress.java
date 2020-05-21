package cn.hello.jay.practice.leetcode.other;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 周健以
 * @Date 2020年04月11日
 */
public class ValidIPAddress {


    public static String validIPAddress(String IP) {
        final String RES_IPV4 = "IPv4";
        final String RES_IPV6 = "IPv6";
        final String RES_NEITHER = "Neither";

        final String POINT = "\\.";
        final String COLON = ":";
        try {
            if (isBlank(IP)) {
                return RES_NEITHER;
            }

            if (IP.split(POINT).length == 4) {
                if (IP.startsWith(".") || IP.endsWith(".")) {
                    return RES_NEITHER;
                }
                String[] segments = IP.split(POINT);
                for (String segment : segments) {
                    if (isBlank(segment)) {
                        return RES_NEITHER;
                    }

                    if (segment.startsWith("0") && segment.length() != 1) {
                        return RES_NEITHER;
                    }

                    Pattern pattern = Pattern.compile("^[0-9]+$");
                    Matcher matcher = pattern.matcher(segment);
                    if (!matcher.matches()) {
                        return RES_NEITHER;
                    }

                    int num = Integer.parseInt(segment);
                    if (num < 0 || num > 255) {
                        return RES_NEITHER;
                    }
                }
                return RES_IPV4;
            } else if (IP.split(COLON).length == 8) {
                if (IP.startsWith(COLON) || IP.endsWith(COLON)) {
                    return RES_NEITHER;
                }
                String[] segments = IP.split(COLON);
                for (String segment : segments) {
                    if (isBlank(segment)) {
                        return RES_NEITHER;
                    }

                    Pattern pattern = Pattern.compile("^[a-fA-F0-9]+$");
                    Matcher matcher = pattern.matcher(segment);
                    if (!matcher.matches()) {
                        return RES_NEITHER;
                    }

                    if (segment.length() < 1 || segment.length() > 4) {
                        return RES_NEITHER;
                    }

                }
                return RES_IPV6;
            }
            return RES_NEITHER;
        } catch (Exception e) {
            return RES_NEITHER;
        }
    }

    static boolean isBlank(String str) {
        return str == null || "".equalsIgnoreCase(str);
    }


    public static void mainReplace(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                ValidIPAddress.a();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                ValidIPAddress.b();
            }
        }).start();
    }

    public static synchronized void a() {
        System.out.println("a");
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void b() {
        System.out.println("b");
    }

}
