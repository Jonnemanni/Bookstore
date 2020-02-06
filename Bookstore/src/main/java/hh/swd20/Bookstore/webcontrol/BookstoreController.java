package hh.swd20.Bookstore.webcontrol;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookstoreController {
	
	@GetMapping("/index")
	public String book(Model model) {
		return "welcome";
	}
	
}
