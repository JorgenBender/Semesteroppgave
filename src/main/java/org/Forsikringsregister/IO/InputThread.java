package org.Forsikringsregister.IO;

import javafx.concurrent.Task;
import javafx.scene.control.Alert;
import org.Forsikringsregister.Programlogikk.Kunderegister;

import java.io.File;

public class InputThread extends Task<Void> {

    private Runnable doneFunc;
    private File file;
    private String filtype;

    public InputThread(Runnable doneFunc, File file, String filtype) {
        this.doneFunc = doneFunc;
        this.file = file;
        this.filtype = filtype;
    }

    @Override
    protected Void call() throws Exception {
        //Thread.sleep(1250); //Simulerer en stor innlasting
        switch (filtype) {
            case "csv":
                LesCsv csvLeser = new LesCsv(file);
                Kunderegister.setKundeliste(csvLeser.lesKundeliste());
                break;
            case "jobj":
                LesJobj jobjLeser= new LesJobj(file);
                Kunderegister.setKundeliste(jobjLeser.lesKundeliste());
                break;
        }
        return null;
    }
    @Override
    protected void succeeded(){
        doneFunc.run();
    }
    @Override
    protected void failed() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Dialog");
        alert.setHeaderText("Fil kunne ikke lastes inn");
        alert.setContentText(getException().getMessage());
        alert.showAndWait();
        doneFunc.run();
    }
}
