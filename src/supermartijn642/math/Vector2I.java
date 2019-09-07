package supermartijn642.math;

/**
 * Created 4/26/2019 by SuperMartijn642
 */
public class Vector2I {

    public int x, y;

    public Vector2I(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Vector2I add(int x, int y){
        return new Vector2I(this.x + x, this.y + y);
    }

    public Vector2I add(Vector2I vector){
        return this.add(vector.x, vector.y);
    }

    public Vector2I subtract(int x, int y){
        return new Vector2I(this.x - x, this.y - y);
    }

    public Vector2I subtract(Vector2I vector){
        return this.subtract(vector.x, vector.y);
    }

    public Vector2I multiply(int value){
        return new Vector2I(this.x * value, this.y * value);
    }

    public Vector2I devide(int value){
        return new Vector2I(this.x / value, this.y / value);
    }

    public int dot(Vector2I vector){
        return this.x * vector.x + this.y * vector.y;
    }

    public int lengthSquared(){
        return this.x * this.x + this.y * this.y;
    }

    public double length(){
        return Math.sqrt(this.lengthSquared());
    }

    public Position2I toPosition(){
        return new Position2I(this.x,this.y);
    }

    public Vector2I clone(){
        return new Vector2I(this.x,this.y);
    }

    public boolean equals(Object object){
        return object instanceof Vector2I && ((Vector2I)object).x == this.x && ((Vector2I)object).y == this.y;
    }

    public String toString(){
        return "(" + this.x + "," + this.y + ")";
    }

    public static Vector2I zero(){
        return new Vector2I(0,0);
    }

    public double angle(){
        return this.x == 0 ? this.y == 0 ? 0 : this.y > 0 ? Math.PI / 2D : Math.PI * 1.5D : this.x > 0 ? Math.asin((double)this.y / this.x) : Math.PI - Math.asin((double)this.y / this.x);
    }
}
