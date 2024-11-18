import java.util.Objects;

public class Character extends People implements Movement, WaterHoseUser<Character>{
    private WaterHose<Character> waterHose;
    private StatementsOfCharacter statement;
    private Direction direction;
    private int position;

    private static DescribeActions comeUpAction = new DescribeActions("медленно подошел", "подошел", "подбежал");
    private static DescribeActions leaveAction = new DescribeActions("медленно ушел", "ушел", "убежал");
    private static DescribeActions comeAction = new DescribeActions("медленно пришел", "пришел", "прибежал");
    private static DescribeActions turnAroundAction = new DescribeActions("медленно повернулся", "повернулся", "быстро повернулся");
    private static DescribePlaces describePlaces = new DescribePlaces("улица", "тротуар", "поле");


    public Character(String name, Places place){
        this(name, place, Direction.FORWARD, 0, null);
    }

    public Character(String name, Places place, Direction direction, int position){
        this(name, place, direction, position, null);
    }

    public Character(String name, Places place, Direction direction, int position, WaterHose<Character> waterHose){
        super(name, place);
        this.waterHose = waterHose;
        this.direction = direction;
        this.position = position;

        try{
            if (waterHose.isActive()){
                this.statement = StatementsOfCharacter.DIRECTS_WATER_STREAM;
            }
            else{
                this.statement = StatementsOfCharacter.INACTIVE;
            }
            waterHose.changeOwner(this);

        } catch (NullPointerException e){
            this.statement = StatementsOfCharacter.INACTIVE;
        }


    }

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public String turnAround(){
        return this.turnAround(Speed.NORMAL);
    }

    public String turnAround(Speed speed){
        this.direction = Direction.getByDirection((this.direction.getDirection() + 180) % 360);
        String action = switch (speed){
            case SLOW -> turnAroundAction.slow();
            case NORMAL -> turnAroundAction.normal();
            case FAST -> turnAroundAction.fast();
        };
        return this.name + " " + action + ". ";
    }

    public void turnAround(boolean flag){
        this.direction = Direction.getByDirection((this.direction.getDirection() + 180) % 360);
    }

    @Override
    public String come(Places place){
        return this.come(place, Speed.NORMAL);
    }

    public String come(Places place, Speed speed){
        this.place = place;
        String action = switch (speed){
            case SLOW -> comeAction.slow();
            case NORMAL -> comeAction.normal();
            case FAST -> comeAction.fast();
        };
        String placeName = switch (place){
            case STREET -> describePlaces.street();
            case PAVEMENT -> describePlaces.pavement();
            case FIELD -> describePlaces.field();
        };
        return this.getName() + " " + action + " на " + placeName + ". ";
    }

    public void come(Places place, boolean flag){
        this.place = place;
    }

    @Override
    public String leave(){
        return this.leave(Speed.NORMAL);
    }

    public String leave(Speed speed){
        if (this.place == Places.PAVEMENT){
            this.place = Places.STREET;
        }
        else{
            this.place = Places.PAVEMENT;
        }
        String action = switch (speed){
            case SLOW -> leaveAction.slow();
            case NORMAL -> leaveAction.normal();
            case FAST -> leaveAction.fast();
        };
        return this.getName() + " " + action + " с " + this.getPlace() + ". ";
    }

    public void leave(boolean flag){
        if (this.place == Places.PAVEMENT){
            this.place = Places.STREET;
        }
        else{
            this.place = Places.PAVEMENT;
        }
    }

    @Override
    public String comeUp(Character character){
        return this.comeUp(character, Speed.NORMAL);
    }

    public String comeUp(Character character, Speed speed){
        this.changePlace(character.getPlace());
        this.changePosition(character.getPosition());
        String action = switch (speed){
            case SLOW -> comeUpAction.slow();
            case NORMAL -> comeUpAction.normal();
            case FAST -> comeUpAction.fast();
        };
        String direction;
        if (character.getDirection() == Direction.LEFT || character.getDirection() == Direction.RIGHT) {
            direction = "сбоку";
        } else{
            int k1 = switch (this.getPlace()){
                case STREET -> this.getPosition();
                case PAVEMENT -> this.getPosition() + 20;
                case FIELD -> this.getPosition() + 40;
            };
            int k2 = switch (character.getPlace()){
                case STREET -> character.getPosition();
                case PAVEMENT -> character.getPosition() + 20;
                case FIELD -> character.getPosition() + 40;
            };
            if ((k1 > k2 && character.getDirection() == Direction.FORWARD) || (k1 < k2 && character.getDirection() == Direction.BACKWARD)){
                direction = "сзади";
            }
            else {
                direction = "спереди";
            }
        }
        return this.getName() + " " + action + " к " + character.getName() + " " + direction + ". ";
    }

    public void comeUp(Character character, boolean flag){
        this.changePlace(character.getPlace());
        this.changePosition(character.getPosition());
    }

