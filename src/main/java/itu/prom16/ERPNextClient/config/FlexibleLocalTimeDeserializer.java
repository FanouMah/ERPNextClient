package itu.prom16.ERPNextClient.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

/**
 *
 * @author Fanou
 */
public class FlexibleLocalTimeDeserializer extends JsonDeserializer<LocalTime> {

    private static final DateTimeFormatter FLEXIBLE_FORMATTER = new DateTimeFormatterBuilder()
            .appendValue(ChronoField.HOUR_OF_DAY)       // 1 or 2 digits
            .appendLiteral(':')
            .appendValue(ChronoField.MINUTE_OF_HOUR)    // 1 or 2 digits
            .appendLiteral(':')
            .appendValue(ChronoField.SECOND_OF_MINUTE)  // 1 or 2 digits
            .optionalStart()
            .appendFraction(ChronoField.NANO_OF_SECOND, 1, 6, true)  // .S to .SSSSSS
            .optionalEnd()
            .toFormatter();

    @Override
    public LocalTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String value = p.getText();
        try {
            return LocalTime.parse(value, FLEXIBLE_FORMATTER);
        } catch (Exception e) {
            throw new IOException("Unable to parse LocalTime: " + value, e);
        }
    }
}