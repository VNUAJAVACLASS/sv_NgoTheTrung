import java.util.Scanner;

public class Subject {

    private String subjectCode;
    private String subjectName;
    private int credit;
    private float attendanceMark;
    private float midExamMark;
    private float finalExamMark;

    public Subject() {
    }
    public Subject(String subjectCode, String subjectName, int credit) {
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
        this.credit = credit;
    }
    public float calcSubjectMark() {
        return (float)(attendanceMark * 0.1 + midExamMark * 0.3 + finalExamMark * 0.6);
    }
    public float calcConversionMark(){
        float subjectMark = calcSubjectMark();
        if (subjectMark > 8.4) return (float)4.0;
        if (subjectMark > 7.4) return (float)3.5;
        if (subjectMark > 6.9) return (float)3.0;
        if (subjectMark > 6.4) return (float)2.5;
        if (subjectMark > 5.4) return (float)2.0;
        if (subjectMark > 4.9) return (float)1.5;
        if (subjectMark > 3.9) return (float)1.0;
        if (subjectMark <= 3.9) return (float)0.0;
        return -1;
    }
    public float calcConversionMark(String grade){
        if (grade.equals("A")) return (float)4.0;
        if (grade.equals("B+")) return (float)3.5;
        if (grade.equals("B")) return (float)3.0;
        if (grade.equals("C+")) return (float)2.5;
        if (grade.equals("C")) return (float)2.0;
        if (grade.equals("D+")) return (float)1.5;
        if (grade.equals("D")) return (float)1.0;
        if (grade.equals("F")) return (float)0.0;
        return -1;
    }
    public String calcGrade(){
        float subjectMark = calcSubjectMark();
        if (subjectMark > 8.4) return "A";
        if (subjectMark > 7.4) return "B+";
        if (subjectMark > 6.9) return "B";
        if (subjectMark > 6.4) return "C+";
        if (subjectMark > 5.4) return "C";
        if (subjectMark > 4.9) return "D+";
        if (subjectMark > 3.9) return "D";
        if (subjectMark <= 3.9) return "F";
        return "Error";
    }
    public int getCredit() {
        return credit;
    }
    public void setAttendanceMark(float attendanceMark) {
        if ((attendanceMark >= 0) && (attendanceMark <= 10))
            this.attendanceMark = attendanceMark;
        else System.out.println("Invalid attendance mark!");
    }
    public void setmidExamMark(float midExamMark) {
        if ((midExamMark >= 0) && (midExamMark <= 10))
            this.midExamMark = midExamMark;
        else System.out.println("Invalid mid exam mark!");
    }
    public void setFinalExamMark(float finalExamMark) {
        if ((finalExamMark >= 0) && (finalExamMark <= 10))
            this.finalExamMark = finalExamMark;
        else System.out.println("Invalid final exam mark!");
    }
    public void enterInfo(Scanner sc){
        System.out.print("Enter subject code: ");
        subjectCode = sc.nextLine();
        System.out.print("Enter subject name: ");
        subjectName = sc.nextLine();
        System.out.print("Enter credit: ");
        credit = sc.nextInt();
        System.out.print("Enter attendance mark: ");
        setAttendanceMark(attendanceMark = sc.nextFloat());
        System.out.print("Enter mid exam mark: ");
        setmidExamMark(midExamMark = sc.nextFloat());
        System.out.print("Enter final exam mark: ");
        setFinalExamMark(finalExamMark = sc.nextFloat());
    }
    @Override
    public String toString() {
        return subjectCode + " - " + subjectName + " - " + credit + " - " + calcSubjectMark() + " - " + calcConversionMark() + " - " + calcGrade();
    }
}
