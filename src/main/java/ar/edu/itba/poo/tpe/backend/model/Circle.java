package ar.edu.itba.poo.tpe.backend.model;

import java.util.HashSet;
import java.util.Set;

public class Circle extends Ellipse {

    public Circle(Point centerPoint, double radius) {
        super(centerPoint, radius, radius);
    }

    public double getRadius() {
        return getsHorizontalAxis();
    }

    @Override
    public Set<Point> getOutsidePoints() {
        Set<Point> outsidePoints = new HashSet<>();
        Point topPoint = new Point(getCenterPoint().getX(), getCenterPoint().getY() + getRadius());
        outsidePoints.add(topPoint);

        Point bottomPoint = new Point(getCenterPoint().getX(), getCenterPoint().getY() - getRadius());
        outsidePoints.add(bottomPoint);

        Point  rightPoint = new Point(getCenterPoint().getX() + getRadius(), getCenterPoint().getY());
        outsidePoints.add(rightPoint);

        Point lefPoint = new Point(getCenterPoint().getX() - getRadius(), getCenterPoint().getY());
        outsidePoints.add(lefPoint);

        return outsidePoints;
    }

    @Override
    public String toString() {
        return String.format("Círculo [Centro: %s, Radio: %.2f]", getCenterPoint(), getRadius());
    }

}
