import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JComponent implements ActionListener {
    int x = 0;
    int y = 0;
    int w = 40;
    int h = 40;
    double delta=0.1;
    int radius = 170;
    static int winW = 510;
    static int winH = 430;
    Image sky = new ImageIcon("src/небо.jpg").getImage();
    Image sun = new ImageIcon("src/солнце2.png").getImage();
    Image earth = new ImageIcon("src/земля1.png").getImage();
    Timer timer = new Timer(1, this);

    public static void main(String[] args) {
        Main t = new Main();
        JFrame frame = new JFrame("Вращение Земли вокруг Солнца");
        frame.setSize(winW, winH);
        frame.setLocation(434, 134);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.add(t);
        frame.setVisible(true);
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(sky, 0,0,510,400,null);
        g2d.drawImage(sun, 195,140,100,100,null);
        g2d.drawImage(earth, x,y, w,h,null);

        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        x= 227 + (int) (radius*(Math.cos(delta)));
        y= 175 + (int) (radius*(Math.sin(delta)));
        delta += 0.003;
        repaint();
    }
}