package Attack.SpecialMove;
import ru.ifmo.se.pokemon.*;


public class Mud_Bomb extends SpecialMove {
    public Mud_Bomb(){
        super(Type.GROUND, 65, 85);
    }

    @Override
    protected void applyOppEffects(Pokemon var1) {
        if (Math.random() < 0.3) {
            var1.setMod(Stat.ACCURACY, -1);
        }
    }

    @Override
    protected String describe() {
        return "использует Mud_Bomb";
    }
}
