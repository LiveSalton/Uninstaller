package androidx.f.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.multidex.BuildConfig;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* compiled from: source */
/* loaded from: classes.dex */
public final class a {
    private static final Object f = new Object();
    private static a g;
    private final Context a;
    private final HashMap<BroadcastReceiver, ArrayList<b>> b = new HashMap<>();
    private final HashMap<String, ArrayList<b>> c = new HashMap<>();
    private final ArrayList<C0035a> d = new ArrayList<>();
    private final Handler e;

    /* compiled from: source */
    private static final class b {
        final IntentFilter a;
        final BroadcastReceiver b;
        boolean c;
        boolean d;

        b(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.a = intentFilter;
            this.b = broadcastReceiver;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.b);
            sb.append(" filter=");
            sb.append(this.a);
            if (this.d) {
                sb.append(" DEAD");
            }
            sb.append("}");
            return sb.toString();
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.f.a.a$a */
    private static final class C0035a {
        final Intent a;
        final ArrayList<b> b;

        C0035a(Intent intent, ArrayList<b> arrayList) {
            this.a = intent;
            this.b = arrayList;
        }
    }

    public static a a(Context context) {
        a aVar;
        synchronized (f) {
            if (g == null) {
                g = new a(context.getApplicationContext());
            }
            aVar = g;
        }
        return aVar;
    }

    private a(Context context) {
        this.a = context;
        this.e = new Handler(context.getMainLooper()) { // from class: androidx.f.a.a.1
            AnonymousClass1(Looper looper) {
                super(looper);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    a.this.a();
                } else {
                    super.handleMessage(message);
                }
            }
        };
    }

    /* compiled from: source */
    /* renamed from: androidx.f.a.a$1 */
    class AnonymousClass1 extends Handler {
        AnonymousClass1(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                a.this.a();
            } else {
                super.handleMessage(message);
            }
        }
    }

    public void a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.b) {
            b bVar = new b(intentFilter, broadcastReceiver);
            ArrayList<b> arrayList = this.b.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList<>(1);
                this.b.put(broadcastReceiver, arrayList);
            }
            arrayList.add(bVar);
            for (int i = 0; i < intentFilter.countActions(); i++) {
                String action = intentFilter.getAction(i);
                ArrayList<b> arrayList2 = this.c.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>(1);
                    this.c.put(action, arrayList2);
                }
                arrayList2.add(bVar);
            }
        }
    }

    public void a(BroadcastReceiver broadcastReceiver) {
        synchronized (this.b) {
            ArrayList<b> remove = this.b.remove(broadcastReceiver);
            if (remove == null) {
                return;
            }
            for (int size = remove.size() - 1; size >= 0; size--) {
                b bVar = remove.get(size);
                bVar.d = true;
                for (int i = 0; i < bVar.a.countActions(); i++) {
                    String action = bVar.a.getAction(i);
                    ArrayList<b> arrayList = this.c.get(action);
                    if (arrayList != null) {
                        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                            b bVar2 = arrayList.get(size2);
                            if (bVar2.b == broadcastReceiver) {
                                bVar2.d = true;
                                arrayList.remove(size2);
                            }
                        }
                        if (arrayList.size() <= 0) {
                            this.c.remove(action);
                        }
                    }
                }
            }
        }
    }

    public boolean a(Intent intent) {
        String str;
        ArrayList arrayList;
        int i;
        ArrayList<b> arrayList2;
        String str2;
        Uri uri;
        String str3;
        synchronized (this.b) {
            String action = intent.getAction();
            String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.a.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            boolean z = (intent.getFlags() & 8) != 0;
            if (z) {
                Log.v("LocalBroadcastManager", "Resolving type " + resolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
            }
            ArrayList<b> arrayList3 = this.c.get(intent.getAction());
            if (arrayList3 != null) {
                if (z) {
                    Log.v("LocalBroadcastManager", "Action list: " + arrayList3);
                }
                ArrayList arrayList4 = null;
                int i2 = 0;
                while (i2 < arrayList3.size()) {
                    b bVar = arrayList3.get(i2);
                    if (z) {
                        Log.v("LocalBroadcastManager", "Matching against filter " + bVar.a);
                    }
                    if (bVar.c) {
                        if (z) {
                            Log.v("LocalBroadcastManager", "  Filter's target already added");
                        }
                        i = i2;
                        arrayList2 = arrayList3;
                        str = action;
                        str2 = resolveTypeIfNeeded;
                        uri = data;
                        arrayList = arrayList4;
                    } else {
                        IntentFilter intentFilter = bVar.a;
                        String str4 = action;
                        str = action;
                        arrayList = arrayList4;
                        i = i2;
                        arrayList2 = arrayList3;
                        str2 = resolveTypeIfNeeded;
                        uri = data;
                        int match = intentFilter.match(str4, resolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                        if (match >= 0) {
                            if (z) {
                                Log.v("LocalBroadcastManager", "  Filter matched!  match=0x" + Integer.toHexString(match));
                            }
                            arrayList4 = arrayList == null ? new ArrayList() : arrayList;
                            arrayList4.add(bVar);
                            bVar.c = true;
                            i2 = i + 1;
                            action = str;
                            arrayList3 = arrayList2;
                            resolveTypeIfNeeded = str2;
                            data = uri;
                        } else if (z) {
                            switch (match) {
                                case -4:
                                    str3 = "category";
                                    break;
                                case -3:
                                    str3 = "action";
                                    break;
                                case -2:
                                    str3 = "data";
                                    break;
                                case BuildConfig.VERSION_CODE /* -1 */:
                                    str3 = "type";
                                    break;
                                default:
                                    str3 = "unknown reason";
                                    break;
                            }
                            Log.v("LocalBroadcastManager", "  Filter did not match: " + str3);
                        }
                    }
                    arrayList4 = arrayList;
                    i2 = i + 1;
                    action = str;
                    arrayList3 = arrayList2;
                    resolveTypeIfNeeded = str2;
                    data = uri;
                }
                ArrayList arrayList5 = arrayList4;
                if (arrayList5 != null) {
                    for (int i3 = 0; i3 < arrayList5.size(); i3++) {
                        ((b) arrayList5.get(i3)).c = false;
                    }
                    this.d.add(new C0035a(intent, arrayList5));
                    if (!this.e.hasMessages(1)) {
                        this.e.sendEmptyMessage(1);
                    }
                    return true;
                }
            }
            return false;
        }
    }

    void a() {
        C0035a[] c0035aArr;
        while (true) {
            synchronized (this.b) {
                int size = this.d.size();
                if (size <= 0) {
                    return;
                }
                c0035aArr = new C0035a[size];
                this.d.toArray(c0035aArr);
                this.d.clear();
            }
            for (C0035a c0035a : c0035aArr) {
                int size2 = c0035a.b.size();
                for (int i = 0; i < size2; i++) {
                    b bVar = c0035a.b.get(i);
                    if (!bVar.d) {
                        bVar.b.onReceive(this.a, c0035a.a);
                    }
                }
            }
        }
    }
}
