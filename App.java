import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;


public class App {

    public static void main(String[] args){

        // Create the main frame using border layout.
        JFrame frame =  new JFrame("To Do List");
        frame.setSize(450,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new java.awt.BorderLayout());

        // Create a label
        // JLabel label =  new JLabel("Hello, welcome!");
        // frame.add(label);

        // Create buttons to add, remove, and mark complete tasks.
        JButton addTask = new JButton("Add Task");
        addTask.setPreferredSize(new Dimension(150,50));
        JButton removeTask = new JButton("Remove Task");
        removeTask.setPreferredSize(new Dimension(150,50));
        JButton markComplete = new JButton("Mark Complete");
        markComplete.setPreferredSize(new Dimension(150,50));

        // Adding buttons to Jpanel, then Jpanel to Jframe.
        JPanel buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.add(addTask,BorderLayout.WEST);
        buttonPanel.add(removeTask, BorderLayout.CENTER);
        buttonPanel.add(markComplete, BorderLayout.EAST);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Create a text field, where user will enter task.
        JTextField textField = new JTextField("Enter tasks here");
        frame.add(textField, BorderLayout.NORTH);

        // Creating a JList to store tasks
        DefaultListModel<String> model = new DefaultListModel<>();
        model.addElement("one");
        model.addElement("two");
        JList<String> taskList = new JList<>(model);
        JScrollPane scrollPane = new JScrollPane(taskList);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Adding action listener for addTask button.
        addTask.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                // Getting task from textfield.
                String task = textField.getText();
                // Check if a task has been entered.
                if(task.length() == 0){
                    //Popup pop = PopupFactory.getSharedInstance().getPopup(frame, new JLabel("There is no task to add, please add a task in the field above."), 50, 100);
                    //pop.show();
                }
                // If task is valid, add to taskList.
                else{
                    model.addElement(task);
                }
            }
        });
        // Adding action listener for removeTask button.
        removeTask.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                // Getting index of selected task
                int selectedIndex = taskList.getSelectedIndex();
                // If index is valid remove it.
                if(selectedIndex != -1){
                    model.remove(selectedIndex);
                }
                else{
                    //Popup pop = PopupFactory.getSharedInstance().getPopup(frame, new JLabel("There is no task to add, please add a task in the field above."), 50, 100);
                    //pop.show();
                }
            }
        });
        markComplete.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent a){
                // Getting index of selected task
                int selectedIndex = taskList.getSelectedIndex();
                // If index is valid remove it.
                if(selectedIndex != -1){
                    // Highlight the task that is completed.
                }
                else{
                    //Popup pop = PopupFactory.getSharedInstance().getPopup(frame, new JLabel("There is no task to add, please add a task in the field above."), 50, 100);
                    //pop.show();
                }
            }
        });


        // Making frame visible.
        frame.setVisible(true);
    }
}
