package views.components;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JTextField;

public class ToDoTextField {
  static JTextField toDoTextField = new JTextField("");
  Color borderColor = new Color(189, 189, 189);

  public ToDoTextField() {
    //initialization of configs for the components
    toDoTextField.setBounds(50, 120, 210, 35);
    toDoTextField.setEditable(true);
    toDoTextField.setVisible(true);
    toDoTextField.setBorder(BorderFactory.createLineBorder(borderColor));
  }

  public JTextField getToDoTextField() {
    return toDoTextField;
  }

  public static String getTextContent() {
    return toDoTextField.getText();
  }

  public static void setTextContent(String string) {
    toDoTextField.setText(string);
  }
}
