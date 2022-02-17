//============================================================================
// Name        : GeometricPropertyCalculatorOO.cpp
// Author      : 
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================


#include "Rectangle.h"
#include "Circle.h"
#include "Triangle.h"
//#include "Parent.h"

using namespace std;
#include <iostream>    // using IO functions
#include <string>      // using string
using namespace std;
#include <fstream>
#include <sstream>
#include <bits/stdc++.h>
using std::string;

int main(int argc, char *argv[]) {

	//Parent p1;
	//p1.getArea(3);

	char command = 0;
			string str = "";
			cout << "Program name : " << argv[0] << endl;

			if (argc == 1) {
				printf("\nNo command passed");
			} else {
				command = *argv[1];

				string op = " ";
				if (command == '1') {
							op = "AREA";
						}
						else if (command == '2')
							op = "PERIMETER";
						else {
							cout << "Invalid Command" << endl;
							op = "INVALID. Printing in_file.";
						}

				cout << "Command to run is - " << op << endl;



				string file_name = "data/input.txt";
				string out_file_name = "data/output.txt";
				string line;

				ifstream stream(file_name);
				ofstream out_file(out_file_name);

				if (stream.is_open()) {
				if (out_file.is_open()) {
						cout << " huh" << endl;
						string out_line;
					while (getline(stream, line)) {


			std::stringstream  line1stream(line);
			string a = "Shape";
			double b = 1;
			double c = 1;
			double d = 1;

			cout << "Checking stream" << endl;
			cout << b << " " << c << " " << d << endl;
			line1stream >> a;

				transform(a.begin(),a.end(),a.begin(),::toupper);
				cout << "shape found as " << a << endl;
				out_line = "No valid shape \n";
				if (a == "RECTANGLE") {
					line1stream >> b >> c;
					cout << "Checking Rectangle stream" << endl;
								cout << b << " " << c << " " << endl;
					Rectangle r1(b, c);
					if (command == '1') {
						cout << "Area = " << r1.getArea() << endl;
						stringstream ss;
						ss << r1.getArea();
						string str = ss.str();
						out_line = "Rectangle area = " + str + "\n";
					}
					else if(command == '2') {
						cout << "Perimeter = " << r1.getPerimeter() << endl;
						stringstream ss;
						ss << r1.getPerimeter();
						string str = ss.str();
						out_line = "Rectangle perimeter = " + str + "\n";
					}
					else
						out_line = "Not a valid request argument";
				}
				cout << "checking circle..." << endl;
				if (a == "CIRCLE") {
								line1stream >> b;
								cout << "Checking Circle stream" << endl;
								cout << b << endl;
								Circle c1(b);
								if (command == '1') {
									cout << "Area = " << c1.getArea() << endl;
									stringstream ss;
									ss << c1.getArea();
									string str = ss.str();
									out_line = "Circle area = " + str + "\n";
								}
								else if(command == '2') {
									cout << "Perimeter = " << c1.getPerimeter() << endl;
									stringstream ss;
									ss << c1.getPerimeter();
									string str = ss.str();
									out_line = "Circle perimeter = " + str + "\n";
								}
								else
									out_line = "Not a valid request argument";
							}
				cout << "checking triangle..." << endl;
				if (a == "TRIANGLE") {
								line1stream >> b >> c >> d;
								cout << "Checking Triangle stream" << endl;
								cout << b << " " << c << " " << d << endl;
								Triangle t1(b, c, d);
								if (command == '1') {
									cout << "Area = " << t1.getArea() << endl;
									stringstream ss;
									ss << t1.getArea();
									string str = ss.str();
									if (t1.getArea() <= 0) {
										str = "Invalid sides for a triangle";
									}

									out_line = "Triangle area = " + str + "\n";

								}
								else if(command == '2') {
									cout << "Perimeter = " << t1.getPerimeter() << endl;
									stringstream ss;
									ss << t1.getPerimeter();
									string str = ss.str();
									out_line = "Triangle perimeter = " + str + "\n";
								}
								else
									out_line = "Not a valid request argument";
							}

				if (b <= 0 || c <= 0 || d <= 0) {
							cout << "Invalid Size. Only use positive" << endl;
							out_line = a + ": Invalid sizes. Only use positive \n";
						}


					out_file << out_line;
							}
					}
				}

			}


	return 0;

}
