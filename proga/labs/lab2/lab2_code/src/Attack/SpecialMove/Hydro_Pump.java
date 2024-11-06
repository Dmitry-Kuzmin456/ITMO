package Attack.SpecialMove;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Type;


public class Hydro_Pump extends SpecialMove {
    public Hydro_Pump(){
        super(Type.WATER, 110, 80);
    }
    protected String describe() {
        return "использует Hydro_Pump";
    }
}
