package windows;


import drugs.BaseDrugs;
import drugs.Drugs;
import drugs.GrammDrugs;
import drugs.Receipt;
import events.DrugsEvent;
import org.w3c.dom.Text;
import people.Patient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class PatientListWindow {

    public static Patient patient;
    public PatientListWindow(Patient pat) {
        patient = pat;
       EventQueue.invokeLater( () ->
        {
            var frame = new PatWindow();

            frame.setTitle("registration window");
            frame.setDefaultCloseOperation(
                    JFrame.DISPOSE_ON_CLOSE);
            frame.setResizable(false);
            frame.setLocation(800,200);
            frame.setSize(1000,400);
            frame.setVisible(true);
        });
    }
    public void setBase(DataBase base) {
        SearchWindow.base = base;
    }
}

class PatWindow extends JFrame
{
    DataBase base = SearchWindow.base;
    Patient patient = PatientListWindow.patient;
    static BaseDrugs baseDrugs = SearchWindow.baseDrugs;
    private static final int DEFAULT_WIDTH = 250;
    private static final int DEFAULT_HEIGHT = 250;

    private static JPanel panel;
    private static final TextField nameArea = new TextField();
    private static final TextField surnameArea = new TextField();
    private static final TextField fatherNameArea = new TextField();
    private static final TextField ageArea = new TextField();
    private static final TextField drugArea = new TextField();
    private static final TextArea text = new TextArea();
    //private static final JComboBox<Drugs> comboBox = new JComboBox<>(baseDrugs.getDrugs());


    public PatWindow() {

        surnameArea.setText(patient.getSurname());
        nameArea.setText(patient.getName());
        fatherNameArea.setText(patient.getFatherName());
        ageArea.setText(String.valueOf(patient.getAge()));

        surnameArea.setEditable(false);
        nameArea.setEditable(false);
        ageArea.setEditable(false);
        fatherNameArea.setEditable(false);

        var westPanel = new JPanel();
        westPanel.setLayout(new GridLayout(5,1));

        westPanel.add(new JLabel("name: ", SwingConstants.RIGHT));
        westPanel.add(nameArea);
        westPanel.add(new JLabel("surname: ", SwingConstants.RIGHT));
        westPanel.add(surnameArea);
        westPanel.add(new JLabel("father's name: ", SwingConstants.RIGHT));
        westPanel.add(fatherNameArea);
        westPanel.add(new JLabel("age: ", SwingConstants.RIGHT));
        westPanel.add(ageArea);
        westPanel.add(new JLabel("drug: ", SwingConstants.RIGHT));
        westPanel.add(drugArea);

       // westPanel.add(comboBox);

        westPanel.setLocation(0,100);
        add(westPanel);


        var cancelButton = new JButton("clear");
        var addButton = new JButton("add");
        var closeButton = new JButton("close");

        var southPanel = new JPanel();

        {
            closeButton.addActionListener(event -> {
                dispose();
            });

            cancelButton.addActionListener(event -> {
                drugArea.setText("");
                text.setText("");
            });

            addButton.addActionListener(event-> {
                LocalDate date = LocalDate.now();
                Patient p = patient;
                Drugs drug = baseDrugs.getDrug(drugArea.getText());
                Receipt receipt = new Receipt(drug,text.getText());
                base.addEvent(new DrugsEvent(date,p,receipt));
                drugArea.setText("");
                text.setText("");

                base.printAllEvents(null,System.out);
            });
        }

        southPanel.setLayout(new GridLayout(1,3));
        southPanel.add(cancelButton);
        southPanel.add(addButton);
        southPanel.add(closeButton);

        add(southPanel, BorderLayout.SOUTH);

        var eastPanel = new JPanel();
        eastPanel.add(text);

        add(eastPanel,BorderLayout.EAST);
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

