public class Pedestrians extends People{
    private boolean isWet = false;

    public Pedestrians(Places place){
        super("пешеходы", place);
    }

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public Places getPlace(){
        return this.place;
    }

    @Override
    public void changePlace(Places place){
        this.place = place;
    }

    protected boolean isWet(){
        return this.isWet;
    }

    protected void changeStatement(boolean isWet){
        this.isWet = isWet;
    }
}
