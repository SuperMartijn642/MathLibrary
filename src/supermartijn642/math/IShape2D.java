package supermartijn642.math;

/**
 * Created 06/09/2019 by SuperMartijn642
 */
public interface IShape2D {

    /**
     * @return whether the given position is inside this shape
     */
    boolean contains(Position2D pos);

    /**
     * Casts a ray and checks if it collides with this shape
     */
    RayCastInfo2D castRay(Position2D pos, Vector2D direction);

}
