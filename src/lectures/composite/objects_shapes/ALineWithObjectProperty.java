package lectures.composite.objects_shapes;

import lectures.graphics.ACartesianPoint;
import lectures.graphics.Point;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.misc.ThreadSupport;
import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
@StructurePattern(StructurePatternNames.LINE_PATTERN) 
/**
 *   
 * In all objects we have seen so far, the instance variables and properties
 * were primitive values. Thus, these objects are composed of primitive values.
 * 
 * This class defines an object that has both a variable and a property of a 
 * non primitive type. 
 * 
 * So, we have an object composed of another object, or in other words, we have
 * "object nesting" with a parent/child relationship.
 * 
 * Yes this is an atomic shape - a line - as the StructurePattern annotation
 * shows.
 * 
 * Look through this program. Go to the declaration of both the the interface 
 * Point and the class ACartesianPoint used here.
 * 
 * After that look at AnInteger.
 */
public class ALineWithObjectProperty implements LineWithObjectProperty {
	
	int width, height;
	
	Point location;	// an non-primitive variable!
	
	public ALineWithObjectProperty(
		Point initLocation, int initWidth, int initHeight) {

		location = initLocation;	// comment this out on the second run
		width = initWidth;
		height = initHeight;	
	}
	
	public Point getLocation() {return location;}					// a non-primitive property!
	public void setLocation(Point newVal) {location = newVal;}
	
	public int getWidth() {return width;}
	public void setWidth(int newVal) {width = newVal;}
	public int getHeight() {return height;}
	public void setHeight(int newHeight) {height = newHeight;}	
	
	public static void main(String args[]) {
			LineWithObjectProperty line =  new ALineWithObjectProperty(
					new ACartesianPoint(10, 10), 20, 20);		
			OEFrame aFrame = ObjectEditor.edit (line);
			aFrame.showTreePanel();
			/*
			 * Click on the grey/blue bar left of the following line to set
			 * a break point before you run the program.
			 * 
			 */
			line.setHeight(line.getHeight()*2);
			aFrame.refresh();
		}
}
/*
 * DECOMPOSING AN OBJECT
 * 
 * We can decompose ("break apart") an object by the values assigned to its instance variables
 * or properties.
 * 
 * Decomposing an object by its instance variables creates its physical structure.
 * 
 * Decomposing an object by its properties creates its logical structure.
 * 
 * The physical structure represents how the object is physically stored in memory.
 * 
 * The logical structure describes how the object is logically structured by someone
 * looking at its public instance methods.
 * 
 * Both structures involve common concepts of root, internal nodes, and leaves.
 * 
 * The debugger and ObjectEditor provide visualizations of this structures.
 * 
 * We will use these visualizations to describe common concepts in these 
 * structures.
 * 
 * 
 * Execute the Run-->Debug As command (F11 key).
 * 
 * The ObjectEditor window should be shown, the program should stop or
 * break at the line with the breakpoint you placed, and you should be
 * in the Debug perspective.
 * 
 * Execute the Run->Step Into command (F5) to step into the getter called
 * and step return back (F7).
 * 
 * Now execute again the Run->Step Into command (F5) to step into the setter. 
 * 
 * 
 * Look at the top right window and select the left tab: Variables (if not
 * already selected). 
 * 
 * It shows two variables. 
 * 
 * One is the variable, newHeight, holding the parameter value 
 * passed to the setter. 
 * 
 * Verify its value is correct.
 * 
 * The other is the variable, this, which refers to the object 
 * on which the setter is being executed.
 * 
 * Press on the arrow to the left of "this" to expand it, and expand
 * the "location" item also.
 * 
 * Similarly, expand the Location item in the tree view displayed 
 * by ObjectEditor.
 * 
 * So you have two tree views displayed now, one by ObjectEditor 
 * and one by the debugger.
 * 
 * Some items are similar (ignoring the case) and some are different.
 * 
 * The structure created by ObjectEditor is the logical structure and
 * the one created by the debugger is the physical structure.			

 * As we see in the two structures, names and values are displayed 
 * for primitive components of an object, and expandable names are 
 * shown for object components (location, in this case). 

 * In computer science, the items in a structure are called nodes, 
 * which have names and possibly values and children (sub structures).
 *  
 * A node with no children is a leaf node in the structure.
 * 
 * A non leaf node is a composite node.
 * 
 * A node with no parent is a root node in the structure.
 * 
 * Any node that is not a leaf or root is an internal node.
 * 
 * If B is the child of A, and C is a child of B then 
 * B and C are descendants of A and A and B are ancestors of C

 * To visualize the structure, a parent is connected to a child through a 
 * line segment called an edge. The tree view in object editor uses such a visualization.
 * The debugger uses indentation to show child relationships. 

 * Identify the root, a leaf, a composite, and an internal node 
 * in the two structures.
 * 
 * (T/F) The physical structure of ALineWithObjectProperty has a composite
 * node labeled "location". 
 * 
 * (T/F) The physical structure of ALineWithObjectProperty has a root
 * node labeled "this".
 * 
 * (T/F) The physical structure of ALineWithObjectProperty has a composite
 * node labeled "this".
 * 
 * (T/F) The physical structure of ALineWithObjectProperty has a composite
 * node labeled "x".
 * 
 * (T/F) The physical structure of ALineWithObjectProperty has a leaf
 * node labeled "radius".
 * 
 * (T/F) The logical structure of ALineWithObjectProperty has a leaf
 * node labeled "Radius".
 * 

 * Now comment out the statement in the constructor that assigns to location
 * and debug the program again (F11), stepping into the break point.

 * Can you explain how each of the two tree views has changed and why?
 * 
 * Do the tree views show the same nodes as previously?
 * 
 * (T/F) Different instances of the same class can have different physical and
 * logical structures.
 *  
 * 
 */


/*
 * ATOMIC VS STRUCTURED TYPE
 * 
 * A type whose logical and physical structure has only one leaf node is an 
 * atomic type - it cannot be decomposed into multiple components.
 * 
 * A primitive type is always an atomic type.
 * 
 * Some object types may also be atomic types depending on the instance
 * variables/properties they define.
 * 
 * A non-atomic type is a structured type - these types can be decomposed into
 * more than one component.
 * 
 * 
 * (T/F) int is an atomic type
 * 
 * (T/F) Point is a structured type.
 * 
 * (T/F) MyInteger is a structured type.
 */

/*
 * COMPOSITE VS. NON-COMPOSITE  TYPES
 * 
 * A structured type with at least one internal structured node is a 
 * composite type - such a type has a component that is itself structured.
 * 
 * (T/F) Point is a composite type.
 * (T/F) ALineWithObjectProperty is a composite type.
 *  
 */
/*
 * COMPOSITE SHAPES VS OBJECTS
 * 
 * In this example, the ObjectEditor tree view was structured but not the
 * graphics view, because the object simply represented a line that used a 
 * Point object rather than x,y coordinates for the location. (I recommend using
 * x,y coordinates for your project to avoid some subtle problems)
 * 
 * The next example shows a structured shape.
 * 
 * Next class: ACartesianPlane

 */

