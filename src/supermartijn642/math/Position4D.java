package supermartijn642.math;

/**
 * Created 3/13/2019 by SuperMartijn642
 */
public class Position4D {

    public double x, y, z, w;

    public Position4D(double x, double y, double z, double w){
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public Position4D translate(double x, double y, double z, double w){
        return new Position4D(this.x + x, this.y + y, this.z + z, this.w + w);
    }

    public Position4D translate(Vector4D vector){
        return this.translate(vector.x, vector.y, vector.z, vector.w);
    }

    public double distance(Position4D position){
        return new Vector4D(this.x - position.x,this.y - position.y,this.z - position.z,this.w - position.w).length();
    }

    /**
     * @return a vector from this position to the given position
     */
    public Vector4D direction(Position4D position){
        return new Vector4D(position.x - this.x, position.y - this.y, position.z - this.z, position.w - this.w);
    }

    public Vector4D toVector(){
        return new Vector4D(this.x,this.y,this.z,this.w);
    }

    public Position4D clone(){
        return new Position4D(this.x,this.y,this.z,this.w);
    }

    public boolean equals(Object object){
        return object instanceof Position4D && ((Position4D)object).x == this.x && ((Position4D)object).y == this.y && ((Position4D)object).z == this.z && ((Position4D)object).w == this.w;
    }

    public String toString(){
        return "(" + this.x + "," + this.y + "," + this.z + "," + this.w + ")";
    }

    public static Position4D origin(){
        return new Position4D(0,0,0,0);
    }

}
