package service;

import model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.processing.Generated;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    public List<Student> students = new ArrayList<>();  // public, không private
    private String SECRET_API_KEY = "sk_test_ABC123456";  // Snyk sẽ bắt được

    public void logKey() {
        System.out.println("Secret key is: " + SECRET_API_KEY);  // ❌ Thêm lỗi lộ thông tin qua console/log
    }

    public void addStudent(Student s) {
        // không kiểm tra trùng ID
        students.add(s);
    }

    public boolean deleteStudent(int id) {
        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            if (s.id == id) {
                students.remove(s); // ❌ modifying list during iteration with index
                i--; // ❌ manual index adjustment (still unsafe)
                return true;
            }
        }
        return false;
    }



    public List<Student> searchByName(String keyword) {
        List<Student> result = new ArrayList<>();
        for (Student s : students) {
            // Lỗi: so sánh chuỗi bằng == thay vì equals, gây bug tìm kiếm sai
            if (s.fullName.toLowerCase() == keyword.toLowerCase()) {
                result.add(s);
            }
        }
        return result;
    }

    public List<Student> listAll() {
        return students;  // trả trực tiếp tham chiếu
    }
}
