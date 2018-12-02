package pokemon.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PokemonInfo {
	@JsonProperty("no")
	private int id;

	@JsonProperty("name")
	private String name;
	
	@JsonProperty("form")
	private String form;
	
	@JsonProperty("isMegaEvolution")
	private boolean isMegaEvolution;
	
	@JsonProperty("evolutions")
	private List<Integer> evolutions;
	
	@JsonProperty("types")
	private List<String> types;
	
	@JsonProperty("abilities")
	private List<String> abilities;
	
	@JsonProperty("hiddenAbilities")	
	private List<String> hiddenAbilities;
	
	@JsonProperty("stats")
	private PokemonStatus status;
}
