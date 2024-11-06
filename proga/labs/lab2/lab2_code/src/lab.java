import ru.ifmo.se.pokemon.*;
import my_pokemons.*;


public class lab {
    public static void main(String[] args) {
        Battle b = new Battle();
        Pokemon p1 = new Poliwag("Мелкий гипнозист", 1);
        Pokemon p2 = new Diancie("Алмазная штука", 1);
        Pokemon p3 = new Poliwrath("Большой гипнозист", 1);
        Pokemon p4 = new Poliwhirl("Средний гипнозист", 1);
        Pokemon p5 = new Diglett("Подземная утка", 1);
        Pokemon p6 = new Dugtrio("3 утки", 1);

        b.addAlly(p1);
        b.addAlly(p2);
        b.addAlly(p3);

        b.addFoe(p4);
        b.addFoe(p5);
        b.addFoe(p6);

        System.out.println();

        b.go();
    }
}
