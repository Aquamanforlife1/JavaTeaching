package lectures.composite.objects_shapes;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
/*
 * Without looking at this program, run it and observe the graphics view 
 * created (stretch the window to see all of it).
 * 
 * Edit the properties in the main panel to see the effect on in the graphics
 * panel.
 * 
 * What properties/logical structure do you think this class has based on the
 * graphics view?
 * 
 * Use the Common->TreeView command to view the actual logical structure.
 * 
 * Examine this code. Does your predicted logical structure match the actual one?
 * 
 * If not, which is the preferable one?
 * 
 * APlottedShuttle has:
 *   (a) a child node that represents the X axis.
 *   (b) a (non-child) descendant node that represents the X axis.
 *   
 *  APlottedShuttle has:
 *   (a) a child node that represents the shuttle.
 *   (b) a (non-child) descendant node that represents the shuttle. 
 * 
 * (T/F) APlottedShuttle reuses the code in ACartesianPlane.
 * 
 */
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
public class APlottedShuttle implements PlottedShuttle  {
    
	public static final String SHUTTLE_IMAGE_FILE_NAME = "shuttle2.jpg";
	int shuttleX = 0, shuttleY = 0;
	protected CartesianPlane cartesianPlane; 
	protected ImageWithHeight shuttleImage;
	
	public APlottedShuttle(int anX, int aY) {
		cartesianPlane = new ACartesianPlane (AXES_LENGTH, ORIGIN_X, ORIGIN_Y);
		shuttleImage = new AnImageWithHeight(SHUTTLE_IMAGE_FILE_NAME);
		setShuttleX(anX);
		setShuttleY(aY);
	}
	
	public CartesianPlane getCartesianPlane() {return cartesianPlane;}
	
	public ImageWithHeight getShuttleImage() {return shuttleImage;}
	
	public int getShuttleX() {return shuttleX;}
	public void setShuttleX(int newVal) {
		shuttleX = newVal;
		shuttleImage.setX(toWindowX());
	}
	public int getShuttleY() {return shuttleY;}
	public void setShuttleY(int newVal) {
		shuttleY = newVal;
		shuttleImage.setY(toWindowY());
	}
	
	int toWindowX() {
		return ORIGIN_X + shuttleX; 
	}
	int toWindowY() {
		return ORIGIN_Y - shuttleY - shuttleImage.getHeight(); 
	}
	public static void main (String[] args) {
		PlottedShuttle shuttle = new APlottedShuttle(0, 0);
		OEFrame anOEFrame = ObjectEditor.edit(shuttle);
		anOEFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
//		oeFrame.hideMainPanel();
	}
}

