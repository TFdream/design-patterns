package io.bitmuse.designpatterns.util;

import com.google.gson.*;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author Ricky Fung
 */
public abstract class JsonUtils {
    private static final Gson GSON = (new GsonBuilder())
            .registerTypeAdapter(Date.class, new JsonDateSerializer())
            .registerTypeAdapter(LocalDateTime.class, new Java8DateTimeSerializer()).create();

    public JsonUtils() {
    }

    public static String toJson(Object obj) {
        return GSON.toJson(obj);
    }

    public static <T> T parseObject(String json, Class<T> classOfT) {
        return GSON.fromJson(json, classOfT);
    }

    public static <T> T parseObject(String json, Type typeOfT) {
        return GSON.fromJson(json, typeOfT);
    }

}

/**
 * Java8 LocalDateTime
 */
class Java8DateTimeSerializer implements
        JsonSerializer<LocalDateTime>, JsonDeserializer<LocalDateTime> {

    @Override
    public LocalDateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        if (json==null || json.isJsonNull()) {
            return null;
        }
        String dateStr = json.getAsString();
        if (StringUtils.isEmpty(dateStr)) {
            return null;
        }
        return DateUtils.parseDateTime(dateStr);
    }

    @Override
    public JsonElement serialize(LocalDateTime src, Type typeOfSrc, JsonSerializationContext context) {
        if (src == null) {
            return null;
        }
        return new JsonPrimitive(DateUtils.format(src));
    }
}

/**
 * java.util.Date序列化/反序列化
 * @author Ricky Fung
 */
class JsonDateSerializer implements
        JsonSerializer<Date>, JsonDeserializer<Date> {

    @Override
    public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        if (json==null || json.isJsonNull()) {
            return null;
        }
        String dateStr = json.getAsString();
        if (StringUtils.isEmpty(dateStr)) {
            return null;
        }
        return DateUtils.parseJdkDate(dateStr);
    }

    @Override
    public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
        if (src == null) {
            return null;
        }
        return new JsonPrimitive(DateUtils.format(src));
    }
}
