package sample;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class DateSorterTest {
    @Test
    void testValidInput() {
        // Given
        List<LocalDate> excepted = new ArrayList<>();
        excepted.add(LocalDate.of(2005, 1, 2));
        excepted.add(LocalDate.of(2007, 1, 1));
        excepted.add(LocalDate.of(2032, 5, 3));
        excepted.add(LocalDate.of(2004, 7, 1));

        List<LocalDate> sampleDates = new ArrayList<>();
        sampleDates.add(LocalDate.of(2004, 7, 1));
        sampleDates.add(LocalDate.of(2005, 1, 2));
        sampleDates.add(LocalDate.of(2007, 1, 1));
        sampleDates.add(LocalDate.of(2032, 5, 3));

        // When
        Collection<LocalDate> actual = new DateSorter().sortDates(sampleDates);

        // Then
        Assertions.assertEquals(excepted, actual);
    }

    @Test
    void testNullInput() {
        // Given
        List<LocalDate> excepted = List.of();

        // When
        Collection<LocalDate> actual = new DateSorter().sortDates(null);

        // Then
        Assertions.assertEquals(excepted, actual);
    }
}