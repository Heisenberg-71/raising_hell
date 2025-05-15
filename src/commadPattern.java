//Command interface
interface Command {
    void execute();
}

//recevier
class Light{
    void lightOn(){
        System.out.println("light ON");
    }
    void lightOff(){
        System.out.println("light OFF");
    }
}

//invoker
class ONCommand implements Command {
private Light light;
    public ONCommand(Light light){
        this.light=light;
    }
    @Override
    public void execute(){
        light.lightOn();
    }
}
class OFFCommand implements Command {
private Light light;
public OFFCommand(Light light){
    this.light=light;
}
@Override
public  void execute(){
    light.lightOff();
}
}

class remote{
    private Command command;
    public void setCommand(Command command){
        this.command=command;
    }
    public void pressButton(){
        command.execute();
    }
}


public class commadPattern {
    public static void main(String[] args) {
Light light=new Light();
ONCommand onCommand=new ONCommand(light);
OFFCommand offCommand=new OFFCommand(light);

remote remoteObj=new remote();

remoteObj.setCommand(onCommand);
remoteObj.pressButton();


    }
}
