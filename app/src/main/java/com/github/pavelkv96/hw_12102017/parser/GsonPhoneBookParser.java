package com.github.pavelkv96.hw_12102017.parser;

import com.github.pavelkv96.hw_12102017.model.PhoneBook;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by Pavel on 19.10.2017.
 */

public class GsonPhoneBookParser implements Parser<PhoneBook>{
    @Override
    public PhoneBook parse(String string) throws Exception {
        Gson gson = registerDateAdapter().create();
        return gson.fromJson(string, PhoneBook.class);
    }

    private GsonBuilder registerDateAdapter() {
        return new GsonBuilder().registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
            @Override
            public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                return new Date(json.getAsJsonPrimitive().getAsLong());
            }
        }).registerTypeAdapter(Date.class, new JsonSerializer<Date>() {
            @Override
            public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
                return new JsonPrimitive(src.getTime());
            }
        });
    }

    @Override
    public List<PhoneBook> parseArray(String string) throws Exception {
        Gson gson = registerDateAdapter().create();
        PhoneBook[] phoneBooks = gson.fromJson(string,PhoneBook[].class);
        return Arrays.asList(phoneBooks);
    }

    @Override
    public String toJson(PhoneBook object) {
        if (object == null) {
            return "null";
        }
        return new Gson().toJson(object);
    }
}
