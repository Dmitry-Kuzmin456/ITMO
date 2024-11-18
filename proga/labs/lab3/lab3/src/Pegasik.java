public class Pegasik extends Character {
    public Pegasik(Places place) {
        super("Пегасик", place);
    }

    public Pegasik(Places place, Direction direction, int position) {
        super("Пегасик", place, direction, position);
    }

    public Pegasik(Places place, Direction direction, int position, WaterHose<Character> waterHose) {
        super("Пегасик", place, direction, position, waterHose);
    }
}