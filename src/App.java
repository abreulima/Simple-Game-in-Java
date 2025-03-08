import javax.swing.JFrame;

public class App {
    public static void main(String[] args) throws Exception {
        //System.out.println("Hello World!");
    
        JFrame frame = new JFrame("Pou");
        frame.setVisible(true);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Game game = new Game();
        frame.add(game);
        frame.pack();
        frame.setVisible(true);

    
    }
}