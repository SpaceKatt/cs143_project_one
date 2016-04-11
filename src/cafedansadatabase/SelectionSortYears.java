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

import java.util.ArrayList;

/**
 * SelectionSortYears.java
 
 Implements a simple selection sort.
 * @author Thomas
 */
public class SelectionSortYears {
    
    /** Compares two values. */
    private boolean less(Dancer one, Dancer two) {
        return one.getYears() < two.getYears();
    }
    
    /** Checks to make sure the ArrayList is sorted. */ 
    private boolean isSorted(ArrayList<Dancer> list) {
        for (int i = 0; i < list.size(); i++) {
            if(less(list.get(i), list.get(i - 1))) { return false; }
        }
        return true;
    }
    
    /** Swaps two elements in an ArrayList. */
    private void swap(ArrayList list, int indexOne, int indexTwo) {
        Object temp = list.get(indexTwo);
        list.set(indexTwo, list.get(indexOne));
        list.set(indexOne, temp);
    }
    
    /** Uses  insertion sort to sort an ArrayList of Cities by population. */
    public void sort(ArrayList<Dancer> list) {
        int arraySize = list.size();
        for (int i = 0; i < arraySize; i++) {
            int min = i;
            for (int j = 0; j < arraySize; j++) {
                if (less(list.get(j), list.get(min))) {
                    swap(list, min, j);
                }
            }
        }
        assert isSorted(list);
    }
}
