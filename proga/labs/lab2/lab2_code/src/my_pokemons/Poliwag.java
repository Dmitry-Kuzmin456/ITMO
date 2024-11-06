package my_pokemons;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;
import Attack.StatusMove.Hypnosis;
import Attack.SpecialMove.Ice_Beam;

public class Poliwag extends Pokemon {
    public Poliwag(String name, int age) {
        super(name, age);
        this.setStats(40, 50, 40, 40, 40, 90);
        this.setType(Type.WATER);
        this.addMove(new Hypnosis());
        this.addMove(new Ice_Beam());
    }
}
