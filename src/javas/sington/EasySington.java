package sington;


public class EasySington {
    public static EasySington  easySington= new EasySington();
    private EasySington(){}
    public static EasySington getInstance (){
        return easySington;
    }
}
