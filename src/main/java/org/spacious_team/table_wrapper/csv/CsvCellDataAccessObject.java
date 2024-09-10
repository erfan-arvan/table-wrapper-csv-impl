package org.spacious_team.table_wrapper.csv;
public class CsvCellDataAccessObject implements CellDataAccessObject<RowAndIndex, CsvTableRow> {
    public static final CsvCellDataAccessObject INSTANCE = new CsvCellDataAccessObject();
    @Setter
    @Getter
    public static DateTimeFormatter dateTimeFormatter = null;
    @Override
    public RowAndIndex getCell(CsvTableRow row, Integer cellIndex) {
        return row.getCell(cellIndex).getRowAndIndex();
    }
    @Override
    public String getValue(RowAndIndex cell) {
        return cell.getValue();
    }
    @Override
    public Instant getInstantValue(RowAndIndex cell) {
        String value = getValue(cell);
        DateTimeFormatter formatter = (dateTimeFormatter != null) ?
                dateTimeFormatter :
                DateTimeFormatParser.getFor(value);
        LocalDateTime dateTime = (value.length() == 10) ?
                LocalDate.parse(value, formatter).atTime(12, 0) :
                LocalDateTime.parse(value, formatter);
        return dateTime
                .atZone(ZoneOffset.systemDefault())
                .toInstant();
    }
}
