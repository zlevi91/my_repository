package com.company;

/**
 * Created by hackeru on 3/27/2017.
 */
public class UserListener {

    private EncDecListener listener;

    public UserListener(EncDecListener listener) {
        this.listener = listener;
    }

    public void setListeners(EncDecListener listen){
        this.listener = listen;
    }

    public void started(){
        if(listener != null)
            listener.StartDetect();
    }

    public void ended(){
        if(listener != null)
            listener.EndDetect();
    }

    public interface EncDecListener {
        void StartDetect();
        void EndDetect();
    }

}
