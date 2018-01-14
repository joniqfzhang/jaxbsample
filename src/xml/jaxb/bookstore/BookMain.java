package xml.jaxb.bookstore;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import xml.jaxb.bookstore.model.Book;
import xml.jaxb.bookstore.model.Bookstore;

public class BookMain {
	private static final String BOOKSTORE_XML = "./bookstore-jaxb.xml";
	
	public static void main(String[] args) throws JAXBException, FileNotFoundException {
		ArrayList<Book> bookList = new ArrayList<Book>();
		
		// Create books
		Book book1 = new Book();
        book1.setIsbn("978-0060554736");
        book1.setName("The Game");
        book1.setAuthor("Neil Strauss");
        book1.setPublisher("Harpercollins");
        bookList.add(book1);

        Book book2 = new Book();
        book2.setIsbn("978-3832180577");
        book2.setName("Feuchtgebiete");
        book2.setAuthor("Charlotte Roche");
        book2.setPublisher("Dumont Buchverlag");
        bookList.add(book2);

        // Create bookstore, assigning book
        Bookstore bookstore = new Bookstore();
        bookstore.setName("Fraport Bookstore");
        bookstore.setLocation("Frankfurt Airport");
        bookstore.setBookList(bookList);
        
        // Create JAXB instantiate marshaller
        JAXBContext context = JAXBContext.newInstance(Bookstore.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        
        // Write to System.out
        m.marshal(bookstore, System.out);
        
        // Write to a file
        m.marshal(bookstore, new File(BOOKSTORE_XML));
        
        // get variables from our xml file, created before
        System.out.println();
        System.out.println("Output from our XML File: ");
        Unmarshaller um = context.createUnmarshaller();
        Bookstore bookstore2 = (Bookstore) um.unmarshal(new FileReader(BOOKSTORE_XML));
        System.out.println("BookStore: " + bookstore2.toString());
        ArrayList<Book> list = bookstore2.getBooksList();
        for (Book book : list) {
            System.out.println("Book: " + book.toString());
        }
	}
}
