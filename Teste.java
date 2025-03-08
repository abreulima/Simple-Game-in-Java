import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game extends JPanel implements KeyListener, ActionListener {

    private Image pou;
    private int pouX = 100, pouY = 200;
    private int pouSpeed = 5; // Speed of Pou's movement
    private Timer timer; // Timer to control game loop

    Game() {
        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.black);
        
        pou = new ImageIcon(getClass().getResource("./pou.png")).getImage();

        // Add button to feed Pou
        JButton alimentarButton = new JButton("Alimentar");
        alimentarButton.setBounds(650, 500, 120, 40);
        alimentarButton.addActionListener(e -> alimentar());
        
        setLayout(null);
        add(alimentarButton);

        // Add the KeyListener to this panel to listen for key events
        addKeyListener(this);
        setFocusable(true); // Make sure the panel is focusable to receive key events
        
        // Initialize and start the game loop timer
        timer = new Timer(16, this); // 16ms for ~60 FPS
        timer.start(); // Start the game loop
    }

    public void alimentar() {
        pouY += 20;
        repaint();
    }

    // Method to handle key presses for movement
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        
        // Move Pou based on key press
        if (keyCode == KeyEvent.VK_UP) {
            pouY -= pouSpeed;
        } else if (keyCode == KeyEvent.VK_DOWN) {
            pouY += pouSpeed;
        } else if (keyCode == KeyEvent.VK_LEFT) {
            pouX -= pouSpeed;
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            pouX += pouSpeed;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Not needed in this case
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not needed in this case
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Called on each game loop iteration (about 60 times per second)
        repaint(); // Repaint the screen continuously
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(100, 100, 32, 32);

        g.setColor(Color.BLUE);
        g.fillRect(100, 200, 32, 32);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20)); // Font style & size
        g.drawString("Hello, Pou!", 50, 50);

        // Draw Pou at the updated position
        g.drawImage(pou, pouX, pouY, 50, 50, null);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Pou Game");
        Game gamePanel = new Game();
        frame.add(gamePanel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
