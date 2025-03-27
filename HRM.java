import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HRM {
    
    private List<Human> hrList;

    public HRM() {
        hrList = new ArrayList<Human>();
    }
    public void addHR(Human hm) {
        hrList.add(hm);
    }
    public void addHR(Scanner sc){
        int choice = 0;
        Human hm = null;
        do {
            System.out.println("\n1. Add lecturer, 2. Add student, 3. Exit");
            choice = sc.nextInt();
            sc.nextLine();
            if (choice == 1) {
                hm = new Lecturer();
                hm.enterInfo(sc);
                addHR(hm);
            }
            if (choice == 2) {
                hm = new Student();
                hm.enterInfo(sc);
                addHR(hm);
            }
        } while ((choice == 1) || (choice == 2));
    }
    public List<Human> getHRList() {
        return hrList;
    }
    public void printHRList(){
        System.out.println("--------------------");
        System.out.println("List of human resources: ");
        for (Human hm : hrList) {
            System.out.println(hm.getCode() + " - " + hm.getFullName());
        }
    }
    public void printLecturerInfo(){
        System.out.println("--------------------");
        System.out.println("List of lecturers: ");
        for (Human hm : hrList) {
            if (hm instanceof Lecturer) {
                System.out.println(hm.toString());
            }
        }
    }
    public void printStudentInfo(){
        System.out.println("--------------------");
        System.out.println("List of students: ");
        for (Human hm : hrList) {
            if (hm instanceof Student) {
                System.out.println(hm.getFullName() + " - " + hm.getCode() + " - " + ((Student)hm).getClass_());
            }
        }
    }
    public void searchHuman(String code){
        System.out.println("--------------------");
        System.out.println("Search result: ");
        for (Human hm : hrList) {
            if (hm.getCode().equals(code)) {
                System.out.println(hm.toString());
                return;
            }
        }
        System.out.println("Not found!");
    }
    public void initDemoData(){
        Student st1 = new Student("634245", "Nguyen Van A", "KTPM2018");
        Subject sb1 = new Subject("IT111", "Java", 3);
        sb1.setAttendanceMark(9.0f);
        sb1.setmidExamMark(8.0f);
        sb1.setFinalExamMark(7.0f);
        Subject sb2 = new Subject("IT112", "C#", 2);
        sb2.setAttendanceMark(8.5f);
        sb2.setmidExamMark(7.5f);
        sb2.setFinalExamMark(9.5f);
        st1.addSubject(sb1);
        st1.addSubject(sb2);
        Student st2 = new Student("648214", "Tran Thi B", "KTPM2018");
        Subject sb3 = new Subject("IT111", "Java", 3);
        sb3.setAttendanceMark(7.0f);
        sb3.setmidExamMark(6.0f);
        sb3.setFinalExamMark(8.0f);
        Subject sb4 = new Subject("IT112", "C#", 2);
        sb4.setAttendanceMark(8.0f);
        sb4.setmidExamMark(7.0f);
        sb4.setFinalExamMark(9.0f);
        st2.addSubject(sb3);
        st2.addSubject(sb4);
        Lecturer lt1 = new Lecturer("cnt02", "Tran Van C", "Khoa CNTT");
        Lecturer lt2 = new Lecturer("cnt03", "Nguyen Thi D", "Khoa CNTT");
        addHR(st1); 
        addHR(lt1);
        addHR(st2);
        addHR(lt2);
    }
    public void initDemoData(Scanner sc){
        String option = "n";
        do {
            addHR(sc);
            System.out.print("Do you want to continue (y/n)? ");
            option = sc.nextLine();
        } while (option.equalsIgnoreCase("y"));
    }
    public static void main(String[] args) {
        HRM hrm = new HRM();
        Scanner sc = new Scanner(System.in);
        hrm.initDemoData();
        hrm.initDemoData(sc);
        hrm.printHRList();
        hrm.printLecturerInfo();
        hrm.printStudentInfo();
        System.out.print("Enter code to search: ");
        String code = sc.nextLine();
        hrm.searchHuman(code);
        sc.close();
    }
}
