package clientapplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainWindow extends JFrame implements MessageSender {

    private JTextField textField;
    private JButton button;
    private JScrollPane scrollPane;
    private JList<Message> messageList;
    private DefaultListModel<Message> messageListModel;
    private DefaultListModel<String> userListModel;
    private JList<String> userList;
    private JPanel panel;
    private MessageWriterHistory history = new  MessageWriterHistory ("","", "", "");



    private Network network;

    public MainWindow() {
        setTitle("Сетевой чат");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(200, 200, 500, 500);

        setLayout(new BorderLayout());

        messageListModel = new DefaultListModel<>();
        messageList = new JList<>(messageListModel);
        messageList.setCellRenderer(new MessageCellRenderer());

        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(messageList, BorderLayout.SOUTH);
        panel.setBackground(messageList.getBackground());
        scrollPane = new JScrollPane(panel);
        add(scrollPane, BorderLayout.CENTER);

        userListModel = new DefaultListModel<>();
        userList = new JList(userListModel);

        userList.setPreferredSize(new Dimension(100, 0));
        add(userList, BorderLayout.WEST);

        textField = new JTextField();
        button = new JButton("Отправить");



        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                messageAn();
            }
        });


        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt) {
                int key = evt.getKeyCode();
                     if (key == KeyEvent.VK_ENTER) {
                         messageAn();
                     }
                }
        });

        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent evt) {
                messageList.ensureIndexIsVisible(messageListModel.size() - 1);
            }
        });

        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(button, BorderLayout.EAST);
        panel.add(textField, BorderLayout.CENTER);

        add(panel, BorderLayout.SOUTH);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    if (network != null) {
                        network.close();
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                super.windowClosing(e);
            }
        });

        setVisible(true);

        network = new Network("localhost", 7777, this);

        LoginDialog loginDialog = new LoginDialog(this, network);
        loginDialog.setVisible(true);

        if (!loginDialog.isConnected()) {
            System.exit(0);
        }
        setTitle("Сетевой чат. Пользователь " + network.getUsername());
    }



    private void messageAn() {

        String userTo = userList.getSelectedValue();
        String amI = network.getUsername();
        String text = textField.getText();
        Matcher matcher = RECOGNIZE_PATTERN.matcher(text);

        if ((userTo == null) && (!matcher.matches())) {
            JOptionPane.showMessageDialog(MainWindow.this,
                    "Укажите получателя",
                    "Отправка сообщения",
                    JOptionPane.ERROR_MESSAGE);

            return;
        }

        if (userTo.equals(amI)) {
            JOptionPane.showMessageDialog(MainWindow.this,
                    "Не имеет смысла отправлять сообщение себе.",
                    "Отправка сообщения",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }


        if (text == null || text.trim().isEmpty()) {
            JOptionPane.showMessageDialog(MainWindow.this,
                    "Ошибка! Сообщение пустое.",
                    "Отправка сообщения",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        Message msg = new Message(network.getUsername(), userTo, text.trim());

        submitMessage(msg);

        textField.setText(null);
        textField.requestFocus();
        network.sendMessageToUser(msg);
    }

    @Override
    public void submitMessage(Message msg) {
        messageListModel.add(messageListModel.size(), msg);
        messageList.ensureIndexIsVisible(messageListModel.size() - 1);
    }


    @Override
    public void submitUser(String [] msg) {
        userList.setListData(msg);
    }




}
