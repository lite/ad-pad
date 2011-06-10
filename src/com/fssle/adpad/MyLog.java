package com.fssle.adpad;  

import android.util.Log;

public class MyLog {
                       
	public static final String MAIN_TAG = "MonTransit";

	private static boolean DEBUG = false;
	public static final boolean SHOW_LOCATION = false;

	public static boolean isLoggable(int level) {
		return DEBUG || Log.isLoggable(MAIN_TAG, level);
	}

	public static void v(String tag, String msg) {
		if (DEBUG || Log.isLoggable(MAIN_TAG, Log.VERBOSE)) {
			Log.v(MAIN_TAG, String.format("%s>%s", tag, msg));
		}
	}

	public static void v(String tag, String msg, Object... args) {
		if (DEBUG || Log.isLoggable(MAIN_TAG, Log.VERBOSE)) {
			Log.v(MAIN_TAG, String.format("%s>%s", tag, String.format(msg, args)));
		}
	}

	public static void d(String tag, String msg) {
		if (DEBUG || Log.isLoggable(MAIN_TAG, Log.DEBUG)) {
			Log.d(MAIN_TAG, String.format("%s>%s", tag, msg));
		}
	}

	public static void d(String tag, String msg, Object... args) {
		if (DEBUG || Log.isLoggable(MAIN_TAG, Log.DEBUG)) {
			Log.d(MAIN_TAG, String.format("%s>%s", tag, String.format(msg, args)));
		}
	}

	public static void i(String tag, String msg) {
		if (DEBUG || Log.isLoggable(MAIN_TAG, Log.INFO)) {
			Log.i(MAIN_TAG, String.format("%s>%s", tag, msg));
		}
	}

	public static void i(String tag, String msg, Object... args) {
		if (DEBUG || Log.isLoggable(MAIN_TAG, Log.INFO)) {
			Log.i(MAIN_TAG, String.format("%s>%s", tag, String.format(msg, args)));
		}
	}

	public static void w(String tag, String msg, Object... args) {
		if (DEBUG || Log.isLoggable(MAIN_TAG, Log.WARN)) {
			Log.w(MAIN_TAG, String.format("%s>%s", tag, String.format(msg, args)));
		}
	}

	public static void w(String tag, Throwable t, String msg, Object... args) {
		if (DEBUG || Log.isLoggable(MAIN_TAG, Log.WARN)) {
			Log.w(MAIN_TAG, String.format("%s>%s", tag, String.format(msg, args)), t);
		}
	}

	public static void e(String tag, Throwable t, String msg) {
		if (DEBUG || Log.isLoggable(MAIN_TAG, Log.ERROR)) {
			Log.e(MAIN_TAG, String.format("%s>%s", tag, msg), t);
		}
	}
}
