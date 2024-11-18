public interface Movement {
    String turnAround();
    String turnTo(Character character);
    String come(Places place);
    String leave();
    String comeUp(Character character);
    String pushAway(Character character);
}
