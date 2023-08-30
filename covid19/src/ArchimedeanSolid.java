public abstract class ArchimedeanSolid {
    private double edgeLength;

    public ArchimedeanSolid(double edgeLength) {
        this.edgeLength = edgeLength;
        if (edgeLength < 0) {
            throw new IllegalArgumentException();
        }
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object.equals(edgeLength)) {
            return true;
        } else {
            return false;
        }
    }

    public double getEdgeLength() {
        return edgeLength;
    }

    public String toString() {
        return String.format("ArchimedeanSolid[%.6f]", edgeLength);

    }

    public abstract double getVolume();

    public abstract double getSurfaceArea();
}
