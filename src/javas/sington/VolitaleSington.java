package sington;

import com.sun.org.apache.regexp.internal.RE;

public class VolitaleSington {
    public volatile static  VolitaleSington volitaleSington = null;

    public static VolitaleSington getInstance(){
        if (volitaleSington==null){
            synchronized (VolitaleSington.class){
                if (volitaleSington==null){
                    volitaleSington=new VolitaleSington();
                }
            }
        }
        return volitaleSington;
    }


}
