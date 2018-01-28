import turtle

def draw_flower(brad):
    brad.forward(100)
    brad.right(45)
    brad.forward(100)
    brad.right(135)
    brad.forward(100)
    brad.right(45)
    brad.forward(100)
    brad.right(10)

def draw_art():

    window = turtle.Screen()
    window.bgcolor("black")

    brad = turtle.Turtle()

    brad.shape("turtle")
    brad.color("white")
    brad.speed(100)

    for i in range(1,30):
        draw_flower(brad)

    brad.right(120)
    brad.forward(250)

draw_art()
