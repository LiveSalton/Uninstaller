package com.google.gson.internal.bind;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.Primitives;
import com.google.gson.internal.reflect.ReflectionAccessor;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: source */
/* loaded from: classes.dex */
public final class ReflectiveTypeAdapterFactory implements TypeAdapterFactory {
    private final ReflectionAccessor accessor = ReflectionAccessor.getInstance();
    private final ConstructorConstructor constructorConstructor;
    private final Excluder excluder;
    private final FieldNamingStrategy fieldNamingPolicy;
    private final JsonAdapterAnnotationTypeAdapterFactory jsonAdapterFactory;

    public ReflectiveTypeAdapterFactory(ConstructorConstructor constructorConstructor, FieldNamingStrategy fieldNamingStrategy, Excluder excluder, JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory) {
        this.constructorConstructor = constructorConstructor;
        this.fieldNamingPolicy = fieldNamingStrategy;
        this.excluder = excluder;
        this.jsonAdapterFactory = jsonAdapterAnnotationTypeAdapterFactory;
    }

    public boolean excludeField(Field field, boolean z) {
        return excludeField(field, z, this.excluder);
    }

    static boolean excludeField(Field field, boolean z, Excluder excluder) {
        return (excluder.excludeClass(field.getType(), z) || excluder.excludeField(field, z)) ? false : true;
    }

    private List<String> getFieldNames(Field field) {
        SerializedName serializedName = (SerializedName) field.getAnnotation(SerializedName.class);
        if (serializedName == null) {
            return Collections.singletonList(this.fieldNamingPolicy.translateName(field));
        }
        String value = serializedName.value();
        String[] alternate = serializedName.alternate();
        if (alternate.length == 0) {
            return Collections.singletonList(value);
        }
        ArrayList arrayList = new ArrayList(alternate.length + 1);
        arrayList.add(value);
        for (String str : alternate) {
            arrayList.add(str);
        }
        return arrayList;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Class<? super T> rawType = typeToken.getRawType();
        if (Object.class.isAssignableFrom(rawType)) {
            return new Adapter(this.constructorConstructor.get(typeToken), getBoundFields(gson, typeToken, rawType));
        }
        return null;
    }

