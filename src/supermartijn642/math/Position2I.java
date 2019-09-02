package supermartijn642.math;

/**
 * Created 4/26/2019 by SuperMartijn642
 */
public class Position2I {

    public int x, y;

    public Position2I(int x,int y){
        this.x = x;
        this.y = y;
    }

    public Position2I translate(int x,int y){
        return new Position2I(this.x + x,this.y + y);
    }

    public Position2I translate(Vector2I vector){
        return this.translate(vector.x,vector.y);
    }

    public Position2I translate(Position2I pos){
        return this.translate(pos.x,pos.y);
    }

    public Position2I scale(int x,int y){
        return new Position2I(this.x * x,this.y * y);
    }

    public double distance(Position2I position){
        return new Vector2I(this.x - position.x,this.y - position.y).length();
    }

    public double distance(Position2D position){
        return new Vector2D(this.x - position.x,this.y - position.y).length();
    }

    /**
     * @return a vector from this position to the given position
     */
    public Vector2I direction(Position2I position){
        return new Vector2I(position.x - this.x,position.y - this.y);
    }

    public Vector2I toVector(){
        return new Vector2I(this.x,this.y);
    }

    public Position2I clone(){
        return new Position2I(this.x,this.y);
    }

    public boolean equals(Object object){
        return object instanceof Position2I && ((Position2I)object).x == this.x && ((Position2I)object).y == this.y;
    }

    @Override
    public int hashCode(){
        return this.x * 233 + this.y * 239;
    }

    public String toString(){
        return "(" + this.x + "," + this.y + ")";
    }

    public static Position2I origin(){
        return new Position2I(0,0);
    }
}
