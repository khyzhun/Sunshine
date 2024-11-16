import SwiftUI
import ComposeApp

@main
struct iOSApp: App {

    init() {
        LoggerKt.setupLogger()
        KoinKt.doInitKoin()
    }

    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }

}
