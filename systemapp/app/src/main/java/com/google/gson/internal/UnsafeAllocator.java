package com.google.gson.internal;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* compiled from: source */
/* loaded from: classes.dex */
public abstract class UnsafeAllocator {
    public abstract <T> T newInstance(Class<T> cls) throws Exception;

    public static UnsafeAllocator create() {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return new UnsafeAllocator() { // from class: com.google.gson.internal.UnsafeAllocator.1
                final /* synthetic */ Method val$allocateInstance;
                final /* synthetic */ Object val$unsafe;

                AnonymousClass1(Method method, Object obj) {
                    method = method;
                    obj = obj;
                }

                @Override // com.google.gson.internal.UnsafeAllocator
                public <T> T newInstance(Class<T> cls2) throws Exception {
                    assertInstantiable(cls2);
                    return (T) method.invoke(obj, cls2);
                }
            };
        } catch (Exception unused) {
            try {
                try {
                    Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
                    declaredMethod.setAccessible(true);
                    int intValue = ((Integer) declaredMethod.invoke(null, Object.class)).intValue();
                    Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
                    declaredMethod2.setAccessible(true);
                    return new UnsafeAllocator() { // from class: com.google.gson.internal.UnsafeAllocator.2
                        final /* synthetic */ int val$constructorId;
                        final /* synthetic */ Method val$newInstance;

                        AnonymousClass2(Method declaredMethod22, int intValue2) {
                            declaredMethod2 = declaredMethod22;
                            intValue = intValue2;
                        }

                        @Override // com.google.gson.internal.UnsafeAllocator
                        public <T> T newInstance(Class<T> cls2) throws Exception {
                            assertInstantiable(cls2);
                            return (T) declaredMethod2.invoke(null, cls2, Integer.valueOf(intValue));
                        }
                    };
                } catch (Exception unused2) {
                    Method declaredMethod3 = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                    declaredMethod3.setAccessible(true);
                    return new UnsafeAllocator() { // from class: com.google.gson.internal.UnsafeAllocator.3
                        final /* synthetic */ Method val$newInstance;

                        AnonymousClass3(Method declaredMethod32) {
                            declaredMethod3 = declaredMethod32;
                        }

                        @Override // com.google.gson.internal.UnsafeAllocator
                        public <T> T newInstance(Class<T> cls2) throws Exception {
                            assertInstantiable(cls2);
                            return (T) declaredMethod3.invoke(null, cls2, Object.class);
                        }
                    };
                }
            } catch (Exception unused3) {
                return new UnsafeAllocator() { // from class: com.google.gson.internal.UnsafeAllocator.4
                    AnonymousClass4() {
                    }

                    @Override // com.google.gson.internal.UnsafeAllocator
                    public <T> T newInstance(Class<T> cls2) {
                        throw new UnsupportedOperationException("Cannot allocate " + cls2);
                    }
                };
            }
        }
    }

    /* compiled from: source */
    /* renamed from: com.google.gson.internal.UnsafeAllocator$1 */
    static class AnonymousClass1 extends UnsafeAllocator {
        final /* synthetic */ Method val$allocateInstance;
        final /* synthetic */ Object val$unsafe;

        AnonymousClass1(Method method, Object obj) {
            method = method;
            obj = obj;
        }

        @Override // com.google.gson.internal.UnsafeAllocator
        public <T> T newInstance(Class<T> cls2) throws Exception {
            assertInstantiable(cls2);
            return (T) method.invoke(obj, cls2);
        }
    }

    /* compiled from: source */
    /* renamed from: com.google.gson.internal.UnsafeAllocator$2 */
    static class AnonymousClass2 extends UnsafeAllocator {
        final /* synthetic */ int val$constructorId;
        final /* synthetic */ Method val$newInstance;

        AnonymousClass2(Method declaredMethod22, int intValue2) {
            declaredMethod2 = declaredMethod22;
            intValue = intValue2;
        }

        @Override // com.google.gson.internal.UnsafeAllocator
        public <T> T newInstance(Class<T> cls2) throws Exception {
            assertInstantiable(cls2);
            return (T) declaredMethod2.invoke(null, cls2, Integer.valueOf(intValue));
        }
    }

    /* compiled from: source */
    /* renamed from: com.google.gson.internal.UnsafeAllocator$3 */
    static class AnonymousClass3 extends UnsafeAllocator {
        final /* synthetic */ Method val$newInstance;

        AnonymousClass3(Method declaredMethod32) {
            declaredMethod3 = declaredMethod32;
        }

        @Override // com.google.gson.internal.UnsafeAllocator
        public <T> T newInstance(Class<T> cls2) throws Exception {
            assertInstantiable(cls2);
            return (T) declaredMethod3.invoke(null, cls2, Object.class);
        }
    }

    /* compiled from: source */
    /* renamed from: com.google.gson.internal.UnsafeAllocator$4 */
    static class AnonymousClass4 extends UnsafeAllocator {
        AnonymousClass4() {
        }

        @Override // com.google.gson.internal.UnsafeAllocator
        public <T> T newInstance(Class<T> cls2) {
            throw new UnsupportedOperationException("Cannot allocate " + cls2);
        }
    }

    static void assertInstantiable(Class<?> cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            throw new UnsupportedOperationException("Interface can't be instantiated! Interface name: " + cls.getName());
        }
        if (Modifier.isAbstract(modifiers)) {
            throw new UnsupportedOperationException("Abstract class can't be instantiated! Class name: " + cls.getName());
        }
    }
}
