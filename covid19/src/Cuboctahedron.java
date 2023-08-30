
public class Cuboctahedron extends ArchimedeanSolid {

    public Cuboctahedron(double edgeLength) {
        super(edgeLength);
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object.equals(getEdgeLength())) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return String.format("CuboctahedronSolid[%.6f]", getEdgeLength());

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
