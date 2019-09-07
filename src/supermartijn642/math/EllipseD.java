package supermartijn642.math;

/**
 * Created 06/09/2019 by SuperMartijn642
 */
public class EllipseD implements IShape2D {

    public Position2D pos;
    public double width, height;

    public EllipseD(Position2D pos, double width, double height){
        this.pos = pos;
        this.width = width;
        this.height = height;
    }

    public EllipseD(double x, double y, double width, double height){
        this(new Position2D(x,y),width,height);
    }

    @Override
    public boolean contains(Position2D pos){
        return Math.pow(this.pos.x - pos.x,2) / Math.pow(this.width / 2D, 2) + Math.pow(this.pos.y - pos.y,2) / Math.pow(this.height / 2D, 2) <= 1;
    }

    @Override
    public RayCastInfo2D castRay(Position2D pos, Vector2D direction){
        return null;
    }
}
