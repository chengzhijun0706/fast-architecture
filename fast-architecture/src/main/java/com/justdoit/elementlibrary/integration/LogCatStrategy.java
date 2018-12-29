package com.justdoit.elementlibrary.integration;

import android.support.annotation.NonNull;
import android.util.Log;

import com.orhanobut.logger.LogStrategy;

public class LogCatStrategy implements LogStrategy {

    private static ThreadLocal<Integer> last = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    private static final String[] ARMS = new String[]{"-A-", "-R-", "-M-", "-S-"};

    private static String computeKey() {
        if (last.get() >= 4) {
            last.set(0);
        }
        String s = ARMS[last.get()];
        last.set(last.get() + 1);
        return s;
    }

    @Override
    public void log(final int priority, final String tag, @NonNull final String message) {
        Log.println(priority, computeKey() + tag, message);
    }
}