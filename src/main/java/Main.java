import model.Student;
import service.StudentService;
import util.InputUtil;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static StudentService svc = new StudentService();
    public List<Student> students = new ArrayList<>();

    public static void main(String[] args) {

        while (true) {
            System.out.println("1) Add");
            System.out.println("2) Delete");
            System.out.println("3) Search");
            System.out.println("4) List");
            System.out.println("0) Exit");
            int choice = InputUtil.readInt("Choose: ");
            if (choice == 1) {
                int id = InputUtil.readInt("ID: ");
                String name = InputUtil.readString("Name: ");
                double gpa = InputUtil.readDouble("GPA: ");
                Student s = new Student(id, name, gpa);
                svc.addStudent(s);
                System.out.println("Added");
            } else if (choice == 2) {
                int id = InputUtil.readInt("ID to delete: ");
                if (svc.deleteStudent(id)) {
                    System.out.println("Deleted");
                } else {
                    System.out.println("Not found");
                }
            } else if (choice == 3) {
                String kw = InputUtil.readString("Search name: ");
                List<Student> res = svc.searchByName(kw);
                for (Student s : res) {
                    System.out.println(s);
                }
            } else if (choice == 4) {
                List<Student> list = svc.listAll();
                for (Student s : list) {
                    System.out.println(s);
                }
            } else if (choice == 0) {
                System.out.println("Bye");
                break;
            }
        }
    }
}
