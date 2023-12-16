package com.example.imagemanagement.app;

/**
 * factory to create app.
 */
public class AppFactory {

    /**
     * create application.
     * @return
     */
    public static AbstractApp createApp() {
        return new ImageListApp();
    }
}
