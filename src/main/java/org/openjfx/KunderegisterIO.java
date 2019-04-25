package org.openjfx;

import java.io.*;

public class KunderegisterIO {

    public static Kunderegister lastOppKundeRegister(){

        Kunderegister loadedKundeRegister = null;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("kunderegister.jobj"))){
           loadedKundeRegister = Kunderegister.class.cast(ois.readObject());
        } catch(IOException e) {
            System.err.println("Could not read file. Cause: " + e.getCause());
        } catch(ClassNotFoundException e) {
            System.err.println("Could not convert Object");
        }
        return loadedKundeRegister;
    }

    public static void skrivKundeRegisterTilFil(Kunderegister kunderegister) {
        try (ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream("kunderegister.jobj"))) {
            ous.writeObject(kunderegister);
        } catch (IOException e) {
            e.printStackTrace(); // This should not happen, so we print debug information here.
        }
    }
}
