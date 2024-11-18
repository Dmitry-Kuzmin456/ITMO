public class Story {
    public static void main(String[] args) {

        StringBuilder story = new StringBuilder();

        WaterHose<Character> hose = new WaterHose<>(true);
        Neznaika neznaika = new Neznaika(Places.FIELD, Direction.BACKWARD, 0);
        Knopochka knopochka = new Knopochka(Places.FIELD, Direction.BACKWARD, 0);
        Character kirill = new Character("Кирилл", Places.FIELD, Direction.BACKWARD, 0);
        Group NeznaikaWithFriends = new Group(neznaika, knopochka, kirill);
        Pegasik pegasik = new Pegasik(Places.FIELD, Direction.FORWARD, 5, hose);
        Pedestrians pedestrians = new Pedestrians(Places.PAVEMENT);
        story.append(NeznaikaWithFriends.turnAround());
        story.append(pegasik.jetWaterStreamOnSmb(knopochka));
        story.append(neznaika.comeUp(pegasik, Speed.FAST));
        story.append(neznaika.tryToTakeAwayHose(pegasik));
        story.append("\n");
        story.append(hose.owner().jetWaterStreamOnPedestrians(pedestrians));
        if (pegasik.isHaveWaterHose()){
            story.append(neznaika.comeUp(pegasik));
            story.append(neznaika.pushAway(pegasik));
        }
        else {
            story.append(pegasik.comeUp(neznaika));
            story.append(pegasik.pushAway(neznaika));
        }
        System.out.print(story.toString());

    }
}
