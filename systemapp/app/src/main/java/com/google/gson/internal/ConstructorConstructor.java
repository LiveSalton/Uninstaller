package com.google.gson.internal;

import com.google.gson.InstanceCreator;
import com.google.gson.JsonIOException;
import com.google.gson.internal.reflect.ReflectionAccessor;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/* compiled from: source */
/* loaded from: classes.dex */
public final class ConstructorConstructor {
    private final ReflectionAccessor accessor = ReflectionAccessor.getInstance();
    private final Map<Type, InstanceCreator<?>> instanceCreators;

    public ConstructorConstructor(Map<Type, InstanceCreator<?>> map) {
        this.instanceCreators = map;
    }

    public <T> ObjectConstructor<T> get(TypeToken<T> typeToken) {
        Type type = typeToken.getType();
        Class<? super T> rawType = typeToken.getRawType();
        InstanceCreator<?> instanceCreator = this.instanceCreators.get(type);
        if (instanceCreator != null) {
            return new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.1
                final /* synthetic */ Type val$type;
                final /* synthetic */ InstanceCreator val$typeCreator;

                AnonymousClass1(InstanceCreator instanceCreator2, Type type2) {
                    instanceCreator = instanceCreator2;
                    type = type2;
                }

                @Override // com.google.gson.internal.ObjectConstructor
                public T construct() {
                    return (T) instanceCreator.createInstance(type);
                }
            };
        }
        InstanceCreator<?> instanceCreator2 = this.instanceCreators.get(rawType);
        if (instanceCreator2 != null) {
            return new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.2
                final /* synthetic */ InstanceCreator val$rawTypeCreator;
                final /* synthetic */ Type val$type;

                AnonymousClass2(InstanceCreator instanceCreator22, Type type2) {
                    instanceCreator2 = instanceCreator22;
                    type = type2;
                }

                @Override // com.google.gson.internal.ObjectConstructor
                public T construct() {
                    return (T) instanceCreator2.createInstance(type);
                }
            };
        }
        ObjectConstructor<T> newDefaultConstructor = newDefaultConstructor(rawType);
        if (newDefaultConstructor != null) {
            return newDefaultConstructor;
        }
        ObjectConstructor<T> newDefaultImplementationConstructor = newDefaultImplementationConstructor(type2, rawType);
        return newDefaultImplementationConstructor != null ? newDefaultImplementationConstructor : newUnsafeAllocator(type2, rawType);
    }

    /* compiled from: source */
    /* renamed from: com.google.gson.internal.ConstructorConstructor$1 */
    class AnonymousClass1<T> implements ObjectConstructor<T> {
        final /* synthetic */ Type val$type;
        final /* synthetic */ InstanceCreator val$typeCreator;

        AnonymousClass1(InstanceCreator instanceCreator2, Type type2) {
            instanceCreator = instanceCreator2;
            type = type2;
        }

        @Override // com.google.gson.internal.ObjectConstructor
        public T construct() {
            return (T) instanceCreator.createInstance(type);
        }
    }

    /* compiled from: source */
    /* renamed from: com.google.gson.internal.ConstructorConstructor$2 */
    class AnonymousClass2<T> implements ObjectConstructor<T> {
        final /* synthetic */ InstanceCreator val$rawTypeCreator;
        final /* synthetic */ Type val$type;

        AnonymousClass2(InstanceCreator instanceCreator22, Type type2) {
            instanceCreator2 = instanceCreator22;
            type = type2;
        }

        @Override // com.google.gson.internal.ObjectConstructor
        public T construct() {
            return (T) instanceCreator2.createInstance(type);
        }
    }

    private <T> ObjectConstructor<T> newDefaultConstructor(Class<? super T> cls) {
        try {
            Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                this.accessor.makeAccessible(declaredConstructor);
            }
            return new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.3
                final /* synthetic */ Constructor val$constructor;

                AnonymousClass3(Constructor declaredConstructor2) {
                    declaredConstructor = declaredConstructor2;
                }

                @Override // com.google.gson.internal.ObjectConstructor
                public T construct() {
                    try {
                        return (T) declaredConstructor.newInstance(null);
                    } catch (IllegalAccessException e) {
                        throw new AssertionError(e);
                    } catch (InstantiationException e2) {
                        throw new RuntimeException("Failed to invoke " + declaredConstructor + " with no args", e2);
                    } catch (InvocationTargetException e3) {
                        throw new RuntimeException("Failed to invoke " + declaredConstructor + " with no args", e3.getTargetException());
                    }
                }
            };
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    /* compiled from: source */
    /* renamed from: com.google.gson.internal.ConstructorConstructor$3 */
    class AnonymousClass3<T> implements ObjectConstructor<T> {
        final /* synthetic */ Constructor val$constructor;

        AnonymousClass3(Constructor declaredConstructor2) {
            declaredConstructor = declaredConstructor2;
        }

        @Override // com.google.gson.internal.ObjectConstructor
        public T construct() {
            try {
                return (T) declaredConstructor.newInstance(null);
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (InstantiationException e2) {
                throw new RuntimeException("Failed to invoke " + declaredConstructor + " with no args", e2);
            } catch (InvocationTargetException e3) {
                throw new RuntimeException("Failed to invoke " + declaredConstructor + " with no args", e3.getTargetException());
            }
        }
    }

    private <T> ObjectConstructor<T> newDefaultImplementationConstructor(Type type, Class<? super T> cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            if (SortedSet.class.isAssignableFrom(cls)) {
                return new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.4
                    AnonymousClass4() {
                    }

                    @Override // com.google.gson.internal.ObjectConstructor
                    public T construct() {
                        return (T) new TreeSet();
                    }
                };
            }
            if (EnumSet.class.isAssignableFrom(cls)) {
                return new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.5
                    final /* synthetic */ Type val$type;

                    AnonymousClass5(Type type2) {
                        type = type2;
                    }

                    @Override // com.google.gson.internal.ObjectConstructor
                    public T construct() {
                        if (type instanceof ParameterizedType) {
                            Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                            if (type2 instanceof Class) {
                                return (T) EnumSet.noneOf((Class) type2);
                            }
                            throw new JsonIOException("Invalid EnumSet type: " + type.toString());
                        }
                        throw new JsonIOException("Invalid EnumSet type: " + type.toString());
                    }
                };
            }
            if (Set.class.isAssignableFrom(cls)) {
                return new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.6
                    AnonymousClass6() {
                    }

                    @Override // com.google.gson.internal.ObjectConstructor
                    public T construct() {
                        return (T) new LinkedHashSet();
                    }
                };
            }
            if (Queue.class.isAssignableFrom(cls)) {
                return new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.7
                    AnonymousClass7() {
                    }

                    @Override // com.google.gson.internal.ObjectConstructor
                    public T construct() {
                        return (T) new ArrayDeque();
                    }
                };
            }
            return new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.8
                AnonymousClass8() {
                }

                @Override // com.google.gson.internal.ObjectConstructor
                public T construct() {
                    return (T) new ArrayList();
                }
            };
        }
        if (!Map.class.isAssignableFrom(cls)) {
            return null;
        }
        if (ConcurrentNavigableMap.class.isAssignableFrom(cls)) {
            return new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.9
                AnonymousClass9() {
                }

                @Override // com.google.gson.internal.ObjectConstructor
                public T construct() {
                    return (T) new ConcurrentSkipListMap();
                }
            };
        }
        if (ConcurrentMap.class.isAssignableFrom(cls)) {
            return new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.10
                AnonymousClass10() {
                }

                @Override // com.google.gson.internal.ObjectConstructor
                public T construct() {
                    return (T) new ConcurrentHashMap();
                }
            };
        }
        if (SortedMap.class.isAssignableFrom(cls)) {
            return new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.11
                AnonymousClass11() {
                }

                @Override // com.google.gson.internal.ObjectConstructor
                public T construct() {
                    return (T) new TreeMap();
                }
            };
        }
        if ((type2 instanceof ParameterizedType) && !String.class.isAssignableFrom(TypeToken.get(((ParameterizedType) type2).getActualTypeArguments()[0]).getRawType())) {
            return new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.12
                AnonymousClass12() {
                }

                @Override // com.google.gson.internal.ObjectConstructor
                public T construct() {
                    return (T) new LinkedHashMap();
                }
            };
        }
        return new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.13
            AnonymousClass13() {
            }

            @Override // com.google.gson.internal.ObjectConstructor
            public T construct() {
                return (T) new LinkedTreeMap();
            }
        };
    }

    /* compiled from: source */
    /* renamed from: com.google.gson.internal.ConstructorConstructor$4 */
    class AnonymousClass4<T> implements ObjectConstructor<T> {
        AnonymousClass4() {
        }

        @Override // com.google.gson.internal.ObjectConstructor
        public T construct() {
            return (T) new TreeSet();
        }
    }

    /* compiled from: source */
    /* renamed from: com.google.gson.internal.ConstructorConstructor$5 */
    class AnonymousClass5<T> implements ObjectConstructor<T> {
        final /* synthetic */ Type val$type;

        AnonymousClass5(Type type2) {
            type = type2;
        }

        @Override // com.google.gson.internal.ObjectConstructor
        public T construct() {
            if (type instanceof ParameterizedType) {
                Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                if (type2 instanceof Class) {
                    return (T) EnumSet.noneOf((Class) type2);
                }
                throw new JsonIOException("Invalid EnumSet type: " + type.toString());
            }
            throw new JsonIOException("Invalid EnumSet type: " + type.toString());
        }
    }

    /* compiled from: source */
    /* renamed from: com.google.gson.internal.ConstructorConstructor$6 */
    class AnonymousClass6<T> implements ObjectConstructor<T> {
        AnonymousClass6() {
        }

        @Override // com.google.gson.internal.ObjectConstructor
        public T construct() {
            return (T) new LinkedHashSet();
        }
    }

    /* compiled from: source */
    /* renamed from: com.google.gson.internal.ConstructorConstructor$7 */
    class AnonymousClass7<T> implements ObjectConstructor<T> {
        AnonymousClass7() {
        }

        @Override // com.google.gson.internal.ObjectConstructor
        public T construct() {
            return (T) new ArrayDeque();
        }
    }

    /* compiled from: source */
    /* renamed from: com.google.gson.internal.ConstructorConstructor$8 */
    class AnonymousClass8<T> implements ObjectConstructor<T> {
        AnonymousClass8() {
        }

        @Override // com.google.gson.internal.ObjectConstructor
        public T construct() {
            return (T) new ArrayList();
        }
    }

    /* compiled from: source */
    /* renamed from: com.google.gson.internal.ConstructorConstructor$9 */
    class AnonymousClass9<T> implements ObjectConstructor<T> {
        AnonymousClass9() {
        }

        @Override // com.google.gson.internal.ObjectConstructor
        public T construct() {
            return (T) new ConcurrentSkipListMap();
        }
    }

    /* compiled from: source */
    /* renamed from: com.google.gson.internal.ConstructorConstructor$10 */
    class AnonymousClass10<T> implements ObjectConstructor<T> {
        AnonymousClass10() {
        }

        @Override // com.google.gson.internal.ObjectConstructor
        public T construct() {
            return (T) new ConcurrentHashMap();
        }
    }

    /* compiled from: source */
    /* renamed from: com.google.gson.internal.ConstructorConstructor$11 */
    class AnonymousClass11<T> implements ObjectConstructor<T> {
        AnonymousClass11() {
        }

        @Override // com.google.gson.internal.ObjectConstructor
        public T construct() {
            return (T) new TreeMap();
        }
    }

    /* compiled from: source */
    /* renamed from: com.google.gson.internal.ConstructorConstructor$12 */
    class AnonymousClass12<T> implements ObjectConstructor<T> {
        AnonymousClass12() {
        }

        @Override // com.google.gson.internal.ObjectConstructor
        public T construct() {
            return (T) new LinkedHashMap();
        }
    }

    /* compiled from: source */
    /* renamed from: com.google.gson.internal.ConstructorConstructor$13 */
    class AnonymousClass13<T> implements ObjectConstructor<T> {
        AnonymousClass13() {
        }

        @Override // com.google.gson.internal.ObjectConstructor
        public T construct() {
            return (T) new LinkedTreeMap();
        }
    }

    /* compiled from: source */
    /* renamed from: com.google.gson.internal.ConstructorConstructor$14 */
    class AnonymousClass14<T> implements ObjectConstructor<T> {
        private final UnsafeAllocator unsafeAllocator = UnsafeAllocator.create();
        final /* synthetic */ Class val$rawType;
        final /* synthetic */ Type val$type;

        AnonymousClass14(Class cls, Type type) {
            cls = cls;
            type = type;
        }

        @Override // com.google.gson.internal.ObjectConstructor
        public T construct() {
            try {
                return (T) this.unsafeAllocator.newInstance(cls);
            } catch (Exception e) {
                throw new RuntimeException("Unable to invoke no-args constructor for " + type + ". Registering an InstanceCreator with Gson for this type may fix this problem.", e);
            }
        }
    }

    private <T> ObjectConstructor<T> newUnsafeAllocator(Type type, Class<? super T> cls) {
        return new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.14
            private final UnsafeAllocator unsafeAllocator = UnsafeAllocator.create();
            final /* synthetic */ Class val$rawType;
            final /* synthetic */ Type val$type;

            AnonymousClass14(Class cls2, Type type2) {
                cls = cls2;
                type = type2;
            }

            @Override // com.google.gson.internal.ObjectConstructor
            public T construct() {
                try {
                    return (T) this.unsafeAllocator.newInstance(cls);
                } catch (Exception e) {
                    throw new RuntimeException("Unable to invoke no-args constructor for " + type + ". Registering an InstanceCreator with Gson for this type may fix this problem.", e);
                }
            }
        };
    }

    public String toString() {
        return this.instanceCreators.toString();
    }
}
