
package org.example;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.*;

public class PlayAudioTest {
    public static void write (String filename, byte[]x) throws IOException {
        BufferedWriter outputWriter = null;
        outputWriter = new BufferedWriter(new FileWriter(filename));
        for (int i = 0; i < x.length; i++) {
            outputWriter.write(Integer.toString(x[i]));
            outputWriter.newLine();
        }
        outputWriter.flush();
        outputWriter.close();
    }

    public static void main(String[]args)
    {
        String filepath = "C:\\Users\\bolek\\IdeaProjects\\PZ1-lab9-Wizualizacja_sygnalu-dzwiekowego_filtrowanie\\src\\RecordAudio8bitMono.wav" ;
        try {
            AudioInputStream aui =  AudioSystem.getAudioInputStream(new File(filepath).getAbsoluteFile());
            AudioFormat af = aui.getFormat();
            byte[]arr = aui.readAllBytes();
            write("C:\\Users\\bolek\\IdeaProjects\\PZ1-lab9-Wizualizacja_sygnalu-dzwiekowego_filtrowanie\\src\\RecordAudio8bitMono.wav", arr);

            InputStream targetStream = new ByteArrayInputStream(arr);
            AudioInputStream ais = new AudioInputStream(targetStream, af, arr.length);
            Clip clip = AudioSystem.getClip() ;
            clip.open(ais);

            //
            clip.start();   //start Clip

            while (!clip.isRunning()){
                Thread.sleep(10);
            }
            //clip.
            while (clip.isRunning()){
                Thread.sleep(10);
            }

            clip.stop();    //Stop Clip
            clip.loop(10); // 10 time loop clip
            //clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.close();

        } catch (Exception e) {System.out.println(e.getMessage());}
    }
}