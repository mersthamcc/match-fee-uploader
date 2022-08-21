package cricket.merstham.matchfee.matchfeesuploader.converters;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.bean.AbstractCsvConverter;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import static java.util.Objects.isNull;

public class InstantConverter extends AbstractBeanField<Instant, Integer> {
    private final DateTimeFormatter formatter = DateTimeFormatter
            .ofPattern("dd/MM/yyyy HH:mm")
            .withZone(ZoneId.systemDefault());

    @Override
    protected Object convert(String value) throws CsvDataTypeMismatchException, CsvConstraintViolationException {
        if (isNull(value) || value.isBlank()) return null;

        return Instant.from(formatter.parse(value));
    }
}
