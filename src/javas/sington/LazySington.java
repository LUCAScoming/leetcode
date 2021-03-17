package sington;

public class LazySington {
    private static LazySington lazySington = null;
    private LazySington(){}
    private static synchronized LazySington getInstance (){
        if (lazySington==null){
            return new LazySington();
        }
        return lazySington;
    }

}
