package pokemon.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pokemon.enums.PokemonTypeEnum;
import pokemon.model.PokemonInfo;
import pokemon.repository.PokemonInfoRepository;

@Service
@RequiredArgsConstructor
public class SearchService {
	private final PokemonInfoRepository pokemonInfoRepository;
	
	public PokemonInfo findById(int id) {
		return pokemonInfoRepository.findById(id);
	}
	
	public List<PokemonInfo> findByType(String type){
		return pokemonInfoRepository.findByType(PokemonTypeEnum.fromNameEn(type).getName_jp());
	}
}
