package my_pokemons;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;
import Attack.PhysicalMove.Magnitude;
import Attack.PhysicalMove.Shadow_Claw;
import Attack.SpecialMove.Mud_Bomb;


public class Diglett extends Pokemon{
    public Diglett(String name, int age){
        super(name, age);
        this.setStats(500, 55, 25, 35, 45, 95);
        this.setType(Type.GROUND);
        this.addMove(new Shadow_Claw());
        this.addMove(new Mud_Bomb());
        this.addMove(new Magnitude());
    }
}
