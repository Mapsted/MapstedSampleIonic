//
//  LaunchViewController.swift
//  App

import UIKit
import Capacitor

public class LaunchViewController: CAPBridgeViewController {
    
    public override func viewDidLoad() {
        super.viewDidLoad()
        bridge?.registerPluginInstance(MapstedIonicPlugin())
    }
    
    public override func viewWillAppear(_ animated: Bool) {
        self.navigationController?.setNavigationBarHidden(true, animated: false)
    }
    
    @objc func launchMapActivity(_ call: CAPPluginCall) {
        do {
            guard let bridge = self.bridge else {
                throw NSError(domain: "MapstedIonicPlugin", code: 500, userInfo: ["message": "Bridge not available"])
            }
            
            let storyboard = UIStoryboard(name: "Main", bundle: Bundle(for: MainViewController.self))
            if let viewController = storyboard.instantiateViewController(withIdentifier: "MAINVC") as? MainViewController {
                bridge.viewController?.navigationController?.pushViewController(viewController, animated: true)
                call.resolve()
            }
        } catch let error as NSError {
            call.reject("Failed to launch Map Activity", "Error: \(error)")
        }
    }
}
