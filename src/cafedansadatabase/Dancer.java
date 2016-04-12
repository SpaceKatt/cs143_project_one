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

    /**
     * Name of the Dancer.
     */
    private String dancerName;
    /**
     * Dance style of the Dancer.
     */
    private String style;
    /**
     * Proficiency of the Dancer.
     */
    private String prof;
    /**
     * Number of years the Dancer has been practicing.
     */
    private int years;
    /**
     * Phone number of the Dancer.
     */
    private String phone;
    /**
     * Email of the Dancer.
     */
    private String email;

    /**
     * The index in an array passed to the Array constructor
     * of the Dancer's name.
     */
    public static final int NAME_INDEX = 0;
    /**
     * The index in an array passed to the Array constructor
     * of the Dancer's Dance Style.
     */
    public static final int STYLE_INDEX = 1;
    /**
     * The index in an array passed to the Array constructor
     * of the Dancer's Proficiency.
     */
    public static final int PROF_INDEX = 2;
    /**
     * The index in an array passed to the Array constructor
     * of the numer of Years the dancer has been practicing.
     */
    public static final int YEARS_INDEX = 3;
    /**
     * The index in an array passed to the Array constructor
     * of the Dancer's Phone Number.
     */
    public static final int PHONE_INDEX = 4;
    /**
     * The index in an array passed to the Array constructor
     * of the Dancer's Email Address.
     */
    public static final int EMAIL_INDEX = 5;



    /**
     * Default constructor, sets everything to the default value.
     */
    Dancer() {
        this.dancerName = "";
        this.style = "";
        this.prof = "";
        this.years = 0;
        this.phone = "";
        this.email = "";
    }

    /**
     * Overloaded constructor, takes all Strings other than int for yearsExp.
     * @param name The name of our Dancer.
     * @param styleDance Style of dance of our Dancer.
     * @param proficiency Level of proficiency of our Dancer.
     * @param yearsExp Years our Dancer has been practicing.
     * @param phoneNum Phone number of our Dancer.
     * @param emailAdd Email address of our Dancer.
     */
    Dancer(final String name, final String styleDance, final String proficiency,
           final int yearsExp, final String phoneNum, final String emailAdd) {
        this.dancerName = name;
        this.style = styleDance;
        this.prof = proficiency;
        this.years = yearsExp;
        this.phone = phoneNum;
        this.email = emailAdd;
    }

    /**
     * Overloaded constructor, takes all Strings.
     * @param name The name of our Dancer.
     * @param danceStyle Style of dance of our Dancer.
     * @param proficiency Level of proficiency of our Dancer.
     * @param yearsExp Years our Dancer has been practicing.
     * @param phoneNum Phone number of our Dancer.
     * @param emailAdd Email address of our Dancer.
     */
    Dancer(final String name, final String danceStyle, final String proficiency,
          final String yearsExp, final String phoneNum, final String emailAdd) {
        this.dancerName = name;
        this.style = danceStyle;
        this.prof = proficiency;
        this.years = Integer.parseInt(yearsExp);
        this.phone = phoneNum;
        this.email = emailAdd;
    }

    /**
     * Array constructor, takes an array of values as an input.
     * @param dancerInfo Array containing our Dancer's info. (ordered)
     */
    Dancer(final String[] dancerInfo) {
        this.dancerName = dancerInfo[NAME_INDEX];
        this.style = dancerInfo[STYLE_INDEX];
        this.prof = dancerInfo[PROF_INDEX];
        this.years = Integer.parseInt(dancerInfo[YEARS_INDEX]);
        this.phone = dancerInfo[PHONE_INDEX];
        this.email = dancerInfo[EMAIL_INDEX];
    }

    /**
     * Copy constructor, copies another Dancer object.
     * @param dancer Other dancer being compared to this.
     */
    Dancer(final Dancer dancer) {
        this.dancerName = dancer.dancerName;
        this.style = dancer.style;
        this.prof = dancer.prof;
        this.years = dancer.years;
        this.phone = dancer.phone;
    }
//CHECKSTYLE:OFF
    /**
     * Returns the Dancer's name.
     * @return The name of the Dancer.
     */
    public String getName() {
        return dancerName;
    }

    /**
     *
     * @param dancerName The name of the Dancer.
     */
    public void setDancerName(final String dancerName) {
        this.dancerName = dancerName;
    }

    /**
     *
     * @return The Style of Dance chosen by the Dancer.
     */
    public String getStyle() {
        return style;
    }

    /**
     *
     * @param style The Style of Dance chosen by the Dancer.
     */
    public void setStyle(final String style) {
        this.style = style;
    }

    /**
     *
     * @return Level of proficiency of the Dancer.
     */
    public String getProf() {
        return prof;
    }

    /**
     *
     * @param prof Level of proficiency of the Dancer.
     */
    public void setProf(final String prof) {
        this.prof = prof;
    }

    /**
     *
     * @return Number of years the Dancer has been practicing.
     */
    public int getYears() {
        return years;
    }

    /**
     *
     * @param years Number of years the Dancer has been practicing.
     */
    public void setYears(final int years) {
        this.years = years;
    }

    /**
     *
     * @return The Dancer's Phone Number.
     */
    public String getPhone() {
        return phone;
    }

    /**
     *
     * @param phone The Dancer's Phone Number.
     */
    public void setPhone(final String phone) {
        this.phone = phone;
    }

    /**
     *
     * @return The Dancer's Email Address.
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email The Dancer's Email Address.
     */
    public void setEmail(final String email) {
        this.email = email;
    }
//CHECKSTYLE:ON

    @Override
    /**
     *
     * @return String A String representation of our Dancer.
     */
    public String toString() {
        return "Dancer{" + "dancerName=" + dancerName + ", style="
                + style + ", proficiency=" + prof + ", years=" + years
                + ", phone=" + phone + ", email=" + email + '}';
    }

    /**
     *
     * @param dancer Other Dancer we are comparing this Dancer to.
     * @return true if the dancers are equal.
     */
    public boolean equals(final Dancer dancer) {
        return this.getName().equalsIgnoreCase(dancer.getName())
               && this.getYears() == dancer.getYears();
    }

    @Override
    public int hashCode() {
        return this.dancerName.hashCode();
    }
}
