package com.ryn;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Optional;

/**
 * Persian Solar Hijri translation class
 *
 * @author jytfsd
 */
public class PersianCalender {
    /*
     * Theres another way to set this variable if `local.of()` rather
     * the reason why im not doing this is to support older versions [Java 8 SE]
     */
    static final Locale defaultLocale = new Locale.Builder()
            .setLanguage("fa")
            .setRegion("IR").build();

    /**
     * Gives a persian ISO standardized date
     * * This is just a rough translation meaning numerical values follow ASCII and
     * * month name is just a representation rather than a persian calender name
     * * The conditional parameter will actually fix this altercation
     *
     * @param date  Provides a specific date
     * @param style A style format for rendering the date by default its short
     * @return A somewhat translation of an date to persian format
     */
    public String persianStandardize(LocalDate date, Optional<FormatStyle> style) {
        String monthFormat = date.format(
                DateTimeFormatter
                        .ofLocalizedDate((style.isPresent()) ? style.get() : FormatStyle.SHORT)
                        .localizedBy(defaultLocale));

        // 🦁🦁🦁🦁
        if (date.getMonthValue() == 1 || date.getMonthValue() == 2 || date.getMonthValue() == 5
                || date.getMonthValue() == 7)
            monthFormat = monthFormat.replace("\u0654", "");

        // We wont need to change the month name from the ISO translation to the persian
        // if we have a only numerical
        if (!style.isEmpty() && !style.get().equals(FormatStyle.SHORT))
            monthFormat = monthFormat.replace(
                    date.getMonth().getDisplayName(TextStyle.FULL_STANDALONE, defaultLocale),
                    PersianMonths.getMonthFromInt(date.getMonthValue()).get().getMonthName());

        return monthFormat;
    }

    public static void main(String[] args) {
        // The reason why this is empty is i simply don't know bruh
    }
}
