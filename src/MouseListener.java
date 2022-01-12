import java.awt.event.MouseEvent;

public class MouseListener implements java.awt.event.MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();

        if(mouseX >= (Pong.width / 2) - 70 && mouseX <= (Pong.width / 2) + 50){
            if(mouseY >= 200 && mouseY <= 260){
                Pong.mode = Pong.Mode.GAME;
                Pong.pointPlayer1 = 0;
                Pong.pointPlayer2 = 0;
                Pong.paused = false;
            }
            if(mouseY >= 400 && mouseY <= 460){
                Pong.mode = Pong.Mode.HELP;
            }
        }

        if(mouseX >= (Pong.width / 2) - 70 && mouseX <= (Pong.width / 2) + 50){
            if(mouseY >= 300 && mouseY <= 360 && !Pong.paused){
                System.exit(1);
            }
        }

        if(Pong.paused){
            if(mouseX >= (Pong.width / 2) - 400 && mouseX <= (Pong.width / 2) - 280){
                if(mouseY >= 100 && mouseY <= 160){
                    if(PauseMenu.speedNum != 30) {
                        PauseMenu.speedNum++;
                    }
                }
                if(mouseY >= 300 && mouseY <= 360){
                    if(PauseMenu.speedNum != 5) {
                        PauseMenu.speedNum--;
                    }
                }
            }
            if(mouseX >= (Pong.width / 2) - 100 && mouseX <= (Pong.width / 2) + 100){
                if(mouseY >= 170 && mouseY <= 240){
                    Pong.paused = false;
                }
                if(mouseY >= 250 && mouseY <= 320){
                    Pong.paused = false;
                    Pong.mode = Pong.Mode.MENU;
                    Pong.resetGame();
                }
                if(mouseY >= 330 && mouseY <= 400){
                    System.exit(1);
                }
            }
        }

        if(Pong.mode == Pong.Mode.HELP){
            if(mouseX >= Pong.width - 150 && mouseX <= Pong.width - 30){
                if(mouseY >= Pong.height - 90 && mouseY <= Pong.height - 30){
                    Pong.mode = Pong.Mode.MENU;
                }
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
