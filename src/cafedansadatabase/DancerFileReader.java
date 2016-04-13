/*
 * Copyright (C) 2016 thomas.kercheval
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package cafedansadatabase;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * DancerFileReader.java
 * This class provides an abstraction to read our database one line at a time.
 * <pre>
    Project: CafeDansa Database
    Platform: jdk 1.8.0_14; NetBeans IDE 8.1; Windows 10
    Course: CS 143
    Created on Apr 9, 2016, 1:32:24 PM
    Revised on Arp 12, 2016, 2:28:03 PM
 </pre>
 * @author Thomas Kercheval
 */
public class DancerFileReader {

    /**
     * Relative path to the Dancer database.
     */
    private final String filePath;
    /**
     * BufferedReader object that will read our files, line by line.
     */
    private final BufferedReader buffRead;

    /**
     * Initializes File Reader, catches file not found error.
     * @param fileName String of file Path
     */
    DancerFileReader(String fileName) {
        this.filePath = fileName;
        this.buffRead = createReader();
        if (this.buffRead == null) {
            JOptionPane.showMessageDialog(null,
                                          "Database at \n"
                                          + this.filePath
                                          + "\nnot Found.",
                                          "IOError",
                                          JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    /**
     * Creates our file reader object and returns it to the constructor.
     * Doing it in this way allows us to declare the reader as final.
     * @return BufferedReader which will read our file at filePath.
     */
    private BufferedReader createReader() {
        BufferedReader reader =  null;
        try {
            reader =  new BufferedReader(new FileReader(this.filePath));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DancerFileReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reader;
    }

    /**
     * Checks for the existence of our file at a given path.
     * @return true if file exists.
     */
    public boolean getFileExists() {
        File dancerFile = new File(this.filePath);
        boolean result = dancerFile.exists() && !dancerFile.isDirectory();
        return result;
    }

    /**
     * Returns the next line of our file at filePath.
     * @return String representation of a line in the file.
     */
    public String readRecord() {
        String line = null;
        try {
            line = buffRead.readLine();
        } catch (IOException ex) {
            Logger.getLogger(DancerFileReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return line;
    }

    /**
     * Closes our BufferedReader object. Forgetting this step may cause
     * unexpected errors while trying to dynamically update our database.
     */
    void close() {
        try {
            buffRead.close();
        } catch (IOException ex) {
            Logger.getLogger(DancerFileReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
