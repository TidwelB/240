#ifndef RECTANGLE_H_
#define RECTANGLE_H_

class Rectangle {
 private:
 	double s1;
 	double s2;

 public:
 	Rectangle(double side1 = 1, double side2 = 1) {
 	s1 = side1;
 	s2 = side2;
 	}

 	double getS1() {
 		return s1;
 	}

 	double getS2() {
 		return s2;
 	}

 	double getArea() {
 		return s1*s2;
 	}

 	double getPerimeter() {
 		return (s1*2 + s2*2);
 	}


 };

#endif /* RECTANGLE_H_ */
