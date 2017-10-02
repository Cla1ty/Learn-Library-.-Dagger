package com.kristal.dagger;

import android.app.Application;
import android.os.Looper;
import android.util.Log;

import java.lang.reflect.Field;


public class Trace {
    private static boolean trace = BuildConfig.DEBUG;
    private static String packageName;

    private static final String TAG_LIFECYCLE = "lifecycle";

    public static void install(Application application) {
        packageName = application.getPackageName();
    }

    private static void buildString(String[] pOutStrings, String pMessage, int pParent) {
        StackTraceElement lTraceElements = new Throwable().getStackTrace()[2 + pParent];
        String lFileName = lTraceElements.getFileName();
        pOutStrings[0] = lFileName.substring(0, lFileName.length() - 5);
        pOutStrings[1] = "." + lTraceElements.getMethodName() + "(" + lTraceElements.getFileName() + ":" + lTraceElements.getLineNumber() + ")" + (pMessage.equals("")
                ? ""
                : " ") + pMessage;
    }

    public static void root() {
        StackTraceElement[] lTraceElements = new Throwable().getStackTrace();
        String lFileName = lTraceElements[1].getFileName();
        lFileName = lFileName.substring(0, lFileName.length() - 5);
        for (int i = 1; i < lTraceElements.length; i++) {
            if (!lTraceElements[i].getClassName().contains(packageName)) return;
            Log.e(lFileName, "" + lTraceElements[i]);
        }
    }

    public static void verbose(String pTitle, String... pMessage) {
        String lMessage = "===== " + pTitle.toUpperCase() + " =====";
        for (String s : pMessage) {
            lMessage += "\n" + s;
        }
        lMessage += "\n===== end =====";
        verbose(lMessage, 1);
    }

    public static void verbose(String pMessage) {
        verbose(pMessage, 1);
    }

    public static void verbose(String pMessage, int pParent) {
        if (!trace) return;

        String[] strings = new String[2];
        buildString(strings, pMessage, pParent);
        Log.v(strings[0], strings[1]);
    }

    public static void debug(String pMessage, Object pContext) {
        debug(pMessage + " --> " + pContext.getClass().getSimpleName(), 1);
    }

    public static void debug(String pMessage) {
        debug(pMessage, 1);
    }

    public static void lifecycle() {
        debug(TAG_LIFECYCLE, Looper.myLooper() == Looper.getMainLooper() ? "Main Thread" : "Worker Thread", 1);
    }

    public static void lifecycle(String message) {
        debug(TAG_LIFECYCLE, (Looper.myLooper() == Looper.getMainLooper() ? "Main Thread" : "Worker Thread") + " - " + message, 1);
    }

    public static void debug(String pMessage, int pParent) {
        if (!trace) return;

        String[] strings = new String[2];
        buildString(strings, pMessage, pParent);
        Log.d(strings[0], strings[1]);
    }

    public static void debug(String tag, String pMessage, int pParent) {
        if (!trace) return;

        String[] strings = new String[2];
        buildString(strings, pMessage, pParent);
        Log.d(tag, strings[1]);
    }

    public static void info(String pTitle, String... pMessage) {
        String lMessage = "===== " + pTitle.toUpperCase() + " =====";
        for (String s : pMessage) {
            lMessage += "\n" + s;
        }
        lMessage += "\n===== end =====";
        info(lMessage, 1);
    }

