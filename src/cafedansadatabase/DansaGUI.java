/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafedansadatabase;


import java.awt.Toolkit;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Thomas
 */
public class DansaGUI extends javax.swing.JFrame {
    
    /** 
     * Class instance ArrayList of City objects.
     */
    private ArrayList<Dancer> dancers = new ArrayList<>();
        
    /**
     * External file name of cities.
     */
    private final String fileName = "src/cafedansadatabase/Dancers.txt";
    
    /**
     * Format for displaying numbers relating to City objects.
     */
    DecimalFormat number = new DecimalFormat("#,##0");
    /**
     * Creates new form DansaGUI
     */
    public DansaGUI() {
        initComponents();
        this.getRootPane().setDefaultButton(addJButton); //set buttonAdd as default
        this.setIconImage(Toolkit.getDefaultToolkit().
                getImage("src/USACities/buckinghamfountain_small.jpg"));
        //centers the form at start.
        setLocationRelativeTo(null);
        
        // Read form an external file Citystats.txt and create an
        // ArrayList of City type, cities        
        readFromFile(fileName);
        
        // Show the city names in the JList
        displayDancers();
        showDancerData(dancersJList.getSelectedIndex());
    }

     /**
     * Method: readFromFile
     * Reads cities from a text file that is comma delimited and
     * creates an instance of the City class with the data read.
     * Then the newly created city is added to the cities database.
     * Uses an object from the ReadFile class to read record.
     * @parem file: String
     * @return void
     * pre-condition: a valid file name, Citystats.txt is expected
     * for input with comma separated text fields (but no spaces) for
     * city name, population, median, local, and degree
     * post-condition: a new City is created with the read fields
     * and added to the ArrayList cities
     * @see ReadFile
     * @see Member
     */
    public void readFromFile(String file)            
    {
        dancers.clear();
        DancerFileReader reader = new DancerFileReader(file);
        String line = null;
        while ((line = reader.readRecord()) != null) {
            String[] dancerInfo = line.split(",");
            Dancer dancer = new Dancer(dancerInfo);
            dancers.add(dancer);
        }
        reader.close();
    }
    
    /**
     * Method: displayDancers()
     * Displays cities in JList sorted by level = 0 using selection sort
     * algorithm or last name = 1 using the insertion sort algorithm.
     * @parem void
     * @return void
     * pre-condition: Uses the ArrayList cities.
     * post-condition: cities ArrayList is sorted and displayed either by
     * level or last name.
     * @see #selectionSort
     * @see #insetionSort
     */
    private void displayDancers()
    {
        int location = dancersJList.getSelectedIndex();
        String[] cityNames = new String[dancers.size()];
        if (popJRadioButtonMenuItem.isSelected()) {
            selectionSort(dancers);
            for (int i = 0; i < dancers.size(); i++) {
                cityNames[i] = dancers.get(i).getName() + ", " +
                               dancers.get(i).getYears() + " years.";
            }
        } else {
            insertionSort(dancers);
            for (int i = 0; i < dancers.size(); i++) {
                cityNames[i] = dancers.get(i).getName();
            }
        }
        dancersJList.setListData(cityNames);
        if (location != -1 && location < dancers.size()) {
            dancersJList.setSelectedIndex(location);
        } else {
            dancersJList.setSelectedIndex(0);
        }
    }

    /**
     * Method: insertionSort
     * Sorts ArrayList dancers in ascending order by name. Uses the insertion
     * sort algorithm which inserts city at correct position and shuffles
     * everyone else below that position.
     * @param dancers
     */
    public static void insertionSort(ArrayList <Dancer> dancers) {
	InsertionSortDancerName sorter = new InsertionSortDancerName();
        sorter.sort(dancers);
    }

    /**
     * Method: selectionSort
     * Sorts ArrayList cities in descending order by population. Calls
     * findsMaximum to find city with maximum population in each pass
     * and swap to exchange cities when necessary.
     * @param cities
     */
    public void selectionSort(ArrayList < Dancer > cities) {
        SelectionSortPopulation sorter = new SelectionSortPopulation();
        sorter.sort(cities);
    }  

