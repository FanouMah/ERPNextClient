package itu.prom16.ERPNextClient.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

/**
 *
 * @author Fanou
 */
public class FlexibleLocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {

    private static final DateTimeFormatter FLEXIBLE_DATE_TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendPattern("yyyy-MM-dd")
            .optionalStart()
            .appendPattern("[['T'][ ]]") // support both 'T' and ' '
            .optionalEnd()
            .appendValue(ChronoField.HOUR_OF_DAY) // H or HH
            .appendLiteral(':')
            .appendValue(ChronoField.MINUTE_OF_HOUR)
            .appendLiteral(':')
            .appendValue(ChronoField.SECOND_OF_MINUTE)
            .optionalStart()
            .appendFraction(ChronoField.NANO_OF_SECOND, 1, 6, true)
            .optionalEnd()
            .toFormatter();

    @Override
    public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String value = p.getText();
        try {
            return LocalDateTime.parse(value, FLEXIBLE_DATE_TIME_FORMATTER);
        } catch (Exception e) {
            throw new IOException("Unable to parse LocalDateTime: " + value, e);
        }
    }
}
