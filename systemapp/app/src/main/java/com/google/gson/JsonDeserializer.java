package com.google.gson;

import java.lang.reflect.Type;

/* compiled from: source */
/* loaded from: classes.dex */
public interface JsonDeserializer<T> {
    T deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException;
}
