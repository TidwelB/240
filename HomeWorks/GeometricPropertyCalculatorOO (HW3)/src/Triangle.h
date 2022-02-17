#include <cmath>

class Triangle {
 private:
 	double s1;
 	double s2;
 	double s3;
 	double helper;
 	double pass;

 public:
 	Triangle(double side1 = 1, double side2 = 1, double side3 = 1) {
 	s1 = side1;
 	s2 = side2;
 	s3 = side3;
 	helper = (s1 + s2 + s3) / 2;
 	pass = 2;
 	}

 	double getS1() {
 		return s1;
 	}

 	double getS2() {
 		return s2;
 	}

 	double getS3() {
 		return s3;
 	}

 	double getArea() {
 		 pass = sqrt((helper)*(helper-s1)*(helper-s2)*(helper-s3));
 		 return pass;
 	}

 	double getPerimeter() {
 		return s1+s2+s3;
 	}

 	};
