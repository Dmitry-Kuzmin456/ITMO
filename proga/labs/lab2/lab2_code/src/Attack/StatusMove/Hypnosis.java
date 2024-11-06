package Attack.StatusMove;
import ru.ifmo.se.pokemon.*;


public class Hypnosis extends StatusMove{
    public Hypnosis(){
        super(Type.PSYCHIC, 0, 60);
    }

    @Override
    protected void applyOppEffects(Pokemon var1) {
        Effect.sleep(var1);
    }

    @Override
    protected String describe() {
        return "использует Hypnosis";
    }
}
