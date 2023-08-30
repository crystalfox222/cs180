/**
 * Icosidodecahedron
 * <p>
 * This class extends ArchimedeanSolid
 * <p>
 * Used stack overflow occasionally
 *
 * @author Edythe Thompson, L09
 * @version 3-26-2020
 */
public class Icosidodecahedron extends ArchimedeanSolid {

    public Icosidodecahedron(double edgeLength) {
        super(edgeLength);
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        return object.equals(getEdgeLength());
    }

    public String toString() {
        return String.format("Icosidodecahedron[%.6f]", getEdgeLength());

    }

    @Override
    public double getVolume() {
        return ((45.0 + (17.0 * Math.sqrt(5.0))) / 6.0) * Math.pow(getEdgeLength(), 3.0);
    }

    @Override
    public double getSurfaceArea() {
        return ((5.0 * Math.sqrt(3.0)) + (3.0 * Math.sqrt(25.0 + (10.0 * Math.sqrt(5.0))))) * Math.pow(getEdgeLength(),
                2.0);
    }
}
