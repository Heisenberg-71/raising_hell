interface Color{
    public void displaycolor();
}
class white implements Color{
    @Override
    public void displaycolor(){
        System.out.println("white color");
    }
}
class black implements Color{
    @Override
    public void displaycolor(){
        System.out.println("black color");
    }
}
class colorFactory{
    Color getColorInstance(String value){
        if(value.equals("white")){
            return new white();
        } else if (value.equals("black")) {
            return new black();
        }
        return null;
    }
}

public class FactoryMethod {
    public static void main(String[] args) {
     colorFactory colorobj=new colorFactory();
     Color blackobj=colorobj.getColorInstance("black");
     blackobj.displaycolor();
    }
}
