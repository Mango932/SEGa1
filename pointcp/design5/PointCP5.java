package design5;


abstract class PointCP5 {
    public abstract double getX();
    public abstract double getY();
    public abstract double getRho();
    public abstract double getTheta();

    public double getDistance(PointCP5 pointB)
  {
    // Obtain differences in X and Y, sign is not important as these values
    // will be squared later.
    double deltaX = getX() - pointB.getX();
    double deltaY = getY() - pointB.getY();
    
    return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
  }

  /**
   * Rotates the specified point by the specified number of degrees.
   * Not required until E2.30
   *
   * @param point The point to rotate
   * @param rotation The number of degrees to rotate the point.
   * @return The rotated image of the original point.
   */
  public PointCP5 rotatePoint(double rotation)
  {
    double radRotation = Math.toRadians(rotation);
    double X = getX();
    double Y = getY();
        
    return new Cartesian(
      (Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y),
      (Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y));
  }
}


class Cartesian extends PointCP5 {
    private double x;
    private double y;
    
    public Cartesian(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public double getX() {
        return x;
    }
    
    public double getY() {
        return y;
    }
    
    public double getRho() {
        return Math.sqrt(x * x + y * y);
    }
    
    public double getTheta() {
        return Math.toDegrees(Math.atan2(y, x));
    }
    public String toString()
  {
    return "Stored as Cartesian  (" + getX() + "," + getY() + ")"
       +  "\n";
  }
}

class Polar extends PointCP5 {
    private double rho;
    private double theta;
    
    public Polar(double rho, double theta) {
        this.rho = rho;
        this.theta = theta;
    }
    
    public double getX() {
        return rho * Math.cos(Math.toRadians(theta));
    }
    
    public double getY() {
        return rho * Math.sin(Math.toRadians(theta));
    }
    
    public double getRho() {
        return rho;
    }
    
    public double getTheta() {
        return theta;
    }
    public String toString()
  {
    return "Stored as Polar [" + getRho() + "," + getTheta() + "]" + "\n";
  }
}