package supermartijn642.math;

/**
 * Created 3/13/2019 by SuperMartijn642
 */
public class Vector2D implements IVectorD {

    public double x, y;

    public Vector2D(double x,double y){
        this.x = x;
        this.y = y;
    }

    public Vector2D add(double x,double y){
        return new Vector2D(this.x + x,this.y + y);
    }

    public Vector2D add(Vector2D vector){
        return this.add(vector.x,vector.y);
    }

    public Vector2D subtract(double x,double y){
        return new Vector2D(this.x - x,this.y - y);
    }

    public Vector2D subtract(Vector2D vector){
        return this.subtract(vector.x,vector.y);
    }

    public Vector2D multiply(double value){
        return new Vector2D(this.x * value,this.y * value);
    }

    public Vector2D devide(double value){
        return new Vector2D(this.x / value,this.y / value);
    }

    public double dot(Vector2D vector){
        return this.x * vector.x + this.y * vector.y;
    }

    public double lengthSquared(){
        return this.x * this.x + this.y * this.y;
    }

    public double length(){
        return Math.sqrt(this.lengthSquared());
    }

    public Position2D toPosition(){
        return new Position2D(this.x,this.y);
    }

    public Vector2D clone(){
        return new Vector2D(this.x,this.y);
    }

    public boolean equals(Object object){
        return object instanceof Vector2D && ((Vector2D)object).x == this.x && ((Vector2D)object).y == this.y;
    }

    public String toString(){
        return "(" + this.x + "," + this.y + ")";
    }

    public static Vector2D zero(){
        return new Vector2D(0,0);
    }

    @Override
    public int getSize(){
        return 2;
    }

    @Override
    public double getValue(int index){
        return index == 0 ? this.x : index == 1 ? this.y : 0;
    }

    public double angle(){
        return this.x == 0 ? this.y == 0 ? 0 : this.y > 0 ? Math.PI / 2D : Math.PI * 1.5D : this.x > 0 ? Math.asin(this.y / this.x) : Math.PI - Math.asin(this.y / this.x);
    }
}
