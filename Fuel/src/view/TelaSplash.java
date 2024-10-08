import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaSplash extends JWindow {

    public TelaSplash() {
        JPanel content = new JPanel(new BorderLayout());
        JLabel label = new JLabel(new ImageIcon("src/Splash.gif"));
        content.add(label, BorderLayout.CENTER);
        setContentPane(content);
        setSize(280, 350);
        setLocationRelativeTo(null);
        Timer timer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                showMainApplication();
            }
        });
        timer.setRepeats(false);
        timer.start();
        setVisible(true);
    }

    private void showMainApplication() {
        SwingUtilities.invokeLater(() -> {
            TelaPrincipal app = new TelaPrincipal();
            app.setVisible(true);
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TelaSplash::new);
    }
}
