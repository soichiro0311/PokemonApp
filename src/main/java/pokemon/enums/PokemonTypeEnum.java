package pokemon.enums;

import java.util.Arrays;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PokemonTypeEnum {
	LEAF("くさ","leaf"),
	ESPER("エスパー","esper"),
	WATER("みず","water"),
	FIRE("ほのお","fire"),
	ROCK("いわ","rock"),
	ELECTRICAL("でんき","electrical"),
	FLY("ひこう","fly"),
	NORMAL("ノーマル","normal"),
	FIGHT("かくとう","fight"),
	GHOST("ゴースト","ghost"),
	DRAGON("ドラゴン","dragon"),
	EVIL("あく","evil");
	
	private String name_jp;
	
	private String name_en;
	
	public static PokemonTypeEnum fromNameJp(String name_jp) {
		return Arrays.asList(values()).stream().filter(type -> type.name_jp.equals(name_jp)).findFirst().get();
	}
	
	public static PokemonTypeEnum fromNameEn(String name_en) {
		return Arrays.asList(values()).stream().filter(type -> type.name_en.equals(name_en)).findFirst().get();
	}
}
