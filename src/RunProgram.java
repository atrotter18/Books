import java.util.List;
import java.util.Scanner;
import model.BookItems;


public class RunProgram {
	static Scanner input = new Scanner(System.in);
	static Helper start = new Helper();

	private static void addBook() {
		// TODO Auto-generated method stub
		System.out.print("Enter a genre: ");
		String genre = input.nextLine();
		System.out.print("Enter an book name: ");
		String bookName = input.nextLine();
		BookItems toAdd = new BookItems(genre,bookName);
		start.insertItem(toAdd);

	}
	private static void deleteBook() {
		// TODO Auto-generated method stub
		System.out.print("Enter the book name to delete: ");
		String bookName = input.nextLine();
		System.out.print("Enter the genre to delete: ");
		String genre = input.nextLine();
		BookItems toDelete = new BookItems(bookName, genre);
		start.deleteItem(toDelete);

	}
	
	private static void showTheList() {
		List<BookItems>allBooks = input.showAllBooks();
		for(BookItems singleItem:allBooks) {
			System.out.println(singleItem.returnBookInfo());
		}
	}
}
