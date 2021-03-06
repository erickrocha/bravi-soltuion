package com.erocha.person.config.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDate;

/**
 * Created by guilherme.roveri on 5/18/16.
 */
public class LocalDateDeserializer extends JsonDeserializer<LocalDate> {

    @Override
    public LocalDate deserialize(final JsonParser jsonParser,
        final DeserializationContext deserializationCtx) throws IOException {
        final ObjectCodec oc = jsonParser.getCodec();
        final String content = oc.readValue(jsonParser, String.class);

        if (content == null) {
            return null;
        }

        return LocalDate.parse(content);
    }
}
