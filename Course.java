/**
 * @author Mohamed Rabeea
 * @author Ali Hasan
 */
public class Course {//...
    // Data members
    private String courseNum; // Represents the course code or number, ex:ITCS214
    private String courseName; // Represents the course Name, ex:Data Structures
    private int credits; // Represents the credits of the course
    private int section; /* Represents the section of the course that
                         the student is currently in*/
    /**
     * Default Constructor
     * , Initializes the default attributes of the class.
     */
    public Course(){
        courseName = null;
        courseNum = null;
        credits = 3;
        section = 1;
    }

    /**
     * A constructor with 4 parameters to initialize the data members of the class
     * It checks if the {@code credits} and {@code section} are valid
     * If credits or section are invalid, the default value will be set to zero
     * @param courseNum the course number or code
     * @param courseName the course name
     * @param credits the course credits
     * @param section the section
     */
    public Course(String courseNum,String courseName,int credits,int section){
        this.courseNum = courseNum;
        this.courseName = courseName;
        if (credits < 0) // Checks if credits are valid
            credits = 0;
        this.credits = credits;
        if (section < 0) // Checks if section is valid
            section = 0;
        this.section = section;
    }
    // Getter methods
    /**
     *
     * @return courseNum
     */
    public String getCourseNum(){
        return courseNum;
    }
    /**
     *
     * @return courseName
     */
    public String getCourseName(){
        return courseName;
    }
    /**
     *
     * @return credits
     */
    public int getCredits (){
        return credits;
    }
    /**
     *
     * @return section
     */
    public int getSection(){
        return section;
    }
    // Setter methods

    /**
     * sets the courseNumber to the passed value
     * @param courseNum Course number
     */
    public void setCourseNum(String courseNum){
        this.courseNum = courseNum;
    }

    /**
     * sets the course name to the passed value
     * @param courseName Course Name
     */
    public void setCourseName(String courseName){
        this.courseName = courseName;
    }
    /**
     * Sets the credits for the course, Checks if credits are valid before setting them to the new value,
     * if credits are invalid the default value of the credits will be set to 3
     * @param credits credits
     */
    public void setCredits(int credits){
        if (credits < 0) //Check if credits are valid
            credits = 3;
        this.credits = credits;
    }
    /**
     * sets the section for the course, Checks if section is valid before setting it to the new value,
     * if section is invalid the default value of the section will be set to 1
     * @param section section
     */
    public void setSection(int section){
        if (section < 0) // check if section is valid
            section = 1;
        this.section = section;
    }
    /**
     * Compares for equality for this course and the other course object passed as a parameter
     * It ensures that the passed object is not null and of type course class
     * @param obj the course object to be tested for equality
     * @return True if both courses have the same attributes, otherwise it returns false
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) return false;
        Course other = (Course) obj;
        return (courseName.equalsIgnoreCase(other.courseName) &&
                courseNum.equalsIgnoreCase(other.courseNum) &&
                credits == other.credits &&
                section == other.section);
    }
    /**
     * generates a string with all the course information
     * @return a string containing all course attributes
     */
    @Override
    public String toString(){
        return ("Course Name: "+courseName +"\n" +
                "Course Number: "+courseNum+"\n" +
                "Credits: "+credits+"\n"+
                "Section: "+section);

    }

}