    /**
     * Method: findMaximum
     * Called by selectionSort to find the index of the member with the maximum
     * population from a given index to the end of the ArrayList
     * @parem ArrayList: cities
     * @parem  int i: index from which to search for the max >= 0
     * @return int: position or index  where maximum is located
     * pre-condition: ArrayList members filled-in with members objects, int i >= 0.
     * post-condition: members ArrayList is sorted by level.
     */
    public int findMaximum(ArrayList < Dancer > dancers, int i)
    {
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
     * Method: swap
     * Called by selectionSort to find the index of the member with the maximum
     * level from a given index to the end of the ArrayList
     * @parem ArrayList: members
     * @parem  int i: index of element to be swapped >= 0
     * @parem  int j: index of element to be swapped >= 0
     * @return void
     * pre-condition: ArrayList members filled-in with members objects, int i, j >= 0.
     * post-condition: members ArrayList with two members swapped.
     */
    public void swap(ArrayList < Dancer > dancers, int i, int j)
    {
        Dancer temp = dancers.get(j);
        dancers.set(j, dancers.get(i));
        dancers.set(i, temp);
    }

    // Binary search for city 

    /** showDancerData
 This method is called from within the constructor to
 display the data for the selected city.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void showDancerData(int index)
    {
        if (index == -1) {
            index = 0;
        }
        nameJTextField.setText(dancers.get(index).getName());
        styleJTextField.setText(dancers.get(index).getStyle());
        profJTextField.setText(dancers.get(index).getProf());
        yearsJTextField.setText(String.valueOf(dancers.get(index).getYears()));
        phoneJTextField.setText(dancers.get(index).getPhone());
        emailJTextField.setText(dancers.get(index).getEmail());
    }   
    
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
        popJRadioButtonMenuItem = new javax.swing.JRadioButtonMenuItem();
        actionJMenu = new javax.swing.JMenu();
        addJMenuItem = new javax.swing.JMenuItem();
        deleteJMenuItem = new javax.swing.JMenuItem();
        editJMenuItem = new javax.swing.JMenuItem();
        searchJMenuItem = new javax.swing.JMenuItem();
        helpJMenu = new javax.swing.JMenu();
        aboutJMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
                .addComponent(logoJLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titleJLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logoJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        titleJPanelLayout.setVerticalGroup(
            titleJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, titleJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(titleJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(titleJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, titleJPanelLayout.createSequentialGroup()
                        .addGroup(titleJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(logoJLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(logoJLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        getContentPane().add(titleJPanel, java.awt.BorderLayout.NORTH);

        dancersJList.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
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
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(llistJScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        listJPanelLayout.setVerticalGroup(
            listJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(llistJScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
        );

        getContentPane().add(listJPanel, java.awt.BorderLayout.LINE_START);

        displayJPanel.setLayout(new java.awt.GridLayout(6, 2, 5, 5));

        nameJLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nameJLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        nameJLabel.setText("Name of dancer: ");
        displayJPanel.add(nameJLabel);

        nameJTextField.setEditable(false);
        nameJTextField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        displayJPanel.add(nameJTextField);

        styleJLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        styleJLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        styleJLabel.setText("Dance Style:");
        displayJPanel.add(styleJLabel);

        styleJTextField.setEditable(false);
        styleJTextField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        styleJTextField.setToolTipText("Press Enter to update");
        displayJPanel.add(styleJTextField);

        profJLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        profJLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        profJLabel.setText("Level of proficiency:");
        displayJPanel.add(profJLabel);

        profJTextField.setEditable(false);
        profJTextField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        profJTextField.setToolTipText("Enter with no $ or commas and press Enter to update");
        displayJPanel.add(profJTextField);

        yearsJLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        yearsJLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        yearsJLabel.setText("Years dancing:");
        displayJPanel.add(yearsJLabel);

        yearsJTextField.setEditable(false);
        yearsJTextField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        yearsJTextField.setToolTipText("Enter without % sign and pres Enter to update");
        displayJPanel.add(yearsJTextField);

        phoneJLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        phoneJLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        phoneJLabel.setText("Phone:");
        displayJPanel.add(phoneJLabel);

        phoneJTextField.setEditable(false);
        phoneJTextField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        phoneJTextField.setToolTipText("Enter without % sign and press Enter to update");
        displayJPanel.add(phoneJTextField);

        emailJLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        emailJLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        emailJLabel.setText("email:");
        displayJPanel.add(emailJLabel);

        emailJTextField.setEditable(false);
        emailJTextField.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        emailJTextField.setToolTipText("Enter without % sign and press Enter to update");
        displayJPanel.add(emailJTextField);

        getContentPane().add(displayJPanel, java.awt.BorderLayout.CENTER);

        controlPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        controlPanel.setMinimumSize(new java.awt.Dimension(299, 45));
        controlPanel.setLayout(new java.awt.GridLayout(1, 5, 5, 5));

        addJButton.setBackground(new java.awt.Color(204, 255, 204));
        addJButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addJButton.setMnemonic('A');
        addJButton.setText("Add");
        addJButton.setToolTipText("Add new city");
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
        editJButton.setToolTipText("Edit city. Press Enter in any of the JTextFields to confirm changes...");
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
        deleteJButton.setToolTipText("Delete city");
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
        printJButton.setToolTipText("Print individual city data");
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
        nameJRadioButtonMenuItem.setText("By Name");
        nameJRadioButtonMenuItem.setToolTipText("Sort by name and display only name");
        nameJRadioButtonMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameJRadioButtonMenuItemActionPerformed(evt);
            }
        });
        sortJMenu.add(nameJRadioButtonMenuItem);

        menubuttonGroup.add(popJRadioButtonMenuItem);
        popJRadioButtonMenuItem.setMnemonic('B');
        popJRadioButtonMenuItem.setText("By Population");
        popJRadioButtonMenuItem.setToolTipText("Sort by populatoin a nd display name and population");
        popJRadioButtonMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popJRadioButtonMenuItemActionPerformed(evt);
            }
        });
        sortJMenu.add(popJRadioButtonMenuItem);

        dancersJMenuBar.add(sortJMenu);

        actionJMenu.setMnemonic('t');
        actionJMenu.setText("Action");

        addJMenuItem.setMnemonic('A');
        addJMenuItem.setText("Add New Dancer");
        addJMenuItem.setToolTipText("Add new city");
        addJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJMenuItemActionPerformed(evt);
            }
        });
        actionJMenu.add(addJMenuItem);

        deleteJMenuItem.setMnemonic('D');
        deleteJMenuItem.setText("Delete Dancer");
        deleteJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteJMenuItemActionPerformed(evt);
            }
        });
        actionJMenu.add(deleteJMenuItem);

        editJMenuItem.setMnemonic('E');
        editJMenuItem.setText("Edit Dancer");
        editJMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editJMenuItemActionPerformed(evt);
            }
        });
        actionJMenu.add(editJMenuItem);

        searchJMenuItem.setMnemonic('r');
        searchJMenuItem.setText("Search Dancer");
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

    /**
     * Clears all fields and sets them to be editable.
     * @return void
     */
    private void clearAll()
    {
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
        nameJTextField.requestFocus();
       
    }
        
    
    private void dancersJListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_dancersJListValueChanged
        int index = (dancersJList.getSelectedIndex());
        if (index == -1)
        {
            index = 0;
        }
        showDancerData(index);
    }//GEN-LAST:event_dancersJListValueChanged

