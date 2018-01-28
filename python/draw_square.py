import turtle

def draw_square(turtle):
    for i in range(0,4):
        turtle.forward(100)
        turtle.right(90)

def draw_art():
    window = turtle.Screen()
    window.bgcolor("black")

    brad = turtle.Turtle()
    brad.color("yellow")
    brad.shape("turtle")
    brad.speed(1000)

    for i in range(0,50):
        draw_square(brad)
        brad.right(10)
        #i += 1
    window.exitonclick()
    

draw_art()
