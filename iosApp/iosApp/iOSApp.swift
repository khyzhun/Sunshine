import SwiftUI
import ComposeApp

@main
struct iOSApp: App {

    init() {
        MainViewControllerKt.setupLogger()
    }

    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }

}
