package Attack.StatusMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;


public class Double_Team extends StatusMove {
    public Double_Team(){
        super(Type.NORMAL, 0, 100);
    }

    @Override
    protected void applySelfEffects(Pokemon var1) {
        var1.setMod(Stat.EVASION, 1);
    }

    @Override
    protected String describe() {
        return "использует Double_Team";
    }
}
