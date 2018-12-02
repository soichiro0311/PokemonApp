package pokemon.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import pokemon.model.PokemonInfo;
import pokemon.service.SearchService;

@RestController
@RequiredArgsConstructor
public class SearchController {
	private final SearchService searchService;

	@RequestMapping(path = "/find/id/{id}", method = RequestMethod.GET)
	public PokemonInfo findById(@PathVariable int id) {
		return searchService.findById(id);
	}
	
	@RequestMapping(path = "/find/type/{type}", method = RequestMethod.GET)
	public List<PokemonInfo> findByType(@PathVariable String type) {
		return searchService.findByType(type);
	}
}
