package com.pileproject.drivecommand.util;

public class Log {
    public static void e(String tag, String msg) {
        System.err.println(String.format("%s: %s", tag, msg));
    }

    public static void e(String tag, String msg, Throwable e) {
        System.err.println(String.format("%s: %s", tag, msg));
        System.err.println(e.toString());
    }

    public static void d(String tag, String msg) {
        System.err.println(String.format("%s: %s", tag, msg));
    }
}
