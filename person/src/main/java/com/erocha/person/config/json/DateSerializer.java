package com.erocha.person.config.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 *
 */
@Component
public class DateSerializer extends JsonSerializer<Date> {

  public static final String DATE_PATTERN = "yyyy-MM-dd";
  private final SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_PATTERN);

  @Override
  public void serialize(final Date date, final JsonGenerator gen, final SerializerProvider provider)
      throws IOException {

    dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
    final String formattedDate = dateFormat.format(date);
    gen.writeString(formattedDate);
  }
}
