package androidx.room.b;

import android.database.Cursor;
import android.os.Build;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* compiled from: source */
/* loaded from: classes.dex */
public class d {
    public final String a;
    public final Map<String, a> b;
    public final Set<b> c;
    public final Set<C0043d> d;

    public d(String str, Map<String, a> map, Set<b> set, Set<C0043d> set2) {
        this.a = str;
        this.b = Collections.unmodifiableMap(map);
        this.c = Collections.unmodifiableSet(set);
        this.d = set2 == null ? null : Collections.unmodifiableSet(set2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        if (this.a == null ? dVar.a != null : !this.a.equals(dVar.a)) {
            return false;
        }
        if (this.b == null ? dVar.b != null : !this.b.equals(dVar.b)) {
            return false;
        }
        if (this.c == null ? dVar.c != null : !this.c.equals(dVar.c)) {
            return false;
        }
        if (this.d == null || dVar.d == null) {
            return true;
        }
        return this.d.equals(dVar.d);
    }

    public int hashCode() {
        return (31 * (((this.a != null ? this.a.hashCode() : 0) * 31) + (this.b != null ? this.b.hashCode() : 0))) + (this.c != null ? this.c.hashCode() : 0);
    }

    public String toString() {
        return "TableInfo{name='" + this.a + "', columns=" + this.b + ", foreignKeys=" + this.c + ", indices=" + this.d + '}';
    }

    public static d a(androidx.g.a.b bVar, String str) {
        return new d(str, c(bVar, str), b(bVar, str), d(bVar, str));
    }

    private static Set<b> b(androidx.g.a.b bVar, String str) {
        int i;
        HashSet hashSet = new HashSet();
        Cursor b2 = bVar.b("PRAGMA foreign_key_list(`" + str + "`)");
        try {
            int columnIndex = b2.getColumnIndex("id");
            int columnIndex2 = b2.getColumnIndex("seq");
            int columnIndex3 = b2.getColumnIndex("table");
            int columnIndex4 = b2.getColumnIndex("on_delete");
            int columnIndex5 = b2.getColumnIndex("on_update");
            List<c> a2 = a(b2);
            int count = b2.getCount();
            int i2 = 0;
            while (i2 < count) {
                b2.moveToPosition(i2);
                if (b2.getInt(columnIndex2) != 0) {
                    i = columnIndex;
                } else {
                    int i3 = b2.getInt(columnIndex);
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    for (c cVar : a2) {
                        int i4 = columnIndex;
                        if (cVar.a == i3) {
                            arrayList.add(cVar.c);
                            arrayList2.add(cVar.d);
                        }
                        columnIndex = i4;
                    }
                    i = columnIndex;
                    hashSet.add(new b(b2.getString(columnIndex3), b2.getString(columnIndex4), b2.getString(columnIndex5), arrayList, arrayList2));
                }
                i2++;
                columnIndex = i;
            }
            return hashSet;
        } finally {
            b2.close();
        }
    }

    private static List<c> a(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("id");
        int columnIndex2 = cursor.getColumnIndex("seq");
        int columnIndex3 = cursor.getColumnIndex("from");
        int columnIndex4 = cursor.getColumnIndex("to");
        int count = cursor.getCount();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < count; i++) {
            cursor.moveToPosition(i);
            arrayList.add(new c(cursor.getInt(columnIndex), cursor.getInt(columnIndex2), cursor.getString(columnIndex3), cursor.getString(columnIndex4)));
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private static Map<String, a> c(androidx.g.a.b bVar, String str) {
        Cursor b2 = bVar.b("PRAGMA table_info(`" + str + "`)");
        HashMap hashMap = new HashMap();
        try {
            if (b2.getColumnCount() > 0) {
                int columnIndex = b2.getColumnIndex("name");
                int columnIndex2 = b2.getColumnIndex("type");
                int columnIndex3 = b2.getColumnIndex("notnull");
                int columnIndex4 = b2.getColumnIndex("pk");
                while (b2.moveToNext()) {
                    String string = b2.getString(columnIndex);
                    hashMap.put(string, new a(string, b2.getString(columnIndex2), b2.getInt(columnIndex3) != 0, b2.getInt(columnIndex4)));
                }
            }
            return hashMap;
        } finally {
            b2.close();
        }
    }

    private static Set<C0043d> d(androidx.g.a.b bVar, String str) {
        Cursor b2 = bVar.b("PRAGMA index_list(`" + str + "`)");
        try {
            int columnIndex = b2.getColumnIndex("name");
            int columnIndex2 = b2.getColumnIndex("origin");
            int columnIndex3 = b2.getColumnIndex("unique");
            if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1) {
                HashSet hashSet = new HashSet();
                while (b2.moveToNext()) {
                    if ("c".equals(b2.getString(columnIndex2))) {
                        String string = b2.getString(columnIndex);
                        boolean z = true;
                        if (b2.getInt(columnIndex3) != 1) {
                            z = false;
                        }
                        C0043d a2 = a(bVar, string, z);
                        if (a2 == null) {
                            return null;
                        }
                        hashSet.add(a2);
                    }
                }
                return hashSet;
            }
            return null;
        } finally {
            b2.close();
        }
    }

    private static C0043d a(androidx.g.a.b bVar, String str, boolean z) {
        Cursor b2 = bVar.b("PRAGMA index_xinfo(`" + str + "`)");
        try {
            int columnIndex = b2.getColumnIndex("seqno");
            int columnIndex2 = b2.getColumnIndex("cid");
            int columnIndex3 = b2.getColumnIndex("name");
            if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1) {
                TreeMap treeMap = new TreeMap();
                while (b2.moveToNext()) {
                    if (b2.getInt(columnIndex2) >= 0) {
                        treeMap.put(Integer.valueOf(b2.getInt(columnIndex)), b2.getString(columnIndex3));
                    }
                }
                ArrayList arrayList = new ArrayList(treeMap.size());
                arrayList.addAll(treeMap.values());
                return new C0043d(str, z, arrayList);
            }
            return null;
        } finally {
            b2.close();
        }
    }

