package UHepler;

import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class DataValidator {

    public static void validateEmpty(JTextField field, StringBuilder sb, String errorMessage) {
        if (field.getText().equals("")) {
            sb.append(errorMessage).append("\n");
            field.setBackground(Color.red);
            field.requestFocus();
        } else {
            field.setBackground(Color.GRAY);
        }
    }

    public static void validateEmpty(JPasswordField field, StringBuilder sb, String errorMessage) {
        String pass = new String(field.getPassword());
        if (pass.equals("")) {
            sb.append(errorMessage).append("\n");
            field.setBackground(Color.red);
            field.requestFocus();
        } else {
            field.setBackground(Color.GRAY);
        }
    }
}
