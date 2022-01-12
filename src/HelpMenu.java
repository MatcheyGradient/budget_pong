
import java.awt.*;

public class HelpMenu {

    public Rectangle backButton = new Rectangle(Pong.width - 150, Pong.height - 90, 120, 60);

    public void render(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        g.setFont(new Font("arial", Font.BOLD, 40));

        g.setColor(Color.white);
        g.drawString("Use 'W' and 'S' to move left paddles.", 20, 50);
        g.drawString("Use arrow keys to move right paddles.", 20, 110);

        g.drawString("Back", Pong.width - 137, Pong.height - 45);

        g2d.draw(backButton);


    }
}
