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
import javax.annotation.Nullable;
import org.spacious_team.table_wrapper.api.AbstractReportPage;
import org.spacious_team.table_wrapper.api.AbstractTable;
import org.spacious_team.table_wrapper.api.CellDataAccessObject;
import org.spacious_team.table_wrapper.api.Table;
import org.spacious_team.table_wrapper.api.TableCellRange;
import org.spacious_team.table_wrapper.api.TableHeaderColumn;

public class CsvTable extends AbstractTable<CsvTableRow, String> {

    private CellDataAccessObject<String, CsvTableRow> cellDataAccessObject = CsvCellDataAccessObject.INSTANCE;

    protected <T extends Enum<T> & TableHeaderColumn> CsvTable(AbstractReportPage<CsvTableRow> reportPage, String tableName, TableCellRange tableRange, Class<T> headerDescription, int headersRowCount) {
        super(reportPage, tableName, tableRange, headerDescription, headersRowCount);
    }

    protected CsvTable(AbstractTable<CsvTableRow, String> table, int appendDataRowsToTop, int appendDataRowsToBottom) {
        super(table, appendDataRowsToTop, appendDataRowsToBottom);
    }

    @Override
    public Table subTable(int topRows, int bottomRows) {
        return new CsvTable(this, topRows, bottomRows);
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    public java.lang.String toString() {
        return "CsvTable(super=" + super.toString() + ", cellDataAccessObject=" + this.getCellDataAccessObject() + ")";
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    public boolean equals(final java.lang.Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CsvTable))
            return false;
        final CsvTable other = (CsvTable) o;
        if (!other.canEqual((java.lang.Object) this))
            return false;
        if (!super.equals(o))
            return false;
        final java.lang.Object this$cellDataAccessObject = this.getCellDataAccessObject();
        final java.lang.Object other$cellDataAccessObject = other.getCellDataAccessObject();
        if (this$cellDataAccessObject == null ? other$cellDataAccessObject != null : !this$cellDataAccessObject.equals(other$cellDataAccessObject))
            return false;
        return true;
    }

    @java.lang.SuppressWarnings("all")
    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof CsvTable;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    public int hashCode() {
        final int PRIME = 59;
        int result = super.hashCode();
        final java.lang.Object $cellDataAccessObject = this.getCellDataAccessObject();
        result = result * PRIME + ($cellDataAccessObject == null ? 43 : $cellDataAccessObject.hashCode());
        return result;
    }

    @java.lang.SuppressWarnings("all")
    public void setCellDataAccessObject(final CellDataAccessObject<String, CsvTableRow> cellDataAccessObject) {
        this.cellDataAccessObject = cellDataAccessObject;
    }

    @java.lang.SuppressWarnings("all")
    public CellDataAccessObject<String, CsvTableRow> getCellDataAccessObject() {
        return this.cellDataAccessObject;
    }
}
