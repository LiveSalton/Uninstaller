package com.google.gson;

import java.lang.reflect.Type;

/* compiled from: source */
/* loaded from: classes.dex */
public interface JsonDeserializationContext {
    <T> T deserialize(JsonElement jsonElement, Type type) throws JsonParseException;
}