    @Override
    public String toString(){
        String x = this.isHaveWaterHose() ? "есть шланг" : "нет шланга";
        return this.name + " находится на  " + this.getPlace() + " и у него " + x;
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.toString());
    }

    @Override
    public boolean equals(Object obj){
        return obj.getClass() == this.getClass() && this.hashCode() == obj.hashCode();
    }

    @Override
    public String turnTo(Character character){
        return this.turnTo(character, Speed.NORMAL);
    }

    public String turnTo(Character character, Speed speed){
        if (this.place == character.place){
            if (this.position > character.position){
                this.direction = Direction.BACKWARD;
            }
            else if (this.position < character.position){
                this.direction = Direction.BACKWARD;
            }
        }
        else{
            if ((this.place == Places.FIELD) || (this.place == Places.PAVEMENT && character.place == Places.STREET)){
                this.direction = Direction.BACKWARD;
            }
            else {
                this.direction = Direction.FORWARD;
            }
        }
        String action = switch (speed){
            case SLOW -> turnAroundAction.slow();
            case NORMAL -> turnAroundAction.normal();
            case FAST -> turnAroundAction.fast();
        };
        return this.getName() + " " + action + " к " + character.getName();
    }

    public void turnTo(Character character, boolean flag){
        if (this.place == character.place){
            if (this.position > character.position){
                this.direction = Direction.BACKWARD;
            }
            else if (this.position < character.position){
                this.direction = Direction.BACKWARD;
            }
        }
        else{
            if ((this.place == Places.FIELD) || (this.place == Places.PAVEMENT && character.place == Places.STREET)){
                this.direction = Direction.BACKWARD;
            }
            else {
                this.direction = Direction.FORWARD;
            }
        }
    }

    @Override
    public String pushAway(Character character){
        if (this.direction == Direction.FORWARD){
            character.changePosition(Math.max(character.getPosition() + 1, 10));
        }
        else if (this.direction == Direction.BACKWARD){
            character.changePosition(Math.min(character.getPosition() - 1, 0));
        }
        return this.getName() + " толкнул " + character.getName() + ". ";
    }

    public void pushAway(Character character, boolean flag){
        if (this.direction == Direction.FORWARD){
            character.changePosition(Math.max(character.getPosition() + 1, 10));
        }
        else if (this.direction == Direction.BACKWARD){
            character.changePosition(Math.min(character.getPosition() - 1, 0));
        }
    }

    protected int getPosition(){
        return this.position;
    }

    protected void changePosition(int position){
        this.position = position % 20;
    }

    @Override
    protected Places getPlace(){
        return this.place;
    }

    @Override
    protected void changePlace(Places place){
        this.place = place;
    }

    protected Direction getDirection(){
        return this.direction;
    }

    protected void changeDirection(Direction direction){
        this.direction = direction;
    }

    protected StatementsOfCharacter getStatement(){
        return this.statement;
    }

    protected void changeStatement(StatementsOfCharacter statement){
        this.statement = statement;
    }

    @Override
    public boolean isHaveWaterHose(){
        return waterHose != null;
    }

    @Override
    public WaterHose<Character> waterHoseInArms(){
        return waterHose;
    }

    @Override
    public void takeWaterHose(WaterHose<Character> waterHose){
        this.waterHose = waterHose;
    }

    @Override
    public void lostWaterHose(){
        this.waterHose = null;
    }

    protected String tryToTakeAwayHose(Character character){
        String s = this.getName() + " попробовал выравать шланг из рук у " + character.getName() + " и ";
        if (Math.random() < 0.5){

            this.changeStatement(StatementsOfCharacter.DIRECTS_WATER_STREAM);
            this.takeWaterHose(character.waterHoseInArms());
            this.waterHoseInArms().changeOwner(this);


            character.changeStatement(StatementsOfCharacter.INACTIVE);
            character.lostWaterHose();


            return s + "у него получилось. ";
        }
        else{
            return s + "у него не получилось. ";
        }
    }

    protected void turnOnWaterHose(WaterHose<Character> waterHose){
        waterHose.turnOn();
    }

    protected void turnOffWaterHose(WaterHose<Character> waterHose){
        waterHose.turnOff();
    }

    protected String jetWaterStreamOnSmb(Character character){
        if (this.waterHoseInArms().getAimedAt() != null){
            this.waterHoseInArms().getAimedAt().changeStatement(StatementsOfCharacter.INACTIVE);
        }
        character.changeStatement(StatementsOfCharacter.UNDER_WATER_STREAM);
        this.waterHoseInArms().changeAimedAt(character);
        return this.getName() + " направил струю на " + character.getName() + ". ";
    }

    protected String jetWaterStreamOnPedestrians(Pedestrians pedestrians){
        if (this.waterHoseInArms().getAimedAt() != null){
            this.waterHoseInArms().getAimedAt().changeStatement(StatementsOfCharacter.INACTIVE);
        }
        pedestrians.changeStatement(true);
        this.waterHoseInArms().changeAimedAt(null);
        String placeName = switch (pedestrians.getPlace()){
            case STREET -> describePlaces.street();
            case PAVEMENT -> describePlaces.pavement();
            case FIELD -> describePlaces.field();
        };
        return this.getName() + " направил струю на " + placeName + ", обливая прохожих. ";
    }

    protected String jetWaterStreamSmw(Places place){
        if (this.waterHoseInArms().getAimedAt() != null){
            this.waterHoseInArms().getAimedAt().changeStatement(StatementsOfCharacter.INACTIVE);
        }
        this.waterHoseInArms().changeAimedAt(null);
        String placeName = switch (place){
            case STREET -> describePlaces.street();
            case PAVEMENT -> describePlaces.pavement();
            case FIELD -> describePlaces.field();
        };
        return this.getName() + " направил струю на " + placeName + ". ";
    }
}
