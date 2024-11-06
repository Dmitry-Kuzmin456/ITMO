package Attack.SpecialMove;
import ru.ifmo.se.pokemon.*;


public class Ice_Beam extends SpecialMove {
    public Ice_Beam(){
        super(Type.ICE, 90, 100);
    }

    @Override
    protected void applyOppEffects(Pokemon var1) {
        if (Math.random() < 0.1) {
            Effect.freeze(var1);
        }
    }

    @Override
    protected String describe() {
        return "использует Ice_Beam";
    }
}
