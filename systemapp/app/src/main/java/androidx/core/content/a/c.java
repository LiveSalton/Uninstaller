package androidx.core.content.a;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.Base64;
import android.util.TypedValue;
import android.util.Xml;
import androidx.core.a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: source */
/* loaded from: classes.dex */
public class c {

    /* compiled from: source */
    public interface a {
    }

    /* compiled from: source */
    public static final class d implements a {
        private final androidx.core.e.a a;
        private final int b;
        private final int c;

        public d(androidx.core.e.a aVar, int i, int i2) {
            this.a = aVar;
            this.c = i;
            this.b = i2;
        }

        public androidx.core.e.a a() {
            return this.a;
        }

        public int b() {
            return this.c;
        }

        public int c() {
            return this.b;
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.core.content.a.c$c */
    public static final class C0018c {
        private final String a;
        private int b;
        private boolean c;
        private String d;
        private int e;
        private int f;

        public C0018c(String str, int i, boolean z, String str2, int i2, int i3) {
            this.a = str;
            this.b = i;
            this.c = z;
            this.d = str2;
            this.e = i2;
            this.f = i3;
        }

        public String a() {
            return this.a;
        }

        public int b() {
            return this.b;
        }

        public boolean c() {
            return this.c;
        }

        public String d() {
            return this.d;
        }

        public int e() {
            return this.e;
        }

        public int f() {
            return this.f;
        }
    }

    /* compiled from: source */
    public static final class b implements a {
        private final C0018c[] a;

        public b(C0018c[] c0018cArr) {
            this.a = c0018cArr;
        }

        public C0018c[] a() {
            return this.a;
        }
    }

    public static a a(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        return b(xmlPullParser, resources);
    }

    private static a b(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return c(xmlPullParser, resources);
        }
        a(xmlPullParser);
        return null;
    }

    private static a c(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), a.c.FontFamily);
        String string = obtainAttributes.getString(a.c.FontFamily_fontProviderAuthority);
        String string2 = obtainAttributes.getString(a.c.FontFamily_fontProviderPackage);
        String string3 = obtainAttributes.getString(a.c.FontFamily_fontProviderQuery);
        int resourceId = obtainAttributes.getResourceId(a.c.FontFamily_fontProviderCerts, 0);
        int integer = obtainAttributes.getInteger(a.c.FontFamily_fontProviderFetchStrategy, 1);
        int integer2 = obtainAttributes.getInteger(a.c.FontFamily_fontProviderFetchTimeout, 500);
        obtainAttributes.recycle();
        if (string != null && string2 != null && string3 != null) {
            while (xmlPullParser.next() != 3) {
                a(xmlPullParser);
            }
            return new d(new androidx.core.e.a(string, string2, string3, a(resources, resourceId)), integer, integer2);
        }
        ArrayList arrayList = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("font")) {
                    arrayList.add(d(xmlPullParser, resources));
                } else {
                    a(xmlPullParser);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new b((C0018c[]) arrayList.toArray(new C0018c[arrayList.size()]));
    }

    private static int a(TypedArray typedArray, int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            return typedArray.getType(i);
        }
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(i, typedValue);
        return typedValue.type;
    }

    public static List<List<byte[]>> a(Resources resources, int i) {
        if (i == 0) {
            return Collections.emptyList();
        }
        TypedArray obtainTypedArray = resources.obtainTypedArray(i);
        try {
            if (obtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (a(obtainTypedArray, 0) == 1) {
                for (int i2 = 0; i2 < obtainTypedArray.length(); i2++) {
                    int resourceId = obtainTypedArray.getResourceId(i2, 0);
                    if (resourceId != 0) {
                        arrayList.add(a(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(a(resources.getStringArray(i)));
            }
            return arrayList;
        } finally {
            obtainTypedArray.recycle();
        }
    }

    private static List<byte[]> a(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(Base64.decode(str, 0));
        }
        return arrayList;
    }

    private static C0018c d(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), a.c.FontFamilyFont);
        if (obtainAttributes.hasValue(a.c.FontFamilyFont_fontWeight)) {
            i = a.c.FontFamilyFont_fontWeight;
        } else {
            i = a.c.FontFamilyFont_android_fontWeight;
        }
        int i6 = obtainAttributes.getInt(i, 400);
        if (obtainAttributes.hasValue(a.c.FontFamilyFont_fontStyle)) {
            i2 = a.c.FontFamilyFont_fontStyle;
        } else {
            i2 = a.c.FontFamilyFont_android_fontStyle;
        }
        boolean z = 1 == obtainAttributes.getInt(i2, 0);
        if (obtainAttributes.hasValue(a.c.FontFamilyFont_ttcIndex)) {
            i3 = a.c.FontFamilyFont_ttcIndex;
        } else {
            i3 = a.c.FontFamilyFont_android_ttcIndex;
        }
        if (obtainAttributes.hasValue(a.c.FontFamilyFont_fontVariationSettings)) {
            i4 = a.c.FontFamilyFont_fontVariationSettings;
        } else {
            i4 = a.c.FontFamilyFont_android_fontVariationSettings;
        }
        String string = obtainAttributes.getString(i4);
        int i7 = obtainAttributes.getInt(i3, 0);
        if (obtainAttributes.hasValue(a.c.FontFamilyFont_font)) {
            i5 = a.c.FontFamilyFont_font;
        } else {
            i5 = a.c.FontFamilyFont_android_font;
        }
        int resourceId = obtainAttributes.getResourceId(i5, 0);
        String string2 = obtainAttributes.getString(i5);
        obtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            a(xmlPullParser);
        }
        return new C0018c(string2, i6, z, string, i7, resourceId);
    }

    private static void a(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int i = 1;
        while (i > 0) {
            switch (xmlPullParser.next()) {
                case 2:
                    i++;
                    break;
                case 3:
                    i--;
                    break;
            }
        }
    }
}
