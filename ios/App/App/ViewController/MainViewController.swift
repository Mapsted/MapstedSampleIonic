//
//  MainViewController.swift
//  Demo


import UIKit
import MapstedCore
import MapstedMap
import MapstedMapUi
import LocationMarketing

class MainViewController : UIViewController {

    private var containerVC: ContainerViewController?
    private var mapsVC: MapstedMapUiViewController?
    private var selectedProperty: Int = -1
    
    @IBOutlet weak var spinnerView: UIActivityIndicatorView!
    
    //MARK: - Segue Handler
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if let containerVC = segue.destination as? ContainerViewController, segue.identifier == "containerSegue" {
            self.containerVC = containerVC
        }
    }
    
    //MARK: - ViewController Lifecycle
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        spinnerView.startAnimating()
        if CoreApi.hasInit() {
            addMapView()
        }
        else {
            MapstedMapApi.shared.setUp(prefetchProperties: false, callback: self)
        }
    }
    
    override func viewDidLayoutSubviews() {
        super.viewDidLayoutSubviews()
        self.navigationController?.setNavigationBarHidden(false, animated: false)
    }
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(animated)
    }
    
    override func viewDidAppear(_ animated: Bool) {
        super.viewDidAppear(animated)
        
    }
    
    override func viewWillDisappear(_ animated: Bool) {
        super.viewWillDisappear(animated)
        if selectedProperty != -1 {
            MapstedMapApi.shared.removeProperty(propertyId: selectedProperty)
        }
    }
    
    //MARK: - Intialize and add MapView and display property
    
    func addMapView() {
        if mapsVC == nil {
            if let mapsVC = MapstedMapUiViewController.shared as? MapstedMapUiViewController {
                mapsVC.setAlertDelegate(alertDelegate: self)
                self.mapsVC = mapsVC
                containerVC?.addController(controller: mapsVC, yOffset: 0, isNew: false)
            }
        }
        self.handleSuccess()
    }
        
    func displayProperty(propertyInfo: PropertyInfo, completion: (() -> ())? = nil) {
        //zoom to property
            self.mapsVC?.showLoadingSpinner(text: "Loading...")
            self.spinnerView.stopAnimating()
        
		let propertyId = propertyInfo.getPropertyId()
        selectedProperty = propertyId
        mapsVC?.selectAndDrawProperty(propertyId: propertyId, callback: {[weak self] status in
            DispatchQueue.main.async {
                self?.mapsVC?.hideLoadingSpinner()
                if status {
                    self?.mapsVC?.displayPropertyOnMap {
                        completion?()
                        self?.navigationController?.navigationBar.isHidden = false
                    }
                }
                else {
                    print("Mapsted - Problem with select and draw property: \(status)")
                }
            }
        })
    }
    
    //Method to handle success scenario after SDK initialized
	fileprivate func handleSuccess() {
        let propertyInfos = CoreApi.PropertyManager.getAll()
        if propertyInfos.count > 0 {
            let firstProperty = propertyInfos[0]
            self.displayProperty(propertyInfo: firstProperty) {
                
            }
        }
        else {
            print("Mapsted - No properties found")
        }
	}
}

//MARK: - Core Init Callback methods
extension MainViewController : CoreInitCallback {
    func onSuccess() {
        //Once the Map API Setup is complete, Setup the Mapview
        DispatchQueue.main.async {
            self.addMapView()
        }
    }
    
    func onFailure(errorCode: EnumSdkError) {
        print("Mapsted - onFailure: \(errorCode)")
    }
    
    func onStatusUpdate(update: EnumSdkUpdate) {
    }
    
    func onStatusMessage(messageType: StatusMessageType) {
    }
}

//MARK: - Routing Request Callback methods
extension MainViewController: RoutingRequestCallback {
    func onSuccess(routeResponse: MNRouteResponse) {
        MapstedMapApi.shared.handleRouteResponse(routeResponse: routeResponse)
    }
    
    func onError(errorCode: Int, errorMessage: String, alertIds: [String]) {
        MapstedMapApi.shared.handleRouteError(errorCode: errorCode, errorMessage: errorMessage, alertIds: alertIds)
    }
    
    
}

extension MainViewController: GeofenceEventListener {
    func onGeofenceEvent(propertyId: Int, triggerId: String) {
        //self.Logger.Log("Go GeofenceEvent for", "\(propertyId) with Trigger: \(triggerId)")
    }
}

//MARK: - MN Alert Delegate methods
extension MainViewController : MNAlertDelegate {
    func showAlerts() {
    }
    
    func loadingAlerts() -> Bool {
        return false
    }
}

