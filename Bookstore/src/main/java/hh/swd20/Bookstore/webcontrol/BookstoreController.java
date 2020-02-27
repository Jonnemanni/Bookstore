package hh.swd20.Bookstore.webcontrol;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.BookRepository;

@Controller
public class BookstoreController {
	
	@Autowired
	BookRepository bookRepository;
	
	//Kirja lista
	@RequestMapping(value="/booklist", method = RequestMethod.GET)
	public String book(Model model) {
		List<Book> books = (List<Book>) bookRepository.findAll();
		model.addAttribute("books", books);
		return "booklist"; //carlist.html
	}
	
	// Tyhjä kirja lomake
	@RequestMapping(value = "/newbook", method = RequestMethod.GET)
	public String getNewBookForm(Model model) {
		model.addAttribute("book", new Book()); // "tyhjä" auto-olio
		return "bookform";
	}

	// kirja lomakkeen tietojen talletus
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveBook(@ModelAttribute Book book) {
		// talletetaan yhden kirjan tiedot tietokantaan
		bookRepository.save(book);
		return "redirect:/booklist";
	}
	
	// Täysi kirja lomake
	@RequestMapping(value = "/editbook/{id}", method = RequestMethod.GET)
	public String getEditBookForm(Model model, @PathVariable("id") Long bookId) {
		model.addAttribute("book", bookRepository.findById(bookId)); // täys auto-olio
		return "editform";
	}
	
	// kirja lomakkeen tietojen talletus
		@RequestMapping(value = "/saveedit", method = RequestMethod.POST)
		public String saveEdit(@ModelAttribute Book book) {
			// talletetaan yhden kirjan tiedot tietokantaan
			bookRepository.save(book);
			return "redirect:/booklist";
		}

	// auton poisto
	@RequestMapping(value = "/deletebook/{id}", method = RequestMethod.GET)
	public String deleteCar(@PathVariable("id") Long bookId) {
		bookRepository.deleteById(bookId);
		return "redirect:../booklist";
	}
		
	
}
