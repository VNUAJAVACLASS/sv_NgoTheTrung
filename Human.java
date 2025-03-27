import java.util.Scanner;

public class Human {

    protected String fullName;
    protected String code;
    protected String address;
    public Human() {
        this.code = "xxxx";
    }
    public Human(String code) {
        this.code = code;
    }
    public Human(String code, String fullName) {
        this.fullName = fullName;
        this.code = code;
    }
    public Human(String code, String fullName, String address) {
        this.fullName = fullName;
        this.code = code;
        this.address = address;
    }
    public void enterInfo(Scanner sc){
        System.out.print("Enter code: ");
        code = sc.nextLine();
        System.out.print("Enter full name: ");
        fullName = sc.nextLine();
        System.out.print("Enter address: ");
        address = sc.nextLine();
    }
    public String getAddress() {
        return address;
    }
    public String getCode() {
        return code;
    }
    public String getFullName() {
        return fullName;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    @Override
    public String toString() {
        return "Fullname: " + fullName + ", Address: " + address + ", Code: " + code;
    }
}
