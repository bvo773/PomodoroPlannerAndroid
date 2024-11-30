package com.vo.binh.prototype;
import java.util.Timer;
import java.util.TimerTask;

public class PomodoroTimer {
    static int secondsPassed = 0;
    Timer myTimer = new Timer();

    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            secondsPassed++;
            System.out.println("Seconds: " + secondsPassed);
        }
    };

    public void Start(){
        while (T)
        myTimer.scheduleAtFixedRate(task, 1000, 1000);

    }

    public static void main(String[] args) {
        PomodoroTimer pomodoroTimer = new PomodoroTimer();
        pomodoroTimer.Start();
    }
}
