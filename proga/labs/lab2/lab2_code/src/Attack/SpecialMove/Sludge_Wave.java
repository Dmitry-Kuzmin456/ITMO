package Attack.SpecialMove;
import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Type;


public class Sludge_Wave extends SpecialMove {
    public Sludge_Wave(){
        super(Type.POISON, 95, 100);
    }

    @Override
    protected void applyOppEffects(Pokemon var1) {
        if ((Math.random() < 0.1) && (!(var1.hasType(Type.POISON))) && (!(var1.hasType(Type.STEEL)))){
            Effect.poison(var1);
        }
    }

    @Override
    protected String describe() {
        return "использует Sludge_Wave";
    }
}
