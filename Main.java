import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.*;

public class Main extends JFrame {

    public Main() {
        setTitle("Чат");
        setBounds(250,250, 450, 450);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        DefaultListModel messListModel = new DefaultListModel();
        JList<String> messagesList = new JList(messListModel);
        messagesList.setVisibleRowCount(10);
        messagesList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);


        JScrollPane scroll = new JScrollPane(messagesList,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scroll, BorderLayout.CENTER);


        JPanel sendMessagePanel = new JPanel();
        sendMessagePanel.setLayout(new BorderLayout());

        JTextArea writeMesArea = new JTextArea();
        writeMesArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 100));
        writeMesArea.setFont(new Font("Serif", Font.BOLD, 14));
        writeMesArea.setLineWrap(true);
        writeMesArea.setWrapStyleWord(true);
        Action enter = new AbstractAction()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                writeMesArea.append( writeMesArea.getText() + "\n" );
                writeMesArea.setText("");
            }
        };

        writeMesArea.getActionMap().put("insert-break", enter);
        writeMesArea.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER)
                    if(e.isShiftDown()) {
                        writeMesArea.append(" \n");
                    } else
                    {
                        messListModel.addElement(writeMesArea.getText());
                        int index = messListModel.size() - 1;
                        messagesList.setSelectedIndex(index);
                        messagesList.ensureIndexIsVisible(index);
                        writeMesArea.setText("");
                        if (writeMesArea.getCaretPosition() > 0)
                        {
                            writeMesArea.setCaretPosition(0);
                        }
                    }
            }
        });

        JButton sendButton = new JButton("Отправить");
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                messListModel.addElement(writeMesArea.getText());
                int index = messListModel.size() - 1;
                messagesList.setSelectedIndex(index);
                messagesList.ensureIndexIsVisible(index);
                writeMesArea.setText("");
            }
        });


        sendMessagePanel.add(sendButton, BorderLayout.EAST);
        sendMessagePanel.add(writeMesArea, BorderLayout.CENTER);

        add(sendMessagePanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}
