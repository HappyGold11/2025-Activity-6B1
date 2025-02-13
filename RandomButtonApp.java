import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RandomButtonApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RandomButtonFrame());
    }
}

class RandomButtonFrame extends JFrame {
    private JButton button;
    private Random random;
    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 500;
    private static final int BUTTON_SIZE = 80;

    public RandomButtonFrame() {
        setTitle("Random Button Clicker");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null); // Absolute positioning

        random = new Random();
        button = new JButton("Click Here");
        button.setBounds(getRandomX(), getRandomY(), BUTTON_SIZE, BUTTON_SIZE);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveButton();
            }
        });

        add(button);
        setVisible(true);
    }

    private int getRandomX() {
        return random.nextInt(FRAME_WIDTH - BUTTON_SIZE);
    }

    private int getRandomY() {
        return random.nextInt(FRAME_HEIGHT - BUTTON_SIZE);
    }

    private void moveButton() {
        button.setBounds(getRandomX(), getRandomY(), BUTTON_SIZE, BUTTON_SIZE);
    }
}
