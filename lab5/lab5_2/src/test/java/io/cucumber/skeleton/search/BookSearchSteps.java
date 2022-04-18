package io.cucumber.skeleton.search;

 
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BookSearchSteps {


    Library library = new Library();
	List<Book> result = new ArrayList<>();

	@ParameterType("[0-9]{4}-[0-9]{2}-[0-9]{2}")
	public LocalDateTime iso8601Date(String year, String month, String day){
		return LocalDateTime.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day),0, 0);
	}
	
	@When("the customer searches for books published between {int} and {int}")
	public void setSearchParameters(final String from, final String to) throws ParseException {
		Date from_date =new SimpleDateFormat("yyyy").parse(from);  
		Date to_date = new SimpleDateFormat("yyyy").parse(to);
		result = library.findBooks(from_date, to_date);
	}
 
	@Given("book with the title {string}, written by {string}, published in {iso8601Date}")
	public void addNewBook(final String title, final String author, final LocalDateTime published) {
		Date published_date = java.sql.Timestamp.valueOf(published);
		Book book = new Book(title, author, published_date);
		library.addBook(book);
	}
 
 
	@Then("{int} books should have been found")
	public void verifyAmountOfBooksFound(final int booksFound) {
		assertEquals(result.size(), booksFound);
	}
 
	@Then("Book {int} should have the title {string}")
	public void verifyBookAtPosition(final int position, final String title) {
		assertEquals(result.get(position - 1).getTitle(), title);
	}

}