    private BoundField createBoundField(Gson gson, Field field, String str, TypeToken<?> typeToken, boolean z, boolean z2) {
        boolean isPrimitive = Primitives.isPrimitive(typeToken.getRawType());
        JsonAdapter jsonAdapter = (JsonAdapter) field.getAnnotation(JsonAdapter.class);
        TypeAdapter<?> typeAdapter = jsonAdapter != null ? this.jsonAdapterFactory.getTypeAdapter(this.constructorConstructor, gson, typeToken, jsonAdapter) : null;
        boolean z3 = typeAdapter != null;
        if (typeAdapter == null) {
            typeAdapter = gson.getAdapter(typeToken);
        }
        return new BoundField(str, z, z2) { // from class: com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.1
            final /* synthetic */ Gson val$context;
            final /* synthetic */ Field val$field;
            final /* synthetic */ TypeToken val$fieldType;
            final /* synthetic */ boolean val$isPrimitive;
            final /* synthetic */ boolean val$jsonAdapterPresent;
            final /* synthetic */ TypeAdapter val$typeAdapter;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(String str2, boolean z4, boolean z22, Field field2, boolean z32, TypeAdapter typeAdapter2, Gson gson2, TypeToken typeToken2, boolean isPrimitive2) {
                super(str2, z4, z22);
                field = field2;
                z3 = z32;
                typeAdapter2 = typeAdapter2;
                gson = gson2;
                typeToken = typeToken2;
                isPrimitive = isPrimitive2;
            }

            @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
            void write(JsonWriter jsonWriter, Object obj) throws IOException, IllegalAccessException {
                (z3 ? typeAdapter2 : new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter2, typeToken.getType())).write(jsonWriter, field.get(obj));
            }

            @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
            void read(JsonReader jsonReader, Object obj) throws IOException, IllegalAccessException {
                Object read = typeAdapter2.read(jsonReader);
                if (read == null && isPrimitive) {
                    return;
                }
                field.set(obj, read);
            }

            @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
            public boolean writeField(Object obj) throws IOException, IllegalAccessException {
                return this.serialized && field.get(obj) != obj;
            }
        };
    }

    /* compiled from: source */
    /* renamed from: com.google.gson.internal.bind.ReflectiveTypeAdapterFactory$1 */
    class AnonymousClass1 extends BoundField {
        final /* synthetic */ Gson val$context;
        final /* synthetic */ Field val$field;
        final /* synthetic */ TypeToken val$fieldType;
        final /* synthetic */ boolean val$isPrimitive;
        final /* synthetic */ boolean val$jsonAdapterPresent;
        final /* synthetic */ TypeAdapter val$typeAdapter;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str2, boolean z4, boolean z22, Field field2, boolean z32, TypeAdapter typeAdapter2, Gson gson2, TypeToken typeToken2, boolean isPrimitive2) {
            super(str2, z4, z22);
            field = field2;
            z3 = z32;
            typeAdapter2 = typeAdapter2;
            gson = gson2;
            typeToken = typeToken2;
            isPrimitive = isPrimitive2;
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
        void write(JsonWriter jsonWriter, Object obj) throws IOException, IllegalAccessException {
            (z3 ? typeAdapter2 : new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter2, typeToken.getType())).write(jsonWriter, field.get(obj));
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
        void read(JsonReader jsonReader, Object obj) throws IOException, IllegalAccessException {
            Object read = typeAdapter2.read(jsonReader);
            if (read == null && isPrimitive) {
                return;
            }
            field.set(obj, read);
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
        public boolean writeField(Object obj) throws IOException, IllegalAccessException {
            return this.serialized && field.get(obj) != obj;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7 */
    private Map<String, BoundField> getBoundFields(Gson gson, TypeToken<?> typeToken, Class<?> cls) {
        ReflectiveTypeAdapterFactory reflectiveTypeAdapterFactory = this;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type type = typeToken.getType();
        TypeToken<?> typeToken2 = typeToken;
        Class<?> cls2 = cls;
        while (cls2 != Object.class) {
            Field[] declaredFields = cls2.getDeclaredFields();
            boolean z = false;
            int length = declaredFields.length;
            int i = 0;
            while (i < length) {
                Field field = declaredFields[i];
                boolean excludeField = reflectiveTypeAdapterFactory.excludeField(field, true);
                boolean excludeField2 = reflectiveTypeAdapterFactory.excludeField(field, z);
                if (excludeField || excludeField2) {
                    reflectiveTypeAdapterFactory.accessor.makeAccessible(field);
                    Type resolve = C$Gson$Types.resolve(typeToken2.getType(), cls2, field.getGenericType());
                    List<String> fieldNames = reflectiveTypeAdapterFactory.getFieldNames(field);
                    BoundField boundField = null;
                    int size = fieldNames.size();
                    ?? r2 = z;
                    while (r2 < size) {
                        String str = fieldNames.get(r2);
                        boolean z2 = r2 != 0 ? false : excludeField;
                        ReflectiveTypeAdapterFactory reflectiveTypeAdapterFactory2 = reflectiveTypeAdapterFactory;
                        BoundField boundField2 = boundField;
                        int i2 = r2;
                        int i3 = size;
                        List<String> list = fieldNames;
                        Type type2 = resolve;
                        Field field2 = field;
                        boundField = boundField2 == null ? (BoundField) linkedHashMap.put(str, reflectiveTypeAdapterFactory2.createBoundField(gson, field, str, TypeToken.get(resolve), z2, excludeField2)) : boundField2;
                        excludeField = z2;
                        resolve = type2;
                        size = i3;
                        fieldNames = list;
                        field = field2;
                        reflectiveTypeAdapterFactory = this;
                        r2 = i2 + 1;
                    }
                    BoundField boundField3 = boundField;
                    if (boundField3 != null) {
                        throw new IllegalArgumentException(type + " declares multiple JSON fields named " + boundField3.name);
                    }
                }
                i++;
                reflectiveTypeAdapterFactory = this;
                z = false;
            }
            typeToken2 = TypeToken.get(C$Gson$Types.resolve(typeToken2.getType(), cls2, cls2.getGenericSuperclass()));
            cls2 = typeToken2.getRawType();
            reflectiveTypeAdapterFactory = this;
        }
        return linkedHashMap;
    }

    /* compiled from: source */
    static abstract class BoundField {
        final boolean deserialized;
        final String name;
        final boolean serialized;

        abstract void read(JsonReader jsonReader, Object obj) throws IOException, IllegalAccessException;

        abstract void write(JsonWriter jsonWriter, Object obj) throws IOException, IllegalAccessException;

        abstract boolean writeField(Object obj) throws IOException, IllegalAccessException;

        protected BoundField(String str, boolean z, boolean z2) {
            this.name = str;
            this.serialized = z;
            this.deserialized = z2;
        }
    }

    /* compiled from: source */
    public static final class Adapter<T> extends TypeAdapter<T> {
        private final Map<String, BoundField> boundFields;
        private final ObjectConstructor<T> constructor;

        Adapter(ObjectConstructor<T> objectConstructor, Map<String, BoundField> map) {
            this.constructor = objectConstructor;
            this.boundFields = map;
        }

        @Override // com.google.gson.TypeAdapter
        public T read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            T construct = this.constructor.construct();
            try {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    BoundField boundField = this.boundFields.get(jsonReader.nextName());
                    if (boundField != null && boundField.deserialized) {
                        boundField.read(jsonReader, construct);
                    }
                    jsonReader.skipValue();
                }
                jsonReader.endObject();
                return construct;
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (IllegalStateException e2) {
                throw new JsonSyntaxException(e2);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, T t) throws IOException {
            if (t == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            try {
                for (BoundField boundField : this.boundFields.values()) {
                    if (boundField.writeField(t)) {
                        jsonWriter.name(boundField.name);
                        boundField.write(jsonWriter, t);
                    }
                }
                jsonWriter.endObject();
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            }
        }
    }
}
