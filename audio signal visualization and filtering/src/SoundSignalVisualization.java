import javax.swing.*;
import java.awt.*;
import java.io.*;

public class SoundSignalVisualization extends JPanel {

    private short[] soundData;  

    public SoundSignalVisualization(short[] soundData) {
        this.soundData = soundData;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        int width = getWidth();
        int height = getHeight();
        int size = soundData.length;
        graphics.setColor(Color.BLACK);
        int step = Math.max(2, soundData.length / width);
        int scale = height / 2;
        for (int i = 0; i < width - step ; i += step) {
            int y = (int) (scale + (soundData[i] * 0.006));
            int y1 = (int) (scale + (soundData[i + step] * 0.006));
            graphics.drawLine(i, y, i + step, y1);
        }

    }

    public static void main(String[] args) throws IOException {
        File srcFile = new File("C:\\Users\\bolek\\IdeaProjects\\PZ1-lab9-Wizualizacja_sygnalu-dzwiekowego_filtrowanie\\src\\RecordAudio8bitMono.wav");
        FileInputStream in = new FileInputStream(srcFile);
        byte[] buf = new byte[786 * 2];
        short[] soundData = new short[786];
        in.read(buf);
        for (int i = 0; i < soundData.length; i++) {
            soundData[i] = (short) ((buf[i * 2] & 0xff) | (buf[i * 2 + 1] << 8));
        }

        in.close();



        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Sound Signal Visualization");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            SoundSignalVisualization panel = new SoundSignalVisualization(soundData);
            frame.add(panel);

            frame.setSize(800, 600);
            frame.setVisible(true);
        });
    }
}
