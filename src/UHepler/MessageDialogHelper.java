package UHepler;

import java.awt.Component;
import javax.swing.JOptionPane;

public class MessageDialogHelper {

    public static void showMessageDialog(Component parent, String content, String tilte) {
        JOptionPane.showMessageDialog(parent, content, tilte, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void showErrorDialog(Component parent, String content, String tilte) {
        JOptionPane.showMessageDialog(parent, content, tilte, JOptionPane.ERROR_MESSAGE);
    }

    public static int showConfirmDialog(Component parent, String content, String tilte) {
        int choose = JOptionPane.showConfirmDialog(parent, content, tilte, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        return choose;
    }
}
