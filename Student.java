import java.util.ArrayList;
/**
 * @author Mohamed Rabeea
 * @author Ali Hasan
 */
public class Student {
    // Data members
    private long idNum; // The id of the student
    private String firstName; // The student first name
    private String lastName; // The student Last name
    private char gender; // Student's gender
    private String email; // Student's email
    private ArrayList<Course> coursesRegistered; // The current courses registered for the student
    private double GPA; // The gpa of the student
    private long advisorNum; // Advisor number of the student
    /**
     * Default constructor,
     * it calls the second constructor and initializes the default values
     */
    public Student(){
        this(0,null,null,'U',null,0.0,0);
    }
    /**
     * A constructor with 7 parameters to initialize the data members of the student class,
     * it ensures that the id of the student is valid, if the id is invalid it will be set to 0
     * It checks if the gender is valid, if the gender is invalid it will be set to U (unknown)
     * it ensures that the GPA and advisor number are non-negative values, if either is invalid they will be set to 0
     * It creates an array list coursesRegistered which is initially empty
     * @param idNum the ID number of the student
     * @param firstName The first name of the student
     * @param lastName The last name of the student
     * @param gender The gender of the student
     * @param email The email of the student
     * @param GPA The GPA of the student
     * @param advisorNum The Advisor Number of the student
     */
    public Student(long idNum, String firstName, String lastName, char gender, String email, double GPA,long advisorNum ){
        if (idNum <0) // Check if id is valid
            idNum = 0;
        this.idNum = idNum;
        this.firstName = firstName;
        this.lastName = lastName;
        if (gender != 'M' && gender !='m' && gender !='F' && gender != 'f')// Check if gender is valid
            gender = 'U';
        this.gender = gender;
        this.email = email;
        if (GPA <0.0) // Check if GPA is valid
            GPA = 0.0;
        this.GPA = GPA;
        if (advisorNum <0) // Check if advisorNum is valid
            advisorNum =0;
        this.advisorNum = advisorNum;
        coursesRegistered = new ArrayList<>();
    }

    // get methods
    /**
     *
     * @return ID of the student
     */
    public long getIdNum() {
        return idNum;
    }
    /**
     *
     * @return the first name of the student
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     *
     * @return the last name of the student
     */
    public String getLastName() {
        return lastName;
    }
    /**
     *
     * @return the gender of the student
     */
    public char getGender() {
        return gender;
    }
    /**
     *
     * @return the email of the student
     */
    public String getEmail() {
        return email;
    }
    /**
     *
     * @return An array list representing the current courses registered for the student
     */
    public ArrayList<Course> getCoursesRegistered(){
        return coursesRegistered;}
    /**
     *
     * @return the GPA of the student
     */
    public double getGPA() {
        return GPA;
    }
    /**
     *
     * @return the advisor number for the student
     */
    public long getAdvisorNum() {
        return advisorNum;
    }
    // set methods
    /**
     * this method checks if ID is valid, if ID is invalid it will be set to 0,
     * otherwise it sets the ID to the passed value
     * @param idNum the id number for the student
     */
    public void setIdNum(long idNum) {
        if (idNum <0) // Check if id is valid
            idNum = 0;
        this.idNum = idNum;
    }
    /**
     * this method sets the first name of the student to the passed first name
     * @param firstName the first name of the student
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /**
     * this method sets the last name of the student to the passed last name
     * @param lastName the last name of the student
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    /**
     * this method checks the gender if it is valid, if it is invalid it will be set to "U" (Unknown)
     * @param gender the gender of the student
     */
    public void setGender(char gender) {
        if (gender != 'M' && gender !='m' && gender !='F' && gender != 'f')// Check if gender is valid
            gender = 'U';
        this.gender = gender;
    }
    /**
     * this method sets the email of the student to the passed email
     * @param email the email of the student
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * this method sets the coursesRegistered for this student to the passed courses registered,
     * It sets the coursesRegistered for this student to the passed array list by calling the copy constructor of the array list class.
     * @param coursesRegistered An array list representing the current courses registered for the student
     */
    public void setCoursesRegistered(ArrayList<Course> coursesRegistered){
        this.coursesRegistered = new ArrayList<>(coursesRegistered);
    }
    /**
     * this method checks if the GPA of the student is valid, if it is invalid it will be set to 0.0, otherwise it will be set to the passed GPA
     * @param GPA the GPA of the student
     */
    public void setGPA(double GPA) {
        if (GPA <0.0) // Check if GPA is valid
            GPA = 0.0;
        this.GPA = GPA;
    }
    /**
     * this method checks if the advisor number of the student is valid, if it is invalid it will be set to 0, otherwise it will be set to the passed advisor number
     * @param advisorNum
     */
    public void setAdvisorNum(long advisorNum) {
        if (advisorNum <0) // Check if advisorNum is valid
            advisorNum =0;
        this.advisorNum = advisorNum;
    }
    /**
     * It tests for equality for the ID of this student and the passed student object ID
     * @param other an object of type student
     * @return true if both student's ID's match, otherwise it returns false
     */
    public boolean equals(Student other){
        return this.idNum== other.idNum;
    }

    /**
     * this method prints the courses Registered of the student,
     * if the student has no courses registered it will print an error message
     */
    public void printCoursesRegistered(){
        if (coursesRegistered.isEmpty())
            System.out.println("No courses registered.");
        else {
            System.out.println("Courses registered:");
            for (int i = 0; i < coursesRegistered.size(); i++)
                System.out.println(coursesRegistered.get(i));
        }
    }
}