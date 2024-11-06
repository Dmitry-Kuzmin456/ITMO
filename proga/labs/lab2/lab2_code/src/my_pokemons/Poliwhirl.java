package my_pokemons;
import Attack.SpecialMove.Hydro_Pump;


public class Poliwhirl extends Poliwag{
    public Poliwhirl(String name, int age){
        super(name, age);
        this.setStats(65, 65, 65, 50, 50, 90);
        this.addMove(new Hydro_Pump());
    }
}



