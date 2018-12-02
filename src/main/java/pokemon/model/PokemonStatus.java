package pokemon.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PokemonStatus {
	private int hp;
	private int attack;
	private int defence;
	private int spAttack;
	private int spDefence;
	private int speed;

}
