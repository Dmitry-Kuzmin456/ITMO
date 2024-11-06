package Attack.SpecialMove;
import ru.ifmo.se.pokemon.*;

import java.util.Arrays;


public class Scald extends SpecialMove {
    public Scald(){
        super(Type.WATER, 80, 100);
    }

    @Override
    protected void applyOppEffects(Pokemon var1) {
        if ((Math.random() < 0.3) && (!(var1.hasType(Type.FIRE)))){
            Effect.burn(var1);
        }
    }

    @Override
    protected String describe() {
        return "использует Scald";
    }
}
