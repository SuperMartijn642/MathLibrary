package supermartijn642.math;

/**
 * Created 6/20/2019 by SuperMartijn642
 */
public class RectangleD {

    public double x, y;
    public double width, height;

    public RectangleD(double x, double y, double width, double height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public RectangleD(Position2D pos, double width, double height){
        this(pos.x, pos.y, width, height);
    }

    public Position2D topLeft(){
        return new Position2D(this.x, this.y);
    }

    public Position2D topRight(){
        return new Position2D(this.x + this.width, this.y);
    }

    public Position2D bottomLeft(){
        return new Position2D(this.x, this.y + this.height);
    }

    public Position2D bottomRight(){
        return new Position2D(this.x + this.width, this.y + this.height);
    }

    public Position2D min(){
        return this.topLeft();
    }

    public Position2D max(){
        return this.bottomRight();
    }

    public double diagonalLength(){
        return new Vector2D(this.width,this.height).length();
    }

    public boolean overlaps(RectangleD rectangle){
        return rectangle.x < this.x + this.width && rectangle.x + rectangle.width > this.x && rectangle.y < this.y + this.height && rectangle.y + rectangle.height > this.y;
    }

    /**
     * Compares the area of this and the given rectangle.
     */
    public boolean isSmallerThan(RectangleD rectangle){
        return this.width * this.height < rectangle.width * rectangle.height;
    }

    /**
     * Compares the area of this and the given rectangle.
     */
    public boolean isBiggerThan(RectangleD rectangle){
        return !this.isSmallerThan(rectangle);
    }

    public boolean contains(Position2D pos){
        return pos.x > this.x && pos.x < this.x + this.width && pos.y > this.y && pos.y < this.y + height;
    }

    @Override
    public int hashCode(){
        return (int)(this.x * 7 + this.y * 11 + this.width * 13 + this.height * 17);
    }

    @Override
    public boolean equals(Object obj){
        return obj == this || (obj instanceof RectangleD && ((RectangleD)obj).x == this.x && ((RectangleD)obj).y == this.y && ((RectangleD)obj).width == this.width && ((RectangleD)obj).height == this.height);
    }

    @Override
    protected RectangleD clone(){
        return new RectangleD(this.x,this.y,this.width,this.height);
    }

    @Override
    public String toString(){
        return "{x:" + this.x + ",y:" + this.y + ",width:" + this.width + ",height:" + this.height + "}";
    }
}
