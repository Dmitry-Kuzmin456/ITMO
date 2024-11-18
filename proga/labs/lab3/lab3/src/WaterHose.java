public class WaterHose<T> implements Switchable{
    private boolean isActive;
    private T owner;
    private T aimedAt;

    public WaterHose(boolean statement){
        this(statement, null);
    }

    public WaterHose(boolean statement, T owner){
        this.isActive = statement;
        this.owner = owner;
    }

    protected boolean isActive(){
        return isActive;
    }

    @Override
    public void turnOff(){
        this.isActive = false;
        this.aimedAt = null;
    }

    @Override
    public void turnOn(){
        this.isActive = true;
    }

    protected boolean isInArms(){
        return this.owner != null;
    }

    protected T owner(){
        return this.owner;
    }

    protected void changeOwner(T owner){
        this.owner = owner;
    }

    protected T getAimedAt(){
        return this.aimedAt;
    }

    protected void changeAimedAt(T smb){
        this.aimedAt = smb;
    }
}
