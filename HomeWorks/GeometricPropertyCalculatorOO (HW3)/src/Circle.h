class Circle {
private:
   double radius;

public:
   Circle(double r = 1.0) {
      radius = r;
   }

   double getRadius() {
      return radius;
   }

   double getArea() {
      return radius*radius*3.14159;
   }
   double getPerimeter() {
	   return radius*2*3.14159;
   }
};

