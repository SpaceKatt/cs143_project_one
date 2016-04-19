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

import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * DansaGUI.java A class representing the GUI used in a maintaining a dancers
 * database.
 * <pre>
 * Project: Cafe Dansa Database
 * Platform: jdk 1.8.0_14; NetBeans IDE 8.1; Windows 10
 * Course:
 * Hours: 9 Hours and 37 Min
 * Created on Apr 9, 2016, 1:45:39 PM
 * Revised on Apr 15, 2016, 07:36:45 PM
 * </pre>
 *
 * @author:	thomas.kercheval@go.shoreline.edu
 * @version: %1% %2%
 * @see java.util.ArrayList
 */
public class DansaGUI extends javax.swing.JFrame {

    /** Class instance ArrayList of Dancer objects. */
    private final ArrayList<Dancer> dancers = new ArrayList<>();
    /** External file name of dancers. */
    private final String fileName = "src/cafedansadatabase/Dancers.txt";

    /** Different styles of dance employed by the dancers. */
    public final static String[] STYLES = new String[]{"baladi", "balkan",
        "ballet", "ballroom", "bhangra", "firedancing", "irish step dancing", 
        "milonga", "modern pop", "rave", "salsa", "samba", "shuffle", "tap"};
    /** Different levels of proficiency held by the dancers. */
    public final static String[] PROFICIENCIES = new String[]{"beginner",
        "intermediate", "advanced", "expert", "master", "guru"};

    /** Creates new form DansaGUI. */
    public DansaGUI() {
        initComponents();
        this.getRootPane().setDefaultButton(addJButton); //set buttonAdd as default
        this.setIconImage(Toolkit.getDefaultToolkit().
                getImage("src/cafedansadatabase/Bottle_Dancers_USA.jpg"));
        // Centers the form at start.
        setLocationRelativeTo(null);

        // Read form an external file Dancers.txt and create an
        // ArrayList of Dancer type, dancers
        readFromFile(fileName);

        // Show the Dancer names in the JList
        displayDancers();
        showDancerData(dancersJList.getSelectedIndex());
    }

    /**
     * Method: readFromFile Reads dancers from a text file that is comma
     * delimited and creates an instance of the Dancer class with the data read.
     * Then the newly created Dancer is added to the cities database. Uses an
     * object from the ReadFile class to read record.
     *
     * @param file String The file path of the database to be read.
     *
     * pre-condition: a valid file name, Dancers.txt is expected for input with
     * comma separated text fields (but no spaces) for dancer name, dance style,
     * proficiency, years of experience, phone number, and email.
     * post-condition: a new Dancer is created with the read fields and added to
     * the ArrayList dancers
     * @see DancerFileReader
     */
    private void readFromFile(String file) {
        dancers.clear();
        DancerFileReader reader = new DancerFileReader(file);
        String line;
        while ((line = reader.readRecord()) != null) {
            String[] dancerInfo = line.split(","); // Create Array of info
            Dancer dancer = new Dancer(dancerInfo); // Use Array Constructor
            dancers.add(dancer);
        }
        reader.close();
    }

    /**
     * Method: displayDancers() Displays dancers in JList sorted by years of
     * experience using selection sort algorithm or last/first name using the
     * insertion sort algorithm. 
     * pre-condition: Uses the ArrayList dancers.
     * post-condition: dancers ArrayList is sorted and displayed either by level
     * or last name.
     *
     * @see #selectionSort
     * @see #insetionSort
     */
    private void displayDancers() {
        int location = dancersJList.getSelectedIndex();
        String[] dancerNames = new String[dancers.size()];
        if (yearJRadioButtonMenuItem.isSelected()) {
            selectionSort(dancers); // Sort by years of experience
            for (int i = 0; i < dancers.size(); i++) {
                dancerNames[i] = dancers.get(i).getName() + ", "
                        + dancers.get(i).getYears() + " years.";
            }
        } else if (firstNameJRadioButtonMenuItem.isSelected()) {
            insertionSortFirst(dancers); // Sort by first name
            for (int i = 0; i < dancers.size(); i++) {
                dancerNames[i] = dancers.get(i).getName();
            }
        } else {
            insertionSort(dancers); // Sort by last name
            for (int i = 0; i < dancers.size(); i++) {
                dancerNames[i] = dancers.get(i).getName();
            }
        }
        dancersJList.setListData(dancerNames);
        if (location != -1 && location < dancers.size()) {
            dancersJList.setSelectedIndex(location);
        } else { // Say if the last Dancer is deleted...
            dancersJList.setSelectedIndex(0);
        }
    }

