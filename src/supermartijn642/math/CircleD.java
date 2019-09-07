package supermartijn642.math;

/**
 * Created 06/09/2019 by SuperMartijn642
 */
public class CircleD implements IShape2D {

    public Position2D pos;
    public double radius;

    public CircleD(Position2D pos, double radius){
        this.pos = pos;
        this.radius = radius;
    }

    public CircleD(double x, double y, double radius){
        this(new Position2D(x, y), radius);
    }

    @Override
    public boolean contains(Position2D pos){
        return this.pos.distance(pos) <= this.radius;
    }

    @Override
    public RayCastInfo2D castRay(Position2D pos, Vector2D direction){
        return null;
    }
}
