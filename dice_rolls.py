import random
import turtle

def write_probability_list(rolled_value_list):
    """writes down the probability distribution list for when the graph is not clear"""
    text = turtle.Turtle()
    text.penup()
    text.setpos(-150,250)
    text.pendown()
    text.right(90)
    text.write("The probability distribution of dice rolls: ")
    text.penup()
    text.forward(10)
    for rolled_value in rolled_value_list:
        b = str(int(rolled_value / sum(rolled_value_list) * 100)) + " %"
        text.write(b)
        text.penup()
        text.forward(15)
        text.pendown()
    text.hideturtle()

def drawAxes(x_coordinate):
    """this function draws the x, y coordinate system"""
    axes = turtle.Turtle()
    axes.penup()
    axes.setpos(30,-200)
    axes.pendown()
    axes.setpos(x_coordinate*30, -200)
    axes.setpos(-(x_coordinate*20),-200)
    axes.left(90)
    axes.forward(x_coordinate * 30)
    axes.hideturtle()

def drawGraph(probability_list,b):
    """draws the graph of the probability distribution"""
    graph = turtle.Turtle()
    graph.speed(0)
    graph.penup()
    graph.setpos(-170,-200)
    graph.pendown()
    for i in range(b):
        graph.left(90)
        graph.forward(probability_list[i] * 10)
        graph.right(90)
        graph.forward(30)
        graph.right(90)
        graph.forward(probability_list[i] * 10)
        graph.left(90)
    graph.hideturtle()

def func1(number_of_dice, min_value, max_value, number_of_rolls):
    """this function creates the probability distribution of the dice rolled
    it creates a list of that distribution"""
    possible_values = max_value - min_value + 1
    probability_list = [0] * possible_values   # probability distribution list
    for i in range(number_of_rolls):
        rolled_value = -1
        die = 0
        while die != number_of_dice: # Roll each die once
            die += 1
            rolled_value += random.randrange(1,7) # Sum the values rolled for each die
        probability_list[rolled_value - min_value] += 1
    drawAxes(len(probability_list))
    drawGraph(probability_list, possible_values)
    write_probability_list(probability_list)
        
def main():
    number_of_dice = int(input("Number of dice (must be higher than 2): "))
    while(number_of_dice < 2):
        number_of_dice = int(input("Must be higher than 2 number: "))
    number_of_rolls = int(input("Number of rolls: "))
    min_val = number_of_dice
    max_val = number_of_dice * 6
    func1(number_of_dice, min_val, max_val, number_of_rolls)
    
if(__name__=="__main__"):
    main()
    
wn = turtle.Screen()    
wn.exitonclick()