    /**
     * Method: insertionSort Sorts ArrayList dancers in ascending order by last
     * name. Uses the insertion sort algorithm which inserts dancer at correct
     * position and shuffles everyone else below that position.
     *
     * @param dancers ArrayList of Dancer objects.
     */
    public static void insertionSort(ArrayList<Dancer> dancers) {
        InsertionSortDancerLastName sorter = new InsertionSortDancerLastName();
        sorter.sort(dancers);
    }

    /**
     * Method: insertionSortFirst Sorts ArrayList dancers in ascending order by
     * first name. Uses the insertion sort algorithm which inserts dancer at
     * correct position and shuffles everyone else below that position.
     *
     * @param dancers ArrayList of Dancer objects.
     */
    public static void insertionSortFirst(ArrayList<Dancer> dancers) {
        InsertionSortDancerFirst sorter = new InsertionSortDancerFirst();
        sorter.sort(dancers);
    }

    /**
     * Method: selectionSort Sorts ArrayList dancers in descending order by
     * years of experience. Calls findsMaximum to find dancer with maximum
     * experience (in years) in each pass and swap to exchange dancers when
     * necessary.
     *
     * @param dancers ArrayList of Dancer objects.
     */
    public void selectionSort(ArrayList<Dancer> dancers) {
        SelectionSortYears sorter = new SelectionSortYears();
        sorter.sort(dancers);
    }

    /**
     * Method: findMaximum Called by selectionSort to find the index of the
     * member with the maximum years of experience from a given index to the end
     * of the ArrayList.
     *
     * @param dancers ArrayList of Dancer objects.
     * @param i int: index from which to search for the max
     * @return maxIndex int position or index where maximum is located
     * pre-condition: ArrayList members filled-in with members objects
     * 0. post-condition: members ArrayList is sorted by level.
     */
    public int findMaximum(ArrayList<Dancer> dancers, final int i) {
        double max = 0;
        int maxIndex = i;
        for (int j = i; j < dancers.size(); j++) {
            int years = dancers.get(j).getYears();
            if (years > max) {
                max = years;
                maxIndex = j;
            }
        }
        return maxIndex;
    }

    /**
     * Called by selectionSort to find the index of the member with the maximum
     * level from a given index to the end of the ArrayList
     *
     * @param dancers ArrayList of Dancer Objects
     * @param i int index of element to be swapped
     * @param j int index of element to be swapped
     * pre-condition: ArrayList
     * members filled-in with members object0. 
     * post-condition:
     * members ArrayList with two members swapped.
     */
    public void swap(ArrayList<Dancer> dancers, final int i, final int j) {
        Dancer temp = dancers.get(j);
        dancers.set(j, dancers.get(i));
        dancers.set(i, temp);
    }

    /**
     * showDancerData This method is called from within the constructor to
     * display the data for the selected dancer.
     *
     * @param index index of the selected Dancer.
     */
    private void showDancerData(int index) {
        if (index == -1) {
            index = 0;
        }
        nameJTextField.setText(dancers.get(index).getName());
        styleJTextField.setText(dancers.get(index).getStyle());
        profJTextField.setText(dancers.get(index).getProf());
        yearsJTextField.setText(String.valueOf(dancers.get(index).getYears())
                + " years");
        phoneJTextField.setText(dancers.get(index).getPhone());
        emailJTextField.setText(dancers.get(index).getEmail());
    }

