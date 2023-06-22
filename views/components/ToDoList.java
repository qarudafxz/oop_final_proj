package views.components;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import views.ToDo;

public class ToDoList {
  private static JPanel listPanel;
  private static int nextY = 5; // Initial Y position for the first todo
  private ToDo toDo;
  private File todoFile;

  private static Font todoTxt = new Font("Arial", Font.PLAIN, 15);
  static Color main = new Color(42, 158, 255);
  private Color frameColor = new Color(246, 246, 246);

  private static Color doneTask = new Color(202, 202, 202);

  public ToDoList(ToDo toDo, File todoFile) {
    this.toDo = toDo;
    this.todoFile = todoFile;
    listPanel = new JPanel();
    listPanel.setBounds(0, 0, 320, 100);
    listPanel.setLayout(null);
    listPanel.setBackground(frameColor);
    toDo.listsPanel.add(listPanel);
  }

  public static void displayTodos() {
    String todoText = ToDoTextField.getTextContent();
    JLabel todo = new JLabel(todoText);
    JButton underline = new JButton("\u2714");

    if (todoText.isEmpty()) {
      return;
    } else {
      underline.addActionListener(
        new ActionListener() {

          @Override
          public void actionPerformed(ActionEvent e) {
            taskDone();
          }
        }
      );
      todo.setBounds(0, nextY, 320, 40);
      todo.setFont(todoTxt);
      listPanel.add(todo);
      underline.setForeground(Color.WHITE);
      underline.setBorderPainted(false);
      underline.setFocusPainted(false);
      underline.setOpaque(true);
      underline.setVisible(true);
      underline.setFont(underline.getFont().deriveFont(25.0f));
      underline.setBorder(null);
      underline.setBackground(main);
      underline.setBounds(280, nextY + 8, 30, 30);

      underline.addActionListener(
        new ActionListener() {

          @Override
          public void actionPerformed(ActionEvent e) {
            taskDone();
          }
        }
      );
      listPanel.add(underline);
      nextY += 35;
      ToDoTextField.setTextContent("");
      listPanel.revalidate();
      listPanel.repaint();
    }
  }

  // this method will make the todos text fades away
  public static void taskDone() {
    Component[] components = listPanel.getComponents();
    for (Component component : components) {
      if (component instanceof JLabel) {
        JLabel label = (JLabel) component;
        label.setForeground(doneTask);
      }
    }
  }

  public static void clearToDo() {
    listPanel.removeAll();
    nextY = 5;
    listPanel.revalidate();
    listPanel.repaint();
  }
}
