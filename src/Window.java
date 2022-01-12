import javax.swing.*;

public class Window extends JFrame {
    public Window(){
        this.add(new Pong());
        this.setTitle("pong");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }
}