    //CHECKSTYLE:OFF
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menubuttonGroup = new javax.swing.ButtonGroup();
        titleJPanel = new javax.swing.JPanel();
        logoJLabel = new javax.swing.JLabel();
        titleJLabel = new javax.swing.JLabel();
        logoJLabel1 = new javax.swing.JLabel();
        listJPanel = new javax.swing.JPanel();
        llistJScrollPane = new javax.swing.JScrollPane();
        dancersJList = new javax.swing.JList();
        displayJPanel = new javax.swing.JPanel();
        nameJLabel = new javax.swing.JLabel();
        nameJTextField = new javax.swing.JTextField();
        styleJLabel = new javax.swing.JLabel();
        styleJTextField = new javax.swing.JTextField();
        profJLabel = new javax.swing.JLabel();
        profJTextField = new javax.swing.JTextField();
        yearsJLabel = new javax.swing.JLabel();
        yearsJTextField = new javax.swing.JTextField();
        phoneJLabel = new javax.swing.JLabel();
        phoneJTextField = new javax.swing.JTextField();
        emailJLabel = new javax.swing.JLabel();
        emailJTextField = new javax.swing.JTextField();
        controlPanel = new javax.swing.JPanel();
        addJButton = new javax.swing.JButton();
        editJButton = new javax.swing.JButton();
        deleteJButton = new javax.swing.JButton();
        printJButton = new javax.swing.JButton();
        exitJButton = new javax.swing.JButton();
        dancersJMenuBar = new javax.swing.JMenuBar();
        fileJMenu = new javax.swing.JMenu();
        clearJMenuItem = new javax.swing.JMenuItem();
        printJMenuItem = new javax.swing.JMenuItem();
        fileJSeparator = new javax.swing.JPopupMenu.Separator();
        exitJMenuItem = new javax.swing.JMenuItem();
        sortJMenu = new javax.swing.JMenu();
        nameJRadioButtonMenuItem = new javax.swing.JRadioButtonMenuItem();
        firstNameJRadioButtonMenuItem = new javax.swing.JRadioButtonMenuItem();
        yearJRadioButtonMenuItem = new javax.swing.JRadioButtonMenuItem();
        actionJMenu = new javax.swing.JMenu();
        addJMenuItem = new javax.swing.JMenuItem();
        deleteJMenuItem = new javax.swing.JMenuItem();
        editJMenuItem = new javax.swing.JMenuItem();
        searchJMenuItem = new javax.swing.JMenuItem();
        helpJMenu = new javax.swing.JMenu();
        aboutJMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cafe Dansa Database");
        setResizable(false);
        getContentPane().setLayout(new java.awt.BorderLayout(0, 5));

        logoJLabel.setFont(new java.awt.Font("Tahoma", 2, 24)); // NOI18N
        logoJLabel.setForeground(new java.awt.Color(51, 0, 0));
        logoJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cafedansadatabase/Bottle_Dancers_USA_small.jpg"))); // NOI18N

        titleJLabel.setFont(new java.awt.Font("Tempus Sans ITC", 2, 24)); // NOI18N
        titleJLabel.setForeground(new java.awt.Color(51, 0, 0));
        titleJLabel.setText("Cafe Dansa Database");

        logoJLabel1.setFont(new java.awt.Font("Tahoma", 2, 24)); // NOI18N
        logoJLabel1.setForeground(new java.awt.Color(51, 0, 0));
        logoJLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cafedansadatabase/The-3-Dancers_3-photo-Chris-Nash-1024x682.jpg"))); // NOI18N

        javax.swing.GroupLayout titleJPanelLayout = new javax.swing.GroupLayout(titleJPanel);
        titleJPanel.setLayout(titleJPanelLayout);
        titleJPanelLayout.setHorizontalGroup(
            titleJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titleJPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoJLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titleJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(logoJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        titleJPanelLayout.setVerticalGroup(
            titleJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titleJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(titleJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(titleJPanelLayout.createSequentialGroup()
                        .addComponent(logoJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(titleJLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, titleJPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(logoJLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        getContentPane().add(titleJPanel, java.awt.BorderLayout.NORTH);

        dancersJList.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dancersJList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        dancersJList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                dancersJListValueChanged(evt);
            }
        });
        llistJScrollPane.setViewportView(dancersJList);

        javax.swing.GroupLayout listJPanelLayout = new javax.swing.GroupLayout(listJPanel);
        listJPanel.setLayout(listJPanelLayout);
        listJPanelLayout.setHorizontalGroup(
            listJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, listJPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(llistJScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        listJPanelLayout.setVerticalGroup(
            listJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(llistJScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
        );

        getContentPane().add(listJPanel, java.awt.BorderLayout.LINE_START);

        displayJPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 10));
        displayJPanel.setLayout(new java.awt.GridLayout(6, 2, 5, 5));

        nameJLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nameJLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        nameJLabel.setText("Name of dancer: ");
        displayJPanel.add(nameJLabel);

        nameJTextField.setEditable(false);
        nameJTextField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nameJTextField.setToolTipText("Dancer's name...");
        displayJPanel.add(nameJTextField);

        styleJLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        styleJLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        styleJLabel.setText("Dance Style:");
        displayJPanel.add(styleJLabel);

        styleJTextField.setEditable(false);
        styleJTextField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        styleJTextField.setToolTipText("Style of Dance");
        displayJPanel.add(styleJTextField);

        profJLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        profJLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        profJLabel.setText("Level of proficiency:");
        displayJPanel.add(profJLabel);

        profJTextField.setEditable(false);
        profJTextField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        profJTextField.setToolTipText("Level of expertise of the dancer");
        displayJPanel.add(profJTextField);

        yearsJLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        yearsJLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        yearsJLabel.setText("Years dancing:");
        displayJPanel.add(yearsJLabel);

        yearsJTextField.setEditable(false);
        yearsJTextField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        yearsJTextField.setToolTipText("Years of dancing experience");
        displayJPanel.add(yearsJTextField);

        phoneJLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        phoneJLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        phoneJLabel.setText("Phone:");
        displayJPanel.add(phoneJLabel);

        phoneJTextField.setEditable(false);
        phoneJTextField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        phoneJTextField.setToolTipText("Phone Number of the Dancer");
        displayJPanel.add(phoneJTextField);

        emailJLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        emailJLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        emailJLabel.setText("email:");
        displayJPanel.add(emailJLabel);

        emailJTextField.setEditable(false);
        emailJTextField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        emailJTextField.setToolTipText("Email address of the dancer");
        displayJPanel.add(emailJTextField);

        getContentPane().add(displayJPanel, java.awt.BorderLayout.CENTER);

        controlPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        controlPanel.setMinimumSize(new java.awt.Dimension(299, 45));
        controlPanel.setLayout(new java.awt.GridLayout(1, 5, 5, 5));

        addJButton.setBackground(new java.awt.Color(204, 255, 204));
        addJButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addJButton.setMnemonic('A');
        addJButton.setText("Add");
        addJButton.setToolTipText("Add new Dancer");
        addJButton.setMinimumSize(new java.awt.Dimension(57, 45));
        addJButton.setPreferredSize(new java.awt.Dimension(57, 35));
        addJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJButtonActionPerformed(evt);
            }
        });
        controlPanel.add(addJButton);

        editJButton.setBackground(new java.awt.Color(204, 255, 204));
        editJButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        editJButton.setMnemonic('E');
        editJButton.setText("Edit");
        editJButton.setToolTipText("Edit Dancer. Press Enter in any of the JTextFields to confirm changes...");
        editJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editJButtonActionPerformed(evt);
            }
        });
        controlPanel.add(editJButton);