    /* compiled from: source */
    public static class a {
        public final String a;
        public final String b;
        public final int c;
        public final boolean d;
        public final int e;

        public a(String str, String str2, boolean z, int i) {
            this.a = str;
            this.b = str2;
            this.d = z;
            this.e = i;
            this.c = a(str2);
        }

        private static int a(String str) {
            if (str == null) {
                return 5;
            }
            String upperCase = str.toUpperCase(Locale.US);
            if (upperCase.contains("INT")) {
                return 3;
            }
            if (upperCase.contains("CHAR") || upperCase.contains("CLOB") || upperCase.contains("TEXT")) {
                return 2;
            }
            if (upperCase.contains("BLOB")) {
                return 5;
            }
            return (upperCase.contains("REAL") || upperCase.contains("FLOA") || upperCase.contains("DOUB")) ? 4 : 1;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (Build.VERSION.SDK_INT >= 20) {
                if (this.e != aVar.e) {
                    return false;
                }
            } else if (a() != aVar.a()) {
                return false;
            }
            return this.a.equals(aVar.a) && this.d == aVar.d && this.c == aVar.c;
        }

        public boolean a() {
            return this.e > 0;
        }

        public int hashCode() {
            return (31 * ((((this.a.hashCode() * 31) + this.c) * 31) + (this.d ? 1231 : 1237))) + this.e;
        }

        public String toString() {
            return "Column{name='" + this.a + "', type='" + this.b + "', affinity='" + this.c + "', notNull=" + this.d + ", primaryKeyPosition=" + this.e + '}';
        }
    }

    /* compiled from: source */
    public static class b {
        public final String a;
        public final String b;
        public final String c;
        public final List<String> d;
        public final List<String> e;

        public b(String str, String str2, String str3, List<String> list, List<String> list2) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = Collections.unmodifiableList(list);
            this.e = Collections.unmodifiableList(list2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.a.equals(bVar.a) && this.b.equals(bVar.b) && this.c.equals(bVar.c) && this.d.equals(bVar.d)) {
                return this.e.equals(bVar.e);
            }
            return false;
        }

        public int hashCode() {
            return (31 * ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode())) + this.e.hashCode();
        }

        public String toString() {
            return "ForeignKey{referenceTable='" + this.a + "', onDelete='" + this.b + "', onUpdate='" + this.c + "', columnNames=" + this.d + ", referenceColumnNames=" + this.e + '}';
        }
    }

    /* compiled from: source */
    static class c implements Comparable<c> {
        final int a;
        final int b;
        final String c;
        final String d;

        c(int i, int i2, String str, String str2) {
            this.a = i;
            this.b = i2;
            this.c = str;
            this.d = str2;
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(c cVar) {
            int i = this.a - cVar.a;
            return i == 0 ? this.b - cVar.b : i;
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.room.b.d$d */
    public static class C0043d {
        public final String a;
        public final boolean b;
        public final List<String> c;

        public C0043d(String str, boolean z, List<String> list) {
            this.a = str;
            this.b = z;
            this.c = list;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C0043d c0043d = (C0043d) obj;
            if (this.b != c0043d.b || !this.c.equals(c0043d.c)) {
                return false;
            }
            if (this.a.startsWith("index_")) {
                return c0043d.a.startsWith("index_");
            }
            return this.a.equals(c0043d.a);
        }

        public int hashCode() {
            int hashCode;
            if (this.a.startsWith("index_")) {
                hashCode = "index_".hashCode();
            } else {
                hashCode = this.a.hashCode();
            }
            return (31 * ((hashCode * 31) + (this.b ? 1 : 0))) + this.c.hashCode();
        }

        public String toString() {
            return "Index{name='" + this.a + "', unique=" + this.b + ", columns=" + this.c + '}';
        }
    }
}
