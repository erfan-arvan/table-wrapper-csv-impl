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
import org.spacious_team.table_wrapper.api.CellDataAccessObject;
import org.spacious_team.table_wrapper.api.InstantParser;
import java.time.Instant;
import java.time.LocalTime;
import static java.util.Objects.requireNonNull;

public class CsvCellDataAccessObject implements CellDataAccessObject<String, CsvTableRow> {
    public static final CsvCellDataAccessObject INSTANCE = CsvCellDataAccessObject.of(InstantParser.builder().defaultTime(LocalTime.NOON).build());
    private final InstantParser instantParser;

    @Override
    
    public String getCell(CsvTableRow row, Integer cellIndex) {
        //noinspection ConstantConditions
        return (cellIndex == null) ? null : row.getCellValue(cellIndex);
    }

    @Override
    
    public String getValue( String cell) {
        return cell;
    }

    @Override
    public Instant getInstantValue( String cell) {
        
        String value = getValue(cell);
        
        String nonNullValue = requireNonNull(value, "Not an instant");
        return instantParser.parseInstant(nonNullValue);
    }

    @java.lang.Override
    
    public java.lang.String toString() {
        return "CsvCellDataAccessObject(instantParser=" + this.instantParser + ")";
    }

    @java.lang.Override
    
    public boolean equals(final java.lang.Object o) {
        if (o == this) return true;
        if (!(o instanceof CsvCellDataAccessObject)) return false;
        final CsvCellDataAccessObject other = (CsvCellDataAccessObject) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
        final java.lang.Object this$instantParser = this.instantParser;
        final java.lang.Object other$instantParser = other.instantParser;
        if (this$instantParser == null ? other$instantParser != null : !this$instantParser.equals(other$instantParser)) return false;
        return true;
    }

    
    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof CsvCellDataAccessObject;
    }

    @java.lang.Override
    
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final java.lang.Object $instantParser = this.instantParser;
        result = result * PRIME + ($instantParser == null ? 43 : $instantParser.hashCode());
        return result;
    }

    
    private CsvCellDataAccessObject(final InstantParser instantParser) {
        this.instantParser = instantParser;
    }

    
    public static CsvCellDataAccessObject of(final InstantParser instantParser) {
        return new CsvCellDataAccessObject(instantParser);
    }
}