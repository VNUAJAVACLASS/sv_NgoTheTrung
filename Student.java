import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Student extends Human{

    private String class_;
    private List<Subject> subjectList = new ArrayList<Subject>();

    public Student() {}
    public Student(String code) {
        super(code);
    }
    public Student(String code, String fullName) {
        super(code, fullName);
    }
    public Student(String code, String fullName, String class_) {
        super(code, fullName);
        this.class_ = class_;
    }
    public Student(String code, String fullName, String class_, String address) {
        super(code, fullName, address);
        this.class_ = class_;
    }
    public void addSubject(Subject subject) {
        subjectList.add(subject);
    }
    public float calcTermAverageMark(){
        float sumCredit = 0;
        float sumMark4 = 0;
        for (Subject subject : subjectList) {
            sumCredit += subject.getCredit();
            sumMark4 += subject.calcConversionMark()*subject.getCredit();
        }
        return sumMark4 / sumCredit;
    }
    public String getClass_() {
        return class_;
    }
    public void setClass_(String class_) {
        this.class_ = class_;
    }
    public void enterInfo(Scanner sc){
        super.enterInfo(sc);
        System.out.print("Enter class: ");
        class_ = sc.nextLine();
        System.out.print("Enter number of subjects: ");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            Subject subject = new Subject();
            subject.enterInfo(sc);
            addSubject(subject);
        }
    }
    @Override
    public String toString() {
        String s = super.toString() + ", Class: " + class_;
        for (Subject subject : subjectList) {
            s += "\n" + subject.toString();
        }
        if (subjectList.size() > 0) {
            s += "\nTerm average mark: " + calcTermAverageMark();
        }
        return s;
    }
}
