package pokemon.repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import pokemon.model.PokemonInfo;
@Repository
@Slf4j
public class PokemonInfoRepository{
	private final ConcurrentHashMap<Integer,PokemonInfo> pokemonInfoCache=new ConcurrentHashMap<>();
	
	@PostConstruct
	public void loadFromJson() {
		String data = "";
		try{
            File file = new File("src/main/resources/static/pokemon_data.json");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String str = br.readLine();
            while(str != null){
                data += str;
                str = br.readLine();
            }
            br.close();
        }catch(IOException e){
            log.error("Cannot read data_file" , e);
        }

		try {
			JSONArray jsonArray = new JSONArray(data);
			ObjectMapper om = new ObjectMapper();
			
			for(int i =0; i<jsonArray.length(); i++) {
				JSONObject json=jsonArray.getJSONObject(i);
				PokemonInfo info = om.readValue(json.toString(),PokemonInfo.class);
				pokemonInfoCache.put(info.getId(), info);
			}
		} catch (JSONException | IOException e) {
			log.error("Cannot convert json to object" , e);
		}
	}
	
	public PokemonInfo findById(int id) {
		return pokemonInfoCache.get(id);
	}
	
	public List<PokemonInfo> findByType(String type) {
		log.info(type);
		return pokemonInfoCache.values().stream().filter(info -> info.getTypes().contains(type)).collect(Collectors.toList());
	}
	
	
}
