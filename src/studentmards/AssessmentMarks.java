//BIT504 Programming 1  Assessment 1
//Student: Alexander Ustinov
//Student Number: 5062598
//Version 29.07.22

package studentmards;

public class AssessmentMarks {

    private String courseName;
    private Integer assessment1;
    private Integer assessment2;
    private Integer assessment3;

    //Constructor assigns the values for their respective fields
    public AssessmentMarks(String name, int mark1, int mark2, int mark3){
        this.courseName = name;
        this.assessment1 = mark1;
        this.assessment2 = mark2;
        this.assessment3 = mark3;
    }

    // Sets the value of the assessments
    public void setMark(int assessmentNumber, int mark){

        switch(assessmentNumber){
            case 1:
                this.assessment1 = mark;
                break;
            case 2:
                this.assessment2 = mark;
                break;
            case 3:
                this.assessment3 = mark;
                break;
        }
    }

    //Returns the mark for the assessment
    public int getMark(int assessmentNumber){
        int mark = 0;
        switch(assessmentNumber){
            case 1:
                mark = this.assessment1;
                break;
            case 2:
                mark = this.assessment2;
                break;
            case 3:
                mark = this.assessment3;
                break;
        }
        return mark;
    }

    //Returns the average mark for the course
    public int getAverageMark(){
        return (getMark(1)+getMark(2) +getMark(3)) / 3;
    }

    //Returns the grade (such as A, B, C) for the assessment
    public String getGrade(int assessmentNumber){

        String grade = "A";
        if (assessmentNumber <= 100 && assessmentNumber >= 95){
            grade =  "A+";//95–100 A+
        }
        if (assessmentNumber <= 94 && assessmentNumber >= 90){
            grade =  "A";//90–94 A
        }
        if (assessmentNumber <= 89 && assessmentNumber >= 85){
            grade =  "A-";//85–89 A–
        }
        if (assessmentNumber <= 84 && assessmentNumber >= 80){
            grade =  "B+";//80–84 B+
        }
        if (assessmentNumber >= 75 && assessmentNumber <= 79){
            grade =  "B";//75–79 B
        }
        if (assessmentNumber >= 70 && assessmentNumber <= 74){
            grade =  "B-";//70–74 B–
        }
        if (assessmentNumber >= 60 && assessmentNumber <= 69){
            grade =  "C+";//60–69 C+
        }
        if (assessmentNumber <= 59 && assessmentNumber >= 50){
            grade =  "C";//50–59 C
        }
        if (assessmentNumber >= 41 && assessmentNumber <= 49){
            grade =  "C-";//41–49 C–
        }
        if (assessmentNumber <= 40 ){
            grade =  "D";//0–40 D
        }
        return grade;
    }

    //Returns the average grade for the course
    public String getAverageGrade(){
        return getGrade(getAverageMark());
    }

    //Returns the grade (A, B, C, and so on) based on the mark given
    public String markToGrade(int mark){
        return getGrade(mark);
    }

    //Sets the value of courseName
    public String setCourseName(String name){
        this.courseName = name;
        return courseName;
    }

    //Returns the value of courseName
    public String getCourseName(){
        return this.courseName;
    }
}
