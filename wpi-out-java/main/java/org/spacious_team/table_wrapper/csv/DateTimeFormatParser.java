/*
 * Table Wrapper CSV Impl
 * Copyright (C) 2022  Spacious Team <spacious-team@ya.ru>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package org.spacious_team.table_wrapper.csv;

import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
class DateTimeFormatParser {

    // internal calculated unique key -> date-time format
    private static final @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull Map<Integer, DateTimeFormatter> dateTimeFormatters = new ConcurrentHashMap<>();

    @org.checkerframework.checker.nullness.qual.EnsuresNonNull({ "#1" })
    @org.checkerframework.dataflow.qual.Impure
    static @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull DateTimeFormatter getFor(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable String dateTime) {
        return (dateTime.length() == 10) ? getForDate(dateTime) : getForDateTime(dateTime);
    }

    @org.checkerframework.dataflow.qual.Impure
    static @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull DateTimeFormatter getForDate(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String date) {
        boolean isYearAtFirst;
        char dateSplitter;
        char ch = date.charAt(date.length() - 5);
        if (!Character.isDigit(ch)) {
            // date format is DD MM YYYY
            isYearAtFirst = false;
            dateSplitter = ch;
        } else {
            // date format is YYYY MM DD
            isYearAtFirst = true;
            dateSplitter = date.charAt(date.length() - 3);
        }
        return getDateFormatter(isYearAtFirst, dateSplitter);
    }

    @org.checkerframework.dataflow.qual.Impure
    static @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull DateTimeFormatter getForDateTime(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String dateTime) {
        boolean isDateAtFirst, isYearAtFirst;
        char dateSplitter;
        if (dateTime.charAt(2) == ':') {
            // format is <time> <date>
            isDateAtFirst = false;
            char ch = dateTime.charAt(dateTime.length() - 5);
            if (!Character.isDigit(ch)) {
                // date format is DD MM YYYY
                isYearAtFirst = false;
                dateSplitter = ch;
            } else {
                // date format is YYYY MM DD
                isYearAtFirst = true;
                dateSplitter = dateTime.charAt(dateTime.length() - 3);
            }
        } else {
            // format is <date> <time>
            isDateAtFirst = true;
            if (!Character.isDigit(dateTime.charAt(2))) {
                // date format is DD MM YYYY
                isYearAtFirst = false;
                dateSplitter = dateTime.charAt(2);
            } else {
                // date format is YYYY MM DD
                isYearAtFirst = true;
                dateSplitter = dateTime.charAt(4);
            }
        }
        return getDateTimeFormatter(isDateAtFirst, isYearAtFirst, dateSplitter);
    }

    @org.checkerframework.dataflow.qual.Impure
    private static @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull DateTimeFormatter getDateFormatter( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean isYearAtFirst,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull char dateSplitter) {
        Integer key = dateSplitter + 0x40000 + (isYearAtFirst ? 0x20000 : 0);
        DateTimeFormatter result = dateTimeFormatters.get(key);
        if (result == null) {
            StringBuilder format = new StringBuilder();
            appendDate(isYearAtFirst, dateSplitter, format);
            result = DateTimeFormatter.ofPattern(format.toString());
            dateTimeFormatters.putIfAbsent(key, result);
        }
        return result;
    }

    /**
     * @param isDateAtFirst true if date-time format is '[date] [time]', false if '[time] [date]'
     * @param isYearAtFirst true if YYYY in [date] template at first, for example YYYY-MM-DD, false otherwise
     * @param dateSplitter date splitter char in date, for example for YYYY-MM-DD, should be '-'
     */
    @org.checkerframework.dataflow.qual.Impure
    private static @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull DateTimeFormatter getDateTimeFormatter( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean isDateAtFirst,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean isYearAtFirst,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull char dateSplitter) {
        Integer key = dateSplitter + (isDateAtFirst ? 0x10000 : 0) + (isYearAtFirst ? 0x20000 : 0);
        DateTimeFormatter result = dateTimeFormatters.get(key);
        if (result == null) {
            StringBuilder format = new StringBuilder();
            if (isDateAtFirst) {
                appendDate(isYearAtFirst, dateSplitter, format);
                format.append(" ");
                appendTime(format);
            } else {
                appendTime(format);
                format.append(" ");
                appendDate(isYearAtFirst, dateSplitter, format);
            }
            result = DateTimeFormatter.ofPattern(format.toString());
            dateTimeFormatters.putIfAbsent(key, result);
        }
        return result;
    }

    @org.checkerframework.dataflow.qual.Impure
    private static void appendDate( @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull boolean isYearAtFirst,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull char dateSplitter, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull StringBuilder format) {
        if (isYearAtFirst) {
            format.append("yyyy").append(dateSplitter).append("MM").append(dateSplitter).append("dd");
        } else {
            format.append("dd").append(dateSplitter).append("MM").append(dateSplitter).append("yyyy");
        }
    }

    @org.checkerframework.dataflow.qual.Impure
    private static void appendTime(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull StringBuilder format) {
        format.append("HH:mm:ss");
    }
}
