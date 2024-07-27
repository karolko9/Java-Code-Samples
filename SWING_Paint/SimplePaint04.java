
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class SimplePaint04 {
    int Dimensionx = 200;
    int Dimensiony = 200;
    int PencilSize = 10;
    String PencilShape = "oval"; // oval square rectangle
    public static void main(String[] args) {
        new SimplePaint04();
    }

    public SimplePaint04() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private PaintPane paintPane;

        public TestPane() {
            setLayout(new BorderLayout());
            add((paintPane = new PaintPane()));
            add(createMenuBar(), BorderLayout.NORTH);
        }

        private JMenuBar createMenuBar() {
            JMenuBar menuBar = new JMenuBar();

            JMenu ColorsMenu = new JMenu("Colors");
            JMenu PencilSizeMenu = new JMenu("PencilSize");
            JMenu PencilShapeMenu = new JMenu("PencilShape");
            //JMenu Window = new JMenu("Window");


            ColorsMenu.add(new ColorsPane(paintPane));
            PencilSizeMenu.add(new SizePane(paintPane));
            PencilShapeMenu.add(new ShapePane(paintPane));

            menuBar.add(PencilShapeMenu);
            menuBar.add(PencilSizeMenu);
            menuBar.add(ColorsMenu);
            return menuBar;
        }
    }





//    public class WindowPane extends JPanel {
//        public WindowPane(PaintPane paintPane) {
//            add(new JButton(new SizeAction(paintPane, "10", 100)));
//            add(new JButton(new SizeAction(paintPane, "15", 400)));
//            add(new JButton(new SizeAction(paintPane, "20",200)));
//        }
//        public class SizeAction extends AbstractAction {
//
//            private PaintPane paintPane;
//            private int size;
//
//            private SizeAction(PaintPane paintPane, String name, int size) {
//                putValue(NAME, name);
//                this.paintPane = paintPane;
//                this.size = size;
//            }
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                PencilSize = size;
//            }
//        }
//    }


    public class ShapePane extends JPanel {
        public ShapePane(PaintPane paintPane) {
            add(new JButton(new SizeAction(paintPane, "square", "square")));
            add(new JButton(new SizeAction(paintPane, "rectangle", "rectangle")));
            add(new JButton(new SizeAction(paintPane, "oval","oval" )));
        }
        public class SizeAction extends AbstractAction {

            private PaintPane paintPane;
            private String shape;

            private SizeAction(PaintPane paintPane, String name, String shape) {
                putValue(NAME, name);
                this.paintPane = paintPane;
                this.shape = shape;
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                PencilShape = shape;
            }
        }
    }

    public class SizePane extends JPanel {
        public SizePane(PaintPane paintPane) {
            add(new JButton(new SizeAction(paintPane, "10", 10)));
            add(new JButton(new SizeAction(paintPane, "15", 15)));
            add(new JButton(new SizeAction(paintPane, "20",20 )));
        }
        public class SizeAction extends AbstractAction {

            private PaintPane paintPane;
            private int size;

            private SizeAction(PaintPane paintPane, String name, int size) {
                putValue(NAME, name);
                this.paintPane = paintPane;
                this.size = size;
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                PencilSize = size;
            }
        }
    }

    public class ColorsPane extends JPanel {
        public ColorsPane(PaintPane paintPane) {
            add(new JButton(new ColorAction(paintPane, "Red", Color.RED)));
            add(new JButton(new ColorAction(paintPane, "Green", Color.GREEN)));
            add(new JButton(new ColorAction(paintPane, "Blue", Color.BLUE)));
            add(new JButton(new ColorAction(paintPane, "Gray", Color.GRAY)));
            add(new JButton(new ColorAction(paintPane, "Black", Color.BLACK)));
            add(new JButton(new ColorAction(paintPane, "Yellow", Color.YELLOW)));
            add(new JButton(new ColorAction(paintPane, "Orange", Color.ORANGE)));
            add(new JButton(new ColorAction(paintPane, "Cyan", Color.CYAN)));
            add(new JButton(new ColorAction(paintPane, "Magenta", Color.MAGENTA)));
            add(new JButton(new ColorAction(paintPane, "Pink", Color.pink)));
        }


        public class ColorAction extends AbstractAction {

            private PaintPane paintPane;
            private Color color;

            private ColorAction(PaintPane paintPane, String name, Color color) {
                putValue(NAME, name);
                this.paintPane = paintPane;
                this.color = color;
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                paintPane.setForeground(color);
            }
        }
    }

    public class PaintPane extends JPanel {

        private BufferedImage background;

        public PaintPane() {
            setBackground(Color.WHITE);
            setForeground(Color.BLACK);
            MouseAdapter handler = new MouseAdapter() {

                @Override
                public void mousePressed(MouseEvent e) {
                    drawDot(e.getPoint());
                }

                @Override
                public void mouseDragged(MouseEvent e) {
                    drawDot(e.getPoint());
                }

            };
            addMouseListener(handler);
            addMouseMotionListener(handler);
        }

        protected void drawDot(Point p) {
            if (background == null) {
                updateBuffer();;
            }

            if (background != null) {
                Graphics2D g2d = background.createGraphics();
                g2d.setColor(getForeground());
                if(PencilShape == "oval") {
                    g2d.fillOval(p.x - (PencilSize / 2), p.y - (PencilSize / 2), PencilSize, PencilSize);
                }
                else if (PencilShape == "square"){
                    g2d.fillRect(p.x - (PencilSize / 2), p.y - (PencilSize / 2), PencilSize, PencilSize);
                }
                else if (PencilShape == "rectangle"){
                    g2d.fillRect (p.x - (PencilSize / 2), p.y - (PencilSize / 2), PencilSize/3, PencilSize);
                }
                g2d.dispose();
            }
            repaint();
        }

        @Override
        public void invalidate() {
            super.invalidate();
            updateBuffer();
        }

        protected void updateBuffer() {

            if (getWidth() > 0 && getHeight() > 0) {
                BufferedImage newBuffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
                Graphics2D g2d = newBuffer.createGraphics();
                g2d.setColor(Color.WHITE);
                g2d.fillRect(0, 0, getWidth(), getHeight());
                if (background != null) {
                    g2d.drawImage(background, 0, 0, this);
                }
                g2d.dispose();
                background = newBuffer;
            }

        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(Dimensionx, Dimensiony);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            if (background == null) {
                updateBuffer();
            }
            g2d.drawImage(background, 0, 0, this);
            g2d.dispose();
        }
    }


}
