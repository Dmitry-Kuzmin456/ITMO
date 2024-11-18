public class Knopochka extends Character {
    public Knopochka(Places place) {
        super("Кнопочка", place);
    }

    public Knopochka(Places place, Direction direction, int position) {
        super("Кнопочка", place, direction, position);
    }

    public Knopochka(Places place, Direction direction, int position, WaterHose<Character> waterHose) {
        super("Кнопочка", place, direction, position, waterHose);
    }
}