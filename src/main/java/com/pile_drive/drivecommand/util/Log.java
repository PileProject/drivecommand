package com.pile_drive.drivecommand.util;

public class Log {
	public static final void e(String tag, String msg) {
		System.err.println(String.format("%s: %s", tag, msg));
	}
	
	public static final void e(String tag, String msg, Throwable e) {
		System.err.println(String.format("%s: %s", tag, msg));
		System.err.println(e);
	}
	
	public static final void d(String tag, String msg) {
		System.err.println(String.format("%s: %s", tag, msg));
	}
}
