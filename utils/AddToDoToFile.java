package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import views.components.ToDoTextField;

public class AddToDoToFile {
  private ToDoTextField text;

  public void addTextToFile(File file) {
    try {
      //ang daan
      // BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
      // writer.write(text.getTextContent());
      // writer.newLine();
      // writer.close();

      Files.write(
        file.toPath(),
        (text.getTextContent() + System.lineSeparator()).getBytes(),
        StandardOpenOption.APPEND
      );
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
