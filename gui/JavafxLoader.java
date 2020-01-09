package gui;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

public class JavafxLoader {
 
    public static Node loadFxml(String fxml) {
        FXMLLoader loader = new FXMLLoader();
        try {
            loader.setLocation(JavafxLoader.class.getResource(fxml));
            Node root = (Node) loader.load(App.class.getResource(fxml).openStream());
            return root;
        } catch (IOException e) {
            throw new IllegalStateException("cannot load FXML screen", e);
        }
    }
}
