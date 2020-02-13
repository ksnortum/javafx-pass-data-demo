package net.snortum.passdatademo;

import java.net.URL;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import net.snortum.passdatademo.controller.NameController;
import net.snortum.passdatademo.controller.ReceiveNameController;
import net.snortum.passdatademo.model.DataHolder;

public class PassDataDemo extends Application {
	private NameController nameController= new NameController();
	private ReceiveNameController receiveNameController = new ReceiveNameController();
	private DataHolder holder = new DataHolder();
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane mainPane = loadMain();
		mainPane.getChildren().add(loadReceiveName());
		mainPane.getChildren().add(loadName());
		primaryStage.setScene(new Scene(mainPane));
		primaryStage.setTitle("Pass Data Demo");
		primaryStage.show();
	}
	
	private Pane loadMain() {
		PaneLoader pl = loadFxml("Main.fxml");
		pl.getLoader().setControllerFactory(type -> {
			if (type == nameController.getClass()) {
				return nameController;
			} else if (type == receiveNameController.getClass()) {
				return receiveNameController;
			} else {
				throw new IllegalArgumentException(String.format("type %s not found in %s", type, getClass()));
			}
		});
		
		return pl.getPane();
	}
	
	private Pane loadName() {
		PaneLoader pl = loadFxml("Name.fxml");
		nameController = pl.getLoader().getController();
		nameController.setDataHolder(holder);
		
		return pl.getPane();
	}
	
	private Pane loadReceiveName() {
		PaneLoader pl = loadFxml("ReceiveName.fxml");
		receiveNameController = pl.getLoader().getController();
		receiveNameController.bindName(holder);

		return pl.getPane();
	}
	
	private PaneLoader loadFxml(String fxmlPath) {
		URL url = getClass().getClassLoader().getResource(fxmlPath);
		FXMLLoader loader = new FXMLLoader(url);
		Pane pane;
		
		try {
			pane = loader.load();
		} catch (Exception e) {
			System.err.println("Could not find " + fxmlPath);
			Platform.exit();
			return null;
		}
		
		return new PaneLoader(pane, loader);
	}
	
	private class PaneLoader {
		private final Pane pane;
		private final FXMLLoader loader;
		
		PaneLoader(Pane pane, FXMLLoader loader) {
			this.pane = pane;
			this.loader = loader;
		}
		
		Pane getPane() {
			return pane;
		}
		
		FXMLLoader getLoader() {
			return loader;
		}
	}
}
