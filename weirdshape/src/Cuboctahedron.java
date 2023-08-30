/**
 * Cuboctahedron
 * <p>
 * This class extends ArchimedeanSolid
 * <p>
 * Used stack overflow occasionally
 *
 * @author Edythe Thompson, L09
 * @version 3-26-2020
 */
public class Cuboctahedron extends ArchimedeanSolid {

    public Cuboctahedron(double edgeLength) {
        super(edgeLength);
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        return object.equals(getEdgeLength());
    }

    public String toString() {
        return String.format("Cuboctahedron[%.6f]", getEdgeLength());

    }

    @Override
    public double getVolume() {
        return 5.0 / 3.0 * Math.sqrt(2.0) * Math.pow(getEdgeLength(), 3.0);
    }

    @Override
    public double getSurfaceArea() {
        return (6.0 + (2.0 * Math.sqrt(3.0))) * Math.pow(getEdgeLength(), 2.0);
    }
}
