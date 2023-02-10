import org.example.PokemonAPI;
import org.json.simple.JSONObject;
import org.junit.*;
import static org.junit.jupiter.api.Assertions.*;

public class PokemonAPITest {


    @Test
    public void generatePokemonTeamShouldReturnJSONObjectArraySize6(){
        PokemonAPI pokemonAPI = new PokemonAPI();
        JSONObject[] testJson = new JSONObject[6];
        int size = pokemonAPI.generatePokemonTeam(testJson).length;
        assertEquals(6, size);
    }


}
