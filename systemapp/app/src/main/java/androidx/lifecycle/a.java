package androidx.lifecycle;

import androidx.lifecycle.f;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
class a {
    static a a = new a();
    private final Map<Class<?>, C0039a> b = new HashMap();
    private final Map<Class<?>, Boolean> c = new HashMap();

    a() {
    }

    boolean a(Class<?> cls) {
        Boolean bool = this.c.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        Method[] c = c(cls);
        for (Method method : c) {
            if (((q) method.getAnnotation(q.class)) != null) {
                a(cls, c);
                return true;
            }
        }
        this.c.put(cls, false);
        return false;
    }

    private Method[] c(Class<?> cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e);
        }
    }

    C0039a b(Class<?> cls) {
        C0039a c0039a = this.b.get(cls);
        return c0039a != null ? c0039a : a(cls, null);
    }

    private void a(Map<b, f.a> map, b bVar, f.a aVar, Class<?> cls) {
        f.a aVar2 = map.get(bVar);
        if (aVar2 == null || aVar == aVar2) {
            if (aVar2 == null) {
                map.put(bVar, aVar);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Method " + bVar.b.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + aVar2 + ", new value " + aVar);
    }

    private C0039a a(Class<?> cls, Method[] methodArr) {
        int i;
        C0039a b2;
        Class<? super Object> superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        if (superclass != null && (b2 = b(superclass)) != null) {
            hashMap.putAll(b2.b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Map.Entry<b, f.a> entry : b(cls2).b.entrySet()) {
                a(hashMap, entry.getKey(), entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = c(cls);
        }
        boolean z = false;
        for (Method method : methodArr) {
            q qVar = (q) method.getAnnotation(q.class);
            if (qVar != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i = 0;
                } else {
                    if (!parameterTypes[0].isAssignableFrom(j.class)) {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                    i = 1;
                }
                f.a a2 = qVar.a();
                if (parameterTypes.length > 1) {
                    if (!parameterTypes[1].isAssignableFrom(f.a.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if (a2 != f.a.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    i = 2;
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                a(hashMap, new b(i, method), a2, cls);
                z = true;
            }
        }
        C0039a c0039a = new C0039a(hashMap);
        this.b.put(cls, c0039a);
        this.c.put(cls, Boolean.valueOf(z));
        return c0039a;
    }

    /* compiled from: source */
    /* renamed from: androidx.lifecycle.a$a */
    static class C0039a {
        final Map<f.a, List<b>> a = new HashMap();
        final Map<b, f.a> b;

        C0039a(Map<b, f.a> map) {
            this.b = map;
            for (Map.Entry<b, f.a> entry : map.entrySet()) {
                f.a value = entry.getValue();
                List<b> list = this.a.get(value);
                if (list == null) {
                    list = new ArrayList<>();
                    this.a.put(value, list);
                }
                list.add(entry.getKey());
            }
        }

        void a(j jVar, f.a aVar, Object obj) {
            a(this.a.get(aVar), jVar, aVar, obj);
            a(this.a.get(f.a.ON_ANY), jVar, aVar, obj);
        }

        private static void a(List<b> list, j jVar, f.a aVar, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    list.get(size).a(jVar, aVar, obj);
                }
            }
        }
    }

    /* compiled from: source */
    static class b {
        final int a;
        final Method b;

        b(int i, Method method) {
            this.a = i;
            this.b = method;
            this.b.setAccessible(true);
        }

        void a(j jVar, f.a aVar, Object obj) {
            try {
                switch (this.a) {
                    case 0:
                        this.b.invoke(obj, new Object[0]);
                        return;
                    case 1:
                        this.b.invoke(obj, jVar);
                        return;
                    case 2:
                        this.b.invoke(obj, jVar, aVar);
                        return;
                    default:
                        return;
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e2) {
                throw new RuntimeException("Failed to call observer method", e2.getCause());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return this.a == bVar.a && this.b.getName().equals(bVar.b.getName());
        }

        public int hashCode() {
            return (31 * this.a) + this.b.getName().hashCode();
        }
    }
}
