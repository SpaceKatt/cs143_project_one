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

/**
 *
 * @author thomas.kercheval
 */
class Dancer {
    
    //
    private String dancerName;
    private String style;
    private String prof;
    private int years;
    private String phone;
    private String email;
    
    // Default constructor
    Dancer() {
        this.dancerName = "";
        this.style = "";
        this.prof = "";
        this.years = 0;
        this.phone = "";
        this.email = "";
    }
    
    // Overloaded constructor
    Dancer(String name, String style, String proficiency,
         int years, String phone, String email) {
        this.dancerName = name;
        this.style = style;
        this.prof = proficiency;
        this.years = years;
        this.phone = phone;
        this.email = email;
    }

    // Overloaded constructor
    Dancer(String name, String style, String proficiency,
         String years, String phone, String email) {
        this.dancerName = name;
        this.style = style;
        this.prof = proficiency;
        this.years = Integer.parseInt(years);
        this.phone = phone;
        this.email = email;
    }
    
    // Array constructor
    Dancer(String[] dancerInfo) {
        this.dancerName = dancerInfo[0];
        this.style = dancerInfo[1];
        this.prof = dancerInfo[2];
        this.years = Integer.parseInt(dancerInfo[3]);
        this.phone = dancerInfo[4];
        this.email = dancerInfo[5];
    }
    
    // Copy constructor
    Dancer(Dancer dancer) {
        this.dancerName = dancer.dancerName;
        this.style = dancer.style;
        this.prof = dancer.prof;
        this.years = dancer.years;
        this.phone = dancer.phone;
    }

    public String getName() {
        return dancerName;
    }

    public void setDancerName(String dancerName) {
        this.dancerName = dancerName;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getProf() {
        return prof;
    }

    public void setProf(String prof) {
        this.prof = prof;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    

    @Override
    public String toString() {
        return "Dancer{" + "dancerName=" + dancerName + ", style=" + 
                style + ", proficiency=" + prof + ", years=" + years + 
                ", phone=" + phone + ", email=" + email + '}';
    }

    public boolean equals(Dancer dancer) {
        return this.getName().equalsIgnoreCase(dancer.getName()) &&
                this.getYears() == dancer.getYears();
    }
}
