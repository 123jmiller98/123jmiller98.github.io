#include "boxType.h"
#include <iostream>

using namespace std;



ostream& operator<<(ostream& osObject, const boxType& box)
{
	osObject << "Length = " << box.getLength() << " Width = " << box.getWidth() << " Height = " << box.height;
	return osObject;
}

istream& operator>>(istream& isObject, boxType& box)
{
	

	double l;
	double w;

	isObject >> l >> w  >> box.height;
	
	box.setDimension(l, w, box.height);

	return isObject;
}

void boxType::setDimension(double l, double w, double h)
{
	rectangleType::setDimension(l, w);
	if (h >= 0)
		height = h;
	else
		height = 0;
}
double boxType::getHeight() const
{
	return height;
}
double boxType::area() const
{
	return rectangleType::area();
}
double boxType::volume() const
{
	return rectangleType::area() * height;
}
void boxType::print() const
{
	rectangleType::print();
	cout << " Height = " << height << endl;
}


boxType boxType::operator+(const boxType& box) const
{

	rectangleType tempRect(box.getLength(), box.getWidth());
	
	tempRect = rectangleType::operator+(tempRect);
	boxType tempBox;


	tempBox.height = height + box.height;

	tempBox.setDimension(tempRect.getLength(), tempRect.getWidth(), tempBox.height);

	return tempBox;
}

boxType boxType::operator-(const boxType& box) const
{

	rectangleType tempRect(box.getLength(), box.getWidth());

	tempRect = rectangleType::operator-(tempRect);
	boxType tempBox;


	tempBox.height = height - box.height;

	tempBox.setDimension(tempRect.getLength(), tempRect.getWidth(), tempBox.height);

	return tempBox;
}

boxType boxType::operator*(const boxType& box) const
{

	rectangleType tempRect(box.getLength(), box.getWidth());

	tempRect = rectangleType::operator*(tempRect);
	boxType tempBox;


	tempBox.height = height * box.height;

	tempBox.setDimension(tempRect.getLength(), tempRect.getWidth(), tempBox.height);

	return tempBox;
}


boxType boxType::operator++()
{
	 rectangleType::operator++();
	 ++height;

	return *this;
}

boxType boxType::operator++(int u)
{
	boxType temp = *this;
	rectangleType::operator++(u);
	

	height++;

	return temp;
}



boxType boxType::operator--()
{
	rectangleType::operator--();
	--height;

	return *this;
}

boxType boxType::operator--(int u)
{
	boxType temp = *this;

	rectangleType::operator--(u);

	height--;

	return temp;
}

bool boxType::operator==(const boxType& box) const
{
	
	return (volume() == box.volume());	
	
}

bool boxType::operator!=(const boxType& box) const
{
	return (volume() != box.volume());

}

bool boxType::operator<=(const boxType& box) const
{
	return (volume() <= box.volume());

}

bool boxType::operator<(const boxType& box) const
{
	return (volume() < box.volume());

}

bool boxType::operator>=(const boxType& box) const
{
	return (volume() >= box.volume());

}

bool boxType::operator>(const boxType& box) const
{
	return (volume() > box.volume());

}


boxType::boxType(double l, double w, double h)
	: rectangleType(l,w)
{

	if (h >= 0)
		height = h;
	else
		height = 0;

}