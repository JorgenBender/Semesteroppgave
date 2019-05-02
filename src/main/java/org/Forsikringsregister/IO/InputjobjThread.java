package org.Forsikringsregister.IO;

import javafx.concurrent.Task;
import org.Forsikringsregister.Programlogikk.Kunderegister;

import java.io.File;

public class InputjobjThread extends Task<Void> {

    private Runnable doneFunc;
    private File file;

    public InputjobjThread(Runnable doneFunc, File file) {
        this.doneFunc = doneFunc;
        this.file = file;
    }

    @Override
    protected Void call() throws Exception {
        try {
            LesJobj jobjLeser= new LesJobj(file);
            Kunderegister.setKundeliste(jobjLeser.lesKundeliste());
            System.out.println("Reeeeeee");
        }
        catch (Exception e) {
            System.out.println("Noe gikk galt"+e.getMessage()+e.getCause());
        }

        return null;
    }

    @Override
    protected void succeeded(){
        doneFunc.run();
    }
}

