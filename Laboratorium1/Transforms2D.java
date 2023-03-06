import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Transforms2D extends JPanel {
    private class Display extends JPanel {
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D)g;
            g2.translate(300,300);  
            int whichTransform = transformSelect.getSelectedIndex();
            switch(whichTransform) {
                case 0:
                    break;
                case 1:
                    g2.scale(0.5, 0.5);
                    break;
                case 2:
                    g2.rotate(45*Math.PI/180);
                    break;
                case 3:
                    g2.scale(-0.5, 1);
                    g2.rotate(180*Math.PI/180);
                    break;
                case 4:
                    g2.shear(0.5, 0);
                    break;
                case 5:
                    g2.scale(1, 0.4);
                    g2.translate(0, -605);
                    break;
                case 6:
                    g2.rotate(90*Math.PI/180);
                    g2.shear(0.5, 0);
                    break;
                case 7:
                    g2.scale(0.5, 1);
                    g2.rotate(180*Math.PI/180);
                    break;
                case 8:
                    g2.rotate(30*Math.PI/180);
                    g2.scale(1, 0.4);
                    g2.translate(25, 350);
                    break;
                case 9:
                    g2.rotate(180*Math.PI/180);
                    g2.shear(0, 0.5);
                    g2.translate(-165, 50);
                    break;
                default:
            }

            Polygon trzynasto = new Polygon();

            int Katy=13;
            for (int i=0; i<Katy; i++)
            {
            	trzynasto.addPoint( (int)(150*Math.cos(i*2*Math.PI/Katy)),
                            (int)(150*Math.sin(i*2*Math.PI/Katy)));
            }
            g2.setColor(Color.BLUE);
            g.drawPolygon(trzynasto);
            g2.fill(trzynasto);
        }
    }

    private final Display display;
    private BufferedImage pic;
    private final JComboBox<String> transformSelect;

    public Transforms2D() {
        display = new Display();
        display.setBackground(Color.YELLOW);
        display.setPreferredSize(new Dimension(600,600));
        transformSelect = new JComboBox<String>();
        transformSelect.addItem("None");
        for (int i = 1; i < 10 ; i++) {
            transformSelect.addItem("No. " + i);
        }
        transformSelect.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                display.repaint();
            }
        });
        setLayout(new BorderLayout(3,3));
        setBackground(Color.GRAY);
        setBorder(BorderFactory.createLineBorder(Color.GRAY,10));
        JPanel top = new JPanel();
        top.setLayout(new FlowLayout(FlowLayout.CENTER));
        top.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
        top.add(new JLabel("Transform: "));
        top.add(transformSelect);
        add(display,BorderLayout.CENTER);
        add(top,BorderLayout.NORTH);
    }


    public static void main(String[] args) throws IOException {
        JFrame window = new JFrame("2D Transforms");
        window.setContentPane(new Transforms2D());
        window.pack();
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation( (screen.width - window.getWidth())/2, (screen.height - window.getHeight())/2 );
        window.setVisible(true);
    }

}