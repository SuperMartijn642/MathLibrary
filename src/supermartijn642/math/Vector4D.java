package supermartijn642.math;

/**
 * Created 3/13/2019 by SuperMartijn642
 */
public class Vector4D implements IVectorD {

    public double x, y, z, w;

    public Vector4D(double x, double y, double z, double w){
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public Vector4D add(double x, double y, double z, double w){
        return new Vector4D(this.x + x, this.y + y, this.z + z, this.w + w);
    }

    public Vector4D add(Vector4D vector){
        return this.add(vector.x,vector.y,vector.z,vector.w);
    }

    public Vector4D subtract(double x, double y, double z, double w){
        return new Vector4D(this.x - x, this.y - y, this.z - z, this.w - w);
    }

    public Vector4D subtract(Vector4D vector){
        return this.subtract(vector.x,vector.y,vector.z,vector.w);
    }

    public Vector4D multiply(double value){
        return new Vector4D(this.x * value, this.y * value, this.z * value, this.w * value);
    }

    public Vector4D devide(double value){
        return new Vector4D(this.x / value, this.y / value, this.z / value, this.w / value);
    }

    public double dot(Vector4D vector){
        return this.x * vector.x + this.y * vector.y + this.z * vector.z + this.w * vector.w;
    }

    public double lengthSquared(){
        return this.x * this.x + this.y * this.y + this.z * this.z + this.w * this.w;
    }

    public double length(){
        return Math.sqrt(this.lengthSquared());
    }

    public Position4D toPosition(){
        return new Position4D(this.x,this.y,this.z,this.w);
    }

    public Vector4D clone(){
        return new Vector4D(this.x,this.y,this.z,this.w);
    }

    public boolean equals(Object object){
        return object instanceof Vector4D && ((Vector4D)object).x == this.x && ((Vector4D)object).y == this.y && ((Vector4D)object).z == this.z && ((Vector4D)object).w == this.w;
    }

    public String toString(){
        return "(" + this.x + "," + this.y + "," + this.z + "," + this.w + ")";
    }

    public static Vector4D zero(){
        return new Vector4D(0,0,0,0);
    }

    @Override
    public int getSize() {
        return 4;
    }

    @Override
    public double getValue(int index) {
        return index == 0 ? this.x : index == 1 ? this.y : index == 2 ? this.z : index == 3 ? this.w : 0;
    }
}
