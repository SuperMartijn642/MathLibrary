package supermartijn642.math;

/**
 * Created 3/13/2019 by SuperMartijn642
 */
public class Vector3D implements IVectorD {

    public double x, y, z;

    public Vector3D(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3D add(double x, double y, double z){
        return new Vector3D(this.x + x, this.y + y, this.z + z);
    }

    public Vector3D add(Vector3D vector){
        return this.add(vector.x,vector.y,vector.z);
    }

    public Vector3D subtract(double x, double y, double z){
        return new Vector3D(this.x - x, this.y - y, this.z - z);
    }

    public Vector3D subtract(Vector3D vector){
        return this.subtract(vector.x,vector.y,vector.z);
    }

    public Vector3D multiply(double value){
        return new Vector3D(this.x * value, this.y * value, this.z * value);
    }

    public Vector3D devide(double value){
        return new Vector3D(this.x / value, this.y / value, this.z / value);
    }

    public double dot(Vector3D vector){
        return this.x * vector.x + this.y * vector.y + this.z * vector.z;
    }

    public Vector3D cross(Vector3D vector){
        return new Vector3D(this.y * vector.z - this.z * vector.y, this.z * vector.x + this.x * vector.z, this.x * vector.y + this.y * vector.x);
    }

    public double lengthSquared(){
        return this.x * this.x + this.y * this.y + this.z * this.z;
    }

    public double length(){
        return Math.sqrt(this.lengthSquared());
    }

    public Position3D toPosition(){
        return new Position3D(this.x,this.y,this.z);
    }

    public Vector3D clone(){
        return new Vector3D(this.x,this.y,this.z);
    }

    public boolean equals(Object object){
        return object instanceof Vector3D && ((Vector3D)object).x == this.x && ((Vector3D)object).y == this.y && ((Vector3D)object).z == this.z;
    }

    public String toString(){
        return "(" + this.x + "," + this.y + "," + this.z + ")";
    }

    public static Vector3D zero(){
        return new Vector3D(0,0,0);
    }

    @Override
    public int getSize() {
        return 3;
    }

    @Override
    public double getValue(int index) {
        return index == 0 ? this.x : index == 1 ? this.y : index == 2 ? this.z : 0;
    }
}