    private void addJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJButtonActionPerformed
        // Add new dancer
        try
        {
            // Create and display a new AddDialog
            AddDancer addDancer = new AddDancer(this, true);
            addDancer.setLocationRelativeTo(this);
            addDancer.setVisible(true);

            // The modal dialog takes focus, upon regaining focus:
            Dancer newDancer = addDancer.getDancer();

            if (newDancer != null && !dancerExists(newDancer))
            {
                // Add the new city to the database
                dancers.add(newDancer);
                displayDancers();                  //refresh GUI
                searchDancer(newDancer.getName());    //highlight added city

                //save new city to file
                saveDancers();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Dancer not Added",
                    "Dancer is null or already exists", JOptionPane.WARNING_MESSAGE);
                dancersJList.setVisible(true);
                dancersJList.setSelectedIndex(0);
            }

        }
        catch (NullPointerException nullex)
        {
            JOptionPane.showMessageDialog(null, "Dancer not Added", "Input Error",
                JOptionPane.WARNING_MESSAGE);
            dancersJList.setVisible(true);
            dancersJList.setSelectedIndex(0);
        }
    }//GEN-LAST:event_addJButtonActionPerformed

    private void editJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editJButtonActionPerformed
        //Clear and set JTextFields visible--not a good a good implementation

        //        nameJTextField.setEditable(false);
        //        popJTextField.setEditable(true);
        //        medianJTextField.setEditable(true);
        //        percentJTextField.setEditable(true);
        //        degreeJTextField.setEditable(true);
        //        popJTextField.requestFocus();
        //        popJTextField.selectAll();
        //
        //        addJButton.setEnabled(false);
        //        deleteJButton.setEnabled(false);
        //        addJMenuItem.setEnabled(false);
        //        editJMenuItem.setEnabled(true);
        //        deleteJMenuItem.setEnabled(false);
        //        printJMenuItem.setEnabled(false);
        //degreeJTextFieldActionPerformed(evt);
    }//GEN-LAST:event_editJButtonActionPerformed

    private void deleteJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteJButtonActionPerformed
        int reply = JOptionPane.showConfirmDialog(this, "Are you sure?",
            "Confirm Dancer deletion...",
            JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            // Delete selected dancer
            int index = this.dancersJList.getSelectedIndex();
            this.dancers.remove(index);
            displayDancers();
            saveDancers();
        } else {
        }
    }//GEN-LAST:event_deleteJButtonActionPerformed

    private void printJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printJButtonActionPerformed
        // Use the PrintUtilities class to print the GUI
        PrintUtilities.printComponent(this);
    }//GEN-LAST:event_printJButtonActionPerformed

    private void exitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitJButtonActionPerformed
        // End  program
        System.exit(0);
    }//GEN-LAST:event_exitJButtonActionPerformed

    private void clearJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearJMenuItemActionPerformed
        // Empty all fields and reset form by calling the method clearAll
        clearAll();
    }//GEN-LAST:event_clearJMenuItemActionPerformed

    private void printJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printJMenuItemActionPerformed
        // Print entire form
        printJButtonActionPerformed(evt);
    }//GEN-LAST:event_printJMenuItemActionPerformed

    private void exitJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitJMenuItemActionPerformed
        // Quit the application
        exitJButtonActionPerformed(evt);
    }//GEN-LAST:event_exitJMenuItemActionPerformed

    private void nameJRadioButtonMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameJRadioButtonMenuItemActionPerformed
        // display cities sorted by name
        insertionSort(this.dancers);
        displayDancers();
    }//GEN-LAST:event_nameJRadioButtonMenuItemActionPerformed

    private void popJRadioButtonMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popJRadioButtonMenuItemActionPerformed
        // display cities sorted by population
        selectionSort(this.dancers);
        displayDancers();
    }//GEN-LAST:event_popJRadioButtonMenuItemActionPerformed

    private void addJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJMenuItemActionPerformed
        // call buttonAddActionPerformed
        addJButtonActionPerformed(evt);
    }//GEN-LAST:event_addJMenuItemActionPerformed

    private void deleteJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteJMenuItemActionPerformed
        // call buttonDeleteActionPerformed
        deleteJButtonActionPerformed(evt);
    }//GEN-LAST:event_deleteJMenuItemActionPerformed

    private void editJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editJMenuItemActionPerformed
        // call buttonEditActionPerformed
        editJButtonActionPerformed(evt);
    }//GEN-LAST:event_editJMenuItemActionPerformed

    private void searchJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchJMenuItemActionPerformed
        // Find specified city
        String cityName = JOptionPane.showInputDialog(this, "Search for:",
            "Search for City",
            JOptionPane.PLAIN_MESSAGE);
        searchDancer(cityName);
    }//GEN-LAST:event_searchJMenuItemActionPerformed

    private void aboutJMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutJMenuItemActionPerformed
