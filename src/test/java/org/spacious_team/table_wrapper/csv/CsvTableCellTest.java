package org.spacious_team.table_wrapper.csv;
class CsvTableCellTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void getColumnIndex(int colNum) {
        String[] row = new String[5];
        CsvTableCell.RowAndIndex rowAndIndex = new CsvTableCell.RowAndIndex(row, colNum);
        CsvTableCell csv = new CsvTableCell(rowAndIndex);
        assertEquals(colNum, csv.getColumnIndex());
    }
}
