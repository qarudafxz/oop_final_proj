package views.components;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import utils.AddToDoToFile;
import views.ToDo;
import views.components.ToDoTextField;

public class ToDoButton implements ActionListener {
  private JButton toDoButton = new JButton("+");
  private File todosFile;
  private ToDo toDo;
  private ToDoTextField todo;

  public ToDoButton(Color main, File todosFile, ToDo toDo) {
    this.todosFile = todosFile;

    toDoButton.setBounds(270, 120, 40, 35);
    toDoButton.setBackground(main);
    toDoButton.setForeground(Color.WHITE);
    toDoButton.setBorderPainted(false);
    toDoButton.setFocusPainted(false);
    toDoButton.setOpaque(true);
    toDoButton.setVisible(true);
    toDoButton.setFont(toDoButton.getFont().deriveFont(25.0f));
    toDoButton.setBorder(null);
    toDoButton.addActionListener(this);
  }

  public JButton getButton() {
    return toDoButton;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Object source = e.getSource();
    AddToDoToFile addToDoToFile = new AddToDoToFile();
    ToDoTextField todo = new ToDoTextField();

    if (source == toDoButton) {
      if (todo.getTextContent().equals("")) {
        JOptionPane.showMessageDialog(null, "Please enter a todo");
        return;
      }
      addToDoToFile.addTextToFile(todosFile);
      ToDoList.displayTodos();
    }
  }
}
