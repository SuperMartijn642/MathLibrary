package supermartijn642.math;

/**
 * Created 06/09/2019 by SuperMartijn642
 */
public interface IShape3D {

    /**
     * @return whether the given position is inside this shape
     */
    boolean contains(Position3D pos);

    /**
     * Casts a ray and checks if it collides with this shape
     */
    RayCastInfo3D castRay(Position3D pos, Vector3D direction);

}
