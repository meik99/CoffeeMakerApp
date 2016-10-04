import time
import RPi.GPIO as IO

PIN = 4

IO.setmode(IO.BCM)
IO.setup(PIN, IO.OUT)
IO.output(PIN, IO.HIGH)

time.sleep(15)

IO.output(PIN, IO.LOW)
IO.cleanup()