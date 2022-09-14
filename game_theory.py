import random
import turtle

window = turtle.Screen()
lives = 1

def scratch(player_answer, scratch_turtle, max_number):
    scratch_turtle.penup()
    y = 107
    x = -153
    multi_10 = 10
    if(player_answer > 0 and player_answer < max_number ):
        for i in range(player_answer+1):
            if i == multi_10:
                y -= 20
                x = -153
                multi_10 += 10
        scratch_turtle.setpos(x+((player_answer%10)*30), y)
        scratch_turtle.pendown()
        scratch_turtle.forward(15)


def clue(text, hint):
    text.penup()
    text.setpos(0,200)
    text.write(hint)
    
def drawBoard(max_number, write_number_turtle):
    write_number_turtle.penup()
    y = 100
    x = -150
    multi_10 = 10
    for i in range(max_number + 1):
        if i == multi_10:
            y -= 20
            x = -150
            multi_10 += 10
        write_number_turtle.setpos(x,y)    
        write_number_turtle.write(i)
        x += 30

def drawScore(lives, level, write_score_turtle):
    write_score_turtle.penup()
    write_score_turtle.setpos(100,180)
    write_score_turtle.write("Lives remaining: %d"%lives)
    write_score_turtle.setpos(100,150)
    write_score_turtle.write("Level: %d" %level)
        
def game_play(level, text_turtle, write_score_turtle, scratch_turtle, num):
    global lives
    lives += 4
    ans = random.randrange(level*10)

    drawBoard(level * 10 -1, num)
    while(lives > 0):
        drawScore(lives, level, write_score_turtle)
        scratch_turtle.penup()
        scratch_turtle.setpos(-180,0)
        inp = window.textinput("Guessing game","Guess a number between 0 and %d:" % (level * 10 - 1))
        player_answer = int(inp)
        if(player_answer  == ans ):
            write_score_turtle.clear()
            num.clear()
            text_turtle.clear()
            scratch_turtle.clear()
            return True
        lives -= 1
        scratch(player_answer, scratch_turtle, (level * 10 - 1))
        text_turtle.clear()
        if player_answer < ans: 
            hint = "Guess a higher number"
        else:
            hint = "Guess a lower number"
        clue(text_turtle, hint)
        write_score_turtle.clear()
    text_turtle.clear()    
    return False

def main():
    level = 1
    start_lives = 1
    text_turtle = turtle.Turtle()
    text_turtle.hideturtle()
    write_score_turtle = turtle.Turtle()
    write_score_turtle.hideturtle()
    num = turtle.Turtle()
    num.hideturtle()
    scratch_turtle = turtle.Turtle()
    text_turtle.penup()
    text_turtle.setpos(0,200)
    while(game_play(level, text_turtle, write_score_turtle, scratch_turtle, num) and level < 10):
        text_turtle.setpos(0,200)
        text_turtle.write("Well done, you got it!")
        level += 1
    text_turtle.write("YOU DIED!!!")  if level != 10 else text_turtle.write("YOU WIN!!!")

if(__name__=="__main__"):
    main()

window.exitonclick()