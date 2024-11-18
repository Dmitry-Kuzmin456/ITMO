public interface WaterHoseUser<T> {
    boolean isHaveWaterHose();
    WaterHose<T> waterHoseInArms();
    void takeWaterHose(WaterHose<T> waterHose);
    void lostWaterHose();
}
