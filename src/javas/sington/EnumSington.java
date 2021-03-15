package sington;


/*
*
* https://blog.csdn.net/weixin_36586120/article/details/105522491
*创建enum时，编译器会自动为我们生成一个继承自java.lang.Enum的类，
* */
public enum  EnumSington {

    INSTANCE;

    public EnumSington getInstance (){
        return INSTANCE;
    }
}
