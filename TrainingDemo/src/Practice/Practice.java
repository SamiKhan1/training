package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Practice {

	public static void main(String[] args) {

		try {
			
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/library", "root", "");
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("select * from tbl_author");

			while (rs.next()) {
				System.out.println("####################");
				System.out.println("AuthorId:" + rs.getInt("authorId"));
				System.out
						.println("Author Name: " + rs.getString("authorName"));
				System.out.println("####################");
			}
			
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter a new Author Name: ");
			
			String author = scan.next();
			
			stmt.executeUpdate("insert into tbl_author (authorName) values ('" + author + "')");
			
			System.out.println("Added new author");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
try {
			
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/library", "root", "");
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("select * from tbl_publisher");

			while (rs.next()) {
				System.out.println("####################");
				System.out.println("PublisherId:" + rs.getInt("publisherId"));
				System.out
						.println("Publisher Name: " + rs.getString("publisherName"));
				System.out.println("####################");
			}
			
			Scanner scan = new Scanner(System.in);
			
			System.out.println("Enter a new Publisher Name: ");
			String publisher = scan.next();
			//stmt.executeUpdate("insert into tbl_publisher (publisherName) values ('" + publisher + "')");
			
			System.out.println("Enter a new Publisher Address: ");
			String publisherAddress = scan.next();
			//stmt.executeUpdate("insert into tbl_publisher (publisherAddress) values ('" + publisherAddress + "')");
			
			System.out.println("Enter a new Publisher Phone Number: ");	
			String publisherPhone = scan.next();	
			stmt.executeUpdate("insert into tbl_publisher (publisherName,publisherAddress,publisherPhone) values ('" + publisher + "', '" + publisherAddress + "', '" + publisherPhone + "')");
			
			System.out.println("Added new publisher");
			System.out.println("Added new address");
			System.out.println("Added new phone");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
