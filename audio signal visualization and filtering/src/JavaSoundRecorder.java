

import javax.sound.sampled.*;
import java.io.*;

public class JavaSoundRecorder {
    static final long RECORD_TIME = 15000;  // 15 seconds

    File wavFile = new File("C:\\Users\\bolek\\IdeaProjects\\PZ1-lab9-Wizualizacja_sygnalu-dzwiekowego_filtrowanie\\src\\RecordAudio.wav");

    AudioFileFormat.Type fileType = AudioFileFormat.Type.WAVE;

    TargetDataLine line;


    AudioFormat getAudioFormat() {
        float sampleRate = 16000;
        int sampleSizeInBits = 16;
        int channels = 1;
        boolean signed = true;
        boolean bigEndian = false;
        AudioFormat format = new AudioFormat(sampleRate, sampleSizeInBits,
                channels, signed, bigEndian);
        return format;
    }


    void start() {
        try {
            AudioFormat format = getAudioFormat();
            DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);

            if (!AudioSystem.isLineSupported(info)) {
                System.out.println("Line not supported");
                System.exit(0);
            }
            line = (TargetDataLine) AudioSystem.getLine(info);
            line.open(format);
            line.start(); 

            System.out.println("Start capturing...");

            AudioInputStream ais = new AudioInputStream(line);

            System.out.println("Start recording...");

            // start recording
            AudioSystem.write(ais, fileType, wavFile);

        } catch (LineUnavailableException ex) {
            ex.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }


    void finish() {
        line.stop();
        line.close();
        System.out.println("Finished");
    }


    public static void main(String[] args) {
        final JavaSoundRecorder recorder = new JavaSoundRecorder();


        Thread stopper = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(RECORD_TIME);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                recorder.finish();
            }
        });
        stopper.start();
        recorder.start();
    }
}