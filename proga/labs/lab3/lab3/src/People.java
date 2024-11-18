public abstract class People{
    String name;
    Places place;

    public People(String name, Places place){
        this.name = name;
        this.place = place;
    }

    protected abstract String getName();
    protected abstract Places getPlace();
    protected abstract void changePlace(Places place);

}
