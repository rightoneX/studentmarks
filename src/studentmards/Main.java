//BIT504 Programming 1  Assessment 1
//Student: Alexander Ustinov
//Student Number: 5062598
//Version 29.07.22

package studentmards;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Main {

    private static final String filePath = "c://"; //declare the data file location & name
    private static final String fileName = "studentdata.txt";

    private static final List<Student> students = new ArrayList<>();
    private static final List<AssessmentMarks> assessmentMathMarks = new ArrayList<>();
    private static final List<AssessmentMarks> assessmentEnglishMarks = new ArrayList<>();

    public static void main(String[] args) {
        readFile(filePath + fileName); //read the data from file

        while(true){
            displayMenu(); //Display menu
            switch (selectMenuOption()) {
                case 1: // 1) Display student mark
                    displayReportByMarks();
                break;
                case 2: // 2) Display student grades
                    displayReportByGrades();
                    break;
                case 3: // 3) Add new student
                    addNewStudent();
                    break;
                case 4: // 4) Remove student
                    removeStudent();
                    break;
                case 5: // 5) Remove student
                    System.exit(0);// Exit the software
                    break;
                 }
        }
    }


    //reads data from a text file
    public static void readFile(String filename){

        File file = new File(filename);
        try {
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                String[] words =scanner.nextLine().split(",");
                addStudent( Integer.parseInt(words[0]), words[1], words[2], Integer.parseInt(words[3]), Integer.parseInt(words[4]),
                        + Integer.parseInt(words[5]), Integer.parseInt(words[6]),
                        + Integer.parseInt(words[7]), Integer.parseInt(words[8]));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Failed to read file.");
        }
//        return true;
    }


    //Creates a new Student object and Mathematics and English objects
    private static void addStudent(int id, String firstName, String
            lastName,int mathsMark1, int mathsMark2, int mathsMark3, int
                                           englishMark1, int englishMark2, int englishMark3){

        Student student = new Student(id, firstName, lastName);
        AssessmentMarks mathMarks = new AssessmentMarks(student.getFullName(), mathsMark1, mathsMark2, mathsMark3);
        AssessmentMarks englishMarks = new AssessmentMarks(student.getFullName(), englishMark1, englishMark2, englishMark3);

        students.add(student);
        assessmentMathMarks.add(mathMarks);
        assessmentEnglishMarks.add(englishMarks);
    }

    //Displays a list of all the students with the student marks
    private static void displayReportByMarks(){

        displayStudentsListHead("Mark");
        for (int i=0; i < students.size(); i++){
            String studentList = rightpad(students.get(i).getFullName(), 30) +
                    assessmentMathMarks.get(i).getMark(1) + "    " +
                    assessmentMathMarks.get(i).getMark(2) + "    " +
                    assessmentMathMarks.get(i).getMark(3) + "       " +
                    assessmentMathMarks.get(i).getAverageMark() +"                      " +
                    assessmentEnglishMarks.get(i).getMark(1) + "    " +
                    assessmentEnglishMarks.get(i).getMark(2) + "    " +
                    assessmentEnglishMarks.get(i).getMark(3) + "       " +
                    assessmentEnglishMarks.get(i).getAverageMark();
            System.out.println(studentList);
        }
    }

    //Displays a list of all the students with the student letter grades
    private static void displayReportByGrades(){

        displayStudentsListHead("Grade");
        for (int i=0; i < students.size(); i++){
            String studentList = rightpad(students.get(i).getFullName(), 30) +
                    assessmentMathMarks.get(i).getMark(1) + "    " +
                    assessmentMathMarks.get(i).getMark(2) + "    " +
                    assessmentMathMarks.get(i).getMark(3) + "       " +
                    assessmentMathMarks.get(i).getAverageGrade() +"                      " +
                    assessmentEnglishMarks.get(i).getMark(1) + "    " +
                    assessmentEnglishMarks.get(i).getMark(2) + "    " +
                    assessmentEnglishMarks.get(i).getMark(3) + "       " +
                    assessmentEnglishMarks.get(i).getAverageGrade();
            System.out.println(studentList);
        }
    }

    //adding spaces to a names, to make the length equal
    public static String rightpad(String text, int length) {
        return String.format("%-" + length + "." + length + "s", text) ;
    }

    // adds the student to the student list
    private static void addNewStudent(){

    do {
            System.out.println("\n");
            System.out.println("Please enter student information");
            Scanner scanInput = new Scanner(System.in);
            //ToDo build exit by 0 entry
            System.out.println("Please enter the student ID:");
            int id = scanInput.nextInt(); //Read user entry
            scanInput.nextLine();  // Consume newline left-over
            System.out.println("Please enter First Name:");
            String firstName = scanInput.nextLine(); //Read user entry
            System.out.println("Please enter Last Name:");
            String lastName = scanInput.nextLine(); //Read user entry
            System.out.println("Please enter Math Assessment 1 marks:");
            int mathAssessment1 = scanInput.nextInt(); //Read user entry
            System.out.println("Please enter Math Assessment 2 marks:");
            int mathAssessment2 = scanInput.nextInt(); //Read user entry
            System.out.println("Please enter Math Assessment 3 marks:");
            int mathAssessment3 = scanInput.nextInt(); //Read user entry
            System.out.println("Please enter English Assessment 1 marks:");
            int engAssessment1 = scanInput.nextInt(); //Read user entry
            System.out.println("Please enter English Assessment 2 marks:");
            int engAssessment2 = scanInput.nextInt(); //Read user entry
            System.out.println("Please enter English Assessment 3 marks:");
            int engAssessment3 = scanInput.nextInt(); //Read user entry
           System.out.println("\n\nid: " + id + "  First Name: " + firstName + "  Last Name: "+ lastName+
                        " Math A1: "+ mathAssessment1+" Math A2: "+ mathAssessment2+
                        " Math A3: "+ mathAssessment3+ " Eng A1: "+ engAssessment1+
                        " Eng A2: "+ engAssessment2+ " Eng A3: "+ engAssessment3);
            System.out.println("\n\nPress '1' to save and enter next record \n" +
                    "Press '2' to save and leave the page \n" +
                    "Press '0' go to main menu without saving\n");
            int selected =selectMenuOption();
            if(selected == 0) {
                break; //exit this page without saving
            }
            if (selected == 2) {
                addStudent(id, firstName, lastName, mathAssessment1, mathAssessment2,
                        +mathAssessment3, engAssessment1, engAssessment2, engAssessment3);
                System.out.println("New student had been saved to the list \n");
                saveToFile(); //save to file
                break; //saves and exit the page
            }else if(selected == 1){
                addStudent(id, firstName, lastName, mathAssessment1, mathAssessment2,
                        +mathAssessment3, engAssessment1, engAssessment2, engAssessment3);
                System.out.println("New student had been saved to the list \n");
                saveToFile(); //save to file
            }
        }while (true);
    }

    //collect the data and save to file
    private static void saveToFile(){

        String path = filePath + fileName;
        String str="";
        try {
            for (int i=0; i < students.size(); i++){  // read all data
               str += students.get(i).getId() + "," +
                         students.get(i).firstName + "," +
                         students.get(i).lastName + "," +
                       assessmentMathMarks.get(i).getMark(1) + "," +
                       assessmentMathMarks.get(i).getMark(2) + "," +
                       assessmentMathMarks.get(i).getMark(3) + "," +
                       assessmentEnglishMarks.get(i).getMark(1) + "," +
                       assessmentEnglishMarks.get(i).getMark(2) + "," +
                       assessmentEnglishMarks.get(i).getMark(3) +"\n";
            }

            File studentList = new File(path);
            FileWriter fw = new FileWriter(studentList);
            fw.write(str); //save the data to file
            fw.close();

        } catch (IOException iox) {
            System.out.println("\nCan not save the data to the file: " + path);
            iox.printStackTrace();
        }
    }

    //Removes the student by the ID
    private static void removeStudent(){

        boolean loop = true;
        while(loop) {
            displayStudentsList();

            System.out.println("\n");
            System.out.println("Please enter the student ID to delete from the list");
            System.out.println("or enter '0' to return to main menu");

            int selection = selectMenuOption(); // read user entry

            if(selection == 0){
                System.out.println("\n");
                System.out.println("Press '1' to save changes to file. ");
                System.out.println("Press '0' Do Not save changes to file.");
                if(selectMenuOption() == 1){
                    saveToFile();
                }
                    loop = false;
            }// return to main menu

            if (searchStudentById(selection)) {
                System.out.println("The student ID " + selection + " had been removed from the list");
            }

        }
    }

    //Search student list by Id
    private static boolean searchStudentById(int studentId){

        for (int i=0; i < students.size(); i++){ // loop all students list
            if (students.get(i).getId() == studentId ) { //find the student with selected id
                students.remove(i); //student removed from the list
                return true;
            }
        }
        System.out.println("\n No student with this ID was found, try again");
        return false;
    }

    //Returns a menu option the user has selected
    private static int selectMenuOption(){

        int selectedOption = 0;
        System.out.println("Enter your selection :");
        Scanner scanInput = new Scanner(System.in);
        String userEntry = scanInput.nextLine(); //Read user entry
        try { //check if user enter valid menu number
            selectedOption = Integer.parseInt(userEntry);
        }
        catch (NumberFormatException e){
            System.out.println("Please enter valid menu option!");
        }
        return selectedOption;
    }

    //Displays the menu to the user
    private static void displayMenu(){
        System.out.println("\n\nStudent Report System\n" +
                "---------------------------\n" +
                "1) Display student marks\n" +
                "2) Display student grades\n" +
                "3) Add new student\n" +
                "4) Remove student\n" +
                "5) Exit\n");
    }

    //Displays the list of students with id
    private static void displayStudentsList(){
        System.out.println("\n");
        System.out.println("ID  Student Name         ");
        System.out.println("---------------------------");

        for (int i = 0; i < students.size(); i++){
            System.out.println(students.get(i).getId() + "     " + students.get(i).getFullName());
        }
    }

    //Displays the header of student list
    private static void displayStudentsListHead(String title){
        System.out.println("Name               Maths    A1    A2    A3    " + title + "     English    A1    A2    A3    " + title);
        System.out.println("----------------------------------------------------------------------------------------------");
    }
}
