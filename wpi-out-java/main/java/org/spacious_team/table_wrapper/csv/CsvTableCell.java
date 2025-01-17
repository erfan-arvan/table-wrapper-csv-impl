// Generated by delombok at Wed Aug 14 06:24:43 EDT 2024
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

import org.checkerframework.checker.nullness.qual.Nullable;
import org.spacious_team.table_wrapper.api.AbstractTableCell;
import org.spacious_team.table_wrapper.api.EmptyTableCell;
import org.spacious_team.table_wrapper.api.TableCell;

@org.checkerframework.framework.qual.AnnotatedFor("org.checkerframework.checker.nullness.NullnessChecker")
public class CsvTableCell extends AbstractTableCell<String, CsvCellDataAccessObject> {

    private final  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int columnIndex;

    private final @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String value;

    @org.checkerframework.dataflow.qual.Impure
    public static @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull TableCell of(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull [] row,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int columnIndex) {
        return of(row, columnIndex, CsvCellDataAccessObject.INSTANCE);
    }

    @org.checkerframework.dataflow.qual.Impure
    public static @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull TableCell of(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull [] row,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int columnIndex, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull CsvCellDataAccessObject dao) {
        String cellValue = getCellValue(row, columnIndex);
        return cellValue == null ? EmptyTableCell.of(columnIndex) : new CsvTableCell(cellValue, columnIndex, dao);
    }

    @org.checkerframework.dataflow.qual.Pure
    private static @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.Nullable String getCellValue(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull [] row,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int columnIndex) {
        return (columnIndex >= 0) && (columnIndex < row.length) ? row[columnIndex] : null;
    }

    @org.checkerframework.dataflow.qual.Impure
    private CsvTableCell(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull String cellValue,  @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull int columnIndex, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull CsvCellDataAccessObject dao) {
        super(cellValue, dao);
        this.value = cellValue;
        this.columnIndex = columnIndex;
    }

    @org.checkerframework.dataflow.qual.Pure
    protected @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull CsvTableCell createWithCellDataAccessObject(@org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull CsvTableCell this, @org.checkerframework.checker.initialization.qual.Initialized @org.checkerframework.checker.nullness.qual.NonNull CsvCellDataAccessObject dao) {
        return new CsvTableCell(value, columnIndex, dao);
    }

    @org.checkerframework.dataflow.qual.Pure
    public java.lang.String toString() {
        return "CsvTableCell(columnIndex=" + this.getColumnIndex() + ", value=" + this.value + ")";
    }

    @org.checkerframework.dataflow.qual.Pure
    public boolean equals(final java.lang.Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CsvTableCell))
            return false;
        final CsvTableCell other = (CsvTableCell) o;
        if (!other.canEqual((java.lang.Object) this))
            return false;
        if (!super.equals(o))
            return false;
        if (this.getColumnIndex() != other.getColumnIndex())
            return false;
        final java.lang.Object this$value = this.value;
        final java.lang.Object other$value = other.value;
        if (this$value == null ? other$value != null : !this$value.equals(other$value))
            return false;
        return true;
    }

    @org.checkerframework.dataflow.qual.Pure
    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof CsvTableCell;
    }

    @org.checkerframework.dataflow.qual.Pure
    public int hashCode() {
        final int PRIME = 59;
        int result = super.hashCode();
        result = result * PRIME + this.getColumnIndex();
        final java.lang.Object $value = this.value;
        result = result * PRIME + ($value == null ? 43 : $value.hashCode());
        return result;
    }

    @org.checkerframework.dataflow.qual.Pure
    public int getColumnIndex() {
        return this.columnIndex;
    }
}
