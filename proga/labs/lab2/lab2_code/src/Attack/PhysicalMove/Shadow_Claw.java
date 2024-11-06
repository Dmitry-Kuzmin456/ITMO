package Attack.PhysicalMove;
import ru.ifmo.se.pokemon.*;


public class Shadow_Claw extends PhysicalMove{
    public Shadow_Claw(){
        super(Type.GHOST, 70, 100);
    }
// не знаю где здесь коэффициенты 1/8 и 1/24, поэтому просто увеличу шанс в 3 раза
    @Override
    protected double calcCriticalHit(Pokemon var1, Pokemon var2) {
        if ((3 * var1.getStat(Stat.SPEED)) / 512.0D > Math.random()) {
            System.out.println("критический");
            return 2.0D;
        } else {
            return 1.0D;
        }
    }

    @Override
    protected String describe() {
        return "использует Shadow_Claw";
    }
}
