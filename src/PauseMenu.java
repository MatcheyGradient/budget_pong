import javafx.scene.shape.Sphere;

import java.awt.*;

public class PauseMenu {

    public Rectangle addSpeed = new Rectangle((Pong.width / 2) - 400, 100, 120, 60);
    public Rectangle removeSpeed = new Rectangle((Pong.width / 2) - 400, 300, 120, 60);
    public Rectangle backToGame = new Rectangle((Pong.width / 2) - 100, 170, 200, 70);
    public Rectangle backToMenu = new Rectangle((Pong.width / 2) - 100, 250, 200, 70);
    public Rectangle quitGame = new Rectangle((Pong.width / 2) - 100, 330, 200, 70);

    static int speedNum = 12;

    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g.setColor(Color.darkGray);
        g.fillRect(0, 0, Pong.width, Pong.height);
        g.setFont(new Font("arial", Font.BOLD, 60));
        FontMetrics fm = g.getFontMetrics();
        int x = (Pong.width - fm.stringWidth("Paused")) / 2;

        g.setColor(Color.white);
        g.drawString("Paused", x, 100);

        g.setFont(new Font("arial", Font.BOLD, 30));
        g.drawString("Adjust Speed", (Pong.width / 2) - 430, 60);
        g.drawString("Add", addSpeed.x + 30, addSpeed.y + 40);
        g.drawString("Sub", removeSpeed.x + 30, removeSpeed.y + 40);
        g.setFont(new Font("arial", Font.BOLD, 50));
        g.drawString(Integer.toString(speedNum - 2), (Pong.width / 2) - 362, 250);

        g2d.draw(addSpeed);
        g2d.draw(removeSpeed);

        g.drawString("Back", backToGame.x + 40, backToGame.y + 50);
        g.drawString("Menu", backToMenu.x + 40, backToMenu.y + 50);
        g.drawString("Quit", quitGame.x + 40, quitGame.y + 50);
        g2d.draw(backToGame);
        g2d.draw(backToMenu);
        g2d.draw(quitGame);

    }
}
