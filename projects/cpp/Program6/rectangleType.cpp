#include "rectangleType.h"
#include <iostream>

using namespace std;


ostream& operator<<(ostream& osObject, const rectangleType& rectangle)
{
	osObject << "Length = " << rectangle.length << " Width = " << rectangle.width;
	return osObject;
}

istream& operator>>(istream& isObject, rectangleType& rectangle)
{
	isObject >> rectangle.length >> rectangle.width;

	return isObject;
}

void rectangleType::setDimension(double l, double w)
{
	if (l >= 0)
		length = l;
	else
		length = 0;

	if (w >= 0)
		width = w;
	else
		width = 0;
}
double rectangleType::getLength() const
{
	return length;
}
double rectangleType::getWidth() const
{
	return width;
}
double rectangleType::area() const
{
	return length * width;
}
double rectangleType::perimeter() const
{
	return length + length + width + width;
}
void rectangleType::print() const
{
	cout << "Length = " << length << " " << "Width = " << width << " ";
}


rectangleType rectangleType::operator+(const rectangleType& rectangle) const
{
	rectangleType tempRect;

	tempRect.length = length + rectangle.length;
	tempRect.width = width + rectangle.width;

	return tempRect;
}


rectangleType rectangleType::operator-(const rectangleType& rectangle) const
{
	rectangleType tempRect;

	tempRect.length = length - rectangle.length;
	tempRect.width = width - rectangle.width;

	return tempRect;
}

rectangleType rectangleType::operator*(const rectangleType& rectangle) const
{
	rectangleType tempRect;

	tempRect.length = length * rectangle.length;
	tempRect.width = width * rectangle.width;

	return tempRect;
}


rectangleType rectangleType::operator++()
{
	++length;
	++width;

	return *this;
}

 rectangleType rectangleType::operator++(int u)
{
	 rectangleType temp = *this;

	 length++;
	 width++;

	return temp;
}



 rectangleType rectangleType::operator--()
 {
	 --length;
	 --width;

	 return *this;
 }

 rectangleType rectangleType::operator--(int u)
 {
	 rectangleType temp = *this;

	 length--;
	 width--;

	 return temp;
 }


bool rectangleType::operator==(const rectangleType& rectangle) const
{
	return (area() == rectangle.area());
}

bool rectangleType::operator!=(const rectangleType& rectangle) const
{
	return (area() != rectangle.area());
}

bool rectangleType::operator<=(const rectangleType& rectangle) const
{
	return (area() <= rectangle.area());
}

bool rectangleType::operator<(const rectangleType& rectangle) const
{
	return (area() < rectangle.area());
}

bool rectangleType::operator>=(const rectangleType& rectangle) const
{
	return (area() >= rectangle.area());
}

bool rectangleType::operator>(const rectangleType& rectangle) const
{
	return (area() > rectangle.area());
}


rectangleType::rectangleType(double l, double w)
{
	setDimension(l, w);
}