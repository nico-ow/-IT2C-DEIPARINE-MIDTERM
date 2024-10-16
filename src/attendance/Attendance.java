
 
 
package attendance;
import java.util.Scanner;

public class Attendance {


    
    public void addStu(){
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        System.out.print("First Name: ");
        String fname = sc.next();
        System.out.print("Last Name: ");
        String lname = sc.next();
        System.out.print("Date: ");
        String date = sc.next();
        System.out.print("Status:");
        String status = sc.next();
        System.out.print("Time In: ");
        String time = sc.next();
        System.out.print("Remarks: ");
        String remarks = sc.next();
        
        
        String sql = "INSERT INTO tbl_atten (s_fname, s_lname, date, status,time, remarks) VALUES (?,?, ?, ?, ?, ?)";
        conf.addRecord(sql, fname, lname, date, status, time, remarks);
    }
        
    private void viewStu() {
        String cqry = "SELECT * FROM tbl_atten";
        String[] votersHeaders = {"ID", "FIRST NAME", "LAST NAME", "DATE", "STATUS" , "TIME" ,"REMARKS"};
        String[] votersColumns = {"attendance_id", "s_fname", "s_lname", "date", "status", "time", "remarks"};
        config conf = new config();
        conf.viewRecords(cqry, votersHeaders, votersColumns);
    }
    private void updateStu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ID:");
        int attendnace_id = sc.nextInt();
        System.out.println("Enter the new status:");
        String status = sc.next();
        System.out.println("Enter the new time:");
        String time = sc.next();
        System.out.println("Enter the new remarks:");
        String remarks = sc.next();
        String qry = "UPDATE tbl_atten SET status = ?, time = ?, remarks = ? WHERE attendance_id = ?";
        config conf = new config();
        conf.updateRecord(qry, status, time, remarks, attendnace_id);
    }
    private void deleteStu(){
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the ID to Delete: ");
        int attendance_id = sc.nextInt();
        String qry = "DELETE FROM tbl_atten WHERE attendance_id = ?";
        config conf = new config();
        conf.deleteRecord(qry, attendance_id);
    }
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String response;
    do {
        System.out.println("1. Add");
        System.out.println("2. View");
        System.out.println("3. Update");
        System.out.println("4. Delete");
        System.out.println("Enter Action: ");
        int action = sc.nextInt();
        Attendance demo = new Attendance();
        switch (action) {
            case 1:                
                demo.addStu();
                break;
            case 2:              
                demo.viewStu();
                break;
            case 3:
                demo.updateStu();
                break;
            case 4:
                demo.deleteStu();
                break;
        }
        System.out.println("Continue (yes/no): ");
        response = sc.next();
    } while (response.equals("yes"));
    System.out.println("Thank you, See you soon!");
}
}       
 
       
    
    

