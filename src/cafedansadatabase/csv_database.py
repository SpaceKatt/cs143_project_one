# -*- coding: utf-8 -*-

def grab_style(line):
    """From a line, grab the second value in a comma-separated list"""
    fields = line.split(",")
    return fields[2]

def format_array(styles):
    """From a list of values, create a valid Java array code"""
    array = "String[] profs = new String[]{"
    for style in styles:
        array += "\"" + style + "\", "
    array = array[:-2] + "};"
    return array

def create_array():
    """Reads a CSV file and sends an array to StdOut."""
    styles = []    
    with open("./Dancers.txt", "r") as csv_file:
        for line in csv_file:
            style = grab_style(line)
            if style not in styles: # Prevent duplicate entries
                styles.append(style)
    styles.sort()
    print format_array(styles)


if __name__ == "__main__":
    create_array()