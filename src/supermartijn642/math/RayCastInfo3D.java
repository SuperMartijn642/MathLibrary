package supermartijn642.math;

/**
 * Created 06/09/2019 by SuperMartijn642
 */
public class RayCastInfo3D {

    public boolean collision;
    public Position3D startPos;
    public Vector3D startDirection;
    public Position3D collisionPos;
    public Vector3D bounceDirection;

    public RayCastInfo3D(boolean collision, Position3D startPos, Vector3D startDirection, Position3D collisionPos, Vector3D bounceDirection){
        this.collision = collision;
        this.startPos = startPos;
        this.startDirection = startDirection;
        this.collisionPos = collisionPos;
        this.bounceDirection = bounceDirection;
    }

}
