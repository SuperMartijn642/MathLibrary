package supermartijn642.math;

import supermartijn642.render.threedimensional.ITranslation3D;

/**
 * Created 3/13/2019 by SuperMartijn642
 */
public class MatrixD implements ITranslation3D {

    private final int columns, rows;
    private final double[][] values;

    public MatrixD(double[][] values){
        this.columns = values.length;
        this.rows = values[0].length;
        for(double[] arr : values)
            if(arr.length != this.rows)
                throw new IllegalArgumentException("The matrix must be of continuous size");
        this.values = new double[this.columns][this.rows];
        for(int x = 0; x < this.columns; x++){
            for(int y = 0; y < this.rows; y++){
                this.values[x][y] = values[x][y];
            }
        }
    }

    public MatrixD(int columns, int rows){
        this.columns = columns;
        this.rows = rows;
        this.values = new double[columns][rows];
    }

    public void setValue(int column, int row, double value){
        this.values[column][row] = value;
    }

    public double getValue(int column, int row){
        return this.values[column][row];
    }

    public MatrixD multiply(MatrixD matrix){
        if(this.columns != matrix.rows)
            throw new IllegalArgumentException("This matrix' columns must match the given matrix' rows!");
        MatrixD matrix2 = new MatrixD(matrix.columns,this.rows);
        for(int column = 0; column < matrix2.columns; column++){
            for(int row = 0; row < matrix2.rows; row++){
                double value = 0;
                for(int a = 0; a < this.columns; a++)
                    value += this.getValue(a,row) * matrix.getValue(column,a);
                matrix2.setValue(column,row,value);
            }
        }
        return matrix2;
    }

    public IVectorD multiply(IVectorD vector){
        double[] result = new double[this.rows];
        for(int row = 0; row < this.rows; row++){
            result[row] = 0;
            for(int column = 0; column < this.columns; column++){
                result[row] += this.getValue(column,row) * vector.getValue(column);
            }
        }
        return result.length == 2 ? new Vector2D(result[0],result[1]) : result.length == 3 ? new Vector3D(result[0],result[1],result[2]) : result.length == 4 ? new Vector4D(result[0],result[1],result[2],result[3]) : null;
    }

    @Override
    protected Object clone() {
        return new MatrixD(this.values);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("(");
        for(int row = 0; row < this.rows; row++){
            s.append(row > 0 ? ",(" : "(");
            for(int column = 0; column < this.columns; column++){
                if(column > 0)
                    s.append(",");
                s.append(this.getValue(column,row));
            }
            s.append(")");
        }
        s.append(")");
        return s.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof MatrixD))
            return false;
        if(obj == this)
            return true;
        MatrixD matrix = (MatrixD)obj;
        if(matrix.rows != this.rows || matrix.columns != this.columns)
            return false;
        for(int column = 0; column < this.columns; column++){
            for(int row = 0; row < this.rows; row++){
                if(matrix.getValue(column,row) != this.getValue(column,row))
                    return false;
            }
        }
        return true;
    }

    @Override
    public Position3D translate(Position3D position) {
        return ((Vector3D)this.multiply(position.toVector())).toPosition();
    }
}
