package sington;


/*
* 静态内部类实现单例
* */
public class StaticSington {

    public static class innerClass {
        private static StaticSington staticSington = new StaticSington();
    }

    public static StaticSington getInstace (){
        return innerClass.staticSington;
    }
}
