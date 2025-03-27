import java.util.Scanner;

public class Lecturer extends Human {
    
    private String password;

    public Lecturer() {
    }
    public Lecturer(String code, String password) {
        super(code);
        this.password = password;
    }
    public Lecturer(String code, String fullName, String address) {
        super(code, fullName, address);
    }
    public void enterInfo(Scanner sc){
        super.enterInfo(sc);
        System.out.print("Enter password: ");
        password = sc.nextLine();
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
