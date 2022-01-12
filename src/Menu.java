

import java.awt.*;

public class Menu {

    public Rectangle playGame = new Rectangle((Pong.width / 2) - 70, 200, 120, 60);
    public Rectangle quitGame = new Rectangle((Pong.width / 2) - 70, 300, 120, 60);
    public Rectangle helpButton = new Rectangle((Pong.width / 2) - 70, 400, 120, 60);

    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g.setColor(Color.white);
        g.setFont(new Font("arial", Font.BOLD, 90));
        FontMetrics fm = g.getFontMetrics();
        int x = (Pong.width - fm.stringWidth("Pong!")) / 2;
        g.drawString("Pong!", x, 100);

        g.setFont(new Font("arial", Font.BOLD, 40));
        g.drawString("Play", playGame.x + 20, playGame.y + 43);
        g.drawString("Quit", quitGame.x + 20, quitGame.y + 43);
        g.drawString("Help", helpButton.x + 16, helpButton.y + 43);

        g2d.draw(playGame);
        g2d.draw(quitGame);
        g2d.draw(helpButton);
    }
}
