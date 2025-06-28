package com.google.android.gms.internal.measurement;

import android.net.Uri;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

/* compiled from: source */
/* loaded from: classes.dex */
public class zzbw {
    public static final Uri a = Uri.parse("content://com.google.android.gsf.gservices");
    private static final Uri d = Uri.parse("content://com.google.android.gsf.gservices/prefix");
    public static final Pattern b = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
    public static final Pattern c = Pattern.compile("^(0|false|f|off|no|n)$", 2);
    private static final AtomicBoolean e = new AtomicBoolean();
    private static final HashMap<String, Boolean> f = new HashMap<>();
    private static final HashMap<String, Integer> g = new HashMap<>();
    private static final HashMap<String, Long> h = new HashMap<>();
    private static final HashMap<String, Float> i = new HashMap<>();
    private static String[] j = new String[0];
}
