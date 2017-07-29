package prototype.search.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import prototype.search.model.FoodShop;

@RestController
public class SearchController {

	private static final String SEARCH = "/search";
	
	@GetMapping(SEARCH)
	public ResponseEntity<FoodShop> search() {
		// TODO
		return null;
	}
	
}
