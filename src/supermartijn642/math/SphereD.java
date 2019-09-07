package supermartijn642.math;

/**
 * Created 06/09/2019 by SuperMartijn642
 */
public class SphereD implements IShape3D {

    public Position3D pos;
    public double radius;

    @Override
    public boolean contains(Position3D pos){
        return this.pos.distance(pos) <= this.radius;
    }

    @Override
    public RayCastInfo3D castRay(Position3D pos, Vector3D direction){
        double a = direction.x * direction.x + direction.y * direction.y + direction.z * direction.z;
        double b = 2 * (pos.x * direction.x - this.pos.x * direction.x + pos.y * direction.y - this.pos.y * direction.y + pos.z * direction.z - this.pos.z * direction.z);
        double c = pos.x * pos.x + pos.y * pos.y + pos.z * pos.z + this.pos.x * this.pos.x + this.pos.y * this.pos.y + this.pos.z * this.pos.z - 2 * pos.x * this.pos.x - 2 * pos.y * this.pos.y - 2 * pos.z * this.pos.z - this.radius * this.radius;
        double d = b * b - 4 * a * c;
        double e1 = (-b + Math.sqrt(d)) / (2 * a), e2 = (-b - Math.sqrt(d)) / (2 * a);
        double t = e1 < 0 && e2 < 0 ? -1 : e1 < 0 ? e2 : e2 < 0 ? e1 : Math.min(e1, e2);
        Position3D hitPos = pos.translate(direction.multiply(t));
        // TODO calculate and add the bounce direction
        return new RayCastInfo3D(t >= 0, pos, direction, t >= 0 ? hitPos : null, null);
    }
}
