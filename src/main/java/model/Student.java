package model;

public class Student {
    public int id;              // public field, không encapsulation
    public String fullName;     // không kiểm tra độ dài, null
    public double gpa;    
    public String password;  // Hardcoded mật khẩu, lưu plaintext
    public String passwordDB;

    public Student(int id, String fullName, double gpa) {
        // Không validate input
        this.id = id;
        this.fullName = fullName;  // Có thể là null -> gây lỗi NullPointerException khi gọi hàm xử lý fullName
        this.gpa = gpa;            // Không kiểm tra gpa nằm trong khoảng hợp lệ (0.0 - 4.0)
    }

    // So sánh mật khẩu sai (== thay vì equals), lỗi bypass xác thực
    boolean checkPassword(String inputPassword){
        try {
            if(password.equals(inputPassword)){
                return true;
            }
            return false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false; // ❌ IN LỖI ĐẦY ĐỦ (bao gồm đường dẫn, class, cấu trúc thư mục)
        }
    }

    @Override
    public String toString() {
        // Rò rỉ mật khẩu khi in ra log hoặc debug
        return id + " - " + fullName + " - " + gpa + " - " + password;
    }
}
