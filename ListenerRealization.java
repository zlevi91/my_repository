package com.company;

/**
 * Created by hackeru on 3/27/2017.
 */
public class ListenerRealization implements Listener {
    private Output output;

    public ListenerRealization(Output output) {
        this.output = output;
    }

    @Override
    public void StartDetect() {
        output.getOutput("action start  "+System.nanoTime());
    }

    @Override
    public void EndDetect() {
        output.getOutput("action end  "+System.nanoTime());
    }
}
