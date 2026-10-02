import java.util.LinkedList;
/**
 * @author Mohamed Rabeea
 * @author Ali Hasan
 */
public class Roster {
    // Data members
    private LinkedList<Student> studentsList; // A list of the students
    private int size; // The number of students in the list

    /**
     * Default Constructor,
     * Creates an empty studentsList of type LinkedList and initializes the size.
     */
    public Roster() {
        this.studentsList = new LinkedList<>();
        size = 0;
    }

    /**
     * Adds a student to the students list.
     * <br> </br>
     * It checks if the passed new student already exists in the list.
     * If it does not exist, it adds the student in the list based on his/her ID ascending order.
     * @param newStudent an object of the student to be added in our list
     * @return true if the student has been added to the list, otherwise false
     */
    public boolean addStudent(Student newStudent) {
        if (searchStudent(newStudent.getIdNum())!=-1)
            return false;
        int i;
        for (i = 0; i < studentsList.size(); i++)
            if (newStudent.getIdNum() < getStudent(i).getIdNum())
                break;
        studentsList.add(i,newStudent);
        size++;
        return true;
    }

    /**
     * Deletes a student from the list.
     * <br> </br>
     * If the list is not empty, it checks if the student exists in the list. If so, it removes the student from the list.
     * @param idNum the id of the student to be deleted
     * @return true if the student has been deleted from the list, otherwise false
     */
    public boolean deleteStudent(long idNum){
        if (isEmpty())
            return false;
        int index = searchStudent(idNum);
        if (index != -1) {
            studentsList.remove(index);
            size--;
            return true;
        }
        return false;
    }
    /**
     * Searches for the student in the list.
     * @param idNum the id of the student to be searched
     * @return the index of the specified student in the list.
     * If the student does not exist it returns -1
     */
    private int searchStudent(long idNum){
        for (int i = 0; i < studentsList.size(); i++)
            if (getStudent(i).getIdNum() == idNum)
                return i;
        return -1;
    }

    /**
     * Checks if the students list is empty.
     * @return true if we do not have any students in the list, otherwise it returns false
     */
    private boolean isEmpty(){
        return(studentsList.isEmpty());
    }

    /**
     * returns the size of the students list
     * @return the number of students in the list
     */
     public int listSize(){
        return studentsList.size();
     }

    /**
     * It returns the student object at the given index.
     * @param index the index for the student in the students list
     * @return An object of type student in the students list at location index
     */
    private Student getStudent(int index){
        return studentsList.get(index);
    }

    /**
     * Adds a course for the given student's ID number.
     * <br> </br>
     * this method searches for the student with passed ID Number,
     * checks if the student has already registered the course,
     * calculates the total credits and adds the passed course credits to the total credits
     * <br> </br>
     * It adds the course based on two conditions:
     * <br> </br>
     * if the total credits are less than or equal 21 and the student's GPA is greater than 3.00.
     * <br> </br>
     * if the total credits are less than or equal 18.
     * <br> </br>
     * If one of these conditions (Not both) are satisfied it adds the course and returns true, otherwise it returns false
     * <br> </br>
     * If the student does not exist in the list or the course already exists in the coursesRegistered it returns false
     * @param course An object of type course to be added to the student's coursesRegistered
     * @param idNum The ID number of the student
     * @return returns true if the course has been successfully added, otherwise it returns false
     */
    public boolean addCourse(Course course, long idNum ){
        int index = searchStudent(idNum);
        if (index == -1)
            return false;
        int totalCredits = 0;
        Student student = getStudent(index);
        for (int i=0;i<student.getCoursesRegistered().size();i++) {
            if (student.getCoursesRegistered().get(i).equals(course))
                return false;
            totalCredits += student.getCoursesRegistered().get(i).getCredits();
        }
        totalCredits+=course.getCredits();
        if (student.getGPA() >3.00 && totalCredits <=21) {
            student.getCoursesRegistered().add(course);
            return true;
        }
        else if (totalCredits <=18) {
            student.getCoursesRegistered().add(course);
            return true;
        }
        else
            return false;
    }

    /**
     * Deletes a course for the given student's ID number.
     * <br> </br>
     *
     * this method searches for the student with passed ID Number, checks if the student has the course in the coursesRegistered,
     * calculates the total credits of the student, checks if the total credits after removal is valid then deletes the course and returns true,
     * if the credits after removal are invalid it will return false and print an error message.Also,if the student does not exist or
     * the course does not exist in the student's coursesRegistered it will return false.
     * @param course An object of type course to be deleted from the student's coursesRegistered
     * @param idNum The ID number of the student
     * @return true if the course has been successfully deleted from the student's coursesRegistered, otherwise returns false
     */
    public boolean deleteCourse(Course course , long idNum) {
        int index = searchStudent(idNum);
        if (index == -1)
            return false;
        Student student = getStudent(index);
        boolean found = false;
        for (int i = 0; i < student.getCoursesRegistered().size(); i++)
            if (course.equals(student.getCoursesRegistered().get(i))) {
                found = true;
                break;
            }
        int totalCredits =0;
        for (int i = 0;i<student.getCoursesRegistered().size();i++)
            totalCredits+=student.getCoursesRegistered().get(i).getCredits();
        if (found){
          int AfterDeleteCredits = totalCredits - course.getCredits();
          if (AfterDeleteCredits < 12 ) {
              System.out.println("the credits should be 12 or greater.");
              return false;
          }
          else{
              student.getCoursesRegistered().remove(course);
              return true;
          }
        }
        return false;
    }

    /**
     * Prints all the information of the student.
     * <br> </br>
     *
     * this method searches for the student with the passed ID number,
     * if the student is in the list the method prints all details of the student
     * , Otherwise it will print an error message
     * @param idNum the student ID number
     */
    public void printStudentDetails(long idNum){
        int index = searchStudent(idNum);
        if (index !=-1){
            Student student = getStudent(index);
            System.out.println("Student Details: ");
            System.out.println("Student ID: "+student.getIdNum());
            System.out.println("Student Name: "+student.getFirstName()+" "+student.getLastName());
            System.out.println("Student Gender: "+student.getGender());
            System.out.println("Student email: "+student.getEmail());
            System.out.println("Student GPA: "+student.getGPA());
            System.out.println("Advisor Number: "+student.getAdvisorNum());
            student.printCoursesRegistered();
        }
        else
            System.out.println("Student Does Not Exist.");
    }

    // printAdvisor method
    /**
     * Prints the advisor number.
     * <br> </br>
     * this method searches for the student with the passed ID number, if the student is in the list the method prints the advisor number of the student
     * , otherwise it will print an error message
     * @param idNum the ID of the student
     */
    public void printAdvisor(long idNum){
        int index = searchStudent(idNum);
        if (index !=-1){
            Student student = getStudent(index);
            System.out.println("Advisor Number: "+student.getAdvisorNum());
        }
        else
            System.out.println("Student Does Not Exist.");
    }

}
