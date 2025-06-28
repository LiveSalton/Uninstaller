package com.google.ads.mediation;

import com.google.android.gms.internal.ads.zzaza;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* compiled from: source */
@Deprecated
/* loaded from: classes.dex */
public class e {

    /* compiled from: source */
    public static final class a extends Exception {
        public a(String str) {
            super(str);
        }
    }

    /* compiled from: source */
    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface b {
        String a();

        boolean b() default true;
    }

    public void a(Map<String, String> map) throws a {
        HashMap hashMap = new HashMap();
        for (Field field : getClass().getFields()) {
            b bVar = (b) field.getAnnotation(b.class);
            if (bVar != null) {
                hashMap.put(bVar.a(), field);
            }
        }
        if (hashMap.isEmpty()) {
            zzaza.e("No server options fields detected. To suppress this message either add a field with the @Parameter annotation, or override the load() method.");
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            Field field2 = (Field) hashMap.remove(entry.getKey());
            if (field2 != null) {
                try {
                    field2.set(this, entry.getValue());
                } catch (IllegalAccessException unused) {
                    String key = entry.getKey();
                    StringBuilder sb = new StringBuilder(49 + String.valueOf(key).length());
                    sb.append("Server option \"");
                    sb.append(key);
                    sb.append("\" could not be set: Illegal Access");
                    zzaza.e(sb.toString());
                } catch (IllegalArgumentException unused2) {
                    String key2 = entry.getKey();
                    StringBuilder sb2 = new StringBuilder(43 + String.valueOf(key2).length());
                    sb2.append("Server option \"");
                    sb2.append(key2);
                    sb2.append("\" could not be set: Bad Type");
                    zzaza.e(sb2.toString());
                }
            } else {
                String key3 = entry.getKey();
                String value = entry.getValue();
                StringBuilder sb3 = new StringBuilder(31 + String.valueOf(key3).length() + String.valueOf(value).length());
                sb3.append("Unexpected server option: ");
                sb3.append(key3);
                sb3.append(" = \"");
                sb3.append(value);
                sb3.append("\"");
                zzaza.b(sb3.toString());
            }
        }
        StringBuilder sb4 = new StringBuilder();
        for (Field field3 : hashMap.values()) {
            if (((b) field3.getAnnotation(b.class)).b()) {
                String valueOf = String.valueOf(((b) field3.getAnnotation(b.class)).a());
                zzaza.e(valueOf.length() != 0 ? "Required server option missing: ".concat(valueOf) : new String("Required server option missing: "));
                if (sb4.length() > 0) {
                    sb4.append(", ");
                }
                sb4.append(((b) field3.getAnnotation(b.class)).a());
            }
        }
        if (sb4.length() > 0) {
            String valueOf2 = String.valueOf(sb4.toString());
            throw new a(valueOf2.length() != 0 ? "Required server option(s) missing: ".concat(valueOf2) : new String("Required server option(s) missing: "));
        }
    }
}
