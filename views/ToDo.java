package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import views.components.ToDoButton;
import views.components.ToDoDelete;
import views.components.ToDoList;
import views.components.ToDoTextField;

public class ToDo {
  private File todos = new File("D:\\csc_final\\todos.txt");
  private Image icon = Toolkit
    .getDefaultToolkit()
    .getImage("D:\\csc_final\\assets\\logo.png");
  private JFrame toDoFrame = new JFrame("To-Do it | App by Francis Tin-ao");
  private JPanel toDoPanel = new JPanel();
  public JPanel listsPanel = new JPanel();
  private JPanel toDoLayout = new JPanel();
  private JLabel toDoLabel = new JLabel("To-Do it!");
  private JLabel toDoDesc = new JLabel(
    "Add your todos now to track your activities and tasks!"
  );

  private JLabel toDoListLabel = new JLabel("Lists");
  private ToDoList toDoList;

  public static Color main = new Color(42, 158, 255);
  private Color secondary = new Color(0, 107, 196);
  private Color frameColor = new Color(246, 246, 246);

  private ToDoButton toDoButton = new ToDoButton(main, todos, this);
  private ToDoDelete toDoDelete = new ToDoDelete();
  private Font mainFont = new Font("Arial", Font.BOLD, 25);

  public ToDo() {
    toDoFrame.setSize(420, 600);
    toDoFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    toDoFrame.setLayout(null);
    toDoFrame.setIconImage(icon);
    toDoFrame.setResizable(false);
    toDoFrame.getContentPane().setBackground(frameColor);
    toDoFrame.setLocationRelativeTo(null);

    toDoListLabel.setBounds(50, 120, 40, 20);

    toDoPanel.setBounds(0, 0, 420, 110);
    toDoPanel.setBackground(main);
    toDoPanel.setLayout(null);

    listsPanel.setBounds(50, 160, 310, 380);
    listsPanel.setBackground(frameColor);
    listsPanel.setVisible(true);
    listsPanel.setLayout(new BoxLayout(listsPanel, BoxLayout.PAGE_AXIS));

    toDoLabel.setBounds(60, 25, 200, 50);
    toDoLabel.setForeground(Color.WHITE);
    toDoLabel.setFont(mainFont);
    toDoPanel.add(toDoLabel);

    toDoDesc.setBounds(60, 50, 300, 50);
    toDoDesc.setForeground(Color.WHITE);
    toDoDesc.setFont(new Font("Arial", Font.PLAIN, 12));
    toDoPanel.add(toDoDesc);

    toDoFrame.add(toDoPanel);
    toDoFrame.add(listsPanel);
    toDoFrame.add(toDoListLabel);

    ToDoTextField toDoTextField = new ToDoTextField();
    toDoFrame.add(toDoTextField.getToDoTextField());

    toDoFrame.add(toDoButton.getButton());
    toDoFrame.add(toDoDelete.getButton());

    toDoList = new ToDoList(this, todos);
    toDoList.displayTodos();

    toDoFrame.setVisible(true);
  }

  public static void main(String[] args) {
    new ToDo();
  }
}
