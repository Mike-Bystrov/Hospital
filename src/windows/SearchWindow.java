package windows;


import drugs.BaseDrugs;
import drugs.Drugs;
import people.Patient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.geom.Rectangle2D;

public class SearchWindow {

    public static DataBase base;
    public static BaseDrugs baseDrugs;
    public static SWindow frame;

    public SearchWindow() {
        EventQueue.invokeLater( () ->
        {
            frame = new SWindow();

            Image img = new ImageIcon("C:\\Users\\User\\Desktop\\sprites\\redCross.png").getImage();
            frame.setIconImage(img);

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            frame.setResizable(false);

            frame.setLocation(250,120);
            frame.setSize(400,400);

        });
    }

    public void setBaseDrugs(BaseDrugs baseDrugs) {
        SearchWindow.baseDrugs = baseDrugs;
    }

    public void setBase(DataBase base) {
        SearchWindow.base = base;
    }
}

class SWindow extends JFrame
{
    DataBase base = SearchWindow.base;
    private static final int DEFAULT_WIDTH = 1000;
    private static final int DEFAULT_HEIGHT = 600;
    private static JPanel panel = new JPanel();
    private static JTextField textField;
    private static Patient patient;

    public SWindow()
    {
        textField = new JTextField();

        var northPanel = new JPanel();

        northPanel.setLayout(new GridLayout(2,2));

        northPanel.add(new JLabel("name: ", SwingConstants.RIGHT));
        northPanel.add(textField);

        add(northPanel,BorderLayout.NORTH);

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(3,3));

        JButton insertB = new JButton("Check:");
        southPanel.add(insertB);
        insertB.addActionListener( event -> {

            var pat = textField.getText();
            var arr = pat.split(" ");
            patient = base.isSuchPatient(pat);
            if (patient == null) {
                var fr = new RegistrationWindow(base);
            }
            else {
                var fr1 = new PatientListWindow(patient);
            }
            textField.setText("");
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

    static class InfoComponent extends JComponent {

        private static final int DEFAULT_WIDTH = 1000;
        private static final int DEFAULT_HEIGHT = 600;

        public void paintComponent(Graphics g)
        {
            var g2 = (Graphics2D) g;
            String message = "Hospital";
            var f = new Font(Font.SERIF,Font.BOLD,100);

            g2.setFont(f);
            g2.drawString(message, 300,100);
        }

        public Dimension getPreferredSize() {
            return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        }
    }

    static class CheckAction implements ActionListener
    {
        String pat;
        DataBase base;
        @Override
        public void actionPerformed(ActionEvent e) {
            pat = textField.getText();
            var arr = pat.split(" ");
            String p = arr[1] +" " +  arr[0]+" " + arr[2];
            patient = base.isSuchPatient(p);
            if (patient == null) {
                var fr = new RegistrationWindow(base);
                textField.setText("");
            } else {
                textField.setText(patient.toString());
            }
            var f1 = new PatientListWindow(patient);
        }

        public CheckAction(DataBase base1) {
            base = base1;
        }

    }

}


