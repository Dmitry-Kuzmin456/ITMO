package Attack.PhysicalMove;
import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.*;
import java.lang.Math;


public class Magnitude extends PhysicalMove{


    public Magnitude(){
        super(Type.GROUND, 0, 100);


    }

    @Override
    protected double calcBaseDamage(Pokemon var1, Pokemon var2) {
        int x = (int)(Math.random() * 20);
        int RandomDamage = switch(x){
            case 0 -> 10;
            case 1, 2 -> 30;
            case 3, 4, 5, 6 -> 50;
            case 7, 8, 9, 10, 11, 12 -> 70;
            case 13, 14, 15, 16 -> 90;
            case 17, 18 -> 110;
            case 19 -> 150;
            default -> 0;
        };
        return (0.4D * (double)var1.getLevel() + 2.0D) * RandomDamage / 150.0D;
    }

    @Override
    protected String describe() {
        return "использует Magnitude" + "  " + this.power;
    }
}

