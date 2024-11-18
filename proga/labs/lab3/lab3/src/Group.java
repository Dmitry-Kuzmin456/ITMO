import java.util.ArrayList;
import java.util.Arrays;

public class Group implements Movement{
    ArrayList<Character> characters;

    protected static DescribeActions turnAroundAction = new DescribeActions("медленно повернулись", "повернулись", "быстро повернулись");
    protected static DescribeActions comeAction = new DescribeActions("медленно пришли", "пришли", "прибежали");
    protected static DescribeActions leaveAction = new DescribeActions("медленно ушли", "ушли", "убежали");
    protected static DescribeActions comeUpAction = new DescribeActions("медленно подошли", "подошли", "подбежали");
    protected static DescribePlaces describePlaces = new DescribePlaces("улица", "тротуар", "поле");

    public Group(Character... my_characters){
        this.characters = new ArrayList<>(Arrays.asList(my_characters));
    }

    @Override
    public String turnAround(){
        return this.turnAround(Speed.NORMAL);
    }

    public String turnAround(Speed speed){
        for (Character characterInGroup: characters){
            characterInGroup.changeDirection(Direction.getByDirection((characterInGroup.getDirection().getDirection() + 180) % 360));
        }
        String action = switch (speed){
            case SLOW -> turnAroundAction.slow();
            case NORMAL -> turnAroundAction.normal();
            case FAST -> turnAroundAction.fast();
        };
        return "Все " + characters.size() + " " + action + ". ";
    }

    @Override
    public String come(Places place){
        return this.come(place, Speed.NORMAL);
    }

    public String come(Places place, Speed speed){
        for (Character characterInGroup: characters){
            characterInGroup.come(place, false);
        }
        String action = switch (speed){
            case SLOW -> comeAction.slow();
            case NORMAL -> comeAction.normal();
            case FAST -> comeAction.fast();
        };
        return "Все " + characters.size() + " " + action + " на " + place;
    }

    @Override
    public String leave(){
        return this.leave(Speed.NORMAL);
    }

    public String leave(Speed speed){
        Places oldPlace = this.charactersInGroup().get(0).getPlace();
        for (Character characterInGroup: this.charactersInGroup()){
            characterInGroup.leave();
        }
        String action = switch (speed){
            case SLOW -> leaveAction.slow();
            case NORMAL -> leaveAction.normal();
            case FAST -> leaveAction.fast();
        };
        String placeName = switch (oldPlace){
            case STREET -> describePlaces.street();
            case PAVEMENT -> describePlaces.pavement();
            case FIELD -> describePlaces.field();
        };
        return "Все " + characters.size() + " " + action + " с " + placeName + ". ";
    }

    @Override
    public String comeUp(Character character){
        return this.comeUp(character, Speed.NORMAL);
    }

    public String comeUp(Character character, Speed speed){
        for (Character characterInGroup: this.charactersInGroup()){
            characterInGroup.comeUp(character);
        }
        String action = switch (speed){
            case SLOW -> comeUpAction.slow();
            case NORMAL -> comeUpAction.normal();
            case FAST -> comeUpAction.fast();
        };
        return "Все " + characters.size() + " " + action + " к " + character.getName();
    }

    @Override
    public String turnTo(Character character){
        return this.turnTo(character, Speed.NORMAL);
    }

    public String turnTo(Character character, Speed speed){
        for (Character characterInGroup: this.charactersInGroup()){
            characterInGroup.turnTo(character, true);
        }
        String action = switch (speed){
            case SLOW -> turnAroundAction.slow();
            case NORMAL -> turnAroundAction.normal();
            case FAST -> turnAroundAction.fast();
        };
        return "Все " + characters.size() + " " + action + " к " + character.getName();
    }

    @Override
    public String pushAway(Character character){
        for (Character characterInGroup: this.charactersInGroup()){
            characterInGroup.pushAway(character);
        }
        return "Все " + characters.size() + " толкнули " + character.getName();
    }

    private boolean isCharacterInGroup(Character character){
        return this.charactersInGroup().contains(character);
    }

    private void addCharacter(Character character){
        this.characters.add(character);
    }

    private void delCharacter(Character character){
        this.characters.remove(character);
    }

    private ArrayList<Character> charactersInGroup(){
        return this.characters;
    }
}
