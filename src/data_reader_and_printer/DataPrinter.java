package data_reader_and_printer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DataPrinter {
	
	public static void dataWriter(String fileName, String[] header, String[][] data) {
		try {
            // Tạo thư mục 'KOLRank' nếu chưa tồn tại
            File file = new File(fileName);
            file.getParentFile().mkdirs();

            // Ghi file CSV
            try (FileWriter writer = new FileWriter(file)) {
                // Ghi tiêu đề
                writer.append(String.join(",", header));
                writer.append("\n");

                // Ghi dữ liệu
                for (String[] row : data) {
                    writer.append(String.join(",", row));
                    writer.append("\n");
                }

                System.out.println("File CSV đã được tạo thành công tại " + file.getAbsolutePath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
}
