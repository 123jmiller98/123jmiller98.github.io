
#ifndef rectangleType_HEADER
#define rectangleType_HEADER



#include <iostream>
using namespace std;

class rectangleType

{
	
	// overload stream insertion and extraction operators
	friend ostream& operator<< (ostream&, const rectangleType &);
	friend istream& operator>> (istream&, rectangleType &);

	
public:
	void setDimension(double l, double w);
	double getLength() const;
	double getWidth() const;
	double area() const;
	double perimeter() const;
	void print() const;

	// overload arithmetic operators
	rectangleType operator+(const rectangleType&) const;
	rectangleType operator-(const rectangleType&) const;
	rectangleType operator*(const rectangleType&) const;

	// overload the increment and decrement operators
	rectangleType operator++();
	rectangleType operator++(int);
	rectangleType operator--();
	rectangleType operator--(int);


	//overload the relational operators
	bool operator==(const rectangleType&) const;
	bool operator!=(const rectangleType&) const;
	bool operator<=(const rectangleType&) const;
	bool operator<(const rectangleType&) const;
	bool operator>=(const rectangleType&) const;
	bool operator>(const rectangleType&) const;

	rectangleType(double l = 0, double w = 0);

private:
	double length;
	double width;
};


#endif