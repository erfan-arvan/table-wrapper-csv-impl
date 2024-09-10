package org.spacious_team.table_wrapper.csv;
class CsvTableRowTest {
    @ParameterizedTest
    @MethodSource("indexAndRow")
    void getCell(int rowNum, String[] row, int colNum) {
        CsvTableCell cell;
        CsvTableRow csvRow = new CsvTableRow(row, rowNum);
        if (colNum >= row.length) {
            assertNull(csvRow.getCell(colNum));
        } else {
            cell = CsvTableCell.of(row, colNum);
            assertEquals(cell, csvRow.getCell(colNum));
        }
    }
    @ParameterizedTest
    @MethodSource("indexAndRow")
    void getFirstCellNum(int rowNum, String[] row) {
        CsvTableRow csv = new CsvTableRow(row, rowNum);
        if (row.length == 0) {
            assertEquals(-1, csv.getFirstCellNum());
        } else {
            assertEquals(0, csv.getFirstCellNum());
        }
    }
    @ParameterizedTest
    @MethodSource("indexAndRow")
    void getLastCellNum(int rowNum, String[] row) {
        CsvTableRow csv = new CsvTableRow(row, rowNum);
        assertEquals(row.length - 1, csv.getLastCellNum());
    }
    private static Stream<Arguments> indexAndRow() {
        String[] row = new String[]{"1", "2.1", "abc", "2020-01-01 01:02:03"};
        return Stream.of(
                Arguments.of(1, row, 10),
                Arguments.of(5, row, 2),
                Arguments.of(8, new String[]{}, 11)
        );
    }
}
