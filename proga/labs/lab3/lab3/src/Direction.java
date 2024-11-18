public enum Direction {
    FORWARD(0),
    BACKWARD(180),
    RIGHT(90),
    LEFT(270);

    private final int directionInDegrees;

    Direction(int direction){
        this.directionInDegrees = direction;
    }

    public int getDirection(){
        return this.directionInDegrees;
    }

    public static Direction getByDirection(int direction){
        for (Direction dir: Direction.values()){
            if (dir.getDirection() == direction){
                return dir;
            }
        }
        return null;
    }
}