        deleteJButton.setBackground(new java.awt.Color(204, 255, 204));
        deleteJButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        deleteJButton.setMnemonic('D');
        deleteJButton.setText("Delete");
        deleteJButton.setToolTipText("Delete Dancer");
        deleteJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteJButtonActionPerformed(evt);
            }
        });
        controlPanel.add(deleteJButton);

        printJButton.setBackground(new java.awt.Color(204, 255, 204));
        printJButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        printJButton.setMnemonic('P');
        printJButton.setText("Print");
        printJButton.setToolTipText("Print individual dancer data");
        printJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printJButtonActionPerformed(evt);
            }
        });
        controlPanel.add(printJButton);

        exitJButton.setBackground(new java.awt.Color(204, 255, 204));
        exitJButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        exitJButton.setMnemonic('x');
        exitJButton.setText("Exit");
        exitJButton.setToolTipText("Exit application");
        exitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitJButtonActionPerformed(evt);
            }
        });
        controlPanel.add(exitJButton);

        getContentPane().add(controlPanel, java.awt.BorderLayout.SOUTH);

        fileJMenu.setMnemonic('F');
        fileJMenu.setText("File");

        clearJMenuItem.setMnemonic('C');
        clearJMenuItem.setText("Clear");
        clearJMenuItem.setToolTipText("Clear form");
        clearJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(clearJMenuItem);

        printJMenuItem.setMnemonic('P');
        printJMenuItem.setText("Print");
        printJMenuItem.setToolTipText("Print form");
        printJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(printJMenuItem);
        fileJMenu.add(fileJSeparator);

        exitJMenuItem.setMnemonic('x');
        exitJMenuItem.setText("Exit");
        exitJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitJMenuItemActionPerformed(evt);
            }
        });
        fileJMenu.add(exitJMenuItem);

        dancersJMenuBar.add(fileJMenu);

        sortJMenu.setMnemonic('S');
        sortJMenu.setText("Sort");

        menubuttonGroup.add(nameJRadioButtonMenuItem);
        nameJRadioButtonMenuItem.setMnemonic('n');
        nameJRadioButtonMenuItem.setSelected(true);
        nameJRadioButtonMenuItem.setText("By Last Name");
        nameJRadioButtonMenuItem.setToolTipText("Sort by last name and display only name");
        nameJRadioButtonMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameJRadioButtonMenuItemActionPerformed(evt);
            }
        });
        sortJMenu.add(nameJRadioButtonMenuItem);

        menubuttonGroup.add(firstNameJRadioButtonMenuItem);
        firstNameJRadioButtonMenuItem.setMnemonic('f');
        firstNameJRadioButtonMenuItem.setText("By First Name");
        firstNameJRadioButtonMenuItem.setToolTipText("Sort by first name and display only name");
        firstNameJRadioButtonMenuItem.setRequestFocusEnabled(false);
        firstNameJRadioButtonMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstNameJRadioButtonMenuItemActionPerformed(evt);
            }
        });
        sortJMenu.add(firstNameJRadioButtonMenuItem);

        menubuttonGroup.add(yearJRadioButtonMenuItem);
        yearJRadioButtonMenuItem.setMnemonic('B');
        yearJRadioButtonMenuItem.setText("By Years");
        yearJRadioButtonMenuItem.setToolTipText("Sort by years of experience, display name and years of experience.");
        yearJRadioButtonMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearJRadioButtonMenuItemActionPerformed(evt);
            }
        });
        sortJMenu.add(yearJRadioButtonMenuItem);

        dancersJMenuBar.add(sortJMenu);

        actionJMenu.setMnemonic('t');
        actionJMenu.setText("Action");

        addJMenuItem.setMnemonic('A');
        addJMenuItem.setText("Add New Dancer");
        addJMenuItem.setToolTipText("Add new Dancer");
        addJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJMenuItemActionPerformed(evt);
            }
        });
        actionJMenu.add(addJMenuItem);

        deleteJMenuItem.setMnemonic('D');
        deleteJMenuItem.setText("Delete Dancer");
        deleteJMenuItem.setToolTipText("Delete Dancer");
        deleteJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteJMenuItemActionPerformed(evt);
            }
        });
        actionJMenu.add(deleteJMenuItem);

        editJMenuItem.setMnemonic('E');
        editJMenuItem.setText("Edit Dancer");
        editJMenuItem.setToolTipText("Edit Dancer");
        editJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editJMenuItemActionPerformed(evt);
            }
        });
        actionJMenu.add(editJMenuItem);

        searchJMenuItem.setMnemonic('r');
        searchJMenuItem.setText("Search Dancer");
        searchJMenuItem.setToolTipText("Search Dancer");
        searchJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchJMenuItemActionPerformed(evt);
            }
        });
        actionJMenu.add(searchJMenuItem);

        dancersJMenuBar.add(actionJMenu);

        helpJMenu.setMnemonic('H');
        helpJMenu.setText("Help");

        aboutJMenuItem.setMnemonic('A');
        aboutJMenuItem.setText("About");
        aboutJMenuItem.setToolTipText("About this project!");
        aboutJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutJMenuItemActionPerformed(evt);
            }
        });
        helpJMenu.add(aboutJMenuItem);

        dancersJMenuBar.add(helpJMenu);

        setJMenuBar(dancersJMenuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //CHECKSTYLE:ON

    /**
     * Clears all fields and sets them to be editable.
     *
     * @return void
     */
    private void clearAll() {
        //Clear and set JTextFields visible
        dancersJList.setEnabled(false);
        nameJTextField.setText("");
        nameJTextField.setEditable(true);
        styleJTextField.setText("");
        styleJTextField.setEditable(true);
        profJTextField.setText("");
        profJTextField.setEditable(true);
        yearsJTextField.setText("");
        yearsJTextField.setEditable(true);
        phoneJTextField.setText("");
        phoneJTextField.setEditable(true);
        emailJTextField.setText("");
        emailJTextField.setEditable(true);
        nameJTextField.requestFocus();

    }

    /**
     * Listens to dancersJList and updates the displayed dancer info according
     * to the dancer selected in the JList.
     *
     * @param evt
     */
    private void dancersJListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_dancersJListValueChanged
        int index = (dancersJList.getSelectedIndex());
        if (index == -1) {
            index = 0;
        }
        showDancerData(index);
    }//GEN-LAST:event_dancersJListValueChanged

    /**
     * Listens to addJButton, spawns addDancer form, saves a new Dancer in the
     * database, selects the new Dancer in the JList.
     *
     * @param evt
     * @see AddDancer The form used to add a dancer.
     */
    private void addJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJButtonActionPerformed
        int location = this.dancersJList.getSelectedIndex();
        // Add new dancer
        try {
            // Create and display a new AddDialog
            AddDancer addDancer = new AddDancer(this, true);
            addDancer.setLocationRelativeTo(this);
            addDancer.setVisible(true);

            // The modal dialog takes focus, upon regaining focus:
            Dancer newDancer = addDancer.getDancer();

            if (newDancer != null && !dancerExists(newDancer)) {
                // Add the new dancer to the database
                dancers.add(newDancer);
                displayDancers();                  //refresh GUI
                searchDancer(newDancer.getName());    //highlight added dancer

                //save new dancer to file
                saveDancers();
            } else {
                JOptionPane.showMessageDialog(null, "Dancer not Added",
                        "Dancer is null or already exists",
                        JOptionPane.WARNING_MESSAGE);
                dancersJList.setVisible(true);
                dancersJList.setSelectedIndex(location);
            }
        } catch (NullPointerException nullex) {
            JOptionPane.showMessageDialog(null, "Dancer not Added",
                    "Input Error",
                    JOptionPane.WARNING_MESSAGE);
            dancersJList.setVisible(true);
            dancersJList.setSelectedIndex(location);
        }
    }//GEN-LAST:event_addJButtonActionPerformed

    /**
     * Spawns the form used to edit a Dancer object before saving that Dancer
     * back into our database.
     *
     * @param evt
     */
    private void editJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editJButtonActionPerformed
        int index = this.dancersJList.getSelectedIndex();
        try {
            EditDancer editDancer = new EditDancer(this, true, 
                    this.dancers.get(index));
            editDancer.setLocationRelativeTo(this);
            editDancer.setVisible(true);

            // The modal dialog takes focus, upon regaining focus:
            Dancer editedDancer = editDancer.getDancer();
            if (dancerExistsSomewhere(editedDancer, index)) {
                JOptionPane.showMessageDialog(null, "Dancer not Edited\n"
                        + "A dancer with the same name,\n"
                        + "style of dance,\n"
                        + "and years of experience already"
                        + "\nexists somewhere else...",
                        "Dancer already exists",
                        JOptionPane.WARNING_MESSAGE);
                dancersJList.setVisible(true);
                dancersJList.setSelectedIndex(index);
            } else if (editedDancer != null) {
                // Replaces the edited dancer to the database
                dancers.set(index, editedDancer);
                displayDancers();                      //refresh GUI
                searchDancer(editedDancer.getName()); //highlight edited dancer
                //save new dancer to file
                saveDancers();
            } else {
                JOptionPane.showMessageDialog(null, "Dancer not Edited",
                        "Dancer is null...",
                        JOptionPane.WARNING_MESSAGE);
                dancersJList.setVisible(true);
                dancersJList.setSelectedIndex(0);
            }

        } catch (NullPointerException nullex) {
            JOptionPane.showMessageDialog(null, "Dancer not Edited",
                    "Edit cancelled",
                    JOptionPane.INFORMATION_MESSAGE);
            dancersJList.setVisible(true);
            dancersJList.setSelectedIndex(index);
        }
    }//GEN-LAST:event_editJButtonActionPerformed

    /**
     * Deletes a dancer from our database, dynamically, after asking for
     * confirmation.
     *
     * @param evt
     */
    private void deleteJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteJButtonActionPerformed
        int reply = JOptionPane.showConfirmDialog(this, "Are you sure?",
                "Confirm Dancer deletion...",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (reply == JOptionPane.YES_OPTION) {
            // Delete selected dancer
            int index = this.dancersJList.getSelectedIndex();
            this.dancers.remove(index);
            displayDancers();
            saveDancers();
        } else { // Do nothing
        }
    }//GEN-LAST:event_deleteJButtonActionPerformed

    /**
     * Prints out the information of the currently selected dancer.
     *
     * @param evt
     */
    private void printJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printJButtonActionPerformed
        // Use the PrintUtilities class to print the GUI
        PrintUtilities.printComponent(this.displayJPanel);
    }//GEN-LAST:event_printJButtonActionPerformed

    /**
     * Exits the program on button click.
     *
     * @param evt
     */
    private void exitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitJButtonActionPerformed
        // End  program
        System.exit(0);
    }//GEN-LAST:event_exitJButtonActionPerformed

    /**
     * Clears all fields and reset form by calling the method clearAll
     *
     * @param evt
     */
    private void clearJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearJMenuItemActionPerformed
        clearAll();
    }//GEN-LAST:event_clearJMenuItemActionPerformed

    /**
     * Prints out the entire form.
     *
     * @param evt
     */
    private void printJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printJMenuItemActionPerformed
        PrintUtilities.printComponent(this);
    }//GEN-LAST:event_printJMenuItemActionPerformed

    /**
     * Exits the program on JMenuItem click.
     *
     * @param evt
     */
    private void exitJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitJMenuItemActionPerformed
        // Quit the application
        exitJButtonActionPerformed(evt);
    }//GEN-LAST:event_exitJMenuItemActionPerformed

    /**
     * This method sorts the dancers array list by last name and updates
     * dancersJList to display the dancers in this order.
     *
     * @param evt
     * @see InsetionSortDancerLastName
     */
    private void nameJRadioButtonMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameJRadioButtonMenuItemActionPerformed
        // display dancers sorted by last name
        displayDancers();
    }//GEN-LAST:event_nameJRadioButtonMenuItemActionPerformed

    /**
     * This method sorts the dancers array list by years of experience and
     * updates dancersJList to display the dancers in this order.
     *
     * @param evt
     * @see SelectionSortYears
     */
    private void yearJRadioButtonMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearJRadioButtonMenuItemActionPerformed
        // display dancers sorted by years of experience
        displayDancers();
    }//GEN-LAST:event_yearJRadioButtonMenuItemActionPerformed

    /**
     * Listens to addJMenuItem, calls addJButtonActionPerformed, spawns
     * addDancer form, saves a new Dancer in the database, selects the new
     * Dancer in the JList.
     *
     * @param evt
     * @see AddDancer The form used to add a dancer.
     * @see addJButtonActionPerformed
     */
    private void addJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJMenuItemActionPerformed
        // call buttonAddActionPerformed
        addJButtonActionPerformed(evt);
    }//GEN-LAST:event_addJMenuItemActionPerformed

    /**
     * Deletes a dancer from our database, dynamically, after asking for
     * confirmation. This is done by calling deleteJButtonActionPerformed.
     *
     * @param evt
     * @see deleteJButtonActionPerformed
     */
    private void deleteJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteJMenuItemActionPerformed
        // call buttonDeleteActionPerformed
        deleteJButtonActionPerformed(evt);
    }//GEN-LAST:event_deleteJMenuItemActionPerformed

    /**
     * Spawns the form used to edit a Dancer object before saving that Dancer
     * back into our database. This is done by calling
     * editJButtonActionPerformed.
     *
     * @param evt
     * @see editJButtonActionPerformed
     */
    private void editJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editJMenuItemActionPerformed
        // call buttonEditActionPerformed
        editJButtonActionPerformed(evt);
    }//GEN-LAST:event_editJMenuItemActionPerformed

    /**
     * Initiates search for a dancer with a specific name, or a name that
     * contains our search parameter. Does this by calling searchDancer.
     *
     * @param evt
     * @see searchDancer
     */
    private void searchJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchJMenuItemActionPerformed
        // Find specified dancer
        String dancerName = JOptionPane.showInputDialog(this, "Search for:",
                "Search for Dancer",
                JOptionPane.PLAIN_MESSAGE);
        searchDancer(dancerName);
    }//GEN-LAST:event_searchJMenuItemActionPerformed

    /**
     * Spawns the about form. The about form is the about page for this project.
     * The about form is populated with the same text as the README.
     * @param evt
     */
    private void aboutJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutJMenuItemActionPerformed
        AboutJFrame dancerAbout = new AboutJFrame();
        dancerAbout.setVisible(true);

    }//GEN-LAST:event_aboutJMenuItemActionPerformed

    /**
     * This method sorts the dancers array list by first name and updates
     * dancersJList to display the dancers in this order.
     *
     * @param evt
     * @see InsetionSortDancerFirst
     */
    private void firstNameJRadioButtonMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstNameJRadioButtonMenuItemActionPerformed
        displayDancers();
    }//GEN-LAST:event_firstNameJRadioButtonMenuItemActionPerformed

    /**
     * Method: saveDancers Saves the dancers to a file in the alphabetical order
     * of their last name.
     *
     * @see writeToFile
     */
    private void saveDancers() {
        writeToFile(this.fileName);
    }

    /**
     * Method: dancerExists Performs linear search through Dancer list,
     * `this.dancers`, to determine if the specified Dancer object exists.
     *
     * @param dancario - Dancer whose existence is in question
     * @return boolean true if the dancer exists.
     */
    private boolean dancerExists(Dancer dancario) {
        for (int i = 0; i < dancers.size(); i++) {
            if (dancario.equals(dancers.get(i))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method: dancerExistsSomewhere Performs linear search through Dancer list,
     * `this.dancers`, to determine if the specified Dancer object exists at
     * a different indexical location than the one provided.
     *
     * @param dancario - Dancer whose existence is in question
     * @return boolean true if the dancer exists.
     */
    private boolean dancerExistsSomewhere(Dancer dancario, int index) {
        for (int i = 0; i < dancers.size(); i++) {
            if (dancario.equals(dancers.get(i)) && i != index) {
                return true;
            }
        }
        return false;
    }

    /**
     * Searches for a Dancer using linear search to find the first name to
     * contain the String dancerName. Dancer are first sorted by last name, and
     * then the index of the desired dancer is given.
     *
     * @param dancerName The name of the Dancer we are searching for.
     */
    private void searchDancer(String dancerName) {
        if ((dancerName != null) && (dancerName.length() > 0)) {
            this.nameJRadioButtonMenuItem.doClick();
            dancerName = dancerName.toLowerCase();
            String[] dancerNames = new String[dancers.size()];
            for (int i = 0; i < dancers.size(); i++) {
                dancerNames[i] = dancers.get(i).getName().toLowerCase();
            }
            int index = linearSearch(dancerNames, dancerName);
            if (index != -1) {
                dancersJList.setSelectedIndex(index);
            } else {
                JOptionPane.showMessageDialog(this,
                        dancerName + " not found.",
                        "Search Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this,
                    "No dancer name given.",
                    "Search Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * This method implements linear search for a String in a String[].
     *
     * @param array Thing we are searching through
     * @param key Thing we are searching for
     * @return index of where the key was found, or -1 if it was not.
     */
    public int linearSearch(String[] array, String key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].contains(key)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Calls our implementation for binary search.
     *
     * @param array - Comparable type array to be searched through
     * @param key - Comparable type target to be searched for
     * @return int: the index of the target in the array.
     */
    public static int binarySearch(Comparable[] array, Comparable key) {
        BinarySearchName searcher = new BinarySearchName();
        int result = searcher.binarySearch(array, key);
        return result;
    }

    /**
     * Write dancers to a text file that is comma delimited.
     *
     * @param file The file path of our database to be written pre-condition: a
     * valid file name, Dancers.txt is expected post-condition: a new text file
     * is created with the current dancers in the database
     * @see DancerFileWriter
     * @see Dancer
     */
    public void writeToFile(String file) {
        DancerFileWriter writer = new DancerFileWriter(file, dancers);
        writer.writeTheFile();
    }

    /**
     * Runs our program and spawns our GUI.
     *
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DansaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DansaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DansaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DansaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DansaGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutJMenuItem;
    private javax.swing.JMenu actionJMenu;
    private javax.swing.JButton addJButton;
    private javax.swing.JMenuItem addJMenuItem;
    private javax.swing.JMenuItem clearJMenuItem;
    private javax.swing.JPanel controlPanel;
    private javax.swing.JList dancersJList;
    private javax.swing.JMenuBar dancersJMenuBar;
    private javax.swing.JButton deleteJButton;
    private javax.swing.JMenuItem deleteJMenuItem;
    private javax.swing.JPanel displayJPanel;
    private javax.swing.JButton editJButton;
    private javax.swing.JMenuItem editJMenuItem;
    private javax.swing.JLabel emailJLabel;
    private javax.swing.JTextField emailJTextField;
    private javax.swing.JButton exitJButton;
    private javax.swing.JMenuItem exitJMenuItem;
    private javax.swing.JMenu fileJMenu;
    private javax.swing.JPopupMenu.Separator fileJSeparator;
    private javax.swing.JRadioButtonMenuItem firstNameJRadioButtonMenuItem;
    private javax.swing.JMenu helpJMenu;
    private javax.swing.JPanel listJPanel;
    private javax.swing.JScrollPane llistJScrollPane;
    private javax.swing.JLabel logoJLabel;
    private javax.swing.JLabel logoJLabel1;
    private javax.swing.ButtonGroup menubuttonGroup;
    private javax.swing.JLabel nameJLabel;
    private javax.swing.JRadioButtonMenuItem nameJRadioButtonMenuItem;
    private javax.swing.JTextField nameJTextField;
    private javax.swing.JLabel phoneJLabel;
    private javax.swing.JTextField phoneJTextField;
    private javax.swing.JButton printJButton;
    private javax.swing.JMenuItem printJMenuItem;
    private javax.swing.JLabel profJLabel;
    private javax.swing.JTextField profJTextField;
    private javax.swing.JMenuItem searchJMenuItem;
    private javax.swing.JMenu sortJMenu;
    private javax.swing.JLabel styleJLabel;
    private javax.swing.JTextField styleJTextField;
    private javax.swing.JLabel titleJLabel;
    private javax.swing.JPanel titleJPanel;
    private javax.swing.JRadioButtonMenuItem yearJRadioButtonMenuItem;
    private javax.swing.JLabel yearsJLabel;
    private javax.swing.JTextField yearsJTextField;
    // End of variables declaration//GEN-END:variables
}
