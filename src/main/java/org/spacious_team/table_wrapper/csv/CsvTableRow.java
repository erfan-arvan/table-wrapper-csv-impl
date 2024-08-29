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
import org.spacious_team.table_wrapper.api.AbstractReportPageRow;
import org.spacious_team.table_wrapper.api.TableCell;
import java.util.Iterator;
import java.util.NoSuchElementException;
import static org.spacious_team.table_wrapper.api.TableCellAddress.NOT_FOUND;
import static org.spacious_team.table_wrapper.csv.CsvTableHelper.equalsPredicate;

public class CsvTableRow extends AbstractReportPageRow {
    private final String[] row;
    private final int rowNum;
    private final TableCell[] cellsCache;

    public static CsvTableRow of(String[] row, int rowNum) {
        return new CsvTableRow(row, rowNum);
    }

    private CsvTableRow(String[] row, int rowNum) {
        this.row = row;
        this.rowNum = rowNum;
        this.cellsCache = new TableCell[row.length];
    }

    @Override
    
    public TableCell getCell(int i) {
        if (i < 0 || i >= row.length) {
            return null;
        }
        TableCell cell = cellsCache[i];
        if (cell == null) {
            cell = CsvTableCell.of(row, i);
            cellsCache[i] = cell;
        }
        return cell;
    }

    
    String getCellValue(int i) {
        return (i < 0 || i >= row.length) ? null : row[i];
    }

    @Override
    public int getFirstCellNum() {
        return (row.length > 0) ? 0 : -1;
    }

    @Override
    public int getLastCellNum() {
        return row.length - 1;
    }

    @Override
    public boolean rowContains( Object value) {
        return CsvTableHelper.find(row, rowNum, 0, row.length, equalsPredicate(value)) != NOT_FOUND;
    }

    @Override
    public Iterator< TableCell> iterator() {
        return new Iterator< TableCell>() {
            private int cellIndex = 0;
            @Override
            public boolean hasNext() {
                return cellIndex < row.length;
            }
            @Override
            
            public TableCell next() {
                if (hasNext()) {
                    return getCell(cellIndex++);
                }
                throw new NoSuchElementException();
            }
        };
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    public java.lang.String toString() {
        return "CsvTableRow(rowNum=" + this.getRowNum() + ")";
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    public boolean equals(final java.lang.Object o) {
        if (o == this) return true;
        if (!(o instanceof CsvTableRow)) return false;
        final CsvTableRow other = (CsvTableRow) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
        if (this.getRowNum() != other.getRowNum()) return false;
        if (!java.util.Arrays.deepEquals(this.row, other.row)) return false;
        return true;
    }

    @java.lang.SuppressWarnings("all")
    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof CsvTableRow;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getRowNum();
        result = result * PRIME + java.util.Arrays.deepHashCode(this.row);
        return result;
    }

    @java.lang.SuppressWarnings("all")
    public int getRowNum() {
        return this.rowNum;
    }
}