//        AboutJFrame cityAbout = new AboutJFrame();
//        cityAbout.setVisible(true);

    }//GEN-LAST:event_aboutJMenuItemActionPerformed

        /**
     * Method: saveDancers
 Saves the cities to a file in the alphabetical order of their name.
     * @see writeToFile
     * @return void
     */
    private void saveDancers()
    {       
        writeToFile(this.fileName);
    }
    
    /**
     * Method: dancerExists
 Performs linear search through City list, `this.cities`, 
 to determine if the specified City object exists.
     * @param metropolis - City whose existence is in question
     * @return boolean: true if the city exist.
     */
    private boolean dancerExists(Dancer metropolis)
    {
        for (int i = 0; i < dancers.size(); i++) {
            if (metropolis.equals(dancers.get(i))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method: searchDancer
 Searches for a city by how they are currently sorted.
     * Cities are first sorted by name, and then the index of the
     * desired city is given. If citiesJList is sorted by name, then
     * this index will be highlighted. If citiesJList is sorted by
     * population then the population of the desired city is grabbed
     * and then the cities are sorted by population and an array is 
     * created which holds the population of each city. This population
     * array is then searched and the index from this search is then
     * highlighted in citiesJList.
     * @param cityName 
     * @return void
     */
    private void searchDancer(String cityName)
    {
        if ((cityName != null) && (cityName.length() > 0)) {
            this.nameJRadioButtonMenuItem.doClick();
            cityName = cityName.toLowerCase();
            String[] cityNames = new String[dancers.size()];
            for (int i = 0; i < dancers.size(); i++) {
                cityNames[i] = dancers.get(i).getName().toLowerCase();
            }
            int index = linearSearch(cityNames, cityName);    
            if (index != -1) {
                dancersJList.setSelectedIndex(index);   
            } else {
                JOptionPane.showMessageDialog(this,
                                              cityName+" not found.",
                                              "Search Error",
                                              JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this,
                                          "No city name given.",
                                          "Search Error",
                                          JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public int linearSearch(String[] array, String key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].contains(key)){
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Calls our implementation for binary search.
     * @param array - Comparable type array to be searched through
     * @param key - Comparable type target to be searched for
     * @return int: the index of the target in the array.
     */
    public static int binarySearch(Comparable[] array, Comparable key)
    {
//        BinarySearchName searcher = new BinarySearchName();
//        int result = searcher.binarySearch(array, key);
        return -1;
    }
    
     /**
     * Method: writeToFile
     * Write cities to a text file that is comma delimited.
     * @parem file: String
     * @return void
     * pre-condition: a valid file name, Citystats.txt is expected
     * post-condition: a new text file is created with the current cities
     * in the database
     * @see WriteFile
     * @see Dancer
     */
    public void writeToFile(String file) {
        DancerFileWriter writer = new DancerFileWriter(file, dancers);
        writer.writeTheFile();
    }
    
    
    /**
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
    private javax.swing.JRadioButtonMenuItem popJRadioButtonMenuItem;
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
    private javax.swing.JLabel yearsJLabel;
    private javax.swing.JTextField yearsJTextField;
    // End of variables declaration//GEN-END:variables
}