public class Neznaika extends Character{
    public Neznaika(Places place){
        super("Незнайка", place);
    }

    public Neznaika(Places place, Direction direction, int position){
        super("Незнайка", place, direction, position);
    }

    public Neznaika(Places place, Direction direction, int position, WaterHose<Character> waterHose){
        super("Незнайка", place, direction, position, waterHose);
    }

    @Override
    public String tryToTakeAwayHose(Character character){
        String s = this.getName() + " попробовал выравать шланг из рук у " + character.getName() + " и ";
        if (Math.random() < 0.8){

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
}
