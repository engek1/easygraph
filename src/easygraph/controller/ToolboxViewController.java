package easygraph.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * 
 * @author Weber Lukas, engek1
 *
 */
public class ToolboxViewController extends BaseViewController {
	
	private static final String MODE_ADD_VERTEX = "Add a Vertex";
	private static final String MODE_SELECT = "Select Mode";
	private static final String MODE_ADD_EDGE_UNWEIGHT_UNDIR = "Add a unweighted undirected Edge";
	private static final String MODE_ADD_EDGE_WEIGHT_UNDIR = "Add a weighted undirected Edge";
	private static final String MODE_ADD_EDGE_UNWEIGHT_DIR = "Add a unweighted directed Edge";
	private static final String MODE_ADD_EDGE_WEIGHT_DIR = "Add a weighted directed Edge";
	
	@FXML
	private Label modeLabel = new Label();

	/**
	 * The constructor. The constructor is called before the initialize()
	 * method.
	 */
	public ToolboxViewController() {
	}

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
	}

	/**
	 * handle user action
	 */
	@FXML
    private void handleAddVertexMode(){
    	this.modeLabel.setText(MODE_ADD_VERTEX);
    	getRootController().handleAddVertexMode();
    }

	/**
	 * handle user action
	 */
    @FXML
    private void handleSelectMode(){
    	this.modeLabel.setText(MODE_SELECT);
    	getRootController().handleSelectMode();
    }

    @FXML
    private void handleAddEdgeUnweightedUndirected(){
    	this.modeLabel.setText(MODE_ADD_EDGE_UNWEIGHT_UNDIR);
    	getRootController().handleAddEdgeUnweigUndirMode();
    }
    
    @FXML
    private void handleAddEdgeWeightedUndirected(){
    	this.modeLabel.setText(MODE_ADD_EDGE_WEIGHT_UNDIR);
    	getRootController().handleAddEdgeWeigUndirMode();
    }

    @FXML
    private void handleAddEdgeUnweightedDirected(){
    	this.modeLabel.setText(MODE_ADD_EDGE_UNWEIGHT_DIR);
    	getRootController().handleAddEdgeUnweigDirMode();
    }

    @FXML
    private void handleAddEdgeWeightedDirected(){
    	this.modeLabel.setText(MODE_ADD_EDGE_WEIGHT_DIR);
    	getRootController().handleAddEdgeWeigDirMode();
    }

}