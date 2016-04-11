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

import java.awt.List;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thomas.kercheval
 */
class DancerFileWriter {
    
    // File path (relative)
    private final String file;
    // List of lines to be written
    private ArrayList<String> lines;
    
    /**
     * Constructor which stores the relative path of our database and
     * creates the lines to be written in our file.
     * @param file Relative file path of city database
     * @param dancers ArrayList of dancers to be written
     */
    DancerFileWriter(String file, ArrayList<Dancer> dancers) {
        this.file = file;
        this.lines = createLines(dancers);
    }
    
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
        newLines.stream().forEach(System.out::println);
        return newLines;
    }
    
    public void writeTheFile() {
        Path filePath = Paths.get(this.file);
        try {
            Files.write(filePath, lines, Charset.forName("UTF-8"));
        } catch (IOException ex) {
            Logger.getLogger(DancerFileWriter.class.getName()).log(Level.SEVERE, 
                                                                 null, ex);
        }
    }
}
