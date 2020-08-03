import javax.swing.*;

public class Chat {

    private static Main mainChatWindow;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                mainChatWindow = new Main();
            }
        });
    }
}
