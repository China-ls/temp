package com.infinite.framework.core.util;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.text.DateFormat;

/**
 * Created by hx on 16-7-4.
 */
@SuppressWarnings("all")
public abstract class JsonUtil {
    private static Gson simpleGson;

    static {
        simpleGson = new GsonBuilder()
                .setDateFormat(DateFormat.LONG)
                .create();
    }

    public static String toJson(JsonElement jsonElement) {
        return simpleGson.toJson(jsonElement);
    }

    public static String toJson(Object src) {
        return simpleGson.toJson(src);
    }

    public static String toJson(Object src, Type typeOfSrc) {
        return simpleGson.toJson(src, typeOfSrc);
    }

    public static void toJson(Object src, Appendable writer) throws JsonIOException {
        simpleGson.toJson(src, writer);
    }

    public static void toJson(Object src, Type typeOfSrc, Appendable writer) throws JsonIOException {
        simpleGson.toJson(src, typeOfSrc, writer);
    }

    public static void toJson(Object src, Type typeOfSrc, JsonWriter writer) throws JsonIOException {
        simpleGson.toJson(src, typeOfSrc, writer);
    }

    public static void toJson(JsonElement jsonElement, Appendable writer) throws JsonIOException {
        simpleGson.toJson(jsonElement, writer);
    }

    public static JsonWriter newJsonWriter(Writer writer) throws IOException {
        return simpleGson.newJsonWriter(writer);
    }

    public static JsonReader newJsonReader(Reader reader) {
        return simpleGson.newJsonReader(reader);
    }

    public static void toJson(JsonElement jsonElement, JsonWriter writer) throws JsonIOException {
        simpleGson.toJson(jsonElement, writer);
    }

    public static <T> T fromJson(String json, Class<T> classOfT) throws JsonSyntaxException {
        return simpleGson.fromJson(json, classOfT);
    }

    public static <T> T fromJson(String json, Type typeOfT) throws JsonSyntaxException {
        return simpleGson.fromJson(json, typeOfT);
    }

    public static <T> T fromJson(Reader json, Class<T> classOfT) throws JsonSyntaxException, JsonIOException {
        return simpleGson.fromJson(json, classOfT);
    }

    public static <T> T fromJson(Reader json, Type typeOfT) throws JsonIOException, JsonSyntaxException {
        return simpleGson.fromJson(json, typeOfT);
    }

    public static <T> T fromJson(JsonReader reader, Type typeOfT) throws JsonIOException, JsonSyntaxException {
        return simpleGson.fromJson(reader, typeOfT);
    }

    public static <T> T fromJson(JsonElement json, Class<T> classOfT) throws JsonSyntaxException {
        return simpleGson.fromJson(json, classOfT);
    }

    public static <T> T fromJson(JsonElement json, Type typeOfT) throws JsonSyntaxException {
        return simpleGson.fromJson(json, typeOfT);
    }

}