    public static void info(Object obj) {
        String lMessage = "===== " + obj.getClass().getSimpleName().toUpperCase() + " =====";
        try {
            for (Field lField : obj.getClass().getDeclaredFields()) {
                if (lField.getName().equals("$change") || lField.getName().equals("serialVersionUID"))
                    continue;

                lField.setAccessible(true);
                lMessage += "\n" + lField.getName() + " : " + lField.get(obj);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        lMessage += "\n===== end =====";
        info(lMessage, 1);
    }

    public static void info(Class pClass) {
        String lMessage = "===== " + pClass.getSimpleName().toUpperCase() + " =====";
        try {
            for (Field lField : pClass.getDeclaredFields()) {
                if (lField.getName().equals("$change") || lField.getName().equals("serialVersionUID"))
                    continue;

                lField.setAccessible(true);
                lMessage += "\n" + lField.getName() + " : " + lField.get(null);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        lMessage += "\n===== end =====";
        info(lMessage, 1);
    }

    public static void info(String pMessage) {
        info(pMessage, 1);
    }

    public static void info(String pMessage, int pParent) {
        if (!trace) return;

        String[] strings = new String[2];
        buildString(strings, pMessage, pParent);
        Log.i(strings[0], strings[1]);
    }

    public static void warm(String pMessage) {
        warm(pMessage, 1);
    }

    public static void warm(String pMessage, int pParent) {
        if (!trace) return;

        String[] strings = new String[2];
        buildString(strings, pMessage, pParent);
        Log.w(strings[0], strings[1]);
    }

    public static void error(String pMessage) {
        error(pMessage, 1);
    }

    public static void error(String pMessage, int pParent) {
        if (!trace) return;

        String[] strings = new String[2];
        buildString(strings, pMessage, pParent);
        Log.e(strings[0], strings[1]);
    }

    public static void wtf(String pMessage) {
        wtf(pMessage, 1);
    }

    private static void wtf(String pMessage, int pParent) {
        if (!trace) return;

        String[] strings = new String[2];
        buildString(strings, pMessage, pParent);
        Log.wtf(strings[0], strings[1]);
    }

    public static void wtf(String pVariableName, int pValue, int pValueNeed) {
        if (!trace || pValue == pValueNeed) return;

        String[] strings = new String[2];
        buildString(strings, pVariableName + " expected " + pValueNeed + " but was " + pValue, 0);
        Log.wtf(strings[0], strings[1]);
    }

    public static void wtfNot(String pVariableName, int pValue, int pValueNeed) {
        if (!trace || pValue == pValueNeed) return;

        String[] strings = new String[2];
        buildString(strings, pVariableName + " expected not " + pValueNeed, 0);
        Log.wtf(strings[0], strings[1]);
    }

    public static void wtf(String pVariableName, boolean pValue, boolean pValueNeed) {
        if (!trace || pValue == pValueNeed) return;

        String[] strings = new String[2];
        buildString(strings, pVariableName + " expected " + pValueNeed + " but was " + pValue, 0);
        Log.wtf(strings[0], strings[1]);
    }

    public static void wtf(String pVariableName, String pValue, String pValueNeed) {
        if (!trace || pValue.equals(pValueNeed)) return;

        String[] strings = new String[2];
        buildString(strings, pVariableName + " expected " + pValueNeed + " but was " + pValue, 0);
        Log.wtf(strings[0], strings[1]);
    }

    public static void wtfNot(String pVariableName, String pValue, String pValueNeed) {
        if (!trace || !pValue.equals(pValueNeed)) return;

        String[] strings = new String[2];
        buildString(strings, pVariableName + " expected not " + pValueNeed + " but was " + pValue, 0);
        Log.wtf(strings[0], strings[1]);
    }

    public static void wtf(String pVariableName, Object pValue) {
        if (!trace || pValue != null) return;

        String[] strings = new String[2];
        buildString(strings, pVariableName + " expected NOT NULL but was NULL", 0);
        Log.wtf(strings[0], strings[1]);
    }

    public static void wtf(Object pValue, String pMessage) {
        if (!trace || pValue != null) return;

        String[] strings = new String[2];
        buildString(strings, pMessage, 0);
        Log.wtf(strings[0], strings[1]);
    }

    public static void wtf(boolean pValue, String pMessage) {
        if (!trace || pValue) return;

        String[] strings = new String[2];
        buildString(strings, pMessage, 0);
        Log.wtf(strings[0], strings[1]);
    }


    public static void newLine() {
        Log.w("New Line", "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< START >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n\n");
    }
}
