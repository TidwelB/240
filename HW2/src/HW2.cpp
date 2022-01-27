//============================================================================
// Name        : HW2.cpp
// Author      : 
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================
#include <iostream>
#include <string>
#include <fstream>
#include <sstream>

using namespace std;
using std::string;



void HW2(char command) {

	string file_name = "input.txt";
	string out_file_name = "output.txt";
		string line;

		std::ifstream stream(file_name);
		std::ofstream out_myfile(out_file_name);
		if (stream.is_open()) {
			if (out_myfile.is_open()) {
				string out_line = " ";
			while (getline(stream, line)) {


	std::stringstream  line1stream(line);
	string a;
	int b;
	int c;
	int d;
	double perim = 0.0;
	double area = 0.0;
	string operation = "";

	line1stream >> a;

	if (a == "Rectangle") {
		line1stream >> b >> c;
		perim = (2*b + 2*c);
		area = (b*c);
		cout << a <<" " << b << " " << c << " ";
		if (command == '1') {
			cout << area << endl;
			operation = "AREA";
			stringstream ss;
			ss << area;
			string str = ss.str();
			out_line = a + " " + operation + " = " + str + '\n';
		}
		else if (command == '2') {
			cout << perim << endl;
			operation = "PERIMETER";
			stringstream ss;
			ss << perim;
			string str = ss.str();
			out_line = a + " " + operation + " = " + str + '\n';
		}
	}
	if (a == "Circle") {
		line1stream >> b;
		perim = (2*3.14159*b);
		area = ((b*b)*3.14159);
		cout << a << " " << b << " ";
		if (command == '1') {
					cout << area << endl;
					operation = "AREA";
					stringstream ss;
					ss << area;
					string str = ss.str();
					out_line = a + "  " + operation + " = " + str + '\n';
				}
				else if (command == '2') {
					cout << perim << endl;
					operation = "PERIMETER";
					stringstream ss;
					ss << perim;
					string str = ss.str();
					out_line = a + "  " + operation + " = " + str + '\n';
				}
	}
	if (a == "Triangle") {
		line1stream >> b >> c >> d;
		perim = (b + c + d);
		cout << a <<" " << b << " " << c << " " << d << " ";
		if (command == '1') {
					cout << "Area cannot be found from only sides of a triangle" << endl;
					operation = "AREA";
					out_line = a + " " + operation + " = " + "Area cannot be found from only sides of a triangle" + '\n';
				}
				else if (command == '2') {
					cout << perim << endl;
					operation = "PERIMETER";
					stringstream ss;
					ss << perim;
					string str = ss.str();
					out_line = a + " " + operation + " = " + str + '\n';
				}
	}

	out_myfile << out_line;
			}

		}
		}
}


int main(int argc, char *argv[]) {

	char command = 0;
	string str = "";

	// First argument is program name
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
					op = "INVALID. Printing in file.";
				}

		cout << "Command to run is - " << op << endl;
	}


	HW2(command);

	return 0;
}
