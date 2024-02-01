import turtle
import random
from threading import Thread
from time import sleep
import datetime

def get_random_number_from_current_time():
    now = datetime.datetime.now()
    midnight = datetime.datetime.combine(now.date(), datetime.time())
    seconds = (now - midnight).seconds
    return seconds

SEED = get_random_number_from_current_time()

#Global variable position of lazer and astroid
astroid_pos = (0, 0)
lazer_pos = (0, 0)
lazer_pos_x = 0
lazer_pos_y = 0
astroid_pos_y = 0

#score
astroid_score = 0
player_score = 0

#Move Rocket Ship
def move_rocket_ship_right():
    x = rocket_ship.xcor()
    x += 20
    rocket_ship.setx(x)
    if x > 400:
        rocket_ship.setx(-400)

def move_rocket_ship_left():
    x = rocket_ship.xcor()
    x -= 20
    rocket_ship.setx(x)
    if x < -400:
        rocket_ship.setx(400)

def player_score_erase(astroids_destroyed):
    eraser = astroids_destroyed - 1
    sb = turtle.Turtle()
    sb.speed(0)
    sb.color("blue")
    sb.penup()
    sb.hideturtle()
    sb.goto(-271, 260)
    sb.write("Asteroids Destroyed: {} (20 to Win)".format(eraser), font=("Courier", 20, "normal"))

def player_score_write(astroids_destroyed):
    sb = turtle.Turtle()
    sb.speed(0)
    sb.color("white")
    sb.penup()
    sb.hideturtle()
    sb.goto(-271, 260)
    sb.clear()
    sb.write("Asteroids Destroyed: {} (20 to Win)".format(astroids_destroyed), font=("Courier", 20, "normal"))

#Updates the Player score  
def current_player_score():
    global player_score
    player_score += 1 
    return player_score


#Astroid Score Eraser
def astroid_score_erase(score):
    eraser = score - 1
    sba = turtle.Turtle()
    sba.speed(0)
    sba.color("blue")
    sba.penup()
    sba.hideturtle()
    sba.goto(-271, 237)
    sba.clear()
    sba.write("Asteroids Hit Earth: {} (5 to Lose)".format(eraser), font=("Courier", 20, "normal"))

#Astroid Score Display
def astroid_score_write(score):
    sba = turtle.Turtle()
    sba.speed(0)
    sba.color("white")
    sba.penup()
    sba.hideturtle()
    sba.goto(-271, 237)
    sba.clear()
    sba.write("Asteroids Hit Earth: {} (5 to Lose)".format(score), font=("Courier", 20, "normal"))

#Updates the Astroid score  
def current_astroid_score():
    global astroid_score
    astroid_score += 1 
    return astroid_score

#Creates an end game losing screen
def end_game_lose():
    sbL = turtle.Turtle()
    sbL.speed(0)
    sbL.color("white")
    sbL.penup()
    sbL.hideturtle()
    sbL.goto(0, 0)
    sbL.write("YOU LOSE", align="center", font=("Courier", 50, "normal"))

#Creates an end game win screen
def end_game_win():
    sbw = turtle.Turtle()
    sbw.speed(0)
    sbw.color("white")
    sbw.penup()
    sbw.hideturtle()
    sbw.goto(0, 0)
    sbw.write("YOU WIN", align="center", font=("Courier", 50, "normal"))


#Get Ready Countdown and erase functions from 3 2 1 GO
def get_ready():
    sbgr = turtle.Turtle()
    sbgr.speed(0)
    sbgr.color("white")
    sbgr.penup()
    sbgr.hideturtle()
    sbgr.goto(0, 0)
    sbgr.write("Get Ready", align="center", font=("Courier", 50, "normal"))

def get_ready_eraser():
    sbgr = turtle.Turtle()
    sbgr.speed(0)
    sbgr.color("blue")
    sbgr.penup()
    sbgr.hideturtle()
    sbgr.goto(0, 0)
    sbgr.write("Get Ready", align="center", font=("Courier", 50, "normal"))

def three():
    sb3 = turtle.Turtle()
    sb3.speed(0)
    sb3.color("white")
    sb3.penup()
    sb3.hideturtle()
    sb3.goto(0, 0)
    sb3.write("3", align="center", font=("Courier", 50, "normal"))

def three_eraser():
    sb3 = turtle.Turtle()
    sb3.speed(0)
    sb3.color("blue")
    sb3.penup()
    sb3.hideturtle()
    sb3.goto(0, 0)
    sb3.write("3", align="center", font=("Courier", 50, "normal"))

def two():
    sb2 = turtle.Turtle()
    sb2.speed(0)
    sb2.color("white")
    sb2.penup()
    sb2.hideturtle()
    sb2.goto(0, 0)
    sb2.write("2", align="center", font=("Courier", 50, "normal"))

def two_eraser():
    sb2 = turtle.Turtle()
    sb2.speed(0)
    sb2.color("blue")
    sb2.penup()
    sb2.hideturtle()
    sb2.goto(0, 0)
    sb2.write("2", align="center", font=("Courier", 50, "normal"))
    
def one():
    sb1 = turtle.Turtle()
    sb1.speed(0)
    sb1.color("white")
    sb1.penup()
    sb1.hideturtle()
    sb1.goto(0, 0)
    sb1.write("1", align="center", font=("Courier", 50, "normal"))

