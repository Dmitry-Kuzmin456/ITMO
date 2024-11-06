package my_pokemons;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;
import Attack.PhysicalMove.Facade;
import Attack.SpecialMove.Dazzling_Gleam;
import Attack.StatusMove.Double_Team;
import Attack.StatusMove.Harden;

public class Diancie extends Pokemon {
    public Diancie(String name, int age){
        super(name, age);
        this.setStats(50, 100, 150, 100, 150, 50);
        this.setType(Type.ROCK, Type.FAIRY);
        this.addMove(new Double_Team());
        this.addMove(new Facade());
        this.addMove(new Harden());
        this.addMove(new Dazzling_Gleam());
    }

}
