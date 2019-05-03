package org.Forsikringsregister.IO;

import javafx.concurrent.Task;
import javafx.scene.control.Alert;
import org.Forsikringsregister.Programlogikk.Kunderegister;

import java.io.File;

public class InputThread extends Task<Void> {

    private Runnable doneFunc;
    private File file;

    public InputThread(Runnable doneFunc, File file) {
        this.doneFunc = doneFunc;
        this.file = file;
    }

    @Override
    protected Void call() throws Exception {
        //Thread.sleep(1250); //Simulerer en stor innlasting
        String extension = "";
        if (file != null) {
            int i = file.getName().lastIndexOf('.');
            if (i > 0) {
                extension = file.getName().substring(i + 1);
            }
            switch (extension) {
                case "csv":
                    LesCsv csvLeser = new LesCsv(file);
                    Kunderegister.setKundeliste(csvLeser.lesKundeliste());
                    break;
                case "jobj":
                    LesJobj jobjLeser = new LesJobj(file);
                    Kunderegister.setKundeliste(jobjLeser.lesKundeliste());
                    break;
                default:
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Dialog");
                    alert.setHeaderText("Fil kunne ikke lastes inn");
                    alert.setContentText("Inllasting av data fra "+extension+" støttes desverre ikke");
                    alert.showAndWait();
                    break;
            }
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
