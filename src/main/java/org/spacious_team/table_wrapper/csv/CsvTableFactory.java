package org.spacious_team.table_wrapper.csv;
public class CsvTableFactory extends AbstractTableFactory<CsvReportPage> {
    public CsvTableFactory() {
        super(CsvReportPage.class);
    }
    @Override
    public Table create(ReportPage reportPage,
                        String tableName,
                        TableCellRange tableRange,
                        Class<? extends TableColumnDescription> headerDescription,
                        int headersRowCount) {
        return new CsvTable(
                cast(reportPage),
                tableName,
                tableRange,
                headerDescription,
                headersRowCount);
    }
}
