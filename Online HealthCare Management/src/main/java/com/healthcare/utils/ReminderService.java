package com.healthcare.utils;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

// Simple scheduled service that could be extended to send reminders for upcoming appointments.
public class ReminderService {
    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public static void start() {
        scheduler.scheduleAtFixedRate(() -> {
            System.out.println("[ReminderService] scanning appointments for upcoming reminders...");
            // Real implementation would query appointments near now and send emails/SMS.
        }, 10, 60, TimeUnit.SECONDS);
    }

    public static void stop() {
        scheduler.shutdown();
    }
}
