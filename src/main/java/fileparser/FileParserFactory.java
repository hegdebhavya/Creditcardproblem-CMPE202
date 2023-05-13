package fileparser;

public class FileParserFactory {
    public static FileParser getFileParser(String fileType) {
        if (fileType.equalsIgnoreCase("csv")) {
            return new CSVParser();
        } else if (fileType.equalsIgnoreCase("json")) {
            return new JSONParser();
        }else if (fileType.equalsIgnoreCase("xml")) {
            return new XMLParser();
        }
        else {
            throw new IllegalArgumentException("Invalid file type: " + fileType);
        }
    }
}
