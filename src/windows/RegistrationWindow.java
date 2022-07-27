package windows;


import org.w3c.dom.Text;
import people.Patient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationWindow {

    public static DataBase base;
    public RegistrationWindow(DataBase base1) {
        base = base1;
        EventQueue.invokeLater( () ->
        {
            var frame = new RWindow();

            frame.setTitle("registration window");
            frame.setDefaultCloseOperation(
                    JFrame.DISPOSE_ON_CLOSE);
            frame.setResizable(false);
            frame.setLocation(800,200);
            frame.setSize(250,250);
            frame.setVisible(true);
        });
    }
    public void setBase(DataBase base) {
        SearchWindow.base = base;
    }
}

class RWindow extends JFrame
{
    DataBase base = SearchWindow.base;
    private static final int DEFAULT_WIDTH = 250;
    private static final int DEFAULT_HEIGHT = 250;

    private static JPanel panel;
    private static final TextArea nameArea = new TextArea();
    private static final TextArea surnameArea = new TextArea();
    private static final TextArea ageArea = new TextArea();

    public RWindow() {
        var textField = new JTextField();
        var textField1 = new JTextField();
        var textField2 = new JTextField();
        var textField3 = new JTextField();

        var northPanel = new JPanel();

        northPanel.setLayout(new GridLayout(4,3));

        northPanel.add(new JLabel("surname: ", SwingConstants.RIGHT));
        northPanel.add(textField);
        northPanel.add(new JLabel("name: ", SwingConstants.RIGHT));
        northPanel.add(textField1);
        northPanel.add(new JLabel("father's name: ", SwingConstants.RIGHT));
        northPanel.add(textField2);
        northPanel.add(new JLabel("age: ", SwingConstants.RIGHT));
        northPanel.add(textField3);

        add(northPanel,BorderLayout.NORTH);

        var textArea = new JTextArea(8,20);
        add (textArea, BorderLayout.CENTER);

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(3,3));

        JButton insertB = new JButton("Зарегистрировать");
        southPanel.add(insertB);
        insertB.addActionListener( event -> {
            textArea.append("\nname: " + textField.getText() + " surname: " +
                    textField1.getText() + " age: " + textField2.getText());

            base.addPatient(new Patient(textField.getText(),textField1.getText(),textField2.getText(),Integer.parseInt(textField3.getText())));

            this.dispose();
        });
        add(southPanel, BorderLayout.CENTER);
        pack();
    }

    @Override
    public void setResizable(boolean resizable) {
        super.setResizable(resizable);
    }

    @Override
    public void setLocation(int x, int y) {
        super.setLocation(x, y);
    }

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
    }

}

