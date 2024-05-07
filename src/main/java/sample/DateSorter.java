package sample;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 * Marking will be based upon producing a readable, well engineered solution rather than factors
 * such as speed of processing or other performance-based optimizations, which are less
 * important.
 *
 *
 package sample;

 import java.time.LocalDate;
 import java.util.Collection;
 import java.util.List;

 /**
 * Marking will be based upon producing a readable, well engineered solution rather than factors
 * such as speed of processing or other performance-based optimizations, which are less
 * important.
 *
 * Implement in single class. Don't chane constructor and signature method.
 */
public class DateSorter {
    private static final String MONTH_IDENTIFIER = "r";

    /**
     * The implementation of this method should sort dates.
     * The output should be in the following order:
     * Dates with an 'r' in the month,
     * sorted ascending (first to last),
     * then dates without an 'r' in the month,
     * sorted descending (last to first).
     * For example, October dates would come before May dates,
     * because October has an 'r' in it.
     * thus: (2004-07-01, 2005-01-02, 2007-01-01, 2032-05-03)
     * would sort to
     * (2005-01-02, 2007-01-01, 2032-05-03, 2004-07-01)
     *
     * @param unsortedDates - an unsorted list of dates
     * @return the collection of dates now sorted as per the spec
     */
    public Collection<LocalDate> sortDates(List<LocalDate> unsortedDates) {
        if (!isValid(unsortedDates)) {
            return Collections.emptyList();
        }

        Predicate<LocalDate> containsIdentifier = localDate -> localDate.getMonth().toString().toLowerCase().contains(MONTH_IDENTIFIER);

        Collection<LocalDate> withIdentifier = filterAndSort(unsortedDates, containsIdentifier, Comparator.naturalOrder());
        Collection<LocalDate> withoutIdentifier = filterAndSort(unsortedDates, containsIdentifier.negate(), Comparator.reverseOrder());

        Collection<LocalDate> sortedDates = new ArrayList<>();
        sortedDates.addAll(withIdentifier);
        sortedDates.addAll(withoutIdentifier);

        return sortedDates;
    }

    private <T> Collection<T> filterAndSort(
            final Collection<T> unsortedList,
            final Predicate<? super T> predicate,
            final Comparator<? super T> comparator
    ) {
        return unsortedList.stream()
                .filter(predicate)
                .sorted(comparator)
                .toList();
    }

    private boolean isValid(final List<?> list) {
        return list != null && !list.isEmpty();
    }

}