/*
 * Copyright (C) 2016 Thomas Kercheval
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

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * DancerFileWriter.java
 * This class provides an abstraction to write our database one line at a time.
 * <pre>
    Project: CafeDansa Database
    Platform: jdk 1.8.0_14; NetBeans IDE 8.1; Windows 10
    Course: CS 143
    Created on Apr 9, 2016, 2:11:46 PM
    Revised on Arp 14, 2016, 7:13:53 PM
 </pre>
 * @author Thomas Kercheval
 */
public class DancerFileWriter {

    /** File path (relative) to our database. */
    private final String filePath;

    /** List of lines to be written. */
    private final ArrayList<String> lines;

    /**
     * Constructor which stores the relative path of our database and
     * creates the lines to be written in our filePath.
     * @param file Relative filePath path of Dancer database
     * @param dancers ArrayList of dancers to be written
     */
    public DancerFileWriter(String file, ArrayList<Dancer> dancers) {
        this.filePath = file;
        this.lines = createLines(dancers);
    }

    /**
     * Creates the lines to be written by this class.
     * Takes each dancer and creates a line to be written in our database.
     * @param dancers ArrayList of our Dancer objects that need to be written
     * @return ArrayList populated by the dancers and their information.
     */
    private ArrayList<String> createLines(ArrayList<Dancer> dancers) {
        ArrayList<Dancer> sortDancer = new ArrayList<>(dancers);
        InsertionSortDancerLastName sorter = new InsertionSortDancerLastName();
        sorter.sort(sortDancer);
        ArrayList<String> newLines = new ArrayList<>();
        for (int i = 0; i < dancers.size(); i++) {
            Dancer dancer = sortDancer.get(i);
            String line = dancer.getName() + ",";
            line += dancer.getStyle() + ",";
            line += dancer.getProf() + ",";
            line += dancer.getYears() + ",";
            line += dancer.getPhone() + ",";
            line += dancer.getEmail();
            newLines.add(line);
        }
        return newLines;
    }

    /**
     * Writes all the lines created by createLines() into a filePath specified
     * by this.filePath
     * @see createLines
     * @see java.nio.file.Files
     * @see java.nio.file.Path
     * @see java.nio.file.Paths
     */
    public void writeTheFile() {
        Path filePath = Paths.get(this.filePath);
        try {
            Files.write(filePath, lines, Charset.forName("UTF-8"));
        } catch (IOException ex) {
            Logger.getLogger(DancerFileWriter.class.getName()).log(Level.SEVERE,
                                                                 null, ex);
        }
    }
}
