#ifndef SHAPE_H_
#define SHAPE_H_

#include "Rectangle.h"
#include "Circle.h"
#include "Triangle.h"

class Shape {
 private:
 	double s1;
 	double s2;
 	double s3;

 public:
 	Shape(double side1 = 1, double side2 = 1, double side3 = 1) {
 	s1 = side1;
 	s2 = side2;
 	s3 = side3;



 	}
 Triangle t1(double, double, double);
 Rectangle r1(double, double);
 	Circle c1(double);



 	double getArea(double, double, double) {
 		return t1.getArea(s1, s2, s3);
 	}

 	double getArea(double, double) {
 	 		return r1.getArea(s1, s2);
 	 	}

 	double getArea(double) {
 	 	 		return c1.getArea(s1);
 	 	 	}
 	double getPerimeter(double) {
 		return c1.getPerimeter(s1);
 	}
 	double getPerimeter(double, double) {
 		return r1.getPerimeter(s1, s2);
 	}
 	double getPerimeter(double, double, double) {
 		return t1.getPerimeter(s1, s2, s3);
 	}


 };

#endif /* SHAPE_H_ */
