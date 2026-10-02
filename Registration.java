import java.util.Scanner;
/**
 * @author Mohamed Rabeea
 * @author Ali Hasan
 */
public class Registration {
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        Roster list = new Roster();
        System.out.println("Welcome to student information system (SIS)");
        System.out.println("Home:");
        int input;
        do {
            System.out.println("Enter 1 to add a Student");
            System.out.println("Enter 2 to add a Course to a Student");
            System.out.println("Enter 3 to delete a Student");
            System.out.println("Enter 4 to delete a Course from a student");
            System.out.println("Enter 5 to print Student Details");
            System.out.println("Enter 6 to print Advisor Number");
            System.out.println("Enter 7 to show number of students");
            System.out.println("Enter 8 to Exit");
            input = kbd.nextInt();

            switch (input){
                case 1:
                    System.out.println("Enter Student ID:");
                    long idNum = kbd.nextLong();
                    System.out.println("Enter Student First Name:");
                    String FirstName = kbd.next();
                    System.out.println("Enter Student Last Name:");
                    String LastName = kbd.next();
                    System.out.println("Enter Student Gender:");
                    char gender = kbd.next().charAt(0);
                    System.out.println("Enter Student Email:");
                    String email = kbd.next();
                    System.out.println("Enter Student GPA:");
                    double GPA= kbd.nextDouble();
                    System.out.println("Enter Advisor Number:");
                    long advisorNum = kbd.nextLong();
                    Student student = new Student(idNum,FirstName,LastName,gender,email,GPA,advisorNum);
                        if (list.addStudent(student))
                            System.out.println("Student successfully added.");
                        else
                            System.out.println("Student already exists in the list");
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Enter Student ID:");
                    long StuID = kbd.nextLong();
                    System.out.println("Enter Course Number ex:ITCS214: ");
                    String CourseNum = kbd.next();
                    kbd.nextLine(); //dummy read
                    System.out.println("Enter Course Name: ");
                    String CourseName = kbd.nextLine();
                    System.out.println("Enter Course Credits: ");
                    int credits = kbd.nextInt();
                    System.out.println("Enter Course section: ");
                    int section = kbd.nextInt();
                    Course course = new Course(CourseNum,CourseName,credits,section);
                    if (list.addCourse(course,StuID))
                        System.out.println("Course successfully added.");
                    else
                        System.out.println("Course cannot be added");
                    System.out.println();
                    break;

                case 3:
                    System.out.println("Enter Student ID:");
                    long DeletedIdNum = kbd.nextLong();
                    if (list.deleteStudent(DeletedIdNum))
                        System.out.println("Student Successfully Deleted.");
                    else
                        System.out.println("Student Does Not Exist.");
                    System.out.println();
                    break;
                case 4 :
                    System.out.println("Enter Student ID:");
                    long DelId = kbd.nextLong();
                    System.out.println("Enter Course Number ex:ITCS214: ");
                    String CoNum = kbd.next();
                    kbd.nextLine(); //dummy read
                    System.out.println("Enter Course Name: ");
                    String CoName = kbd.nextLine();
                    System.out.println("Enter Course Credits: ");
                    int cred = kbd.nextInt();
                    System.out.println("Enter Course section: ");
                    int sec = kbd.nextInt();
                    Course deleteCourse= new Course(CoNum,CoName,cred,sec);
                    if (list.deleteCourse(deleteCourse,DelId))
                        System.out.println("Course Successfully Deleted.");
                    else
                        System.out.println("Course Can not be Deleted.");
                    System.out.println();
                    break;

                case 5 :
                    System.out.println("Enter Student ID:");
                    long ID = kbd.nextLong();
                    list.printStudentDetails(ID);
                    System.out.println();
                    break;
                case 6 :
                    System.out.println("Enter Student ID: ");
                    int advisorStudentId = kbd.nextInt();
                    list.printAdvisor(advisorStudentId);
                    System.out.println();
                    break;
                case 7 :
                    System.out.println("Number of students: "+list.listSize());
                    System.out.println();
            }
        }while(input !=8);
    }
}
