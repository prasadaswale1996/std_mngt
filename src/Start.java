import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.student.manage.ConnectionProvider;
import com.student.manage.Student;
import com.student.manage.StudentDao;

public class Start {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		System.out.println("WELCOME TO STUDEMT MANAGEMENT APP");
	
	while(true) {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));	
//		 above step -> to take input from user
		System.out.println("PRESS 1 TO ADD STUDENT");
		System.out.println("PRESS 2 TO DELETE STUDENT");
		System.out.println("PRESS 3 TO DISPLAY STUDENT");
		System.out.println("PRESS 4 TO EXIT APP");
		
		int c = Integer.parseInt(br.readLine());
		
		if(c==1) {
//			add student
			System.out.println("Enter user name :");
			String name= br.readLine();
			
			System.out.println("Enter user Phine :");
			String phone= br.readLine();
			
			System.out.println("Enter user city :");
			String city=br.readLine();
			
			// create student object to store student
			Student std= new Student(name, phone, city);
			boolean flag = StudentDao.insertStudentToDb(std);
			
			if(flag) {
				System.out.println("Student added to Db succesfully");
			}else {
				System.out.println("something went wrong, failed to add student to DB");
				System.out.println("Try Again...");
			}
			System.out.println(std);		
			
			
		}else if(c==2) {
//			delete student
			System.out.println("Enter Student id to delete :");
			int stdid = Integer.parseInt(br.readLine());
			boolean flag = StudentDao.deleteStudentFromDb(stdid);
			if(flag) {
				System.out.println("Student deleted from Db succesfully");
			}else {
				System.out.println("something went wrong, failed to delete student from DB");
				System.out.println("Try Again...");
			}
			
			
		}else if(c==3) {
//			display student
			System.out.println("Student data from DB");
			StudentDao.showAllStudents();
			
			
		}else if(c==4) {
//			exit app
			ConnectionProvider.closeDbConnection();
			break;
		}else {
			
		}
			
		
		
	}
		
	System.out.println("Thank you for using my application...");
	System.out.println("See you soon...");
	
	}

}
