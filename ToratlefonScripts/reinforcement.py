import RPi.GPIO as IO
import time
import requests

url = "http://localhost:8080"
path = "/ring"
pressed = False

IO.setmode(IO.BCM)
IO.setup(21, IO.IN)

print "input enabled"

while True:
    if IO.input(21) and not pressed:
        time.sleep(0.1)
        if IO.input(21):
            pressed = True
            print "Called"
            requests.get(url + path)
            time.sleep(5)
        else:
            time.sleep(0.1)
    else:
        if pressed and not IO.input(21):
            pressed = False
