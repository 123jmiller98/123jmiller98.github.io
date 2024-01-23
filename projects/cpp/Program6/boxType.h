
#include "rectangleType.h"
#include <iostream>

using namespace std;


class boxType : protected rectangleType
{
	// overload stream insertion and extraction operators
	friend ostream& operator<< (ostream&, const boxType&);
	friend istream& operator>> (istream&, boxType&);
	
public:
	void setDimension(double l, double w, double h);
	double getHeight() const;
	double area() const;
	double volume() const;
	void print() const;

	// overload arithmetic operators
	boxType operator+(const boxType&) const;
	boxType operator-(const boxType&) const;
	boxType operator*(const boxType&) const;

	// overload the increment and decrement operators
	boxType operator++();
	boxType operator++(int);
	boxType operator--();
	boxType operator--(int);

	//overload the relational operators
	bool operator==(const boxType&) const;
	bool operator!=(const boxType&) const;
	bool operator<=(const boxType&) const;
	bool operator<(const boxType&) const;
	bool operator>=(const boxType&) const;
	bool operator>(const boxType&) const;

	boxType(double l = 0, double w = 0, double h = 0);




private:
	double height;
};
