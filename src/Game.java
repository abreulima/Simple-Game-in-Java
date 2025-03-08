import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game extends JPanel {


    private Image pou;
    private int pouY = 200;

    Game()
    {
        setPreferredSize(new Dimension(800,600));
        setBackground(Color.black);

        pou = new ImageIcon(getClass().getResource("./pou.png")).getImage();
    
        JButton alimentarButton= new JButton("Alimentar");
        alimentarButton.setBounds(650, 500, 120, 40);

        alimentarButton.addActionListener(e -> aliemntar());

        setLayout(null);
        add(alimentarButton);
    
    }

    public void aliemntar()
    {   
        pouY += 20;
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g)
    {
        g.setColor(Color.RED);
        g.fillRect(100, 100, 32, 32);

        //g.setColor(new Color(100, 200, 255))
        g.setColor(Color.BLUE);
        g.fillRect(100, 200, 32, 32);

        g.setColor(Color.WHITE); 
        g.setFont(new Font("Arial", Font.BOLD, 20)); // Font style & size
        g.drawString("Hello, Pou!", 50, 50);

        g.drawImage(pou, 100, pouY, 50, 50, null);
    }

}