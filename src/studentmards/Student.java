//BIT504 Programming 1  Assessment 1
//Student: Alexander Ustinov
//Student Number: 5062598
//Version 29.07.22

package studentmards;

public class Student {

    private int id;
    public final String firstName;
    public final String lastName;

    //Create a constructor that sets the fields' id, firstName, and lastName
    public Student(int id, String firstName, String lastName){
        setId( id);
        this.firstName = firstName;
        this.lastName = lastName;
    }

     //Returns the full name of the student
    public String getFullName(){
        return this.firstName + " " + this.lastName;
    }

    // Getter
    public int getId() {
        return this.id;
    }

    // Setter
    public void setId(int id) {
        if (0 < id) {
            this.id = id;
        }
    }
}
