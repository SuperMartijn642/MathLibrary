package supermartijn642.math;

/**
 * Created 3/13/2019 by SuperMartijn642
 */
public class Position3D {

    public double x, y, z;

    public Position3D(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Position3D translate(double x, double y, double z){
        return new Position3D(this.x + x, this.y + y, this.z + z);
    }

    public Position3D translate(Vector3D vector){
        return this.translate(vector.x, vector.y, vector.z);
    }

    public double distance(Position3D position){
        return new Vector3D(this.x - position.x,this.y - position.y,this.z - position.z).length();
    }

    /**
     * @return a vector from this position to the given position
     */
    public Vector3D direction(Position3D position){
        return new Vector3D(position.x - this.x, position.y - this.y, position.z - this.z);
    }

    public Vector3D toVector(){
        return new Vector3D(this.x,this.y,this.z);
    }

    public Position3D clone(){
        return new Position3D(this.x,this.y,this.z);
    }

    public boolean equals(Object object){
        return object instanceof Position3D && ((Position3D)object).x == this.x && ((Position3D)object).y == this.y && ((Position3D)object).z == this.z;
    }

    public String toString(){
        return "(" + this.x + "," + this.y + "," + this.z + ")";
    }

    public static Position3D origin(){
        return new Position3D(0,0,0);
    }

}
