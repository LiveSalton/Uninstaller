package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.h.w;
import androidx.core.h.y;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: source */
@SuppressLint({"UnknownNullness"})
/* loaded from: classes.dex */
public abstract class q {
    public abstract Object a(Object obj, Object obj2, Object obj3);

    public abstract void a(ViewGroup viewGroup, Object obj);

    public abstract void a(Object obj, Rect rect);

    public abstract void a(Object obj, View view);

    public abstract void a(Object obj, View view, ArrayList<View> arrayList);

    public abstract void a(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3);

    public abstract void a(Object obj, ArrayList<View> arrayList);

    public abstract void a(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    public abstract boolean a(Object obj);

    public abstract Object b(Object obj);

    public abstract Object b(Object obj, Object obj2, Object obj3);

    public abstract void b(Object obj, View view);

    public abstract void b(Object obj, View view, ArrayList<View> arrayList);

    public abstract void b(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    public abstract Object c(Object obj);

    public abstract void c(Object obj, View view);

    protected void a(View view, Rect rect) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        rect.set(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
    }

    ArrayList<String> a(ArrayList<View> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            View view = arrayList.get(i);
            arrayList2.add(w.r(view));
            w.a(view, (String) null);
        }
        return arrayList2;
    }

    void a(View view, ArrayList<View> arrayList, ArrayList<View> arrayList2, ArrayList<String> arrayList3, Map<String, String> map) {
        int size = arrayList2.size();
        ArrayList arrayList4 = new ArrayList();
        for (int i = 0; i < size; i++) {
            View view2 = arrayList.get(i);
            String r = w.r(view2);
            arrayList4.add(r);
            if (r != null) {
                w.a(view2, (String) null);
                String str = map.get(r);
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        break;
                    }
                    if (str.equals(arrayList3.get(i2))) {
                        w.a(arrayList2.get(i2), r);
                        break;
                    }
                    i2++;
                }
            }
        }
        androidx.core.h.s.a(view, new Runnable() { // from class: androidx.fragment.app.q.1
            final /* synthetic */ int a;
            final /* synthetic */ ArrayList b;
            final /* synthetic */ ArrayList c;
            final /* synthetic */ ArrayList d;
            final /* synthetic */ ArrayList e;

            AnonymousClass1(int size2, ArrayList arrayList22, ArrayList arrayList32, ArrayList arrayList5, ArrayList arrayList42) {
                size = size2;
                arrayList2 = arrayList22;
                arrayList3 = arrayList32;
                arrayList = arrayList5;
                arrayList4 = arrayList42;
            }

            @Override // java.lang.Runnable
            public void run() {
                for (int i3 = 0; i3 < size; i3++) {
                    w.a((View) arrayList2.get(i3), (String) arrayList3.get(i3));
                    w.a((View) arrayList.get(i3), (String) arrayList4.get(i3));
                }
            }
        });
    }

    /* compiled from: source */
    /* renamed from: androidx.fragment.app.q$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ int a;
        final /* synthetic */ ArrayList b;
        final /* synthetic */ ArrayList c;
        final /* synthetic */ ArrayList d;
        final /* synthetic */ ArrayList e;

        AnonymousClass1(int size2, ArrayList arrayList22, ArrayList arrayList32, ArrayList arrayList5, ArrayList arrayList42) {
            size = size2;
            arrayList2 = arrayList22;
            arrayList3 = arrayList32;
            arrayList = arrayList5;
            arrayList4 = arrayList42;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (int i3 = 0; i3 < size; i3++) {
                w.a((View) arrayList2.get(i3), (String) arrayList3.get(i3));
                w.a((View) arrayList.get(i3), (String) arrayList4.get(i3));
            }
        }
    }

    void a(ArrayList<View> arrayList, View view) {
        if (view.getVisibility() == 0) {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (y.a(viewGroup)) {
                    arrayList.add(viewGroup);
                    return;
                }
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    a(arrayList, viewGroup.getChildAt(i));
                }
                return;
            }
            arrayList.add(view);
        }
    }

    void a(Map<String, View> map, View view) {
        if (view.getVisibility() == 0) {
            String r = w.r(view);
            if (r != null) {
                map.put(r, view);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    a(map, viewGroup.getChildAt(i));
                }
            }
        }
    }

    /* compiled from: source */
    /* renamed from: androidx.fragment.app.q$2 */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ ArrayList a;
        final /* synthetic */ Map b;

        AnonymousClass2(ArrayList arrayList, Map map) {
            arrayList = arrayList;
            map = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                View view = (View) arrayList.get(i);
                String r = w.r(view);
                if (r != null) {
                    w.a(view, q.a((Map<String, String>) map, r));
                }
            }
        }
    }

    void a(View view, ArrayList<View> arrayList, Map<String, String> map) {
        androidx.core.h.s.a(view, new Runnable() { // from class: androidx.fragment.app.q.2
            final /* synthetic */ ArrayList a;
            final /* synthetic */ Map b;

            AnonymousClass2(ArrayList arrayList2, Map map2) {
                arrayList = arrayList2;
                map = map2;
            }

            @Override // java.lang.Runnable
            public void run() {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    View view2 = (View) arrayList.get(i);
                    String r = w.r(view2);
                    if (r != null) {
                        w.a(view2, q.a((Map<String, String>) map, r));
                    }
                }
            }
        });
    }

    public void a(Fragment fragment, Object obj, androidx.core.d.a aVar, Runnable runnable) {
        runnable.run();
    }

    /* compiled from: source */
    /* renamed from: androidx.fragment.app.q$3 */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ ArrayList a;
        final /* synthetic */ Map b;

        AnonymousClass3(ArrayList arrayList, Map map) {
            arrayList = arrayList;
            map = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                View view = (View) arrayList.get(i);
                w.a(view, (String) map.get(w.r(view)));
            }
        }
    }

    void a(ViewGroup viewGroup, ArrayList<View> arrayList, Map<String, String> map) {
        androidx.core.h.s.a(viewGroup, new Runnable() { // from class: androidx.fragment.app.q.3
            final /* synthetic */ ArrayList a;
            final /* synthetic */ Map b;

            AnonymousClass3(ArrayList arrayList2, Map map2) {
                arrayList = arrayList2;
                map = map2;
            }

            @Override // java.lang.Runnable
            public void run() {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    View view = (View) arrayList.get(i);
                    w.a(view, (String) map.get(w.r(view)));
                }
            }
        });
    }

    protected static void a(List<View> list, View view) {
        int size = list.size();
        if (a(list, view, size)) {
            return;
        }
        list.add(view);
        for (int i = size; i < list.size(); i++) {
            View view2 = list.get(i);
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = viewGroup.getChildAt(i2);
                    if (!a(list, childAt, size)) {
                        list.add(childAt);
                    }
                }
            }
        }
    }

    private static boolean a(List<View> list, View view, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (list.get(i2) == view) {
                return true;
            }
        }
        return false;
    }

    protected static boolean a(List list) {
        return list == null || list.isEmpty();
    }

    static String a(Map<String, String> map, String str) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (str.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }
}
