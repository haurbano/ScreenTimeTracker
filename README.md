# ScreenTimeTracker
Android Library to track time that users spend in your screens

## How to use it?
### Import
Download the project and copy the module stt

### Initializing
Inside your application class add the following code:
``` java
class App: Application() {
    override fun onCreate() {
        super.onCreate()
        
        ScreenTimeTracker.apply {
            // Add reporter
            addReporter(LogcatReporter())
            // Add tracker
            addTracker(ActivitiesTracker(this@App))
            // Initializing
            initialize()
        }
    }
}
```

### Reportes
Available Reportes:
 - LogCatReporter

### Trackers
Available Trackers:
 - ActivitiesTracker
