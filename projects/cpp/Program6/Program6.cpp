

#include <iostream>
#include "rectangleType.h"
#include "boxType.h"

using namespace std;
void testOne();
void testTwo();
void testThree();
void testFour();
void testFive();
void testSix();
void testSeven();
void testEight();
void testNine();
void testTen();
void testEleven();

int main()
{
    testOne();
    cout << endl;
    testTwo();
    cout << endl;
    testThree();
    cout << endl;
    testFour();
    cout << endl;
    testFive();
    cout << endl;
    testSix();
    cout << endl;
    testSeven();
    cout << endl;
    testEight();
    cout << endl;
    testNine();
    cout << endl;
    testTen();
    cout << endl;
    testEleven();
    
}


void testOne()
{
    boxType box1(1, 2, 3);
    boxType box2(4, 5, 6);
    boxType box3;

    cout << "Box 1: ";
    box1.print();

    cout << "Box 2: ";
    box2.print();

    // test + overload
    box3 = box1 + box2;

    cout << "Boxes added together: ";
    //test << overload
    cout << box3 << endl;
    cout << endl;
}

void testTwo()
{
    boxType box1(1, 2, 3);
    boxType box2(4, 5, 6);
    boxType box3;

    cout << "Box 1: ";
    box1.print();

    cout << "Box 2: ";
    box2.print();
    
    box3 = box1 * box2;

    cout << "Boxes Multiplied: ";
    cout << box3 << endl;
    

}
void testThree()
{
    boxType box1(4, 5, 6);
    boxType box2(1, 1, 1);
    boxType box3;
   
    cout << "Box 1: ";
    box1.print();

    cout << "Box 2: ";
    box2.print();
    
    box3 = box1 - box2;

    cout << "Boxes Subtracted: ";
    cout << box3 << endl;


}

void testFour()
{
    boxType box1(1, 2, 3);
    boxType box2(1,2,3);
   
    cout << "Box 1: " << box1 << endl;
    cout << "Box 2: " << box2 << endl;

    if (box1 == box2)
        cout << "Boxes are equal" << endl;
    else
        cout << "boxes are unequal" << endl;

    cout << endl;

    boxType box3(1, 2, 3);
    boxType box4(4, 5, 6);

    cout << "Box 1: " << box3 << endl;
    cout << "Box 2: " << box4 << endl;

    if (box3 == box4)
        cout << "Boxes are equal" << endl;
    else
        cout << "boxes are unequal" << endl;

    cout << endl;

    boxType box5(1, 2, 3);
    boxType box6(1, 2, 3);

    cout << "Box 1: " << box5 << endl;
    cout << "Box 2: " << box6 << endl;

    if (box1 != box2)
        cout << "boxes are unequal" << endl;
     
    else
        cout << "Boxes are equal" << endl;

    cout << endl;

    boxType box7(1, 2, 3);
    boxType box8(4, 5, 6);

    cout << "Box 1: " << box7 << endl;
    cout << "Box 2: " << box8 << endl;

    if (box3 != box4)
        cout << "boxes are unequal" << endl;

    else
        cout << "Boxes are equal" << endl;

}


void testFive()
{
    boxType box1(1, 2, 3);
    boxType box2(1, 2, 3);

    cout << "Box 1: " << box1 << endl;
    cout << "Box 2: " << box2 << endl;

    if (box1 >= box2)
        cout << "Box 1 is greater or equal than Box 2" << endl;
    else
        cout << "Box 1 is less than Box 2" << endl;

    cout << endl;


    boxType box3(1, 2, 3);
    boxType box4(4, 5, 6);

    cout << "Box 1: " << box3 << endl;
    cout << "Box 2: " << box4 << endl;

    if (box3 >= box4)
        cout << "Box 1 is greater or equal than Box 2" << endl;
    else
        cout << "Box 1 is less than Box 2" << endl;
    
    cout << endl;

    boxType box5(4, 5, 6);
    boxType box6(3, 2, 1);

    cout << "Box 1: " << box5 << endl;
    cout << "Box 2: " << box6 << endl;

    if (box5 >= box6)
        cout << "Box 1 is greater or equal than Box 2" << endl;
    else
        cout << "Box 1 is less than Box 2" << endl;

}

