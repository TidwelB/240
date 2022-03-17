#include <iostream>
#include <stdlib.h>
#include <time.h>
#include <chrono>
#include <iomanip>
#include <limits.h>
#include <errno.h>
#include <stdio.h>

using namespace std;
using namespace std::chrono;

int factorial(int n);
int combination(int t, int r);

int main(int argc, char *argv[]) {
	auto start = high_resolution_clock::now();
	char *ptr;
	char *ptr2;
	errno = 0;
	int n;
	if(argc == 2 ) {
		cout << "Running Factorial" << endl;
		long factn = strtol(argv[1], &ptr, 10);
		if (errno !=0 || *ptr != '\0' || factn > INT_MAX || factn < INT_MIN) {
			cout << "improper input. Use a positive integer in bounds" << endl;
	return 0;
		}
		else {
		n = factn;
		cout << n << endl;
		cout << factorial(n) << endl;
		}
	}
	else if(argc == 3 ) {
		cout << "Running Combination" << endl;
		long t = strtol(argv[1], &ptr, 10);
		long r = strtol(argv[2], &ptr2, 10);
		if (errno !=0 || *ptr != '\0' || *ptr2 != '\0' || t > INT_MAX || t < INT_MIN || r < INT_MIN || r > INT_MAX || t < r) {
			cout << "improper input. Use two positive integers in bounds. The first must be greater than the second" << endl;
		return 0;
		}
		cout << combination(t, r) << endl;
	}
	else if(argc > 3) {
		cout << "too many arguments" << endl;
	}
	else if(argc < 2) {
		cout << "too few arguments" << endl;
	}

auto stop = high_resolution_clock::now();
auto duration = duration_cast<microseconds>(stop-start);
cout.setf(ios::fixed);
cout << "Time for processing: " << duration.count() << " microseconds" <<  endl;
return 0;
}

int factorial(int n) {
	if ( n > 1 )
		return n*factorial(n-1);
	else
		return 1;
}

int combination(int t, int r) {
	int top = factorial(t);
	int b1 = factorial(r);
	int b2 = t-r;
	b2 = factorial(b2);

	return (top / (b1*b2));
}
