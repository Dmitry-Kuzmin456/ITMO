package my_pokemons;
import Attack.SpecialMove.Sludge_Wave;


public class Dugtrio extends Diglett{
    public Dugtrio(String name, int age){
        super(name, age);
        this.setStats(35, 100, 50, 50, 70, 120);
        this.addMove(new Sludge_Wave());
    }
}
