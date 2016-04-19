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

/**
 * This class implements Binary Search.
 * It is compatible for arrays and targets of Comparable type
 * <pre>
    Project: CitiesGUI Database
    Platform: jdk 1.8.0_14; NetBeans IDE 8.1; Windows 10
    Course: CS 143
    Hours: 
    Created on: 31/Mar/2016, 3:45:53 pm
    Revised on: 07/Apr/2016, 2:43:24 pm
 </pre>
 *
 * @author:	thomas.kercheval@go.shoreline.edu
 * @version: 	%1% %2%
 * 
 */
public class BinarySearchName {
    
    /**
     * Method: lessThan
     * Called by binarySearcher to determine if one element is less
     * than the other.
     * @param one - first element to be compared
     * @param two - second element to be compared
     * @return boolean: true if one is less than two.
     */
    private boolean lessThan(Comparable one, Comparable two) {
        return one.compareTo(two) < 0;
    }
    
    /**
     * Method: binarySearcher
     * Called recursively to determine if a target is in a given array of
     * comparable values. Breaks up an array into smaller and smaller
     * portions based on whether the median value in the array is 
     * comparatively less than the target.
     * @param names - array we are searching through
     * @param target - value we are looking for
     * @param min - the minimum array index we are concerned with
     * @param high - the maximum array index we are concerned with
     * @return int: index of target in array, or -1 if target does not exist.
     */
    private int binarySearcher(Comparable[] names, Comparable target,
                               int min, int high) {
        int key = (min + high) / 2;
//        System.out.println("Target: "+target+", Result: "+names[key]+
//                           ", Min: "+min+",  High: "+high+", Key: "+key);
        int result = -1;
        if (names[key].equals(target)) {
            return key;
        } else if (min >= high) {
            return -1;
        } else if (lessThan(names[key], target)) {
            result = binarySearcher(names, target, key + 1, high);
            return result;
        } else if (lessThan(target, names[key])) {
            result = binarySearcher(names, target, min, key - 1);
            return result;
        }
        return result;
    }
    
    /**
     * Method: binarySearch
     * Initiates the binary search by recursively calling binarySearcher
     * @param names - an array of comparable values to be searched through
     * @param target - what we are searching for
     * @return int: index of target in array, or -1 if target does not exist.
     */
    public int binarySearch(Comparable[] names, Comparable target) {
        int result = -1;
        int sizeArray = names.length;
        result = binarySearcher(names, target, 0, sizeArray);
        return result;
    }
}
