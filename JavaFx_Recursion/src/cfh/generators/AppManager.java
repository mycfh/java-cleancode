package cfh.generators;

import javafx.scene.control.Button;

public interface AppManager {
	Button getLastButton();
	void appendToStatus(String m);
}
