/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textwriter;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;
import javax.swing.JFileChooser;

/**
 *
 * @author David
 */
public class Backup extends Thread {

    List<String> text;
    String userDir = new JFileChooser().getFileSystemView().getDefaultDirectory().toString();
    File file;
    FileWriter writer;
    PrintWriter out;

    public Backup(List<String> text) {
        this.text = text;
    }

    @Override
    public void run() {
        while (true) {
            try {
                file = new File(userDir + "\\backup.txt");
                writer = new FileWriter(file, false);
                out = new PrintWriter(writer);

                for (String line : text) {
                    out.println(line);
                }
                out.close();
                Thread.sleep(3000);

            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }

    }

}
