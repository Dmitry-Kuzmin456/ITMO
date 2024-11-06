package my_pokemons;
import Attack.SpecialMove.Scald;

//public class Poliwrath extends Pokemon {
//    public Poliwrath(String name, int age) {
//        super(name, age);
//        this.setStats(90, 95, 95, 70, 90, 70);
//        this.setType(Type.WATER, Type.FIGHTING);
//        this.addMove(new Hypnosis());
//        this.addMove(new Ice_Beam());
//        this.addMove(new Hydro_Pump());
//        this.addMove(new Scald());
//    }
//}


public class Poliwrath extends Poliwhirl{
    public Poliwrath(String name, int age){
        super(name, age);
        this.setStats(90, 95, 95, 70, 90, 70);
        this.addMove(new Scald());
    }
}


