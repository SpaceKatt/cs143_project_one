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
/**
 *
 * @author thomas.kercheval
 */
public class DancerFileReader {
    
    private final String file_path;
    String city_info;
    BufferedReader buffRead;
    
    DancerFileReader(String file_name) {
        this.file_path = file_name;
//        if (!getFileExists()) {
//            System.exit(0);
//        }
        try {
            buffRead = new BufferedReader(new FileReader(this.file_path));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DancerFileReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean getFileExists() {
        File city_file = new File(this.file_path);
        boolean result = city_file.exists() && !city_file.isDirectory();
        return result;
    }
    
    public String readRecord() {
        String line = null;
        try {
            line = buffRead.readLine();
        } catch (IOException ex) {
            Logger.getLogger(DancerFileReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return line;
    }

    void close() {
        try {
            buffRead.close();
        } catch (IOException ex) {
            Logger.getLogger(DancerFileReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
