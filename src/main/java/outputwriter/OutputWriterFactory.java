package outputwriter;

public class OutputWriterFactory {
    public static OutputWriter getOutputWriter(String fileType) {
        if (fileType.equalsIgnoreCase("csv")) {
            return new CSVOutputWriter();
        } else if (fileType.equalsIgnoreCase("json")) {
            return new JSONOutputWriter();
        }else if (fileType.equalsIgnoreCase("xml")) {
            return new XMLOutputWriter();
        }
        else {
            throw new IllegalArgumentException("Invalid file type: " + fileType);
        }
    }
}
