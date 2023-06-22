package views.components;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.File;
import java.io.FileWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import views.components.ToDoList;
import views.components.ToDoList;

public class ToDoDelete implements ActionListener {
  ImageIcon deleteIcon = new ImageIcon("D:\\csc_final\\assets\\trash.png");
  Image image = deleteIcon.getImage();
  Image newImage = image.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
  Icon deleteIconResized = new ImageIcon(newImage);
  JButton deleteButton = new JButton(deleteIconResized);
  Color main = new Color(42, 158, 255);

  File todosFile = new File("D:\\csc_final\\todos.txt");

  private static ToDoList toDoList;

  public ToDoDelete() {
    deleteButton.setBounds(320, 120, 40, 35);
    deleteButton.setBackground(main);
    deleteButton.setForeground(Color.WHITE);
    deleteButton.setBorderPainted(false);
    deleteButton.setFocusPainted(false);
    deleteButton.setOpaque(true);
    deleteButton.setVisible(true);
    deleteButton.setFont(deleteButton.getFont().deriveFont(25.0f));
    deleteButton.setBorder(null);
    deleteButton.addActionListener(this);
  }

  public JButton getButton() {
    return deleteButton;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object source = e.getSource();
    if (source == deleteButton) {
      deleteTodo();
    }
  }

  private void deleteTodo() {
    System.out.println("Delete todo");
    ToDoList.clearToDo();

    //delete all records sa  todos.txt
    //statements without the implementation of stream chaining
    //ang daan gihapon ni
    // try {
    //   FileWriter fw = new FileWriter(todosFile);
    //   BufferedWriter bw = new BufferedWriter(fw);
    //   bw.write("");
    //   bw.close();
    // } catch (IOException e) {
    //   e.printStackTrace();
    // }

    //with stream chaining
    try {
      Files
        .newBufferedWriter(
          todosFile.toPath(),
          StandardOpenOption.TRUNCATE_EXISTING
        )
        .close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
