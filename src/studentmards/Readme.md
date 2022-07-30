# Introduction
    BIT504 Programming 1  Assessment 1
    Student: Alexander Ustinov
    Student Number: 5062598
    Version 29.07.22

- The software is to design and build to manage a student records. 
- This application stores student information along with their assessment marks. 
- The user can add students, remove students, and display a report that shows
the student grade equivalent to their mark.
- The application reads a text file ‘studentdata.txt’ to extract student information.


# File Structure

- The file need to be saved as ASCII standard text file with comma divided between columns.
- [ Id], [firstName], [lastName], [Math Assessment 1 Mark],[Math Assessment 2 Mark],[Math Assessment 3 Mark],[English Assessment 1 Mark],[English Assessment 2 Mark],[English Assessment 3 Mark]

*Data Sample
    1,Frank,West,98,95,87,78,77,80
    2,Dianne,Greene,78,94,88,87,95,92
    3,Doug,Lei,78,94,88,87,95,92
    4,James,Hewlett,69,92,74,77,89,91
    5,Aroha,Wright,97,92,87,83,82,92


# File Location

- By default, the file must be placed in the rood directory "c:/studentdata.txt"
- To change the default settings navigate to Main.java file
       private static final String filePath = "c://";
       private static final String fileName = "studentdata.txt";