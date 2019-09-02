package supermartijn642.math;

/**
 * Created 3/13/2019 by SuperMartijn642
 */
public class Position2D {

    public double x, y;

    public Position2D(double x,double y){
        this.x = x;
        this.y = y;
    }

    public Position2D translate(double x,double y){
        return new Position2D(this.x + x,this.y + y);
    }

    public Position2D translate(Vector2D vector){
        return this.translate(vector.x,vector.y);
    }

    public Position2D translate(Position2D pos){
        return this.translate(pos.x,pos.y);
    }

    public Position2D scale(double x,double y){
        return new Position2D(this.x * x,this.y * y);
    }

    public double distance(Position2D position){
        return new Vector2D(this.x - position.x,this.y - position.y).length();
    }

    public double distance(Position2I position){
        return new Vector2D(this.x - position.x,this.y - position.y).length();
    }

    /**
     * @return a vector from this position to the given position
     */
    public Vector2D direction(Position2D position){
        return new Vector2D(position.x - this.x,position.y - this.y);
    }

    public Vector2D toVector(){
        return new Vector2D(this.x,this.y);
    }

    public Position2D clone(){
        return new Position2D(this.x,this.y);
    }

    public boolean equals(Object object){
        return object instanceof Position2D && ((Position2D)object).x == this.x && ((Position2D)object).y == this.y;
    }

    @Override
    public int hashCode(){
        return (int)(this.x * 241 + this.y * 251);
    }

    public String toString(){
        return "(" + this.x + "," + this.y + ")";
    }

    public static Position2D origin(){
        return new Position2D(0,0);
    }

}
