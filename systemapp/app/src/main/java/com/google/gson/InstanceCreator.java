package com.google.gson;

import java.lang.reflect.Type;

/* compiled from: source */
/* loaded from: classes.dex */
public interface InstanceCreator<T> {
    T createInstance(Type type);
}