def one_eraser():
    sb1 = turtle.Turtle()
    sb1.speed(0)
    sb1.color("blue")
    sb1.penup()
    sb1.hideturtle()
    sb1.goto(0, 0)
    sb1.write("1", align="center", font=("Courier", 50, "normal"))

def go():
    sbgo = turtle.Turtle()
    sbgo.speed(0)
    sbgo.color("white")
    sbgo.penup()
    sbgo.hideturtle()
    sbgo.goto(0, 0)
    sbgo.write("GO", align="center", font=("Courier", 50, "normal"))

def go_eraser():
    sbgo = turtle.Turtle()
    sbgo.speed(0)
    sbgo.color("blue")
    sbgo.penup()
    sbgo.hideturtle()
    sbgo.goto(0, 0)
    sbgo.write("GO", align="center", font=("Courier", 50, "normal"))

#Get ready countdown
def countdown():
    get_ready()
    sleep(1)
    for e in range(7):
        get_ready_eraser()
    three()
    sleep(1)
    for e in range(6):
        three_eraser()
    two()
    sleep(1)
    for e in range(6):
        two_eraser()
    one()
    sleep(1)
    for e in range(6):
        one_eraser()
    go()
    sleep(1)
    for e in range(6):
        go_eraser()
    
#Creates Astroid
def create_astroid(x, y):
    global astroid_pos
    global lazer_pos
    global lazer_pos_x
    global lazer_pos_y
    global astroid_pos_y
    global difficulty
    num = random.choice(list(range(1,4)))
    astroid = turtle.Turtle()
    astroid.shape("circle")
    astroid.color("black")
    astroid.fillcolor("slate gray")
    astroid.shapesize(stretch_wid=num, stretch_len=num)
    astroid.penup()
    astroid.goto(x, y)
    astroid.right(90)
    astroid.speed(0)
    astroid.dy = 30
    for p in range(9000):
        Y = astroid.ycor()
        Y -= difficulty
        astroid.sety(Y)
        astroid_pos_x = round(astroid.xcor()/20)*20
        astroid_pos_y = round(astroid.ycor())
        astroid_pos = (astroid_pos_x, astroid_pos_y)
        print("Atroid Coordinates:", astroid_pos)
        if astroid_pos == (lazer_pos_x, astroid_pos_y) or astroid_pos == (lazer_pos_x + 20, astroid_pos_y) or astroid_pos == (lazer_pos_x - 20, astroid_pos_y):
            astroid.hideturtle()
            #get current astroid score
            astroids_destroyed = current_player_score()
            #erase old score
            for e in range(6):
                player_score_erase(astroids_destroyed)
            #write new player score
            player_score_write(astroids_destroyed)
            break
        wn.update()
        if astroid.ycor() < -330:
            #get current score
            current_score = current_astroid_score()
            #erase old score
            #one isn't enough :(
            for e in range(6):
                astroid_score_erase(current_score)
            #write new score 
            astroid_score_write(current_score)
            break
                        
#Lazer
def shoot_lazer():
    global lazer_pos
    global lazer_pos_x
    global lazer_pos_y
    global astroid_pos_y
    lazer = turtle.Turtle()
    lazer.speed(0)
    lazer.shape("square")
    lazer.color("lime")
    lazer.shapesize(stretch_wid=2.5, stretch_len=.2)
    lazer.penup()
    lazer.goto(rocket_ship.xcor(), rocket_ship.ycor() + 50)
    #moves the lazer
    for p in range(90):
        y = lazer.ycor()
        y += 9
        lazer.sety(y)
        lazer_pos_x = round(lazer.xcor())
        lazer_pos_y = round(lazer.ycor())
        lazer_pos = (lazer_pos_x, lazer_pos_y)
        print("Lasor Position: ", lazer_pos)    
        wn.update()
        if lazer_pos == (lazer_pos_x, astroid_pos_y):
            lazer.hideturtle()
            break
    
     
if __name__ == "__main__":
    name = input("Enter your Name: ")
    inputD= float(input("Enter Astroid Speed:  (1.Easy 5.Normal 10.Hard 15.Impossible)"))
    difficulty = inputD * .1

    #Main Window   
    wn = turtle.Screen()
    wn.title('Player: {}   (Use Arrow Keys to Move, Arrow Up to shoot)    Falling Asteroids by: Joseph C. Miller'.format(name))
    wn.bgcolor("blue")
    wn.setup(width=800, height=600)
    wn.tracer(0)

    #Rocket Ship
    rocket_ship = turtle.Turtle()
    rocket_ship.speed(0)
    rocket_ship.shape("triangle")
    rocket_ship.right(-90)
    rocket_ship.color("black")
    rocket_ship.fillcolor("red")
    rocket_ship.shapesize(stretch_wid=2, stretch_len=2)
    rocket_ship.penup()
    rocket_ship.goto(0, -250)
    
    #Keyboard Binding
    wn.listen()
    wn.onkeypress(move_rocket_ship_right, "Right")
    wn.onkeypress(move_rocket_ship_left, "Left")
    wn.onkeypress(shoot_lazer, "Up")

    #Displays a starting score of 0
    astroid_score_write(0)
    player_score_write(0)

    #Begin game countdown
    countdown()

    #Main Game Loop
    while True:
        wn.update()
        if astroid_score == 5:
            end_game_lose()
            sleep(10)
            break
        if player_score == 20:
            end_game_win()
            sleep(10)
            break
        num1 = random.choice(list(range(-350, 350)))
        create_astroid(num1, 250)

    

    

    





