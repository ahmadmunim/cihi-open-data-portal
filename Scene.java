import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public interface Scene<S extends JFrame> {

    public static final Font BUTTON_FONT = new Font("Arial", Font.PLAIN, 33);

    public static final Color BUTTON_COLOUR = new Color(0x00a19a);

    public default S getDerived() {
        return(S)this;
    }

    public default JButton getButton(String s, ActionListener l) {

        JButton button = new JButton(s);

        button.setBackground(BUTTON_COLOUR);
        button.setFont(BUTTON_FONT);
        button.addActionListener(l);

        return button;

    }

}