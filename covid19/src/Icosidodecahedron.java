public class Icosidodecahedron extends ArchimedeanSolid {

    public Icosidodecahedron(double edgeLength) {
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
        return String.format("IcosidodecahedronSolid[%.6f]", getEdgeLength());

    }

    @Override
    public double getVolume() {
        return ((45.0 + (17.0 * Math.sqrt(5.0))) / 6.0) * Math.pow(getEdgeLength(), 3.0);
    }

    @Override
    public double getSurfaceArea() {
        return ((5.0 * Math.sqrt(3.0)) + (3.0 * Math.sqrt(25.0 + (10.0 * Math.sqrt(5.0))))) * Math.pow(getEdgeLength(), 2.0);
    }
}