void testSix()
{
    boxType box1(1, 2, 3);
    boxType box2(1, 2, 3);

    cout << "Box 1: " << box1 << endl;
    cout << "Box 2: " << box2 << endl;

    if (box1 <= box2)
        cout << "Box 1 is less than or equal than Box 2" << endl;
    else
        cout << "Box 1 is greater than Box 2" << endl;

    cout << endl;

    boxType box3(1, 2, 3);
    boxType box4(4, 5, 6);

    cout << "Box 1: " << box3 << endl;
    cout << "Box 2: " << box4 << endl;

    if (box3 <= box4)
        cout << "Box 1 is less than or equal than Box 2" << endl;
    else
        cout << "Box 1 is greater than Box 2" << endl;

    cout << endl;

    boxType box5(4, 5, 6);
    boxType box6(3, 2, 1);

    cout << "Box 1: " << box5 << endl;
    cout << "Box 2: " << box6 << endl;

    if (box5 <= box6)
        cout << "Box 1 is less than or equal than Box 2" << endl;
    else
        cout << "Box 1 is greater than Box 2" << endl;

}
void testSeven()
{
    boxType box1(1, 2, 3);
    boxType box2(1, 2, 3);

    cout << "Box 1: " << box1 << endl;
    cout << "Box 2: " << box2 << endl;

    if (box1 < box2)
        cout << "Box 1 is less than Box 2" << endl;
    else
        cout << "Box 1 is greater than or equal to Box 2" << endl;

    cout << endl;

    boxType box3(1, 2, 3);
    boxType box4(4, 5, 6);

    cout << "Box 1: " << box3 << endl;
    cout << "Box 2: " << box4 << endl;

    if (box3 < box4)
        cout << "Box 1 is less than Box 2" << endl;
    else
        cout << "Box 1 is greater than or equal to Box 2" << endl;

    cout << endl;

    boxType box5(4, 5, 6);
    boxType box6(3, 2, 1);

    cout << "Box 1: " << box5 << endl;
    cout << "Box 2: " << box6 << endl;

    if (box5 < box6)
        cout << "Box 1 is less than Box 2" << endl;
    else
        cout << "Box 1 is greater than or equal to Box 2" << endl;

}

void testEight()
{
    boxType box1(1, 2, 3);
    boxType box2(1, 2, 3);

    cout << "Box 1: " << box1 << endl;
    cout << "Box 2: " << box2 << endl;

    if (box1 > box2)
        cout << "Box 1 is greater than Box 2" << endl;
        
    else
        cout << "Box 1 is less than or equal to Box 2" << endl;

    cout << endl;

    boxType box3(1, 2, 3);
    boxType box4(4, 5, 6);

    cout << "Box 1: " << box3 << endl;
    cout << "Box 2: " << box4 << endl;

    if (box3 > box4)
        cout << "Box 1 is greater than Box 2" << endl;
    else
        cout << "Box 1 is less than or equal to Box 2" << endl;

    cout << endl;

    boxType box5(4, 5, 6);
    boxType box6(3, 2, 1);

    cout << "Box 1: " << box5 << endl;
    cout << "Box 2: " << box6 << endl;

    if (box5 > box6)
        cout << "Box 1 is greater than Box 2" << endl;
    else
        cout << "Box 1 is less than or equal to Box 2" << endl;

}

void testNine()
{
    boxType box1(1, 1, 1);

    cout << "Box before increment: " << box1 << endl;

    box1++;

    cout << "Box after increment: " << box1 << endl;

}

void testTen()
{
    boxType box1(2, 2, 2);

    cout << "Box before decrement: " << box1 << endl;

    box1--;

    cout << "Box after deccrement: " << box1 << endl;

}

void testEleven()
{

    boxType box1;
    
    cout << "Enter Length, Width, and Height" << endl;
    cin >> box1;

    cout << box1;

}